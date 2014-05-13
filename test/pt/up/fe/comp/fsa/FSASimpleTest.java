package pt.up.fe.comp.fsa;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Before;
import org.junit.Test;
import pt.up.fe.comp.dot.DotVisitor;
import pt.up.fe.comp.dot.ir.DotGraph;
import pt.up.fe.comp.dot.parser.dotLexer;
import pt.up.fe.comp.dot.parser.dotParser;


public class FSASimpleTest {
    private FSA automaton;

    @Before
    public void init() {
        try {
            automaton = new FSA("lol", "init", new HashSet<String>());
        } catch (DuplicateElementException e) {
            fail();
        }
    }

    @Test
    public void addNodeTest(){
        try {
            automaton.addNode("q1");
        } catch (DuplicateElementException e) {
            fail();
        }
        Set<String> nodes = automaton.getNodes();
        assertTrue("NodeSet doesn't contain added node.", nodes.contains("q1"));
    }
    
    @Test(expected = DuplicateElementException.class)
    public void addDuplicateNode() throws DuplicateElementException {
        try {
            automaton.addNode("q1");
        } catch (DuplicateElementException e) {
            fail();
        }
        automaton.addNode("q1");
    }

    @Test
    public void hasNodeTest() {
        try {
            automaton.addNode("q1");
        } catch (DuplicateElementException e) {
            fail();
        }
        assertTrue(automaton.getNodes().contains("q1"));
        assertFalse(automaton.getNodes().contains("q2"));
    }

    @Test(expected = NoSuchNodeException.class)
    public void getNodeEdgesThrowsTest() throws NoSuchNodeException {
        automaton.getNodeEdges("q1");
    }

    @Test
    public void nodeClosureTest() {
        try {
            FSA newAut = new FSA("aut","q0", new LinkedHashSet<String>());
            newAut.addEdge("q0", null, "q1");
            newAut.addEdge("q1", null, "q2");
            newAut.addEdge("q2", 'a', "q3");

            Set<String> q0Closure = newAut.getNodeEmptyTransitionClosure("q0");
            assertTrue(q0Closure.contains("q0"));
            assertTrue(q0Closure.contains("q1"));
            assertTrue(q0Closure.contains("q2"));
            assertTrue(!q0Closure.contains("q3"));

            Set<String> q1Closure = newAut.getNodeEmptyTransitionClosure("q1");
            assertTrue(!q1Closure.contains("q0"));
            assertTrue(q1Closure.contains("q1"));
            assertTrue(q1Closure.contains("q2"));
            assertTrue(!q1Closure.contains("q3"));

            Set<String> q2Closure = newAut.getNodeEmptyTransitionClosure("q2");
            assertTrue(!q2Closure.contains("q0"));
            assertTrue(!q2Closure.contains("q1"));
            assertTrue(q2Closure.contains("q2"));
            assertTrue(!q2Closure.contains("q3"));

            Set<String> q3Closure = newAut.getNodeEmptyTransitionClosure("q3");
            assertTrue(!q3Closure.contains("q0"));
            assertTrue(!q3Closure.contains("q1"));
            assertTrue(!q3Closure.contains("q2"));
            assertTrue(q3Closure.contains("q3"));

        } catch (FSAException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void addEdgeAndDeterminismTest() {
        try {
            automaton.addNode("q1");
            automaton.addNode("q2");
            automaton.addNode("q3");
        } catch (DuplicateElementException e) {
            fail();
        }
        
        assertTrue(automaton.isDeterministic());
        try {
            automaton.addEdge("q1", 'a', "q2");
            assertTrue(automaton.getNodeEdges("q1").contains(new FSA.Edge('a',"q2")));
            assertTrue(automaton.getNodeEdges("q1").size() == 1);
            assertTrue(automaton.isDeterministic());
            
            automaton.addEdge("q1", 'a', "q3");
            assertTrue(automaton.getNodeEdges("q1").contains(new FSA.Edge('a',"q2")));
            assertTrue(automaton.getNodeEdges("q1").contains(new FSA.Edge('a',"q3")));
            assertTrue(automaton.getNodeEdges("q1").size() == 2);
            assertFalse(automaton.isDeterministic());
            
            
            automaton.addEdge("q1", null, "q3");
            assertTrue(automaton.getNodeEdges("q1").contains(new FSA.Edge('a',"q2")));
            assertTrue(automaton.getNodeEdges("q1").contains(new FSA.Edge(null,"q3")));
            assertTrue(automaton.getNodeEdges("q1").size() == 3);
            assertFalse(automaton.isDeterministic());
            
            automaton.removeEdge("q1", 'a', "q3");
            automaton.removeEdge("q1", null, "q3");
            assertFalse(automaton.getNodeEdges("q1").contains(new FSA.Edge('a',"q3")));
            assertTrue(automaton.getNodeEdges("q1").size() == 1);
            assertTrue(automaton.isDeterministic());
            
            automaton.addEdge("q1", 'a', "q3");
            automaton.removeNode("q3");
            assertFalse(automaton.getNodeEdges("q1").contains(new FSA.Edge('a',"q3")));
            assertTrue(automaton.getNodeEdges("q1").size() == 1);
            assertTrue(automaton.isDeterministic());
            
            
            automaton.removeEdge("q1", 'a', "q2");
            automaton.addEdges("q1", "abc","q2");
            assertTrue(automaton.getNodeEdges("q1").size() == 1);
            System.out.println(automaton.toString());
            assertTrue(automaton.getNodes().size() == 5);//q1 -> X a -> Y b -> q2 (c)
            assertTrue(automaton.isDeterministic());
            assertTrue(automaton.getNodeEdges("q1").contains(new FSA.Edge('a',"q1_1")));
            assertTrue(automaton.getNodeEdges("q1_1").contains(new FSA.Edge('b',"q1_2")));
            assertTrue(automaton.getNodeEdges("q1_2").contains(new FSA.Edge('c',"q2")));
            
        } catch (FSAException e) {
            fail();
        }

    }

    @Test
    public void testAcceptance() {
        ANTLRInputStream input = null;
        try {
            input = new ANTLRInputStream(new FileInputStream("dot_dfa_examples/COMP_HW1_NFA.gv"));
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
        dotLexer lex = new dotLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lex);
        dotParser parser = new dotParser(tokens);
        ParseTree tree = parser.graph();

        DotVisitor eva = new DotVisitor();
        DotGraph graph = eva.visit(tree);

        FSA automaton = FSABuilder.buildFrom(graph);

        assertTrue(automaton.accepts("ef"));
        assertTrue(automaton.accepts("abc"));
        assertTrue(automaton.accepts("aaabccccc"));
        assertTrue(automaton.accepts("aaabbbbbb"));
        assertTrue(automaton.accepts("abbbb"));
        assertTrue(automaton.accepts("bbbb"));

        assertFalse(automaton.accepts(""));
        assertFalse(automaton.accepts("e"));
        assertFalse(automaton.accepts("eff"));
        assertFalse(automaton.accepts("abbc"));
        assertFalse(automaton.accepts("bcccc"));
        assertFalse(automaton.accepts("sfgddd"));
        assertFalse(automaton.accepts("aaacccc"));
    }
}
