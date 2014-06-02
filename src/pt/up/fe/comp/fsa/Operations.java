package pt.up.fe.comp.fsa;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused") //methods are used through reflection
public class Operations {

    /**
     * Creates a new FSA with a single state.
     *
     * @param name name of the automaton
     * @return returns a new automaton with just an initial state.
     */
    public static FSA empty_fsa(String name) {
        try {
            return new FSA(name, "q0", new HashSet<String>());
        } catch (FSAException e) {
            throw new Error(e);
        }
    }

    /**
     * Creates a new FSA from a regex.
     *
     * @param name   name of the automaton
     * @param regExp regular expression that determines the language of the automaton
     * @return returns a new automaton that accepts the language specified by the regular expression
     */
    public static FSA loadr(String name, String regExp) {
        try {
            return new FSA(name, regExp);

        } catch (InvalidArgumentException e) {
            throw new Error(e);
        }
    }

    /**
     * Concatenates all the specified automata in the order in which they are supplied to the function.
     *
     * @param args array of automata to operate with
     * @return returns a new eNFA that is the concatenation of all the given automata
     */
    public static FSA concat(FSA arg1, FSA arg2, FSA... args) {
        FSA result = new FSA(arg1);
        result.concat(arg2);
        for (FSA automaton : args) {
            result.concat(automaton);
        }
        return result;
    }

    /**
     * Computes the union between several automata. (Minimum of two).
     *
     * @param args array of automata to unite
     * @return returns a new eNFA that is the union of all the supplied automata.
     */
    public static FSA union(FSA arg1, FSA arg2, FSA... args) {
        FSA result = arg1.union(arg2);
        for (FSA automaton : args) {
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
        for (FSA automaton : args) {
            result = result.intersect(automaton);
        }
        return result;
    }

    /**
     * Computes the cartesian product of the automata (minimum of two).
     * The resulting automaton will either have no final states or be the union, intersection, difference or XOR of the automata,
     * deppending on the specified type for the operation.
     * <p>
     * After the cartesian product is calculated, the resulting automaton will have a state for every combination of states of the supplied automata.
     * <p>
     * Operation types:
     * UNION - Computes the union of the languages accepted by the automata
     * INTERSECTION - Computes the intersection of the languages accepted by the automata
     * XOR - Computes the exclusive or of the languages accepted by the automata
     * DIFF - Computes the difference between the languages accepted by the automata, in the same order as they are supplied
     * NONE - Resulting automaton will have no final states
     *
     * @param opType indicates the desired operation type and must have one of the following values: "union", "intersection", "xor", "diff", "none".
     * @param args   array of automata to operate with
     * @return returns a new automaton that is the cartesian product of all the supplied automata
     */
    public static FSA cartesian(String opType, FSA arg1, FSA arg2, FSA... args) {
        try {
            FSA.CartesianType _opType = FSA.CartesianType.valueOf(opType.toUpperCase());
            FSA result = arg1.cartesian(arg2, _opType);

            for (FSA automaton : args) {
                result = result.cartesian(automaton, _opType);
            }
            return result;
        } catch (IllegalArgumentException e) {
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
        for (FSA automaton : args) {
            result = result.diff(automaton);
        }
        return result;
    }

    /**
     * Loads an automatons from dot file.
     *
     * @param fileName path to the dot file
     * @return returns a new automaton built from the information in the dot file
     */
    public static FSA loadf(String fileName) {
        File f = new File(fileName);
        if (!f.exists())
            throw new Error(new FileNotFoundException(f.getAbsolutePath()));

        try {
            return FSALoader.LoadFromFile(fileName);
        } catch (IOException e) {
            throw new Error(e);
        }
    }

    /**
     * Creates a new automaton from the given one and complements it.
     * I.e. it will accept strings iff they were not accepted by the original automaton.
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
     * If automaton is not deterministic, it will be determinized first.
     *
     * @param lhs FSA to minimize
     * @return returns a new deterministic automaton equivalent to lhs but minimal
     */
    public static FSA minimize(FSA lhs) {
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

    /**
     * Test if automaton in first argument is equal to or included in automaton passed as second argument.
     *
     * @param lhs automaton to operate with
     * @param rhs automaton to operate with
     * @return returns true if lhs is equal to or included in rhs, false otherwise
     */
    public static Boolean in(FSA lhs, FSA rhs) {
        return lhs.isIncludedIn(rhs);
    }

    /**
     * Tests if two automata accept the same language. The automata are not modified by this operation.
     *
     * @param lhs automaton to use for comparison
     * @param rhs automaton to use for comparison
     * @return returns true if the automata accept the same language, false otherwise
     */
    public static Boolean equivalent(FSA lhs, FSA rhs) {
        return lhs.equals(rhs);
    }

    /**
     * Changes the name of an automaton.
     *
     * @param lhs     automaton to rename
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
     * @param lhs     automaton to operate on
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
     * @param lhs         automaton to operate on
     * @param origin      origin state of the edge
     * @param label       edge label, if empty string, an empty transition is added
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
     * Inserts an automaton in another automaton.
     *  i.e. to get from the specified origin state to the destination state must traverse the whole automaton to be inserted.
     * <p>
     * Will rename states of the resulting automaton if there is a name conflict between the nodes of both automata.
     *
     * @param lhs           original automaton
     * @param origin        name of the source state
     * @param transition    automaton that specifies the language for the state transition
     * @param destination   name of the destination state
     * @return returns a new automaton with the new transitions
     */
    public static FSA insert_automaton(FSA lhs, String origin, FSA transition, String destination) {
        FSA copy = new FSA(lhs);
        try {
            copy.insertFSA(origin, transition, destination);
            return copy;
        } catch (NoSuchNodeException e) {
            throw new Error("Origin state does not exist in FSA.");
        }
    }

    /**
     * Changes the initial state of an automaton as long as it exists.
     *
     * @param lhs             automaton to operate on
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
     * @param lhs     automaton to operate on
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
     * @param lhs         automaton to operate on
     * @param origin      origin state of the edge
     * @param label       edge label
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
     * @param lhs       automaton to operate on
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
     * @param lhs       automaton to operate on
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
        Set<Character> c = new HashSet<>();

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
     * @param lhs       automaton to operate on
     * @param newTokens string of characters to add to alphabet
     * @return returns a new automaton with modified alphabet
     */
    public static FSA add_to_alphabet(FSA lhs, String newTokens) {
        FSA copy = new FSA(lhs);
        for (int i = 0; i < newTokens.length(); i++) {
            copy.addToAlphabet(newTokens.charAt(i));
        }
        return copy;
    }

    /**
     * Removes all specified characters from an FSA's alphabet as long as they are currently not in use.
     * If any of them are in use, the method fails.
     *
     * @param lhs       automaton to operate on
     * @param oldTokens string of characters to remove from alphabet
     * @return returns a new automaton with modified alphabet
     */
    public static FSA remove_from_alphabet(FSA lhs, String oldTokens) {
        FSA copy = new FSA(lhs);
        Set<Character> toRemove = new HashSet<>();
        for (char c : oldTokens.toCharArray())
            toRemove.add(c);
        if (copy.removeFromAlphabet(toRemove))
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
     * <p>
     * I.e. Every state will have at least one transition for every character in the automaton's alphabet.
     * Previously undefined transitions will lead to a new trap state.
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
     * A state is useless if it is a trap state (cannot reach a final state).
     * <p>
     * However, the initial state is always kept.
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
     * @param lhs      automaton to write as dot
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


    /**
     * Computes a regex from the given automaton. Empty parenthesis (i.e. "()") indicade empty strings (from epsilon transitions and such).
     *
     * @param lhs automaton to convert to regex
     * @return returns a string containing the regex for the given automaton
     */
    public static String to_regex(FSA lhs) {
        return lhs.toRegex();
    }

    private static String string_encode(String str) {
        return str.replace("#", "sharp").replace("++", "pp");
    }

    /**
     * Generates and writes code output for the implementation of a given automaton in the specified language.
     * The generated code exports an acceptance method which allows to test whether a given string is accepted by the automaton or not.
     *
     * @param language language in which to generate the code
     * @param lhs      automaton for which to generate code implementation
     * @param fileName path where to write the output
     * @return returns an invocation for the write method associated with the specified language
     * @throws InvocationTargetException     if the underlying method throws an exception
     * @throws IllegalAccessException        if this Method object is enforcing Java language access control and the underlying method is inaccessible
     * @throws FileNotFoundException         if it fails to open a PrintStream for fileName
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
     * The generated code exports an acceptance method which allows to test whether a given string is accepted by the automaton or not.
     *
     * @param language language in which to generate the code
     * @param lhs      automaton for which to generate code implementation
     * @return returns an invocation for the write method associated with the specified language
     * @throws InvocationTargetException     if the underlying method throws an exception
     * @throws IllegalAccessException        if this Method object is enforcing Java language access control and the underlying method is inaccessible
     * @throws UnsupportedOperationException if there is no method to generate the implementation in the specified language
     */
    public static Object print_code(String language, FSA lhs) throws InvocationTargetException, IllegalAccessException {
        try {
            language = string_encode(language);

            Method m = FSA.class.getMethod("write_" + language.toLowerCase(), String.class, PrintStream.class);
            return m.invoke(lhs, "Automaton", System.out);
        } catch (NoSuchMethodException e) {
            throw new UnsupportedOperationException("No output to language '" + language + "' defined.");
        }
    }

    /**
     * Creates a temporary dot file for the automaton and uses ZGRViewer to visualize it.
     *  Must have Graphviz installed.
     * <p>
     * Additionally, it supports the command line options for ZGRViewer, which can be of types:
     *   opengl                    ZVTM will run in OpenGL accelerated mode");
     *                              (requires JDK 1.5 or later)\n");
     *   Pxxx                      where xxx={dot, neato, svg} to specify what program");
     *                              to use to compute the [file]'s layout\n");
     *   pluginDir=<path>          where <path> is the relative of full path to");
     *                              the directory where to look for plugins");
     *   pluginList=<paths>        where <path> is a list of comma-separated relative");
     *                              to the JAR files that contain plugins");
     *   pluginList                takes precedence over -pluginDir\n");
     *   pluginMode=<PluginClass>  plugin mode enabled by default in tool palette\n");
     *
     * @param lhs automaton to visualize
     * @param options options for ZGRViewer, must be enclosed by double quotes (see description)
     * @return returns null
     */
    public static Object show(FSA lhs, String... options) {
        try {
            final File temp = File.createTempFile("dlmr", ".dot");
            PrintStream stream = new PrintStream(temp);
            lhs.writeDot(stream);
            stream.close();

            final String[] ops = options;
            new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        ArrayList<String> cmdArray = new ArrayList<>();
                        cmdArray.add("java");
                        cmdArray.add("-jar");
                        cmdArray.add("deps/zgrviewer-target/zgrviewer-0.9.0.jar");
                        for (String o: ops)
                            cmdArray.add(" -" + o);
                        String absPath = temp.getAbsolutePath().replace(" ", "\\ ");
                        cmdArray.add(temp.getAbsolutePath());
                        Process proc = Runtime.getRuntime().exec(cmdArray.toArray(new String[cmdArray.size()]));
                        proc.waitFor();
                    } catch (InterruptedException | IOException e) {
                        e.printStackTrace();
                    }
                    if (!temp.delete())
                        temp.deleteOnExit();

                }
            }).start();


        } catch (IOException e) {
            throw new Error("Could not run ZGRViewer.");
        }

        return null;
    }

    /**
     * Prints a new line character to System.out.
     */
    public static void nl() {
        System.out.println();
    }

    /**
     * Prints an object to System.out.
     *
     * @param lhs object to print
     */
    public static void print(Object lhs) {
        System.out.print(lhs);
    }

    /**
     * Prints an object to System.out, followed by a newline.
     *
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

    /**
     * 'AND' operator, used to check if all arguments evaluate to true.
     *
     * @param vals values to check
     * @return returns true if all arguments are true, false otherwise
     */
    public static Boolean and(Boolean val1, Boolean val2, Boolean... vals) {
        Boolean res = val1 && val2;

        for (int i=0; i < vals.length && res; i++) {
            res = vals[i];
        }

        return res;
    }

    /**
     * 'OR' operator, used to check if all arguments evaluate to true.
     *
     * @param vals values to check
     * @return returns true if all arguments are true, false otherwise
     */
    public static Boolean or(Boolean val1, Boolean val2, Boolean... vals) {
        Boolean res = val1 || val2;

        for (int i=0; i < vals.length && !res; i++) {
            res = vals[i];
        }

        return res;
    }

    /**
     * 'XOR' operator, used to check if all arguments evaluate to true.
     *
     * @param val1 value to check
     * @param val2 value to check
     * @return returns true if all arguments are true, false otherwise
     */
    public static Boolean xor(Boolean val1, Boolean val2) {
        int res = (val1 ? 1 : 0) + (val2 ? 1 : 0);

        return res == 1;
    }
}
