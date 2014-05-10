package pt.up.fe.comp.fsa;

import junit.framework.Assert;
import org.junit.Test;
import static junit.framework.TestCase.assertTrue;

import java.util.Arrays;
import java.util.LinkedHashSet;

import static junit.framework.TestCase.fail;

public class FSARemoveUnreachable {

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

            assertTrue(newAut.getNodes().containsAll(Arrays.asList("S","A","B")));
            assertTrue(newAut.getNodes().size() == 3);

        } catch (FSAException e) {
            e.printStackTrace();
            fail();
        }
    }
}