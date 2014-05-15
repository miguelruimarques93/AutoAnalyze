package pt.up.fe.comp.fsa;

import org.junit.Test;

import java.util.LinkedHashSet;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;

public class FSADifference {

    @Test
    public void TestGenericDifference() {
        try {
            FSA aut1 = new FSA("aut1", "q0", new LinkedHashSet<String>()); //(abc)*
            aut1.addEdge("q0", 'a', "q0");
            aut1.addFinalState("q0");

            FSA aut2 = new FSA("aut1", "q0", new LinkedHashSet<String>()); //(ab)*
            aut2.addEdge("q0", 'a', "q1");
            aut2.addEdge("q1", 'a', "q2");
            aut2.addEdge("q2", 'a', "q3");
            aut2.addEdge("q3", 'a', "q3");
            aut2.addFinalState("q3");

            FSA automaton = aut1.diff(aut2);

            assertTrue(automaton.accepts("a"));
            assertTrue(automaton.accepts("aa"));
            assertTrue(automaton.accepts(""));

            assertFalse(automaton.accepts("aaa"));
            assertFalse(automaton.accepts("aaaa"));
            assertFalse(automaton.accepts("aaaaa"));
            assertFalse(automaton.accepts("aaaaaa"));

        } catch (FSAException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void TestDifferenceWithSelf() {
        try {
            FSA aut1 = new FSA("aut1", "q0", new LinkedHashSet<String>());
            aut1.addEdge("q0", 'e', "q1");
            aut1.addEdge("q1", 'f', "q2");
            aut1.addEdge("q2", 'a', "q3");
            aut1.addEdge("q3", 'c', "q4");
            aut1.addEdge("q4", 'l', "q5");
            aut1.addFinalState("q2");

            FSA automaton = aut1.diff(aut1);

            assertTrue(automaton.doesNotAcceptAnything());
        } catch (FSAException e) {
            e.printStackTrace();
            fail();
        }
    }
}
