package pt.up.fe.comp.fsa;

import org.junit.Test;

import java.io.PrintStream;
import java.util.LinkedHashSet;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;

public class FSACartesian {

    @Test
    public void TestCartesianGenericUnion() {
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

            FSA automaton = aut1.cartesian(aut2, FSA.CartesianType.UNION).cartesian(aut3, FSA.CartesianType.UNION);

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
    public void TestCartesianUnionWithComplement() {
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

            FSA automaton = aut1.cartesian(aut1complement, FSA.CartesianType.UNION);

            assertTrue(automaton.acceptsAlphabetKleeneStar());


        } catch (FSAException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void TestGenericCartesianIntersection() {
        try {
            FSA aut1 = new FSA("aut1", "q0", new LinkedHashSet<String>()); //(abc)*
            aut1.addEdge("q0", 'a', "q0");
            aut1.addEdge("q0", 'b', "q0");
            aut1.addEdge("q0", 'c', "q0");
            aut1.addFinalState("q0");

            FSA aut2 = new FSA("aut1", "q0", new LinkedHashSet<String>()); //(ab)*
            aut2.addEdge("q0", 'a', "q0");
            aut2.addEdge("q0", 'b', "q0");
            aut2.addFinalState("q0");

            FSA aut3 = new FSA("aut1", "q0", new LinkedHashSet<String>()); //a*
            aut3.addEdge("q0", 'a', "q0");
            aut3.addFinalState("q0");

            FSA aut4 = aut1.cartesian(aut2, FSA.CartesianType.INTERSECTION);
            FSA automaton = aut4.cartesian(aut3, FSA.CartesianType.INTERSECTION);

            automaton.minimize();

            assertTrue(aut1.accepts("a"));
            assertTrue(aut1.accepts("aa"));
            assertTrue(aut1.accepts(""));
            assertTrue(aut1.accepts("b"));
            assertTrue(aut1.accepts("bb"));
            assertTrue(aut1.accepts("c"));
            assertTrue(aut1.accepts("cc"));

            assertTrue(aut4.accepts("a"));
            assertTrue(aut4.accepts("aa"));
            assertTrue(aut4.accepts(""));
            assertTrue(aut4.accepts("b"));
            assertTrue(aut4.accepts("bb"));
            assertFalse(aut4.accepts("c"));
            assertFalse(aut4.accepts("cc"));

            assertTrue(automaton.accepts("a"));
            assertTrue(automaton.accepts("aa"));
            assertTrue(automaton.accepts(""));
            assertFalse(automaton.accepts("b"));
            assertFalse(automaton.accepts("bb"));
            assertFalse(automaton.accepts("c"));
            assertFalse(automaton.accepts("cc"));

        } catch (FSAException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void TestCartesianIntersectionNFAWithDFA() {
        try {
            FSA a = FSALoader.LoadFromFile("dot_dfa_examples/COMP_HW1.gv");
            FSA b = FSALoader.LoadFromFile("dot_dfa_examples/COMP_HW1_NFA.gv");

            FSA automaton = a.cartesian(b, FSA.CartesianType.INTERSECTION);
            automaton.write_prolog("stff",new PrintStream("testing.hs"));

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

    @Test
    public void TestCartesianIntersectionWithComplement() {
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

            FSA automaton = aut1.cartesian(aut1complement, FSA.CartesianType.INTERSECTION);

            assertTrue(automaton.doesNotAcceptAnything());
        } catch (FSAException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void TestGenericCartesianDifference() {
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

            FSA automaton = aut1.cartesian(aut2, FSA.CartesianType.DIFF);

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
    public void TestCartesianDifferenceWithSelf() {
        try {
            FSA aut1 = new FSA("aut1", "q0", new LinkedHashSet<String>());
            aut1.addEdge("q0", 'e', "q1");
            aut1.addEdge("q1", 'f', "q2");
            aut1.addEdge("q2", 'a', "q3");
            aut1.addEdge("q3", 'c', "q4");
            aut1.addEdge("q4", 'l', "q5");
            aut1.addFinalState("q2");

            FSA automaton = aut1.cartesian(aut1, FSA.CartesianType.DIFF);

            assertTrue(automaton.doesNotAcceptAnything());
        } catch (FSAException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void TestCartesianXOR() {
        try {
            FSA aut1 = new FSA("aut1", "q0", new LinkedHashSet<String>());
            aut1.addEdge("q0", 'a', "q0");
            aut1.addEdge("q0", 'c', "q0");
            aut1.addFinalState("q0");

            FSA aut2 = new FSA("aut1", "q0", new LinkedHashSet<String>());
            aut2.addEdge("q0", 'b', "q0");
            aut2.addEdge("q0", 'c', "q0");
            aut2.addFinalState("q0");

            FSA automaton = aut1.cartesian(aut2, FSA.CartesianType.XOR);
            assertTrue(automaton.accepts("a"));
            assertTrue(automaton.accepts("aa"));
            assertTrue(automaton.accepts("aaa"));
            assertTrue(automaton.accepts("ac"));
            assertTrue(automaton.accepts("acacca"));
            assertTrue(automaton.accepts("ccaacaca"));
            assertTrue(automaton.accepts("b"));
            assertTrue(automaton.accepts("bb"));
            assertTrue(automaton.accepts("bbb"));
            assertTrue(automaton.accepts("bc"));
            assertTrue(automaton.accepts("bcbccb"));
            assertTrue(automaton.accepts("ccbbcbcb"));

            assertFalse(automaton.accepts(""));
            assertFalse(automaton.accepts("c"));
            assertFalse(automaton.accepts("cc"));
            assertFalse(automaton.accepts("ccc"));
            assertFalse(automaton.accepts("ab"));
            assertFalse(automaton.accepts("abcacbca"));
            assertFalse(automaton.accepts("sdjgdfjd"));

        } catch (FSAException e) {
            e.printStackTrace();
            fail();
        }
    }
}
