package pt.up.fe.comp.fsa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Operations {
    public static FSA union(FSA... args) {
        throw new UnsupportedOperationException("Not Yet Implemented: " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public static FSA intersect(FSA... args) {
        throw new UnsupportedOperationException("Not Yet Implemented: " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public static FSA cartesian(FSA... args) {
        throw new UnsupportedOperationException("Not Yet Implemented: " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public static FSA diff(FSA... args) {
        throw new UnsupportedOperationException("Not Yet Implemented: " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public static FSA closure(FSA lhs) {
        throw new UnsupportedOperationException("Not Yet Implemented: " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public static FSA complement(FSA lhs) {
        FSA result = new FSA(lhs);
        result.complement();
        return result;
    }

    public static FSA min(FSA lhs) {
        throw new UnsupportedOperationException("Not Yet Implemented: " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public static FSA to_dfa(FSA lhs) {
        FSA result = new FSA(lhs);
        result.makeDeterministic();
        return result;
    }

    public static Boolean in(FSA lhs, FSA rhs) {
        throw new UnsupportedOperationException("Not Yet Implemented: " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public static Boolean equi(FSA lhs, FSA rhs) {
        throw new UnsupportedOperationException("Not Yet Implemented: " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public static Boolean equals(FSA lhs, FSA rhs) {
        throw new UnsupportedOperationException("Not Yet Implemented: " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public static FSA remove_e(FSA lhs) {
        FSA result = new FSA(lhs);
        result.removeEmptyTransitions();
        return result;
    }

    public static FSA totalize(FSA lhs) {
        FSA result = new FSA(lhs);
        result.makeTotal();
        return result;
    }

    public static FSA remove_unreachable(FSA lhs) {
        FSA result = new FSA(lhs);
        result.removeUnreachableStates();
        return result;
    }

    public static FSA remove_useless(FSA lhs) {
        FSA result = new FSA(lhs);
        result.removeUselessStates();
        return result;
    }

    public static Object write_dot(FSA lhs, String fileName) throws FileNotFoundException {
        PrintStream stream = new PrintStream(fileName);

        lhs.writeDot(stream);
        return null;
    }

    public static Object write_regex(FSA lhs) {
        throw new UnsupportedOperationException("Not Yet Implemented: " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public static Object write_code(String language, FSA lhs, String fileName) throws InvocationTargetException, IllegalAccessException, FileNotFoundException {
        try {
            File f = new File(fileName);
            String moduleName = f.getName().substring(0, f.getName().indexOf('.') > 0 ? f.getName().indexOf('.') : f.getName().length());
            PrintStream stream = new PrintStream(f);

            Method m = FSA.class.getMethod("write_" + language.toLowerCase(), String.class);
            return m.invoke(lhs, moduleName, stream);
        } catch (NoSuchMethodException e) {
            throw new UnsupportedOperationException("No output to language '" + language + "' defined.");
        }
    }

    public static Object show(FSA lhs) {
        throw new UnsupportedOperationException("Not Yet Implemented: " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public static Object print(FSA lhs) {
        throw new UnsupportedOperationException("Not Yet Implemented: " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
