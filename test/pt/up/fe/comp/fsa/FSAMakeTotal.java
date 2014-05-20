package pt.up.fe.comp.fsa;

import org.junit.Test;

import java.util.HashSet;


public class FSAMakeTotal {
    private FSA automaton;

    @Test
    public void TestMakeTotal() {
        try {
            automaton = new FSA("lol", "lol", new HashSet<String>());
            automaton.addNode("lol1");
            automaton.addNode("lol2");

            automaton.addEdge("lol", 'a', "lol1");
            automaton.addEdge("lol", 'a', "lol2");
            automaton.addEdge("lol", 'b', "lol2");
            automaton.addEdge("lol1", 'b', "lol2");

            automaton.addFinalState("lol2");

            assert (!automaton.isTotal());

            automaton.makeTotal();

            assert (automaton.isTotal());

        } catch (FSAException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestMakeTotal1() {
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

            assert (!automaton.isTotal());

            automaton.makeTotal();

            assert (automaton.isTotal());

        } catch (FSAException e) {
            e.printStackTrace();
        }
    }
}
