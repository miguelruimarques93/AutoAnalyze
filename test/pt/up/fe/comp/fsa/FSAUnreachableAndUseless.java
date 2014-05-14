package pt.up.fe.comp.fsa;

import org.junit.Test;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;

import java.util.Arrays;
import java.util.LinkedHashSet;

import static junit.framework.TestCase.fail;

public class FSAUnreachableAndUseless {

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
            
            assertTrue(newAut.getFinalStates().containsAll(Arrays.asList("B","C")));

        } catch (FSAException e) {
            e.printStackTrace();
            fail();
        }
    }

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
}