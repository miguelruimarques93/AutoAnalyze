package pt.up.fe.comp.fsa;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class Operations {

    /**
     * Computes the union between several automata. (Minimum of two).
     *
     * @param args array of automata to unite
     * @return returns a new eNFA that is the union of all the supplied automata.
     */
    public static FSA union(FSA arg1, FSA arg2, FSA... args) {
        FSA result = arg1.union(arg2);
        for (FSA automaton: args) {
            result = result.union(automaton);
        }
        return result;
    }

    /**
     * Computes the intersection between several automata. (Minimum of two).
     *
     * @param args array of automata to intersect
     * @return returns a new eNFA that is the intersection of all the supplied automata.
     */
    public static FSA intersect(FSA arg1, FSA arg2, FSA... args) {
        FSA result = arg1.intersect(arg2);
        for (FSA automaton: args) {
            result = result.intersect(automaton);
        }
        return result;
    }

    /**
     * Computes the cartesian product of the automata (minimum of two).
     *  The resulting automaton will either have no final states or be the union, intersection, difference or XOR of the automata,
     *  deppending on the specified type for the operation.
     *
     *  After the cartesian product is calculated, the resulting automaton will have a state for every combination of states of the supplied automata.
     *
     *  Operation types:
     *      UNION - Computes the union of the languages accepted by the automata
     *      INTERSECTION - Computes the intersection of the languages accepted by the automata
     *      XOR - Computes the exclusive or of the languages accepted by the automata
     *      DIFF - Computes the difference between the languages accepted by the automata, in the same order as they are supplied
     *      NONE - Resulting automaton will have no final states
     *
     * @param opType indicates the desired operation type and must have one of the following values: "union", "intersection", "xor", "diff", "none".
     * @param args array of automata to operate with
     * @return returns a new automaton that is the cartesian product of all the supplied automata
     */
    public static FSA cartesian(String opType, FSA arg1, FSA arg2, FSA... args) {
        try {
            FSA.CartesianType _opType = FSA.CartesianType.valueOf(opType.toUpperCase());
            FSA result = arg1.cartesian(arg2, _opType);
            for (FSA automaton: args) {
                result = result.cartesian(automaton, _opType);
            }
            return result;
        } catch(Exception e) {
            throw new Error("No such operation type: " + opType);
        }
    }

    /**
     * Computes the difference between several automata. (Minimum of two).
     *
     * @param args array of automata to operate with
     * @return returns a new eNFA that is the difference between the automata
     */
    public static FSA diff(FSA arg1, FSA arg2, FSA... args) {
        FSA result = arg1.diff(arg2);
        for (FSA automaton: args) {
            result = result.diff(automaton);
        }
        return result;
    }

    /*
    public static FSA closure(FSA arg1, FSA arg2, FSA lhs) {
        throw new UnsupportedOperationException("Not Yet Implemented: " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }*/

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
     * Changes the name of an automaton.
     *
     * @param lhs automaton to rename
     * @param newName new name of the automaton
     * @return returns a new automaton with altered name
     */
    public static FSA change_name(FSA lhs, String newName) {
        FSA copy = new FSA(lhs);
        copy.setName(newName);
        return copy;
    }

    /**
     * Adds a state to the automaton as well as all associated edges.
     *
     * @param lhs automaton to operate on
     * @param newNode state to add
     * @return returns a new automaton with altered node set
     */
    public static FSA add_state(FSA lhs, String newNode) {
        FSA copy = new FSA(lhs);
        try {
            copy.addNode(newNode);
        } catch (DuplicateElementException e) {
            throw new Error("State already exists in FSA.");
        }
        return copy;
    }

    /**
     * Adds an edge to the automaton.
     *
     * @param lhs automaton to operate on
     * @param origin origin state of the edge
     * @param label edge label, if empty string, an empty transition is added
     * @param destination destination state of the edge
     * @return returns a new automaton with altered edge set
     */
    public static FSA add_edge(FSA lhs, String origin, String label, String destination) {
        FSA copy = new FSA(lhs);
        try {
            copy.addEdges(origin, label, destination);
        } catch (DuplicateElementException e) {
            throw new Error("Edge already exists in FSA.");
        } catch (NoSuchNodeException e) {
            throw new Error("Origin state does not exist in FSA.");
        }
        return copy;
    }

    /**
     * Changes the initial state of an automaton as long as it exists.
     *
     * @param lhs automaton to operate on
     * @param newInitialState state to be the new initial state
     * @return returns a new automaton with altered initial state
     */
    public static FSA change_initial_state(FSA lhs, String newInitialState) {
        FSA copy = new FSA(lhs);
        try {
            copy.setInitialState(newInitialState);
        } catch (NoSuchNodeException e) {
            throw new Error("Specified initial state does not exist in FSA: " + newInitialState);
        }
        return copy;
    }

    /**
     * Removes a state from the automaton as well as all associated edges.
     *
     * @param lhs automaton to operate on
     * @param oldNode state to remove
     * @return returns a new automaton with altered node set
     */
    public static FSA remove_state(FSA lhs, String oldNode) {
        if (lhs.getInitialState().equals(oldNode)) {
            throw new Error("Cannot remove initial state.");
        }
        FSA copy = new FSA(lhs);
        try {
            copy.removeNode(oldNode);
        } catch (NoSuchNodeException e) {
            throw new Error("State to remove does not exist in FSA.");
        }
        return copy;
    }

    /**
     * Removes an edge from the automaton.
     *
     * @param lhs automaton to operate on
     * @param origin origin state of the edge
     * @param label edge label
     * @param destination destination state of the edge
     * @return returns a new automaton with altered edge set
     */
    public static FSA remove_edge(FSA lhs, String origin, String label, String destination) {
        FSA copy = new FSA(lhs);
        if (label.length() != 1)
            throw new Error("Edge to remove can only contain one character");
        try {
            copy.removeEdge(origin, label.charAt(0), destination);
        } catch (NoSuchNodeException e) {
            throw new Error("Origin state does not exist in FSA.");
        } catch (NoSuchEdgeException e) {
            throw new Error("Origin state does not have the specified edge.");
        }
        return copy;
    }

    /**
     * Adds a state to the set of final states of automaton. If it does not exist in the set of ndoes, it is created.
     *
     * @param lhs automaton to operate on
     * @param stateName name of state to add to final states set
     * @return returns a new automaton with altered final states
     */
    public static FSA add_final_state(FSA lhs, String stateName) {
        FSA copy = new FSA(lhs);
        copy.addFinalState(stateName);
        return copy;
    }

    /**
     * Removes a state from the set of final states of automaton.
     *
     * @param lhs automaton to operate on
     * @param stateName name of state to remove from final states set
     * @return returns a new automaton with altered final states
     */
    public static FSA remove_final_state(FSA lhs, String stateName) {
        if (!lhs.getFinalStates().contains(stateName))
            throw new Error("Specified state is not final in FSA.");
        FSA copy = new FSA(lhs);
        copy.removeFinalState(stateName);
        return copy;
    }

    /**
     * Adds the empty string to the alphabet. (Null character)
     *
     * @param lhs automaton to operate on
     * @return returns a new automaton with modified alphabet
     */
    public static FSA add_empty_to_alphabet(FSA lhs) {
        FSA copy = new FSA(lhs);
        Set<Character> c= new HashSet<>();

        copy.addToAlphabet(c);
        return copy;
    }

    /**
     * Adds the double quote character to the alphabet. (Null character)
     *
     * @param lhs automaton to operate on
     * @return returns a new automaton with modified alphabet
     */
    public static FSA add_doublequote_to_alphabet(FSA lhs) {
        FSA copy = new FSA(lhs);
        copy.addToAlphabet('"');
        return copy;
    }

    /**
     * Adds all specified characters to an FSA's alphabet.
     *
     * @param lhs automaton to operate on
     * @param newTokens string of characters to add to alphabet
     * @return returns a new automaton with modified alphabet
     */
    public static FSA add_to_alphabet(FSA lhs, String newTokens) {
        FSA copy = new FSA(lhs);
        for (int i=0; i < newTokens.length(); i++) {
            copy.addToAlphabet(newTokens.charAt(i));
        }
        return copy;
    }

    /**
     * Removes all specified characters from an FSA's alphabet as long as they are currently not in use.
     * If any of them are in use, the method fails.
     *
     * @param lhs automaton to operate on
     * @param oldTokens string of characters to remove from alphabet
     * @return returns a new automaton with modified alphabet
     */
    public static FSA remove_from_alphabet(FSA lhs, String oldTokens) {
        FSA copy = new FSA(lhs);
        Set<Character> toRemove = new HashSet<>();
        for (char c : oldTokens.toCharArray())
            toRemove.add(c);
        if(copy.removeFromAlphabet(toRemove))
            return copy;
        else
            throw new Error("Cannot remove characters from fsa's alphabet as one or more are currently in use.");
    }

    /**
     * Removes all characters from an FSA's alphabet that are currently not in use.
     *
     * @param lhs automaton to operate on
     * @return returns a new automaton with modified alphabet
     */
    public static FSA strip_alphabet(FSA lhs) {
        FSA copy = new FSA(lhs);
        copy.stripAlphabet();
        return copy;
    }

    /**
     * Determines whether an automaton's accepted language only contains the empty string.
     *
     * @param lhs automaton to test
     * @return returns true if lhs only accepts the empty string, false otherwise
     */
    public static Boolean only_accepts_empty_string(FSA lhs) {
        return lhs.onlyAcceptsEmptyString();
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
     * Determines whether an automaton's accepts every string in it's alphabet AND the empty set
     *
     * @param lhs automaton to test
     * @return returns true if lhs accepts the kleene star closure of it's alphabet
     */
    public static Boolean accepts_alphabet_star_closure(FSA lhs) {
        return lhs.acceptsAlphabetKleeneStar();
    }

    /**
     * Determines whether an automaton's accepts every string in it's alphabet
     *
     * @param lhs automaton to test
     * @return returns true if lhs accepts the kleene plus closure of it's alphabet
     */
    public static Boolean accepts_alphabet_plus_closure(FSA lhs) {
        return lhs.acceptsAlphabetKleeneStar();
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
     * Generates and writes dot output for a given automaton.
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

    /**
     * Generates and prints dot output for a given automaton to System.out.
     *
     * @param lhs automaton to write as dot
     * @return always returns null
     */
    public static Object print_dot(FSA lhs) {
        lhs.writeDot(System.out);
        return null;
    }

    public static Object write_regex(FSA lhs) {
        throw new UnsupportedOperationException("Not Yet Implemented: " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    private static String string_encode(String str) {
        return str.replace("#", "sharp").replace("++", "pp");
    }

    /**
     * Generates and writes code output for the implementation of a given automaton in the specified language.
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
            language = string_encode(language);

            File f = new File(fileName);
            String moduleName = f.getName().substring(0, f.getName().indexOf('.') > 0 ? f.getName().indexOf('.') : f.getName().length());
            PrintStream stream = new PrintStream(f);

            Method m = FSA.class.getMethod("write_" + language.toLowerCase(), String.class, PrintStream.class);
            Object result = m.invoke(lhs, moduleName, stream);
            stream.close();
            return result;
        } catch (NoSuchMethodException e) {
            throw new UnsupportedOperationException("No output to language '" + language + "' defined.");
        }
    }

    /**
     * Generates and prints code output for the implementation of a given automaton in the specified language to System.out.
     *  The generated code exports an acceptance method which allows to test whether a given string is accepted by the automaton or not.
     *
     * @param language language in which to generate the code
     * @param lhs automaton for which to generate code implementation
     * @return returns an invocation for the write method associated with the specified language
     * @throws InvocationTargetException if the underlying method throws an exception
     * @throws IllegalAccessException if this Method object is enforcing Java language access control and the underlying method is inaccessible
     * @throws UnsupportedOperationException if there is no method to generate the implementation in the specified language
     */
    public static Object print_code(String language, FSA lhs) throws InvocationTargetException, IllegalAccessException {
        try {
            language = string_encode(language);

            Method m = FSA.class.getMethod("write_" + language.toLowerCase(), String.class, PrintStream.class);
            return m.invoke(lhs, "Automaton", System.out);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object show(FSA lhs) {
        throw new UnsupportedOperationException("Not Yet Implemented: " + Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     * Prints a new line character to System.out.
     */
    public static void nl() {
        System.out.println();
    }

    /**
     * Prints an object to System.out.
     * @param lhs object to print
     */
    public static void print(Object lhs) {
        System.out.print(lhs);
    }

    /**
     * Prints an object to System.out, followed by a newline.
     * @param lhs object to print
     */
    public static void println(Object lhs) {
        System.out.println(lhs);
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
