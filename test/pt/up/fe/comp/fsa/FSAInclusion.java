package pt.up.fe.comp.fsa;

import org.junit.Test;

import java.util.LinkedHashSet;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;

public class FSAInclusion {
    @Test
    public void TestGenericInclusion() {
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

            assertTrue(aut3.isIncludedIn(aut2));
            assertTrue(aut3.isIncludedIn(aut1));
            assertTrue(aut2.isIncludedIn(aut1));
            assertTrue(aut3.isIncludedIn(aut3));
            assertTrue(aut2.isIncludedIn(aut2));
            assertTrue(aut1.isIncludedIn(aut1));

            assertFalse(aut1.isIncludedIn(aut2));
            assertFalse(aut1.isIncludedIn(aut3));
            assertFalse(aut2.isIncludedIn(aut3));
        } catch (FSAException e) {
            e.printStackTrace();
            fail();
        }
    }
}
