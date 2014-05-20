package pt.up.fe.comp.fsa;

import junit.framework.TestCase;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;
import pt.up.fe.comp.dot.DotVisitor;
import pt.up.fe.comp.dot.ir.DotGraph;
import pt.up.fe.comp.dot.parser.dotLexer;
import pt.up.fe.comp.dot.parser.dotParser;

import java.io.FileInputStream;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class FSABuildTest {
    @Test
    public void LoadFromFile() {
        try {
            ANTLRInputStream input = new ANTLRInputStream(new FileInputStream("dot_dfa_examples/fsm.gv"));
            dotLexer lex = new dotLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lex);
            dotParser parser = new dotParser(tokens);
            ParseTree tree = parser.graph();

            DotVisitor eval = new DotVisitor();
            DotGraph graph = eval.visit(tree);

            FSA automaton = FSABuilder.buildFrom(graph);

            assertTrue(automaton.getName().equals(graph.name));

            assertTrue(automaton.getFinalStates().contains("LR_0"));
            assertTrue(automaton.getFinalStates().contains("LR_3"));
            assertTrue(automaton.getFinalStates().contains("LR_4"));
            assertTrue(automaton.getFinalStates().contains("LR_8"));

            assertTrue(automaton.getNodes().containsAll(graph.getNodes()));

            assertTrue(automaton.getInitialState().equals("LR_0"));

            assertTrue(automaton.isDeterministic());


        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void LoadFromFileWithRegex() {
        try {
            ANTLRInputStream input = new ANTLRInputStream(new FileInputStream("dot_dfa_examples/COMP_HW1_REGEX.gv"));
            dotLexer lex = new dotLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lex);
            dotParser parser = new dotParser(tokens);
            ParseTree tree = parser.graph();

            DotVisitor eval = new DotVisitor();
            DotGraph graph = eval.visit(tree);

            FSA automaton = FSABuilder.buildFrom(graph);

            TestCase.assertTrue(automaton.accepts("ef"));
            TestCase.assertTrue(automaton.accepts("abc"));
            TestCase.assertTrue(automaton.accepts("aaabccccc"));
            TestCase.assertTrue(automaton.accepts("aaabbbbbb"));
            TestCase.assertTrue(automaton.accepts("abbbb"));
            TestCase.assertTrue(automaton.accepts("bbbb"));

            assertFalse(automaton.accepts(""));
            assertFalse(automaton.accepts("e"));
            assertFalse(automaton.accepts("eff"));
            assertFalse(automaton.accepts("abbc"));
            assertFalse(automaton.accepts("bcccc"));
            assertFalse(automaton.accepts("sfgddd"));
            assertFalse(automaton.accepts("aaacccc"));

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
