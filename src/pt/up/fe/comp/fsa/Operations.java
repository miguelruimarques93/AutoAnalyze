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

    /**
     * Creates a new automaton from the given one and complements it.
     *  I.e. it will accept strings iff they were not accepted by the original automaton.
     *
     * @param lhs FSA to complement
     * @return returns a new automaton that is the complement of lhs
     */
    public static FSA complement(FSA lhs) {
        FSA result = new FSA(lhs);
        result.complement();
        return result;
    }

    /**
     * Creates a new automaton from the given one and makes it minimal.
     *  If automaton is not deterministic, it will be determinized first.
     *
     * @param lhs FSA to minimize
     * @return returns a new deterministic automaton equivalent to lhs but minimal
     */
    public static FSA min(FSA lhs) {
        FSA result = new FSA(lhs);
        result.minimize();
        return result;
    }

    /**
     * Creates a new automaton from the given one and makes it deterministic.
     *
     * @param lhs FSA to determinize
     * @return returns a new automaton equivalent to lhs but deterministic
     */
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

    /**
     * Determines whether an automaton's accepted language is the empty set.
     *
     * @param lhs automaton to test
     * @return returns true if lhs does not accept any string, false otherwise
     */
    public static Boolean empty_language(FSA lhs) {
        return lhs.doesNotAcceptAnything();
    }

    /**
     * Determines whether an automaton accepts a given string.
     *
     * @param lhs automaton to test
     * @param rhs string of inputs for the automaton
     * @return returns true if lhs does not accept any string, false otherwise
     */
    public static Boolean accepts(FSA lhs, String rhs) {
        return lhs.accepts(rhs);
    }

    /**
     * Creates a new automaton from the given one and removes all empty transitions from it. (eNFA to NFA)
     *
     * @param lhs eNFA to convert
     * @return returns a new automaton equivalent to lhs but without empty transitions
     */
    public static FSA remove_e(FSA lhs) {
        FSA result = new FSA(lhs);
        result.removeEmptyTransitions();
        return result;
    }

    /**
     * Creates a new automaton from the given one and makes it total.
     *
     *  I.e. Every state will have at least one transition for every character in the automaton's alphabet.
     *   Previously undefined transitions will lead to a new trap state.
     *
     * @param lhs FSA to totalize
     * @return returns a new automaton equivalent to lhs but total
     */
    public static FSA totalize(FSA lhs) {
        FSA result = new FSA(lhs);
        result.makeTotal();
        return result;
    }

    /**
     * Creates a new automaton from the given one and removes all it's unreachable states.
     *
     * @param lhs FSA to convert
     * @return returns a new automaton equivalent to lhs but without unreachable states
     */
    public static FSA remove_unreachable(FSA lhs) {
        FSA result = new FSA(lhs);
        result.removeUnreachableStates();
        return result;
    }

    /**
     * Creates a new automaton from the given one and removes all it's useless states.
     *  A state is useless if it is a trap state (cannot reach a final state).
     *
     *  However, the initial state is always kept.
     *
     * @param lhs FSA to convert
     * @return returns a new automaton equivalent to lhs but without useless states
     */
    public static FSA remove_useless(FSA lhs) {
        FSA result = new FSA(lhs);
        result.removeUselessStates();
        return result;
    }

    /**
     * Generates dot output for a given automaton.
     *
     * @param lhs automaton to write as dot
     * @param fileName path where to write the output
     * @return always returns null
     * @throws FileNotFoundException if it fails to open a PrintStream for fileName
     */
    public static Object write_dot(FSA lhs, String fileName) throws FileNotFoundException {
        PrintStream stream = new PrintStream(fileName);

        lhs.writeDot(stream);
        return null;
    }

    public static Object write_regex(FSA lhs) {
        throw new UnsupportedOperationException("Not Yet Implemented: " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     * Generates code output for the implementation of a given automaton in the specified language.
     *  The generated code exports an acceptance method which allows to test whether a given string is accepted by the automaton or not.
     *
     * @param language language in which to generate the code
     * @param lhs automaton for which to generate code implementation
     * @param fileName path where to write the output
     * @return returns an invocation for the write method associated with the specified language
     * @throws InvocationTargetException if the underlying method throws an exception
     * @throws IllegalAccessException if this Method object is enforcing Java language access control and the underlying method is inaccessible
     * @throws FileNotFoundException if it fails to open a PrintStream for fileName
     * @throws UnsupportedOperationException if there is no method to generate the implementation in the specified language
     */
    public static Object write_code(String language, FSA lhs, String fileName) throws InvocationTargetException, IllegalAccessException, FileNotFoundException {
        try {
            File f = new File(fileName);
            String moduleName = f.getName().substring(0, f.getName().indexOf('.') > 0 ? f.getName().indexOf('.') : f.getName().length());
            PrintStream stream = new PrintStream(f);

            Method m = FSA.class.getMethod("write_" + language.toLowerCase(), String.class, PrintStream.class);
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

    /**
     * 'Not' operator, used to negate boolean values.
     *
     * @param val value to negate
     * @return returns false if val is true, false otherwise
     */
    public static Boolean not(Boolean val) {
        return !val;
    }
}
