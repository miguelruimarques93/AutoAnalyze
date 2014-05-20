package pt.up.fe.comp.fsa;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;

import static junit.framework.TestCase.*;

public class FSAUnreachableAndUseless {

    @Test
    public void TestRemoveUnreachable() {
        try {
            FSA newAut = new FSA("aut", "S", new LinkedHashSet<String>());
            newAut.addEdge("S", 'a', "A");
            newAut.addEdge("A", 'a', "S");
            newAut.addEdge("A", 'b', "B");
            newAut.addEdge("B", 'b', "A");
            newAut.addNode("C");
            newAut.addEdge("C", 'a', "A");
            newAut.addEdge("C", 'b', "B");

            newAut.removeUnreachableStates();

            assertTrue(newAut.getNodes().containsAll(Arrays.asList("S", "A", "B")));
            assertTrue(newAut.getNodes().size() == 3);

        } catch (FSAException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void TestRemoveUseless() {
        try {
            FSA newAut = new FSA("aut", "S", new LinkedHashSet<String>());
            newAut.addEdge("S", 'a', "A");
            newAut.addEdge("A", 'a', "S");
            newAut.addEdge("A", 'b', "B");
            newAut.addEdge("A", 'a', "C");
            newAut.addEdge("B", 'b', "C");
            newAut.addFinalState("A");

            newAut.removeUselessStates();

            assertTrue(newAut.getNodes().containsAll(Arrays.asList("S", "A")));
            assertTrue(newAut.getNodes().size() == 2);
            assertTrue(newAut.getNodeEdges("A").size() == 1);
            assertTrue(newAut.getNodeEdges("S").size() == 1);

        } catch (FSAException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void TestMaintainLanguage() {
        try {
            FSA a = FSALoader.LoadFromFile("dot_dfa_examples/COMP_HW1.gv");
            FSA automaton = FSALoader.LoadFromFile("dot_dfa_examples/COMP_HW1_NFA.gv");

            a.removeUnreachableStates();
            a.removeUselessStates();
            automaton.removeUnreachableStates();
            automaton.removeUselessStates();

            assertTrue(a.accepts("ef"));
            assertTrue(a.accepts("abc"));
            assertTrue(a.accepts("aaabccccc"));
            assertTrue(a.accepts("aaabbbbbb"));
            assertTrue(a.accepts("abbbb"));
            assertTrue(a.accepts("bbbb"));

            assertFalse(a.accepts(""));
            assertFalse(a.accepts("e"));
            assertFalse(a.accepts("eff"));
            assertFalse(a.accepts("abbc"));
            assertFalse(a.accepts("bcccc"));
            assertFalse(a.accepts("sfgddd"));
            assertFalse(a.accepts("aaacccc"));

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
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}