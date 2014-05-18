package pt.up.fe.comp.fsa;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;

public class FSAEquivalence {

    @Test
    public void TestEquivalenceDFAToNFA() {
        try {
            FSA a = FSALoader.LoadFromFile("dot_dfa_examples/COMP_HW1.gv");
            FSA b = FSALoader.LoadFromFile("dot_dfa_examples/COMP_HW1_NFA.gv");

            assertTrue(a.equals(b));
            a.addEdge("q0", null, "qq");
            assertTrue(a.equals(b));
            a.addFinalState("qq");
            assertFalse(a.equals(b));
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

}
