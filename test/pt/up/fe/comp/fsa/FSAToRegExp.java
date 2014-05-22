package pt.up.fe.comp.fsa;

import org.junit.Test;
import static junit.framework.TestCase.*;

public class FSAToRegExp {

    @Test
    public void TestToRegExp0() {
        try {
            FSA a = new FSA("aut", "a*");
            FSA b = new FSA("aut2", a.toRegex());
            assertTrue(a.equals(b));
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void TestToRegExp1() {
            try {
            FSA a = new FSA("aut", "a");
            String aReg = a.toRegex();
            FSA b = new FSA("aut2", aReg);
            assertTrue(a.equals(b));
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
     public void TestToRegExp2() {
        try {
            FSA a = new FSA("aut", "ab");
            String aReg = a.toRegex();
            FSA b = new FSA("aut2", aReg);
            assertTrue(a.equals(b));
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
     public void TestToRegExp3() {
        try {
            FSA a = new FSA("aut", "ab(cd)*e{20}");
            String aReg = a.toRegex();
            FSA b = new FSA("aut2", aReg);
            assertTrue(a.equals(b));
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void TestToRegExpCOMPHW1() {
        try {
            FSA a = new FSA("aut", "a*bb*|aa*bc*|ef");
            String aReg = a.toRegex();
            FSA b = new FSA("aut2", aReg);
            assertTrue(a.equals(b));
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void TestToRegExpMessedUp() {
        try {
            FSA a = new FSA("aut", "(a*bb*|aa*bc*|ef){4}zy?d");
            String aReg = a.toRegex();
            //System.out.println(aReg); lol
            FSA b = new FSA("aut2", aReg);
            assertTrue(a.equals(b));
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
