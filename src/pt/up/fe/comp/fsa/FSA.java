package pt.up.fe.comp.fsa;

import org.antlr.v4.runtime.misc.Pair;

import java.util.*;

/**
 * This class defines a Finite State Automata, containing all necessary information to describe one, namely:
 *  
 *   - The alphabet;
 *   
 *   - The set of states (can NOT be empty);
 *   
 *   - The initial state;
 *   
 *   - The set of final states (can be empty);
 *   
 *   - The set of edges / transition function.
 *   
 *   
 * It also contains several methods to allow for the manipulation of the automata and a boolean to indicate if it is
 *  deterministic or not.
 */
public class FSA {
    /**
     * This class is essentially a wrapper for a Pair<Character, String> already defined in the ANTLR4 libraries.
     * 
     * If the Character (input) is null it symbolizes an empty transition
     * 
     * @see "https://github.com/antlr/antlr4/blob/master/runtime/Java/src/org/antlr/v4/runtime/misc/Pair.java"
     */
    public static class Edge {
        public Edge(Character input, String destination){
            transition = new Pair<>(input, destination);
        }
        public Character label(){
            return transition.a;
        }
        public String destination(){
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
        public int hashCode(){
            return ((transition.a == null ? "nill" : transition.a)+"->"+transition.b).hashCode();
        }
        @Override
        public String toString() { return transition.a + " -> " + transition.b; }

        private Pair<Character, String> transition;
    }

    public FSA(String name, String initialState, Set<String> stateNames) throws DuplicateElementException {
        _name = name;
        _initialState = initialState;

        addNode(_initialState);

        for (String state : stateNames)
            addNode(state);
        
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

    public void addEdge(String nodeName, Character input, String destination) throws NoSuchNodeException, DuplicateElementException{
        if (!_nodes.containsKey(nodeName))
            throw new NoSuchNodeException(nodeName); //custom exception created to force code using this method to catch exceptions

        if (!_nodes.containsKey(destination))
            throw new NoSuchNodeException(destination);
        
        
        Edge newEdge = new Edge(input, destination);
        Set<Edge> nodeEdges = _nodes.get(nodeName);

        if (nodeEdges.contains(newEdge)){
            throw new DuplicateElementException(nodeName+" + "+(input == null? "nill" : input)+" -> "+destination);
        }

        //if FSA was deterministic, check if this has been compromised
        if (isDeterministic()){
            if (newEdge.label()==null)
                _deterministic = false;
            else{
                for (Edge edge : nodeEdges){
                    if (edge.label().equals(newEdge.label()))
                        _deterministic = false;
                }
            }
        }

        //if the given input is not part of the alphabet, extend it
        if (!_alphabet.contains(input))
            _alphabet.add(input);

        nodeEdges.add(newEdge);
    }

    /**
     * Same as addEdge but allows for a chain of inputs and creates intermediate states
     * TODO allow for regular expressions
     */
    public void addEdges(String nodeName, String input, String destination) throws NoSuchNodeException, DuplicateElementException{       
        if (!_nodes.containsKey(nodeName))
            throw new NoSuchNodeException(nodeName);
        if (!_nodes.containsKey(destination))
            throw new NoSuchNodeException(destination);

        if (input == null || input.length() == 0){
            addEdge(nodeName, null, destination);
            return;
        }

        String currentNode = nodeName;

        String nextNode;
        if(input.length() == 1)
            nextNode = destination;
        else{
            nextNode = nodeName+"_1";
            while (_nodes.containsKey(nextNode)) 
                nextNode += "_1";
        }

        for (int i=0; i < input.length(); i++){
            if (i < input.length()-1)
                addNode(nextNode);

            addEdge(currentNode, input.charAt(i), nextNode);
            currentNode = nextNode;

            if (i < input.length() - 2){
                nextNode = nodeName+"_"+Integer.toString(i+2); //starts at "_1"
                while(_nodes.containsKey(nextNode)) //TODO find a better way to obtain a certainly non existing name
                    nextNode += Integer.toString(i+2);
            }
            else
                nextNode = destination;

        }
    }

    public void removeEdge(String nodeName, Character input, String destination) throws NoSuchNodeException, NoSuchEdgeException{
        if (!_nodes.containsKey(nodeName))
            throw new NoSuchNodeException(nodeName);

        Set<Edge> nodeEdges = _nodes.get(nodeName);
        Edge oldEdge = new Edge(input, destination);
        if (!nodeEdges.contains(oldEdge))
            throw new NoSuchEdgeException(nodeName+" + "+(input == null? "nill" : input)+" -> "+destination);

        nodeEdges.remove(oldEdge);

        if (!isDeterministic()) //by removing the edge, the FSA may have been made deterministic
            checkDeterminism();
    }

    public void removeNode(String nodeName) throws NoSuchNodeException{
        if (!_nodes.containsKey(nodeName))
            throw new NoSuchNodeException(nodeName);

        boolean wasDeterministic = _deterministic;
        _deterministic = true; //avoids checking after every edge removal for determinism in case it was an NFA

        for (Edge edge : _nodes.get(nodeName))
            try {
                removeEdge(nodeName, edge.label(), edge.destination());
            } catch (NoSuchEdgeException e) {
                //Shh
            }

        removeEdgesWithDestination(nodeName);

        _nodes.remove(nodeName);

        _deterministic = wasDeterministic;
        if (!_deterministic)
            checkDeterminism();
    }

    private void removeEdgesWithDestination(String nodeName) {
        boolean wasDeterministic = _deterministic;
        _deterministic = true; //avoids checking after every edge removal for determinism in case it was an NFA

        for (Map.Entry<String,Set<Edge>> node : _nodes.entrySet()){
            for (Edge edge : node.getValue()){
                if (edge.destination().equals(nodeName)){
                    try {
                        removeEdge(node.getKey(),edge.label(), nodeName);
                    } catch (NoSuchNodeException | NoSuchEdgeException e) {
                        //shh1
                    }
                }
            }
        }

        _deterministic = wasDeterministic;
        if (!_deterministic)
            checkDeterminism();
    }

    private void checkDeterminism() {
        _deterministic = true;
        for (String node : _nodes.keySet()){
            if (nonDeterministicNode(node)){
                _deterministic = false;
                return;
            }
        }
    }

    private boolean nonDeterministicNode(String nodeName) {
        Set<Edge> nodeEdges = _nodes.get(nodeName);
        for (Edge edge : nodeEdges){
            if (edge.label() == null)
                return true;
            int counter = 0;
            for (Edge edge2 : nodeEdges){
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
    public void setName(String name) {
        this._name = name;
    }

    public Set<Character> getAlphabet() {
        return _alphabet;
    }
    public void setAlphabet(Set<Character> alphabet) {
        this._alphabet = alphabet;
    }

    public String getInitialState() {
        return _initialState;
    }
    public void setInitialState(String initialState) {
        this._initialState = initialState;
    }

    public Set<String> getFinalStates() {
        return _finalStates;
    }
    public void setFinalStates(Set<String> finalStates) {
        this._finalStates = finalStates;
    }

    public void addFinalState(String st) { _finalStates.add(st); }

    public boolean isDeterministic() {
        return _deterministic;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Initial State: ").append(_initialState).append("\n");
        sb.append("Final States: ").append(_finalStates.toString()).append("\n");
        sb.append("Edges: ").append(_nodes.toString()).append("\n");

        return sb.toString();
    }

    public void makeDeterministic() {
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

            for (String state: stateSet) {
                if (_finalStates.contains(state)) {
                    newFinalStates.add(nState);
                    break;
                }
            }

            Set<Edge> oldEdges = new HashSet<>();
            for (String state: stateSet)
                oldEdges.addAll(_nodes.get(state));

            Map<Character, Set<String>> transitions = new HashMap<>();
            for (Edge e : oldEdges) {
                if (!transitions.containsKey(e.transition.a))
                    transitions.put(e.transition.a, new HashSet<String>());

                transitions.get(e.transition.a).add(e.transition.b);
            }

            Set<Edge> newEdges = new HashSet<>();
            for (Map.Entry<Character, Set<String>> entry: transitions.entrySet()) {
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

    private Set<Character> _alphabet = new HashSet<Character>();
    private String _initialState;
    private Set<String> _finalStates = new HashSet<String>();
    private Map<String, Set<Edge>> _nodes = new LinkedHashMap<String, Set<Edge>>(); //for efficient iteration
    private String _name = ""; //may eventually be necessary to generate implementation of the automata (and name it)
    private boolean _deterministic = true;
}
