package pt.up.fe.comp.fsa;


import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;

public class FSAAppend {
    @Test
    public void TestAppend() {
        try {
            FSA automaton = new FSA("aut1", "q0", new LinkedHashSet<String>()); //ef
            automaton.addEdge("q0", 'e', "q1");
            automaton.addEdge("q1", 'f', "q2");
            automaton.addFinalState("q2");

            FSA aut2 = new FSA("aut1", "q0", new LinkedHashSet<String>()); //a*bb*
            aut2.addEdge("q0", 'a', "q0");
            aut2.addEdge("q0", 'b', "q1");
            aut2.addEdge("q1", 'b', "q1");
            aut2.addFinalState("q1");

            FSA aut3 = new FSA("aut1", "q0", new LinkedHashSet<String>()); //aa*bc*
            aut3.addEdge("q0", 'a', "q1");
            aut3.addEdge("q1", 'a', "q1");
            aut3.addEdge("q1", 'b', "q2");
            aut3.addEdge("q2", 'c', "q2");
            aut3.addFinalState("q2");

            automaton.concat(aut2);
            automaton.concat(aut3);

            assertTrue(automaton.accepts("efabbbbabccc"));

            assertFalse(automaton.accepts("abc"));
            assertFalse(automaton.accepts("aaabccccc"));
            assertFalse(automaton.accepts("aaabbbbbb"));
            assertFalse(automaton.accepts("abbbb"));
            assertFalse(automaton.accepts("bbbb"));
            assertFalse(automaton.accepts(""));
            assertFalse(automaton.accepts("e"));
            assertFalse(automaton.accepts("eff"));
            assertFalse(automaton.accepts("abbc"));
            assertFalse(automaton.accepts("bcccc"));
            assertFalse(automaton.accepts("sfgddd"));
            assertFalse(automaton.accepts("aaacccc"));

        } catch (FSAException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void TestAppendWithoutRename() {
        try {
            FSA automaton = new FSA("aut1", "q0", new LinkedHashSet<String>()); //ef
            automaton.addEdge("q0", 'e', "q1");
            automaton.addEdge("q1", 'f', "q2");
            automaton.addFinalState("q2");

            FSA aut2 = new FSA("aut1", "A", new LinkedHashSet<String>()); //a*bb*
            aut2.addEdge("A", 'a', "A");
            aut2.addEdge("A", 'b', "B");
            aut2.addEdge("B", 'b', "B");
            aut2.addFinalState("B");

            FSA aut3 = new FSA("aut1", "S", new LinkedHashSet<String>()); //aa*bc*
            aut3.addEdge("S", 'a', "S1");
            aut3.addEdge("S1", 'a', "S1");
            aut3.addEdge("S1", 'b', "S2");
            aut3.addEdge("S2", 'c', "S2");
            aut3.addFinalState("S2");

            automaton.concat(aut2);
            automaton.concat(aut3);

            assertTrue(automaton.getNodes().containsAll(Arrays.asList("q0", "q1", "q2", "A", "B", "S", "S1", "S2")));

            assertTrue(automaton.accepts("efabbbbabccc"));

            assertFalse(automaton.accepts("ef"));
            assertFalse(automaton.accepts("abc"));
            assertFalse(automaton.accepts("aaabccccc"));
            assertFalse(automaton.accepts("aaabbbbbb"));
            assertFalse(automaton.accepts("abbbb"));
            assertFalse(automaton.accepts("bbbb"));
            assertFalse(automaton.accepts(""));
            assertFalse(automaton.accepts("e"));
            assertFalse(automaton.accepts("eff"));
            assertFalse(automaton.accepts("abbc"));
            assertFalse(automaton.accepts("bcccc"));
            assertFalse(automaton.accepts("sfgddd"));
            assertFalse(automaton.accepts("aaacccc"));

        } catch (FSAException e) {
            e.printStackTrace();
            fail();
        }
    }
}
