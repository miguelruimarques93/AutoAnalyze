package pt.up.fe.comp.fsa;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileInputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import pt.up.fe.comp.dot.DotVisitor;
import pt.up.fe.comp.dot.ir.DotGraph;
import pt.up.fe.comp.dot.parser.dotLexer;
import pt.up.fe.comp.dot.parser.dotParser;

public class FSABuildTest {
    @Test
    public void LoadFromFile(){
        try {
            ANTLRInputStream input = new ANTLRInputStream(new FileInputStream("dot_dfa_examples/fsm.gv"));
            dotLexer lex = new dotLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lex);            
            dotParser parser = new dotParser(tokens);
            ParseTree tree = parser.graph();
            
            DotVisitor eval = new DotVisitor();
            DotGraph graph = eval.visit(tree);
            
            FSA automata = FSABuilder.buildFrom(graph);
            
            assertTrue(automata.getName().equals(graph.name));
            
            assertTrue(automata.getFinalStates().contains("LR_0"));
            assertTrue(automata.getFinalStates().contains("LR_3"));
            assertTrue(automata.getFinalStates().contains("LR_4"));
            assertTrue(automata.getFinalStates().contains("LR_8"));
            
            assertTrue(automata.getNodes().containsAll(graph.getNodes()));
            
            assertTrue(automata.getInitialState().equals("LR_0"));
            
            assertTrue(automata.isDeterministic());
            
            
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
