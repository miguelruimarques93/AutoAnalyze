package pt.up.fe.comp.fsa;

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
        throw new UnsupportedOperationException("Not Yet Implemented: " + Thread.currentThread().getStackTrace()[1].getMethodName());
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
        throw new UnsupportedOperationException("Not Yet Implemented: " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public static FSA totalize(FSA lhs) {
        throw new UnsupportedOperationException("Not Yet Implemented: " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public static FSA remove_unreachable(FSA lhs) {
        throw new UnsupportedOperationException("Not Yet Implemented: " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public static FSA remove_useless(FSA lhs) {
        throw new UnsupportedOperationException("Not Yet Implemented: " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public static Object write_dot(FSA lhs, String fileName) {
        throw new UnsupportedOperationException("Not Yet Implemented: " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public static Object write_regex(FSA lhs) {
        throw new UnsupportedOperationException("Not Yet Implemented: " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public static Object write_code(FSA lhs, String language, String fileName) {
        throw new UnsupportedOperationException("Not Yet Implemented: " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public static Object show(FSA lhs) {
        throw new UnsupportedOperationException("Not Yet Implemented: " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public static Object print(FSA lhs) {
        throw new UnsupportedOperationException("Not Yet Implemented: " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
