package pt.up.fe.comp.dot;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.BeforeClass;
import org.junit.Test;
import pt.up.fe.comp.dot.ir.DotGraph;
import pt.up.fe.comp.dot.parser.dotLexer;
import pt.up.fe.comp.dot.parser.dotParser;

import java.util.*;

import static junit.framework.TestCase.fail;
import static junit.framework.TestCase.assertTrue;

public class DotVisitorTest {
    private static DotGraph graph;

    @BeforeClass
    public static void setUp() throws Exception {
        String code = "digraph finite_state_machine {"
                    +  "    rankdir=LR;"
                    +  "    size=\"8,5\""
                    +  "    node [shape = doublecircle]; LR_0 LR_3 LR_4 LR_8;"
                    +  "    node [shape = circle];"
                    +  "    LR_0 -> LR_2 [ label = \"SS(B)\" ];"
                    +  "    LR_0 -> LR_1 [ label = \"SS(S)\" ];"
                    +  "    LR_1 -> LR_3 [ label = \"S($end)\" ];"
                    +  "    LR_2 -> LR_6 [ label = \"SS(b)\" ];"
                    +  "    LR_2 -> LR_5 [ label = \"SS(a)\" ];"
                    +  "    LR_2 -> LR_4 [ label = \"S(A)\" ];"
                    +  "    LR_5 -> LR_7 [ label = \"S(b)\" ];"
                    +  "    LR_5 -> LR_5 [ label = \"S(a)\" ];"
                    +  "    LR_6 -> LR_6 [ label = \"S(b)\" ];"
                    +  "    LR_6 -> LR_5 [ label = \"S(a)\" ];"
                    +  "    LR_7 -> LR_8 [ label = \"S(b)\" ];"
                    +  "    LR_7 -> LR_5 [ label = \"S(a)\" ];"
                    +  "    LR_8 -> LR_6 [ label = \"S(b)\" ];"
                    +  "    LR_8 -> LR_5 [ label = \"S(a)\" ];"
                    +  "}";


        ANTLRInputStream input =  new ANTLRInputStream(code);
        dotLexer lexer = new dotLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        dotParser parser = new dotParser(tokens);
        ParseTree tree = parser.graph(); // parse

        DotVisitor eval = new DotVisitor();
        graph = eval.visit(tree);
    }

    @Test
    public void nodesTest() {
        List<String> expectedNodes = Arrays.asList("LR_0", "LR_1", "LR_2", "LR_3", "LR_4", "LR_5", "LR_6", "LR_7", "LR_8");
        Collection<String> actualNodes = graph.getNodes();
        assertTrue(actualNodes.containsAll(expectedNodes) && actualNodes.size() == expectedNodes.size());
    }

    @Test
    public void nodesAttributesTest() {
    	assertTrue(graph.getNodeAttributes("LR_0").get("shape").equals("doublecircle"));
    	assertTrue(graph.getNodeAttributes("LR_1").get("shape").equals("circle"));
    	assertTrue(graph.getNodeAttributes("LR_2").get("shape").equals("circle"));
    	assertTrue(graph.getNodeAttributes("LR_3").get("shape").equals("doublecircle"));
    	assertTrue(graph.getNodeAttributes("LR_4").get("shape").equals("doublecircle"));
    	assertTrue(graph.getNodeAttributes("LR_5").get("shape").equals("circle"));
    	assertTrue(graph.getNodeAttributes("LR_6").get("shape").equals("circle"));
    	assertTrue(graph.getNodeAttributes("LR_7").get("shape").equals("circle"));
    	assertTrue(graph.getNodeAttributes("LR_8").get("shape").equals("doublecircle"));
    }

    @Test
    public void attributesTest() {
    	assertTrue(graph.getAttribute("rankdir").equals("LR"));
    	assertTrue(graph.getAttribute("size").equals("\"8,5\""));
    }

    @Test
    public void edgesTest() {
        Map<String, List<String>> expectedEdges = new HashMap<String, List<String>>() {
            private static final long serialVersionUID = 1L;
        {
            put("LR_0", Arrays.asList("LR_2", "LR_1"));
            put("LR_1", Arrays.asList("LR_3"));
            put("LR_2", Arrays.asList("LR_4", "LR_5", "LR_6"));
            put("LR_3", Arrays.asList(new String[0]));
            put("LR_4", Arrays.asList(new String[0]));
            put("LR_5", Arrays.asList("LR_5", "LR_7"));
            put("LR_6", Arrays.asList("LR_5", "LR_6"));
            put("LR_7", Arrays.asList("LR_8", "LR_5"));
            put("LR_8", Arrays.asList("LR_6", "LR_5"));
        }};

        Set<String> nodes = graph.getNodes();

        for (String node: nodes) {
            List<String> expectedDestinationIds = expectedEdges.get(node);
            if (expectedDestinationIds == null) fail();

            List<DotGraph.Edge> actualEdges = graph.getNodeEdges(node);
            assertTrue(actualEdges.size() == expectedDestinationIds.size());
            for (DotGraph.Edge edge: actualEdges)
            	assertTrue(expectedDestinationIds.contains(edge.destination));
        }
    }
}
