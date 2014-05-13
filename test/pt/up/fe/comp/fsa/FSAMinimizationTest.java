package pt.up.fe.comp.fsa;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;

import java.util.Arrays;
import java.util.LinkedHashSet;

import org.junit.Test;

public class FSAMinimizationTest {
    @Test
    public void MinimizationTest() {
        try {
            FSA newAut = new FSA("aut","S", new LinkedHashSet<String>());
            newAut.addEdge("S", 'a', "A");
            newAut.addEdge("A", 'b', "B");
            newAut.addEdge("B", 'a', "A");

            newAut.addFinalState("A");

            newAut.minimize();

            System.out.println(newAut);

            assertTrue(newAut.getNodes().containsAll(Arrays.asList("S", "A")));
            assertTrue(newAut.getNodes().size() == 2);

            assertTrue(newAut.getNodeEdges("S").size()==1);
            assertTrue(newAut.getNodeEdges("A").size()==1);

            assertTrue(newAut.getNodeEdges("S").contains(new FSA.Edge('a',"A")));
            assertTrue(newAut.getNodeEdges("A").contains(new FSA.Edge('b',"S")));

        } catch (FSAException e) {
            e.printStackTrace();
            fail();
        }
    }
}
