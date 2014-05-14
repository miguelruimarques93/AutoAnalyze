package pt.up.fe.comp.fsa;

import org.antlr.v4.runtime.misc.Pair;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.*;

/**
 * This class defines a Finite State Automata, containing all necessary information to describe one, namely:
 * <p/>
 * - The alphabet;
 * <p/>
 * - The set of states (can NOT be empty);
 * <p/>
 * - The initial state;
 * <p/>
 * - The set of final states (can be empty);
 * <p/>
 * - The set of edges / transition function.
 * <p/>
 * <p/>
 * It also contains several methods to allow for the manipulation of the automata and a boolean to indicate if it is
 * deterministic or not.
 */
public class FSA {
    /**
     * This class is essentially a wrapper for a Pair<Character, String> already defined in the ANTLR4 libraries.
     * <p/>
     * If the Character (input) is null it symbolizes an empty transition
     *
     * @see "https://github.com/antlr/antlr4/blob/master/runtime/Java/src/org/antlr/v4/runtime/misc/Pair.java"
     */
    public static class Edge {
        public Edge(Character input, String destination) {
            transition = new Pair<>(input, destination);
        }

        public Character label() {
            return transition.a;
        }

        public String destination() {
            return transition.b;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Edge) {
                Edge other = (Edge) obj;
                if (label() == null)
                    return other.label() == null && other.destination().equals(destination());
                else if (other.label() == null)
                    return false;

                return other.label().equals(label()) && other.destination().equals(destination());
            }
            return false;
        }

        @Override
        public int hashCode() {
            return ((transition.a == null ? "nill" : transition.a) + "->" + transition.b).hashCode();
        }

        @Override
        public String toString() {
            return transition.a + " -> " + transition.b;
        }

        private Pair<Character, String> transition;
    }

    public FSA(String name, String initialState, Set<String> stateNames) throws DuplicateElementException {
        _name = name;
        _initialState = initialState;

        for (String state : stateNames)
            addNode(state);

        if (!_nodes.containsKey(_initialState))
            addNode(_initialState);
    }

    public FSA(FSA fsa) {
        _name = fsa.getName();
        _initialState = fsa.getInitialState();
        _finalStates = new HashSet<>(fsa.getFinalStates());
        _alphabet = new HashMap<>(fsa._alphabet);

        for (String node : fsa.getNodes()) {
            _nodes.put(node, new LinkedHashSet<Edge>());
            try {
                for (Edge edge : fsa.getNodeEdges(node))
                    _nodes.get(node).add(new Edge(edge.label(), edge.destination()));
            } catch (NoSuchNodeException e) {
                e.printStackTrace();
            }
        }

        _deterministic = fsa.isDeterministic();
    }

    public Set<String> getNodes() {
        return _nodes.keySet();
    }

    public Set<Edge> getNodeEdges(String nodeName) throws NoSuchNodeException {
        if (!_nodes.containsKey(nodeName))
            throw new NoSuchNodeException(nodeName);
        return _nodes.get(nodeName);
    }

    public void addNode(String nodeName) throws DuplicateElementException {
        if (!_nodes.containsKey(nodeName))
            _nodes.put(nodeName, new LinkedHashSet<Edge>());
        else
            throw new DuplicateElementException(nodeName);
    }

    public void addEdge(String nodeName, Character input, String destination) throws NoSuchNodeException, DuplicateElementException {
        if (!_nodes.containsKey(nodeName))
            throw new NoSuchNodeException(nodeName); //custom exception created to force code using this method to catch exceptions

        if (!_nodes.containsKey(destination))
            addNode(destination);


        Edge newEdge = new Edge(input, destination);
        Set<Edge> nodeEdges = _nodes.get(nodeName);

        if (nodeEdges.contains(newEdge)) {
            throw new DuplicateElementException(nodeName + " + " + (input == null ? "nill" : input) + " -> " + destination);
        }

        //if FSA was deterministic, check if this has been compromised
        if (isDeterministic()) {
            if (newEdge.label() == null)
                _deterministic = false;
            else {
                for (Edge edge : nodeEdges) {
                    if (edge.label().equals(newEdge.label()))
                        _deterministic = false;
                }
            }
        }

        //if the given input is not part of the alphabet, extend it
        if (!_alphabet.containsKey(input))
            _alphabet.put(input, 1);
        else {
            Integer numU = _alphabet.get(input);
            _alphabet.put(input, numU + 1);
        }

        nodeEdges.add(newEdge);
    }

    /**
     * Same as addEdge but allows for a chain of inputs and creates intermediate states
     * TODO allow for regular expressions
     */
    public void addEdges(String nodeName, String input, String destination) throws NoSuchNodeException, DuplicateElementException {
        if (!_nodes.containsKey(nodeName))
            throw new NoSuchNodeException(nodeName);
        if (!_nodes.containsKey(destination))
            throw new NoSuchNodeException(destination);

        if (input == null || input.length() == 0) {
            addEdge(nodeName, null, destination);
            return;
        }

        String currentNode = nodeName;

        String nextNode;
        if (input.length() == 1)
            nextNode = destination;
        else {
            nextNode = nodeName + "_1";
            while (_nodes.containsKey(nextNode))
                nextNode += "_1";
        }

        for (int i = 0; i < input.length(); i++) {
            if (i < input.length() - 1)
                addNode(nextNode);

            addEdge(currentNode, input.charAt(i), nextNode);
            currentNode = nextNode;

            if (i < input.length() - 2) {
                nextNode = nodeName + "_" + Integer.toString(i + 2); //starts at "_1"
                while (_nodes.containsKey(nextNode)) //TODO find a better way to obtain a certainly non existing name
                    nextNode += Integer.toString(i + 2);
            } else
                nextNode = destination;

        }
    }

    public void removeEdge(String nodeName, Character input, String destination) throws NoSuchNodeException, NoSuchEdgeException {
        if (!_nodes.containsKey(nodeName))
            throw new NoSuchNodeException(nodeName);

        Set<Edge> nodeEdges = _nodes.get(nodeName);
        Edge oldEdge = new Edge(input, destination);
        if (!nodeEdges.contains(oldEdge))
            throw new NoSuchEdgeException(nodeName + " + " + (input == null ? "nill" : input) + " -> " + destination);

        nodeEdges.remove(oldEdge);

        if (_alphabet.containsKey(input)) {
            Integer numU = _alphabet.get(input) - 1;
            if (numU > 0)
                _alphabet.put(input, numU);
            else
                _alphabet.remove(input);
        }

        if (!_deterministic) //don't use isDeterministic to prevent check from occurring if another edge had been removed
            _needsDeterminismUpdate = true;
    }

    public void removeNode(String nodeName) throws NoSuchNodeException {
        if (!_nodes.containsKey(nodeName))
            throw new NoSuchNodeException(nodeName);

        boolean wasDeterministic = _deterministic;
        _deterministic = true; //avoids checking after every edge removal for determinism in case it was an NFA

        removeEdgesWithDestination(nodeName);

        _nodes.remove(nodeName);

        if (_finalStates.contains(nodeName))
            _finalStates.remove(nodeName);

        _deterministic = wasDeterministic;
        if (!_deterministic)
            _needsDeterminismUpdate = true;
    }

    private void removeEdgesWithDestination(String nodeName) {
        boolean wasDeterministic = _deterministic;
        _deterministic = true; //avoids checking after every edge removal for determinism in case it was an NFA


        for (Map.Entry<String, Set<Edge>> node : _nodes.entrySet()) {
            Set<Edge> toRemove = new LinkedHashSet<>();
            for (Edge edge : node.getValue()) {
                if (edge.destination().equals(nodeName)) {
                    toRemove.add(edge);
                }
            }

            for (Edge edge : toRemove)
                node.getValue().remove(edge);
        }

        _deterministic = wasDeterministic;
        if (!_deterministic)
            _needsDeterminismUpdate = true;
    }

    private void checkDeterminism() {
        _deterministic = true;
        for (String node : _nodes.keySet()) {
            if (nonDeterministicNode(node)) {
                _deterministic = false;
                return;
            }
        }
    }

    private boolean nonDeterministicNode(String nodeName) {
        Set<Edge> nodeEdges = _nodes.get(nodeName);
        for (Edge edge : nodeEdges) {
            if (edge.label() == null)
                return true;
            int counter = 0;
            for (Edge edge2 : nodeEdges) {
                if (edge.label().equals(edge2.label()))
                    counter++;
            }
            if (counter > 1)
                return true;
        }

        return false;
    }

    public String getName() {
        return _name;
    }

    /*public void setName(String name) {
        this._name = name;
    }*/

    public Set<Character> getAlphabet() {
        return _alphabet.keySet();
    }

    public String getInitialState() {
        return _initialState;
    }

    /*public void setInitialState(String initialState) throws NoSuchNodeException {
        if (!_nodes.containsKey(initialState))
            throw new NoSuchNodeException(initialState);
        this._initialState = initialState;
    }*/

    public Set<String> getFinalStates() {
        return _finalStates;
    }

    public void setFinalStates(Set<String> finalStates) {
        this._finalStates = finalStates;
    }

    public void addFinalState(String st) {
        if (!_nodes.containsKey(st))
            _nodes.put(st, new LinkedHashSet<Edge>());
        _finalStates.add(st);
    }

    public boolean isDeterministic() {
        if (_needsDeterminismUpdate){
            _needsDeterminismUpdate = false;
            checkDeterminism();
        }
        return _deterministic;
    }

    private boolean nodeHasIncomingEdges(String nodename) {

        for (String node : getNodes()) {
            try {
                for (Edge edge : getNodeEdges(node)) {
                    if (edge.destination().equals(nodename))
                        return true;
                }
            } catch (NoSuchNodeException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    public boolean accepts(String input) {
        if (_finalStates.isEmpty())
            return false;

        LinkedHashSet<String> curNodes = new LinkedHashSet<>(getNodeEmptyTransitionClosure(getInitialState()));

        for (Character c : input.toCharArray()) {
            LinkedHashSet<String> newNodes = new LinkedHashSet<>();
            for (String node : curNodes) {
                for (Edge edge : _nodes.get(node)) {
                    if (edge.label() == c)
                        newNodes.addAll(getNodeEmptyTransitionClosure(edge.destination()));
                }
            }
            curNodes = newNodes;
        }

        for (String node : curNodes) {
            if (_finalStates.contains(node))
                return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Initial State: " + _initialState + "\n" + "Final States: " + _finalStates.toString() + "\n" + "Edges: " + _nodes.toString() + "\n";
    }

    public LinkedHashSet<String> getNodeEmptyTransitionClosure(String nodename) {
        LinkedHashSet<String> nodes = new LinkedHashSet<>();
        LinkedList<String> toExpand = new LinkedList<>();
        nodes.add(nodename);
        toExpand.add(nodename);

        while(!toExpand.isEmpty()) {
            String curNode = toExpand.removeFirst();
            try {
                for (Edge edge : getNodeEdges(curNode)) {
                    if (edge.label() == null && !nodes.contains(edge.destination())) {
                        nodes.add(edge.destination());
                        toExpand.add(edge.destination());
                    }
                }
            } catch (NoSuchNodeException e) {
                e.printStackTrace();
            }
        }

        return nodes;
    }

    public void removeEmptyTransitions() {
        for (String node : getNodes()) {
            Set<String> nodeEClosure = getNodeEmptyTransitionClosure(node);
            if (!_finalStates.contains(node)) {
                for (String n : nodeEClosure) {
                    if (_finalStates.contains(n)) {
                        _finalStates.add(node);
                        break;
                    }
                }
            }

            for (String n : nodeEClosure) {
                for (Edge e : _nodes.get(n)) {
                    if (!_nodes.get(node).contains(e))
                        _nodes.get(node).add(e);
                }
            }
        }

        Map<String, Set<Edge>> newNodes = new LinkedHashMap<>();

        for (String node : getNodes()) {
            Set<Edge> oldEdges = _nodes.get(node);
            Set<Edge> newEdges = new LinkedHashSet<>();
            for (Edge old : oldEdges) {
                if (old.label() != null)
                    newEdges.add(old);
            }

            newNodes.put(node, newEdges);
        }

        if(_alphabet.containsKey(null))
            _alphabet.remove(null);
        _nodes = newNodes;
        _needsDeterminismUpdate = true;
    }

    public void makeDeterministic() {
        if (!this.isDeterministic())
            removeEmptyTransitions();
        //determinism may be changed
        if (this.isDeterministic())
            return;


        Set<String> initialSet = new HashSet<>();
        initialSet.add(_initialState);

        Queue<Set<String>> workQueue = new LinkedList<>();
        Map<Set<String>, String> newStates = new HashMap<>();
        Set<Set<String>> processed = new HashSet<>();
        Set<String> newFinalStates = new HashSet<>();
        Map<String, Set<Edge>> newNodes = new LinkedHashMap<>();

        newStates.put(initialSet, "q0");

        workQueue.add(initialSet);
        while (!workQueue.isEmpty()) {
            Set<String> stateSet = workQueue.poll();
            String nState = newStates.get(stateSet);

            for (String state : stateSet) {
                if (_finalStates.contains(state)) {
                    newFinalStates.add(nState);
                    break;
                }
            }

            Set<Edge> oldEdges = new HashSet<>();
            for (String state : stateSet)
                oldEdges.addAll(_nodes.get(state));

            Map<Character, Set<String>> transitions = new HashMap<>();
            for (Edge e : oldEdges) {
                if (!transitions.containsKey(e.transition.a))
                    transitions.put(e.transition.a, new HashSet<String>());

                transitions.get(e.transition.a).add(e.transition.b);
            }

            Set<Edge> newEdges = new HashSet<>();
            for (Map.Entry<Character, Set<String>> entry : transitions.entrySet()) {
                if (!processed.contains(entry.getValue())) {
                    processed.add(entry.getValue());
                    workQueue.add(entry.getValue());
                    newStates.put(entry.getValue(), "q" + Integer.toString(newStates.size()));
                }
                newEdges.add(new Edge(entry.getKey(), newStates.get(entry.getValue())));
            }

            if (!newNodes.containsKey(nState))
                newNodes.put(nState, new HashSet<Edge>());
            newNodes.get(nState).addAll(newEdges);
        }

        _initialState = "q0";
        _finalStates = newFinalStates;
        _nodes = newNodes;
        _deterministic = true;
    }

    public void removeUnreachableStates() {
        HashSet<String> reachableStates = new HashSet<>();
        reachableStates.add(_initialState);

        boolean done;
        do {
            HashSet<String> temp = new HashSet<>();
            for (String q : reachableStates) {
                for (Edge e : _nodes.get(q)) {
                    if (!reachableStates.contains(e.destination()) && !temp.contains(e.destination()))
                        temp.add(e.destination());
                }
            }

            reachableStates.addAll(temp);
            done = temp.isEmpty();
        } while(!done);

        LinkedList<String> toRemove = new LinkedList<>();
        for (String node : getNodes()) {
            if (!reachableStates.contains(node))
                toRemove.add(node);
        }

        for (String nr : toRemove) {
            try {
                removeNode(nr);
            } catch (NoSuchNodeException e) {
                e.printStackTrace();
            }
        }
    }

    private HashSet<String> getNewNodesWithTransitionsTo(Set<String> nodenames) {
        HashSet<String> nodes = new HashSet<>();

        for (String node: getNodes()) {
            for (Edge e : _nodes.get(node)) {
                if (nodenames.contains(e.destination()) && !nodenames.contains(node)) {
                    nodes.add(node);
                    break;
                }
            }
        }
        return nodes;
    }

    public void removeUselessStates() {
        HashSet<String> usefulStates = new HashSet<>(_finalStates);
        boolean done;
        do {
            HashSet<String> newStates = getNewNodesWithTransitionsTo(usefulStates);
            usefulStates.addAll(newStates);
            done = newStates.isEmpty();
        } while(!done);

        LinkedList<String> toRemove = new LinkedList<>();
        for (String node : getNodes()) {
            if (!usefulStates.contains(node))
                toRemove.add(node);
        }

        for (String nr : toRemove) {
            try {
                removeNode(nr);
            } catch (NoSuchNodeException e) {
                e.printStackTrace();
            }
        }

        //If the initial state has been removed, add a new state with no related transitions and set it to be the initial state.
        //1- remove the initial node anyway to remove all transitions to/from it
        //2- then just add a node with the same name
        if (toRemove.contains(_initialState)) {
            _nodes.put(_initialState, new LinkedHashSet<Edge>());
        }
    }

    public boolean isTotal() {
        Set<Character> alphabet = getAlphabet();

        for (Map.Entry<String, Set<Edge>> node: _nodes.entrySet()) {
            Set<Edge> nodeEdges = node.getValue();
            Set<Character> edgesCharacters = new HashSet<>();

            for (Edge e: nodeEdges)
                edgesCharacters.add(e.label());

            Set<Character> nonExistent = new HashSet<>(alphabet);
            nonExistent.removeAll(edgesCharacters);

            if (!nonExistent.isEmpty())
                return false;
        }

        return true;
    }

    public void makeTotal() {
        String errorState = "_error";
        Set<Character> alphabet = getAlphabet();
        Map<String, Set<Character>> toAdd = new HashMap<>();

        for (Map.Entry<String, Set<Edge>> node: _nodes.entrySet()) {
            Set<Edge> nodeEdges = node.getValue();
            Set<Character> edgesCharacters = new HashSet<>();

            for (Edge e: nodeEdges)
                edgesCharacters.add(e.label());

            Set<Character> nonExistent = new HashSet<>(alphabet);
            nonExistent.removeAll(edgesCharacters);

            if (!nonExistent.isEmpty())
                toAdd.put(node.getKey(), nonExistent);
        }

        if (!toAdd.isEmpty()) {
            try {
                addNode(errorState);
            } catch (DuplicateElementException ex) {
                ex.printStackTrace();
            }

            toAdd.put("_error", alphabet);

            for (Map.Entry<String, Set<Character>> node : toAdd.entrySet()) {
                String nodeLabel = node.getKey();
                for (Character c: node.getValue()) {
                    try {
                        addEdge(nodeLabel, c, errorState);
                    } catch (FSAException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    public boolean acceptsAlphabetKleeneStar() {
        FSA copy = new FSA(this);
        copy.complement();
        return copy.doesNotAcceptAnything();
    }

    public boolean acceptsAlphabetKleenePlus() {
        FSA copy = new FSA(this);
        copy.complement();
        copy.minimize();
        String copyInit = copy.getInitialState();
        if (copy.getFinalStates().isEmpty())
            return true;
        else if (copy.getFinalStates().size() == 1 && copy.getFinalStates().contains(copyInit)) {
            try {
                Set<Edge> initEdges = copy.getNodeEdges(copyInit);
                return (initEdges.isEmpty() || (initEdges.size() == 1 && initEdges.contains(new Edge(null, copyInit))));
            } catch (NoSuchNodeException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    public boolean doesNotAcceptAnything() {
        FSA copy = new FSA(this);
        copy.makeDeterministic();
        copy.removeUnreachableStates();

        return copy.getFinalStates().isEmpty();
    }

    public void complement() {
        makeDeterministic();
        makeTotal();
        Set<String> newFinalStates = new HashSet<>(_nodes.keySet());
        newFinalStates.removeAll(_finalStates);
        _finalStates = newFinalStates;
    }

    public void minimize() {
        /*The following algorithm generates a total FSA equivalent to the one we start off
           with but with the least possible number of states.
          Note, however, that useless and unreachable states would first have to be removed for the algorithm to work.
          Also, the finite state automaton must be deterministic.*/
        makeDeterministic();
        removeUselessStates();
        removeUnreachableStates();
        makeTotal();

        HashMap<String, Integer> nodeToNumber = new HashMap<>();
        HashMap<Integer, String> numberToNode = new HashMap<>();
        int counter = 0;
        for (String node : getNodes()) {
            nodeToNumber.put(node, counter);
            numberToNode.put(counter, node);
            ++counter;
        }

        boolean[][] matrix = new boolean[nodeToNumber.size()][nodeToNumber.size()];

        //Compute D(0)
        for (int i=0; i < matrix.length; i++) {
            for (int j=0; j < i; j++) {
                matrix[i][j] = (_finalStates.contains(numberToNode.get(i)) && !_finalStates.contains(numberToNode.get(j))) ||
                        (!_finalStates.contains(numberToNode.get(i)) && _finalStates.contains(numberToNode.get(j)));
            }
        }

        boolean changed = true;
        while(changed) {
            changed = false;
            for (int i=0; i < matrix.length; i++) {
                for (int j=0; j < i; j++) { //symmetrical matrix
                    if (matrix[i][j]) continue;

                    for (char c : _alphabet.keySet()) {
                        String iNode = null;
                        String jNode = null;
                        for (Edge e : _nodes.get(numberToNode.get(i))) {
                            if (e.label() == c) {
                                iNode = e.destination();
                                break;
                            }
                        }
                        for (Edge e : _nodes.get(numberToNode.get(j))) {
                            if (e.label() == c) {
                                jNode = e.destination();
                                break;
                            }
                        }

                        if (matrix[nodeToNumber.get(iNode)][nodeToNumber.get(jNode)]) {
                            matrix[i][j] = true;
                            changed = true;
                            break;
                        }
                    }
                }
            }
        }

        for (int i=matrix.length-1; i > -1; i--) { //start from largest nodes and merge progressively
            boolean toRemove = false;
            for (int j=i-1; j > -1; j--) {
                if (matrix[i][j]) continue;
                toRemove = true;
                for (String node : _nodes.keySet()) {
                    Set<Edge> oldE = new LinkedHashSet<>(_nodes.get(node));
                    for (Edge e : oldE) {
                        if (e.destination().equals(numberToNode.get(i)))
                            _nodes.get(node).add(new Edge(e.label(), numberToNode.get(j)));
                    }
                }
                for (Edge e : _nodes.get(numberToNode.get(i)))
                    _nodes.get(numberToNode.get(j)).add(e);

            }
            if(toRemove) {
                try {
                    removeNode(numberToNode.get(i));
                } catch (NoSuchNodeException e) {
                    e.printStackTrace();
                }
            }
        }
        removeUselessStates();
    }

    public void writeDot(PrintStream stream) {
        PrintWriter writer = new PrintWriter(stream);


        writer.println("digraph " + getName() + " {");
        writer.println("\trankdir=LR;");

        writer.println("\tinitialstate=" + _initialState + ";");

        Set<String> fs = getFinalStates();
        if (!fs.isEmpty()) {
            writer.print("\tnode [shape = doublecircle];");
            for (String finalNode : fs) {
                writer.print(" " + finalNode);
            }
            writer.println(";");
        }

        Set<String> nds = getNodes();
        if(!nds.isEmpty()){
            writer.println("\tnode [shape = circle];");
            for (String node : nds) {
                try {
                    if (getNodeEdges(node).isEmpty() && !nodeHasIncomingEdges(node)) {//prevent useless and unreachable nodes from disappearing. for that, use removeUnreachable/Useless
                        writer.println("\t" + node + ";");
                    }

                    for (Edge edge : getNodeEdges(node)) {
                        writer.print("\t" + node + " -> " + edge.destination());
                        if (edge.label() != null) {
                            writer.print(" [ label = " + edge.label() + " ]");
                        }
                        writer.println(";");
                    }
                } catch (NoSuchNodeException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }

        writer.println("}");
        writer.close();
    }

    public void write_prolog(String moduleName, PrintStream stream) {
        PrintWriter writer = new PrintWriter(stream);

        String m_code_name = "code_"+moduleName+"_";
        String m_trans_name = "transition_"+moduleName;
        String m_ini_name = "initial_state_"+moduleName;
        String m_final_name = "final_state_"+moduleName;
        String m_accept_name = "accept_"+moduleName;

        for (Character c : _alphabet.keySet())
            writer.print(m_code_name+c+"(C):- \""+c+"\" = [C]. ");

        writer.println();
        writer.println();

        int initialState = -1;
        LinkedList<Integer> finalStates = new LinkedList<>();

        LinkedList<String> nodes = new LinkedList<>(getNodes());
        for (int i = 0; i < nodes.size(); i++) {
            if (initialState == -1 && nodes.get(i).equals(getInitialState()))
                initialState = i;
            if (getFinalStates().contains(nodes.get(i)))
                finalStates.add(i);

            try {
                Set<Edge> edges = getNodeEdges(nodes.get(i));
                if (edges != null && !edges.isEmpty()) {
                    for (Edge edge : edges) {
                        writer.println(m_trans_name+"(q"+Integer.toString(i)+", C, q"+nodes.indexOf(edge.destination())+"):- "+m_code_name+edge.label()+"(C).");
                    }
                    writer.println();
                }

            } catch (NoSuchNodeException e) {
                e.printStackTrace();
            }
        }
        writer.println();
        writer.println(m_ini_name+"(q"+Integer.toString(initialState)+").");
        writer.println();
        for (Integer finalState : finalStates) writer.print(m_final_name + "(q" + finalState + "). ");

        writer.println();
        writer.println(m_accept_name+"(String):-\n" +
                "        "+m_ini_name+"(State), "+m_accept_name+"(String,State).\n" +
                "\n" +
                m_accept_name+"([],State):- "+m_final_name+"(State). %state must be a final state after all of the input has been tested\n" +
                m_accept_name+"([C|Cs],State):-\n" +
                "        "+m_trans_name+"(State,C,NextState), "+m_accept_name+"(Cs,NextState).");

        writer.close();
    }

    public void write_haskell(String moduleName, PrintStream stream) {
        if (!isDeterministic()) {
            FSA aut = new FSA(this);
            aut.makeDeterministic();
            aut.write_haskell(moduleName, stream);
            return;
        }

        PrintWriter writer = new PrintWriter(stream);

        int initialState = -1;
        LinkedList<Integer> finalStates = new LinkedList<>();

        //module name must start with capital letter
        writer.println("module Aut_"
                + moduleName
                + "(accept) where\n\ndelta :: Int -> Char -> Int");
        LinkedList<String> nodes = new LinkedList<>(getNodes());
        for (int i = 0; i < nodes.size(); i++) {
            if (initialState == -1 && nodes.get(i).equals(getInitialState()))
                initialState = i;
            if (getFinalStates().contains(nodes.get(i)))
                finalStates.add(i);

            try {
                Set<Edge> edges = getNodeEdges(nodes.get(i));
                if (edges != null && !edges.isEmpty()) {
                    writer.print("delta " + Integer.toString(i) + " c\t");
                    for (Edge edge : edges) {
                        writer.print("|c=='"+edge.label()+"' = "+nodes.indexOf(edge.destination()));
                    }
                    writer.println();
                }

            } catch (NoSuchNodeException e) {
                e.printStackTrace();
            }
        }
        writer.println("delta _ _ = -1");
        writer.println();
        writer.println("initialState::Int\ninitialState = "+Integer.toString(initialState));
        writer.println();
        writer.println("finalStates::[Int]");
        writer.print("finalStates = [");
        for (int i=0; i < finalStates.size(); i++) {
            writer.print(finalStates.get(i));
            if (i < finalStates.size()-1)
                writer.print(",");
        }
        writer.println("]");
        writer.println();

        writer.println("accept::String -> Bool");
        writer.println("accept str = foldl delta initialState str `elem` finalStates");

        writer.close();
    }

    private boolean _needsDeterminismUpdate = false;
    private Map<Character, Integer> _alphabet = new HashMap<>();
    private String _initialState;
    private Set<String> _finalStates = new HashSet<>();
    private Map<String, Set<Edge>> _nodes = new LinkedHashMap<>(); //for efficient iteration
    private String _name = "";
    private boolean _deterministic = true;
}
