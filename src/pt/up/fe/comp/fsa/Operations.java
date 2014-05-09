package pt.up.fe.comp.fsa;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Operations {
    public static FSA union(FSA lhs, FSA rhs) {
        throw new UnsupportedOperationException("Not Yet Implemented: " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public static FSA intersect(FSA lhs, FSA rhs) {
        throw new UnsupportedOperationException("Not Yet Implemented: " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public static FSA cartesian(FSA lhs, FSA rhs) {
        throw new UnsupportedOperationException("Not Yet Implemented: " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public static FSA diff(FSA lhs, FSA rhs) {
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
        result.collapseEmptyTransitions();
        return result;
    }

    public static FSA totalize(FSA lhs) {
        FSA result = new FSA(lhs);
        result.makeTotal();
        return result;
    }

    public static FSA remove_unreachable(FSA lhs) {
        throw new UnsupportedOperationException("Not Yet Implemented: " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public static FSA remove_useless(FSA lhs) {
        throw new UnsupportedOperationException("Not Yet Implemented: " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public static Object write_dot(FSA lhs, String fileName) {
        lhs.writeDot(fileName);
        return null;
    }

    public static Object write_regex(FSA lhs) {
        throw new UnsupportedOperationException("Not Yet Implemented: " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public static Object write_code(String language, FSA lhs, String fileName) throws InvocationTargetException, IllegalAccessException {
        try {
            Method m = FSA.class.getMethod("write" + language, String.class);
            return m.invoke(lhs, fileName);
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
