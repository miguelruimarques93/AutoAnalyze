package pt.up.fe.comp.fsa;

import org.junit.Test;

import java.util.LinkedHashSet;

import static junit.framework.TestCase.*;

public class FSAUnion {

    @Test
    public void TestGenericUnion() {
        try {
            FSA aut1 = new FSA("aut1", "q0", new LinkedHashSet<String>()); //ef
            aut1.addEdge("q0", 'e', "q1");
            aut1.addEdge("q1", 'f', "q2");
            aut1.addFinalState("q2");

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

            FSA automaton = aut1.union(aut2).union(aut3);

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

        } catch (FSAException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void TestUnionWithComplement() {
        try {
            FSA aut1 = new FSA("aut1", "q0", new LinkedHashSet<String>());
            aut1.addEdge("q0", 'e', "q1");
            aut1.addEdge("q1", 'f', "q2");
            aut1.addEdge("q2", 'a', "q3");
            aut1.addEdge("q3", 'c', "q4");
            aut1.addEdge("q4", 'l', "q5");
            aut1.addFinalState("q2");

            FSA aut1complement = new FSA(aut1);
            aut1complement.complement();

            FSA automaton = aut1.union(aut1complement);

            assertTrue(automaton.acceptsAlphabetKleeneStar());


        } catch (FSAException e) {
            e.printStackTrace();
            fail();
        }
    }
}
