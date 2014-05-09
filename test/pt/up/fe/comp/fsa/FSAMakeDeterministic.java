package pt.up.fe.comp.fsa;

import org.junit.Test;
import static junit.framework.TestCase.assertTrue;

import java.util.HashSet;
import java.util.LinkedHashSet;

import static junit.framework.TestCase.fail;

public class FSAMakeDeterministic {
    private FSA automaton;

    @Test
    public  void TestCollapseEmptyTransitions() {
        try {
            FSA newAut = new FSA("aut","q0", new LinkedHashSet<String>());
            newAut.addEdge("q0", null, "q1");
            newAut.addEdge("q1", null, "q2");
            newAut.addEdge("q1", null, "q0"); //e-loop
            newAut.addEdge("q2", 'a', "q3");
            newAut.addNode("q4");
            newAut.addFinalState("q3");

            newAut.collapseEmptyTransitions();

            System.out.println(newAut);

            assertTrue(newAut.getNodes().contains("q0"));
            assertTrue(newAut.getNodes().contains("q1"));
            assertTrue(newAut.getNodes().contains("q2"));
            assertTrue(newAut.getNodes().size() == 3);
            assertTrue(newAut.getNodeEdges("q0").size() == 1);
            assertTrue(newAut.getNodeEdges("q0").contains(new FSA.Edge('a',"q1")));
            assertTrue(newAut.getFinalStates().contains("q1"));
            assertTrue(newAut.getFinalStates().size() == 1);
            assertTrue(newAut.getInitialState().equals("q0"));

        } catch (FSAException e) {
            e.printStackTrace();
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
            System.out.println(automaton);

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

            System.out.println(automaton);

            automaton.makeDeterministic();
            System.out.println(automaton);

            fail("DFA Equivalence not implemented yet.");

        } catch (FSAException e) {
            e.printStackTrace();
        }
    }
}
