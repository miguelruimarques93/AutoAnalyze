package pt.up.fe.comp.fsa;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

import static junit.framework.TestCase.fail;

public class FSAMakeDeterministic {
    private FSA automaton;

    @Test
    public  void TestCollapseEmptyTransitions() {
        try {
            FSA newAut = new FSA("aut","P", new LinkedHashSet<String>());
            newAut.addEdge("P", null, "Q");
            newAut.addEdge("P", null, "R");
            newAut.addEdge("Q", 'a', "Q1");
            newAut.addEdge("Q1", 'a', "Q");
            newAut.addEdge("R", 'a', "R1");
            newAut.addEdge("R1", 'a', "R2");
            newAut.addEdge("R2", 'a', "R");

            newAut.addFinalState("Q");
            newAut.addFinalState("R");

            newAut.removeEmptyTransitions();

            //System.out.println(newAut);

            assertTrue(newAut.getNodes().containsAll(Arrays.asList("P","Q","R","Q1","R1","R2")));
            assertTrue(newAut.getNodes().size() == 6);

            assertTrue(newAut.getFinalStates().containsAll(Arrays.asList("P","Q","R")));
            assertTrue(newAut.getFinalStates().size() == 3);

            assertTrue(newAut.getNodeEdges("P").contains(new FSA.Edge('a',"Q1")));
            assertTrue(newAut.getNodeEdges("P").contains(new FSA.Edge('a',"R1")));
            assertTrue(newAut.getNodeEdges("P").size() == 2);

            assertTrue(newAut.getInitialState().equals("P"));

        } catch (FSAException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void TestMakeDeterministic() {
        try {
            automaton = new FSA("lol", "lol", new HashSet<String>());
            automaton.addNode("lol1");
            automaton.addNode("lol2");

            automaton.addEdge("lol", 'a', "lol1");
            automaton.addEdge("lol", 'a', "lol2");
            automaton.addEdge("lol", 'b', "lol2");
            automaton.addEdge("lol1", 'b', "lol2");

            automaton.addFinalState("lol2");

            assert(!automaton.isDeterministic());

            automaton.makeDeterministic();
            //System.out.println(automaton);

            fail("DFA Equivalence not implemented yet.");

        } catch (FSAException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestMakeDeterministic1() {
        try {
            automaton = new FSA("S", "S", new HashSet<String>());
            automaton.addNode("A");
            automaton.addNode("B");

            automaton.addEdge("S", 'a', "A");
            automaton.addEdge("S", 'b', "B");
            automaton.addEdge("B", 'b', "A");
            automaton.addEdge("B", 'b', "B");
            automaton.addEdge("A", 'a', "A");

            automaton.addFinalState("A");

            assert(!automaton.isDeterministic());

            //System.out.println(automaton);

            automaton.makeDeterministic();
            //System.out.println(automaton);

            fail("DFA Equivalence not implemented yet.");

        } catch (FSAException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestMaintainLanguage() {
        try {
            FSA a = FSALoader.LoadFromFile("dot_dfa_examples/COMP_HW1.gv");
            FSA automaton = FSALoader.LoadFromFile("dot_dfa_examples/COMP_HW1_NFA.gv");

            a.makeDeterministic();
            automaton.makeDeterministic();

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
