package pt.up.fe.comp.fsa;

import static junit.framework.TestCase.*;

import org.junit.Test;

public class FSAFromRegExp {

    @Test
    public void TestGenericRegExp() {
        try {
            FSA automaton = new FSA("COMP_HW1", "a*bb*|aa*bc*|ef");

            System.out.print(automaton);

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
