package pt.up.fe.comp.fsa;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;
import pt.up.fe.comp.dot.DotVisitor;
import pt.up.fe.comp.dot.ir.DotGraph;
import pt.up.fe.comp.dot.parser.dotLexer;
import pt.up.fe.comp.dot.parser.dotParser;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashSet;

import static junit.framework.TestCase.*;

public class FSAAcceptance {

    @Test
    public void TestStringAcceptance() {
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

    @Test
    public void TestOnlyEmptyString() {
        try {
            FSA newAut = new FSA("aut", "I", new LinkedHashSet<String>());
            newAut.addEdge("I", 'a', "S");
            newAut.addEdge("S", 'a', "A");
            newAut.addEdge("A", 'a', "S");
            newAut.addEdge("A", 'b', "B");
            newAut.addEdge("B", 'b', "A");
            newAut.addNode("C");
            newAut.addEdge("C", 'a', "A");
            newAut.addEdge("C", 'b', "B");

            newAut.addFinalState("I");


            assertTrue(newAut.onlyAcceptsEmptyString());

            newAut.addFinalState("C");
            assertTrue(newAut.onlyAcceptsEmptyString());

            FSA copy = new FSA(newAut);
            copy.addEdge("S", null, "I");

            newAut.addFinalState("B");
            assertFalse(copy.onlyAcceptsEmptyString());
            assertFalse(newAut.onlyAcceptsEmptyString());

        } catch (FSAException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void TestEmptyLanguage() {
        try {
            FSA newAut = new FSA("aut", "S", new LinkedHashSet<String>());
            newAut.addEdge("S", 'a', "A");
            newAut.addEdge("A", 'a', "S");
            newAut.addEdge("A", 'b', "B");
            newAut.addEdge("B", 'b', "A");
            newAut.addNode("C");
            newAut.addEdge("C", 'a', "A");
            newAut.addEdge("C", 'b', "B");

            newAut.addFinalState("C");

            assertTrue(newAut.doesNotAcceptAnything());

            newAut.addFinalState("B");
            assertFalse(newAut.doesNotAcceptAnything());

            assertTrue(newAut.getFinalStates().containsAll(Arrays.asList("B", "C")));

        } catch (FSAException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void TestAcceptAlphabetKleeneStar() {
        try {
            FSA newAut = new FSA("aut", "S", new LinkedHashSet<String>());
            newAut.addEdge("S", 'a', "A");
            newAut.addEdge("S", 'b', "B");
            newAut.addEdge("A", 'a', "A");
            newAut.addEdge("A", 'b', "B");
            newAut.addEdge("B", 'b', "B");
            newAut.addEdge("B", 'a', "A");

            newAut.addFinalState("A");
            newAut.addFinalState("B");

            assertFalse(newAut.acceptsAlphabetKleeneStar()); //does not yet accept empty string

            newAut.addFinalState("S");
            assertTrue(newAut.acceptsAlphabetKleeneStar()); //accepts empty string as well

        } catch (FSAException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void TestAcceptAlphabetKleenePlus() {
        try {
            FSA newAut = new FSA("aut", "S", new LinkedHashSet<String>());
            newAut.addEdge("S", 'a', "A");
            newAut.addEdge("S", 'b', "B");
            newAut.addEdge("A", 'a', "A");
            newAut.addEdge("A", 'b', "B");
            newAut.addEdge("B", 'b', "B");
            newAut.addEdge("B", 'a', "A");

            newAut.addFinalState("A");
            assertFalse(newAut.acceptsAlphabetKleenePlus());
            newAut.addFinalState("B");

            assertTrue(newAut.acceptsAlphabetKleenePlus());

            newAut.addFinalState("S");
            assertTrue(newAut.acceptsAlphabetKleenePlus());

        } catch (FSAException e) {
            e.printStackTrace();
            fail();
        }
    }
}
