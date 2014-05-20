package pt.up.fe.comp.fsa;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.antlr.v4.runtime.misc.Pair;

import java.io.PrintStream;
import java.util.*;

/**
 * This class defines a Finite State Automata, containing all necessary information to describe one, namely:
 * <p>
 * - The alphabet;
 * <p>
 * - The set of states (can NOT be empty);
 * <p>
 * - The initial state;
 * <p>
 * - The set of final states (can be empty);
 * <p>
 * - The set of edges / transition function.
 * <p>
 * <p>
 * It also contains several methods to allow for the manipulation of the automata and a boolean to indicate if it is
 * deterministic or not.
 */
public class FSA {

    /**
     * This class is essentially a wrapper for a Pair<Character, String> already defined in the ANTLR4 libraries.
     * <p>
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

    public enum CartesianType {
        UNION, INTERSECTION, XOR, DIFF, NONE
    }

    public FSA(String name, String initialState, Collection<String> stateNames) throws DuplicateElementException {
        if (name == null)
            _name = "";
        else
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
        _alphabet = new HashSet<>(fsa._alphabet);

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

    public void addToAlphabet(Character c) {
        _alphabet.add(c);
    }

    public void addToAlphabet(Set<Character> chars) {
        _alphabet.addAll(chars);
    }

    public boolean isIncludedIn(FSA other) {
        return other.intersect(this).equals(this);
    }

    private Set<Character> getCharactersInUse() {
        Set<Character> res = new HashSet<>();

        for (String node : _nodes.keySet()) {
            for (Edge edge : _nodes.get(node)) {
                res.add(edge.label());
            }
        }
        return res;
    }

    public boolean removeFromAlphabet(Set<Character> str) {
        Set<Character> charsInUse = getCharactersInUse();

        for (Character c : str) {
            if (charsInUse.contains(c)) {
                return false;
            }
        }

        for (Character c : str) {
            _alphabet.remove(c);
        }

        return true;
    }

    public void stripAlphabet() {
        Set<Character> charsInUse = getCharactersInUse();

        Set<Character> unused = new HashSet<>(_alphabet);
        unused.removeAll(charsInUse);

        _alphabet.removeAll(unused);
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
        if (!_alphabet.contains(input))
            _alphabet.add(input);

        nodeEdges.add(newEdge);
    }

    /**
     * Same as addEdge but allows for a chain of inputs and creates intermediate states
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
                while (_nodes.containsKey(nextNode))
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

        if (!_deterministic) //don't use isDeterministic to prevent check from occurring if another edge had been removed
            _needsDeterminismUpdate = true;
    }

    public void removeNode(String nodeName) throws NoSuchNodeException {
        if (_initialState.equals(nodeName))
            return;

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

    public void setName(String name) {
        this._name = name;
    }

    public Set<Character> getAlphabet() {
        return _alphabet;
    }

    public String getInitialState() {
        return _initialState;
    }

    public void setInitialState(String initialState) throws NoSuchNodeException {
        if (!_nodes.containsKey(initialState))
            throw new NoSuchNodeException(initialState);
        this._initialState = initialState;
    }

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

    public void removeFinalState(String st) {
        _finalStates.remove(st);
    }

    public boolean isDeterministic() {
        if (_needsDeterminismUpdate) {
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

    public FSA union(FSA other) {
        try {
            FSA res = new FSA(this.getName() + "_" + other.getName(), "q0", new LinkedHashSet<String>());
            res.addToAlphabet(this.getAlphabet());
            res.addToAlphabet(other.getAlphabet());

            Integer counter = 1;
            Map<String, String> this_newNames = new HashMap<>();
            Map<String, String> other_newNames = new HashMap<>();

            for (String state : getNodes()) {
                String newName = "q" + counter;
                res.addNode(newName);
                this_newNames.put(state, newName);
                if (getFinalStates().contains(state))
                    res.addFinalState(newName);
                counter++;
            }
            for (String state : other.getNodes()) {
                String newName = "q" + counter;
                res.addNode(newName);
                other_newNames.put(state, newName);
                if (other.getFinalStates().contains(state))
                    res.addFinalState(newName);
                counter++;
            }

            res.addEdge("q0", null, this_newNames.get(getInitialState()));
            res.addEdge("q0", null, other_newNames.get(other.getInitialState()));

            for (String state : getNodes()) {
                for (Edge e : getNodeEdges(state)) {
                    res.addEdge(this_newNames.get(state), e.label(), this_newNames.get(e.destination()));
                }
            }

            for (String state : other.getNodes()) {
                for (Edge e : other.getNodeEdges(state)) {
                    res.addEdge(other_newNames.get(state), e.label(), other_newNames.get(e.destination()));
                }
            }

            return res;
        } catch (FSAException e) {
            e.printStackTrace();
            return null;
        }
    }

    public FSA intersect(FSA other) {
        FSA temp1 = new FSA(this);
        FSA temp2 = new FSA(other);
        temp1.addToAlphabet(other.getAlphabet());
        temp2.addToAlphabet(getAlphabet());

        temp1.complement();
        temp2.complement();

        FSA united = temp1.union(temp2);
        united.complement();

        return united;
    }

    public FSA diff(FSA other) {
        FSA temp1 = new FSA(this);
        FSA temp2 = new FSA(other);
        temp1.addToAlphabet(other.getAlphabet());
        temp2.addToAlphabet(getAlphabet());
        temp2.complement();

        return temp1.intersect(temp2);
    }

    public FSA cartesian(FSA other, CartesianType resultType) {
        FSA thisCopy = new FSA(this);
        thisCopy.addToAlphabet(other.getAlphabet());
        thisCopy.makeTotal();
        FSA otherCopy = new FSA(other);
        otherCopy.addToAlphabet(getAlphabet());
        otherCopy.makeTotal();

        Table<String, String, String> newNodes = HashBasedTable.create(thisCopy.getNodes().size(), otherCopy.getNodes().size());
        HashMap<String, Integer> numFinalsForNode = new HashMap<>();

        Integer counter = 0;
        String initialState = null;
        boolean initialStateFound = false;

        for (String node : thisCopy.getNodes()) {
            boolean isInitial = node.equals(thisCopy.getInitialState());
            int numFinals = thisCopy.getFinalStates().contains(node) ? 1 : 0;

            for (String oNode : otherCopy.getNodes()) {
                String newName = "q" + counter.toString();
                newNodes.put(node, oNode, newName);
                if (!initialStateFound && isInitial && oNode.equals(otherCopy.getInitialState())) {
                    initialStateFound = true;
                    initialState = newName;
                }
                if (otherCopy.getFinalStates().contains(oNode))
                    numFinalsForNode.put(newName, numFinals + 1);
                else
                    numFinalsForNode.put(newName, numFinals);
                ++counter;
            }
        }

        if (!initialStateFound) {
            return null;
        }

        try {
            FSA result = new FSA("cart_" + resultType.toString().toLowerCase() + "_" + thisCopy.getName() + "_" + otherCopy.getName(), initialState, newNodes.values());
            Set<Character> alphabet = thisCopy.getAlphabet();
            result.addToAlphabet(alphabet);
            for (String node : thisCopy.getNodes()) {
                Set<Edge> thisEdges = thisCopy.getNodeEdges(node);

                for (String oNode : otherCopy.getNodes()) {
                    Set<Edge> otherEdges = otherCopy.getNodeEdges(oNode);
                    String newNode = newNodes.get(node, oNode);
                    for (Character c : alphabet) {
                        Set<String> thisReachable = getDestinationsForInput(thisEdges, c);
                        Set<String> otherReachable = getDestinationsForInput(otherEdges, c);
                        for (String thisDest : thisReachable) {
                            for (String otherDest : otherReachable) {
                                String newDest = newNodes.get(thisDest, otherDest);
                                result.addEdge(newNode, c, newDest);
                            }
                        }
                    }
                }
            }
            int minFinals;
            int maxFinals;
            switch (resultType) {
                case UNION:
                    minFinals = 1;
                    maxFinals = 2;
                    break;
                case INTERSECTION:
                    minFinals = 2;
                    maxFinals = 2;
                    break;
                case XOR:
                    minFinals = 1;
                    maxFinals = 1;
                    break;
                case DIFF:
                    for (String node : thisCopy.getFinalStates()) {
                        Map<String, String> finalsInRow = newNodes.row(node);
                        for (String fn : finalsInRow.keySet()) {
                            if (!otherCopy.getFinalStates().contains(fn)) {
                                result.addFinalState(finalsInRow.get(fn));
                            }
                        }
                    }
                    return result;
                case NONE:
                    return result;
                default:
                    return null;
            }
            for (String newNode : numFinalsForNode.keySet()) {
                int nf = numFinalsForNode.get(newNode);
                if (nf >= minFinals && nf <= maxFinals)
                    result.addFinalState(newNode);
            }

            return result;
        } catch (FSAException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Set<String> getDestinationsForInput(Set<Edge> edges, Character input) {
        Set<String> destNodes = new HashSet<>();
        for (Edge e : edges) {
            if (e.label() == input)
                destNodes.add(e.destination());
        }
        return destNodes;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (!(obj instanceof FSA))
            return false;

        FSA thisCopy = new FSA(this);
        thisCopy.minimize();
        thisCopy.stripAlphabet();
        FSA otherCopy = new FSA((FSA) obj);
        otherCopy.minimize();
        otherCopy.stripAlphabet();

        if (!thisCopy.getAlphabet().containsAll(otherCopy.getAlphabet()) || !otherCopy.getAlphabet().containsAll(thisCopy.getAlphabet()))
            return false;
        if (thisCopy.getNodes().size() != otherCopy.getNodes().size())
            return false;
        if (thisCopy.getFinalStates().size() != otherCopy.getFinalStates().size())
            return false;

        Queue<String> thisToVisit = new LinkedList<>();
        thisToVisit.add(thisCopy.getInitialState());
        Queue<String> otherToVisit = new LinkedList<>();
        otherToVisit.add(otherCopy.getInitialState());
        Set<String> thisVisited = new HashSet<>();
        Set<String> otherVisited = new HashSet<>();
        Map<String, String> thisToNew = new HashMap<>();
        Map<String, String> otherToNew = new HashMap<>();

        Integer counter = 0;
        try {
            while (!thisToVisit.isEmpty() && !otherToVisit.isEmpty()) {
                String thisCur = thisToVisit.remove();
                String otherCur = otherToVisit.remove();
                thisVisited.add(thisCur);
                otherVisited.add(otherCur);
                String mappedName = "q" + counter;
                thisToNew.put(thisCur, mappedName);
                otherToNew.put(otherCur, mappedName);
                ++counter;

                Set<Edge> thisEdges = thisCopy.getNodeEdges(thisCur);
                Set<Edge> otherEdges = otherCopy.getNodeEdges(otherCur);
                if (thisEdges.size() != otherEdges.size()) {
                    System.out.println("fail1");
                    return false;
                }

                for (Edge e : thisEdges) {
                    Set<String> otherDests = getDestinationsForInput(otherEdges, e.label());
                    if (otherDests.size() != 1) {
                        System.out.println("fail2");
                        return false;
                    }

                    String oDest = otherDests.iterator().next();
                    if (thisVisited.contains(e.destination()) || otherVisited.contains(oDest)) {
                        if (!thisVisited.contains(e.destination()) || !otherVisited.contains(oDest)) {
                            System.out.println("fail3");
                            return false;
                        }
                        if (!thisToNew.get(e.destination()).equals(otherToNew.get(oDest))) {
                            System.out.println("fail4");
                            return false;
                        }
                    } else {
                        thisToVisit.add(e.destination());
                        otherToVisit.add(oDest);
                    }
                }

            }
        } catch (FSAException e) {
            e.printStackTrace();
            return false;
        }

        return true;
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

        while (!toExpand.isEmpty()) {
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

        if (_alphabet.contains(null))
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
        } while (!done);

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

        for (String node : getNodes()) {
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
        } while (!done);

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

        for (Map.Entry<String, Set<Edge>> node : _nodes.entrySet()) {
            Set<Edge> nodeEdges = node.getValue();
            Set<Character> edgesCharacters = new HashSet<>();

            for (Edge e : nodeEdges)
                edgesCharacters.add(e.label());

            Set<Character> nonExistent = new HashSet<>(alphabet);
            nonExistent.removeAll(edgesCharacters);

            if (!nonExistent.isEmpty())
                return false;
        }

        return true;
    }

    public void makeTotal() {
        if (_alphabet.contains(null)) { //special case
            _deterministic = false;
            for (String node : getNodes()) {
                _nodes.get(node).add(new Edge(null, node));
            }
        }
        String errorState = "_error";
        Set<Character> alphabet = getAlphabet();
        Map<String, Set<Character>> toAdd = new HashMap<>();

        for (Map.Entry<String, Set<Edge>> node : _nodes.entrySet()) {
            Set<Edge> nodeEdges = node.getValue();
            Set<Character> edgesCharacters = new HashSet<>();

            for (Edge e : nodeEdges)
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
                for (Character c : node.getValue()) {
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

    public boolean onlyAcceptsEmptyString() {
        FSA copy = new FSA(this);
        copy.minimize();
        if (copy.getNodes().size() != 1 || copy.getFinalStates().size() != 1)
            return false;

        Set<Edge> nodeEdges;
        try {
            nodeEdges = copy.getNodeEdges(copy.getInitialState());
        } catch (NoSuchNodeException e) {
            e.printStackTrace();
            return false;
        }
        return (nodeEdges.isEmpty() || (nodeEdges.size() == 1 && nodeEdges.contains(new Edge(null, copy.getInitialState()))));
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
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                matrix[i][j] = (_finalStates.contains(numberToNode.get(i)) && !_finalStates.contains(numberToNode.get(j))) ||
                        (!_finalStates.contains(numberToNode.get(i)) && _finalStates.contains(numberToNode.get(j)));
            }
        }

        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < i; j++) { //symmetrical matrix
                    if (matrix[i][j]) continue;

                    for (char c : _alphabet) {
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

                        if (matrix[nodeToNumber.get(iNode)][nodeToNumber.get(jNode)] || matrix[nodeToNumber.get(jNode)][nodeToNumber.get(iNode)]) {
                            matrix[i][j] = true;
                            changed = true;
                            break;
                        }
                    }
                }
            }
        }

        for (int i = matrix.length - 1; i > -1; i--) { //start from largest nodes and merge progressively
            boolean toRemove = false;
            for (int j = i - 1; j > -1; j--) {
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
            if (toRemove) {
                try {
                    removeNode(numberToNode.get(i));
                } catch (NoSuchNodeException e) {
                    e.printStackTrace();
                }
            }
        }
        removeUselessStates();
    }

    public void writeDot(PrintStream writer) {
        writer.println("digraph " + getName() + " {");
        writer.println("\trankdir=LR;");

        writer.println("\tinitialstate=" + _initialState + ";");
        if (_alphabet.size() > 0) {
            writer.print("\talphabet=\"");
            for (Character c : _alphabet) {
                if (c != null && c != '"')
                    writer.print(c);
            }
            writer.println("\";");
            if (_alphabet.contains(null)) {
                writer.println("\talphabethasnull=true;");
            }
            if (_alphabet.contains('"')) {
                writer.println("\talphabethasdoublequote=true;");
            }
        }

        Set<String> fs = getFinalStates();
        if (!fs.isEmpty()) {
            writer.print("\tnode [shape = doublecircle];");
            for (String finalNode : fs) {
                writer.print(" " + finalNode);
            }
            writer.println(";");
        }

        Set<String> nds = getNodes();
        if (!nds.isEmpty()) {
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
    }

    public void write_prolog(String moduleName, PrintStream writer) {
        FSA aut = new FSA(this);
        aut.removeEmptyTransitions();

        String m_code_name = "code_" + moduleName + "_";
        String m_trans_name = "transition_" + moduleName;
        String m_ini_name = "initial_state_" + moduleName;
        String m_final_name = "final_state_" + moduleName;
        String m_accept_name = "accept_" + moduleName;

        for (Character c : aut.getAlphabet())
            writer.print(m_code_name + c + "(C):- \"" + c + "\" = [C]. ");

        writer.println();
        writer.println();

        int initialState = -1;
        LinkedList<Integer> finalStates = new LinkedList<>();

        LinkedList<String> nodes = new LinkedList<>(aut.getNodes());
        for (int i = 0; i < nodes.size(); i++) {
            if (initialState == -1 && nodes.get(i).equals(aut.getInitialState()))
                initialState = i;
            if (aut.getFinalStates().contains(nodes.get(i)))
                finalStates.add(i);

            try {
                Set<Edge> edges = aut.getNodeEdges(nodes.get(i));
                if (edges != null && !edges.isEmpty()) {
                    for (Edge edge : edges) {
                        writer.println(m_trans_name + "(q" + Integer.toString(i) + ", C, q" + nodes.indexOf(edge.destination()) + "):- " + m_code_name + edge.label() + "(C).");
                    }
                    writer.println();
                }

            } catch (NoSuchNodeException e) {
                e.printStackTrace();
            }
        }
        writer.println();
        writer.println(m_ini_name + "(q" + Integer.toString(initialState) + ").");
        writer.println();
        for (Integer finalState : finalStates) writer.print(m_final_name + "(q" + finalState + "). ");

        writer.println();
        writer.println(m_accept_name + "(String):-\n" +
                "        " + m_ini_name + "(State), " + m_accept_name + "(String,State).\n" +
                "\n" +
                m_accept_name + "([],State):- " + m_final_name + "(State). %state must be a final state after all of the input has been tested\n" +
                m_accept_name + "([C|Cs],State):-\n" +
                "        " + m_trans_name + "(State,C,NextState), " + m_accept_name + "(Cs,NextState).");
    }

    public void write_haskell(String moduleName, PrintStream writer) {
        if (!isDeterministic()) {
            FSA aut = new FSA(this);
            aut.makeDeterministic();
            aut.write_haskell(moduleName, writer);
            return;
        }

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
                        writer.print("|c=='" + edge.label() + "' = " + nodes.indexOf(edge.destination()));
                    }
                    writer.println();
                }

            } catch (NoSuchNodeException e) {
                e.printStackTrace();
            }
        }
        writer.println("delta _ _ = -1");
        writer.println();
        writer.println("initialState::Int\ninitialState = " + Integer.toString(initialState));
        writer.println();
        writer.println("finalStates::[Int]");
        writer.print("finalStates = [");
        for (int i = 0; i < finalStates.size(); i++) {
            writer.print(finalStates.get(i));
            if (i < finalStates.size() - 1)
                writer.print(",");
        }
        writer.println("]");
        writer.println();

        writer.println("accept::String -> Bool");
        writer.println("accept str = foldl delta initialState str `elem` finalStates");
    }

    public void write_csharp(String moduleName, PrintStream writer) {
        if (!isDeterministic()) {
            FSA aut = new FSA(this);
            aut.makeDeterministic();
            aut.write_csharp(moduleName, writer);
            return;
        }

        ArrayList<Character> alphabet = new ArrayList<>(getAlphabet());
        ArrayList<Boolean> finalStates = new ArrayList<>();
        Set<String> finalStatesSet = getFinalStates();
        Set<String> statesSet = getNodes();
        int[][] transitions = new int[statesSet.size() + 1][alphabet.size() + 1];

        int initialState = -1;

        LinkedList<String> nodes = new LinkedList<>(statesSet);
        finalStates.add(false);
        for (int i = 0; i < nodes.size(); i++) {
            if (initialState == -1 && nodes.get(i).equals(getInitialState()))
                initialState = i;

            finalStates.add(finalStatesSet.contains(nodes.get(i)));

            try {
                for (int j = 0; j < alphabet.size(); ++j) {
                    Set<Edge> edges = getNodeEdges(nodes.get(i));
                    String dest = null;
                    for (Edge edge : edges) {
                        if (edge.label() == alphabet.get(j)) {
                            dest = edge.destination();
                            break;
                        }
                    }

                    int edgesIdx = nodes.indexOf(dest);
                    transitions[i + 1][j] = edgesIdx + 1;
                }

                transitions[i + 1][alphabet.size()] = 0;
            } catch (NoSuchNodeException e) {
                e.printStackTrace();
            }
        }

        int level = 0;

        writer.println(indent(level) + "using System;");
        writer.println(indent(level) + "using System.Linq;");
        writer.println();
        writer.println(indent(level) + "namespace Aut_" + moduleName);
        writer.println(indent(level++) + "{");
        writer.println(indent(level) + "static class Program");
        writer.println(indent(level++) + "{");
        writer.println(indent(level) + "static public bool Accept(string str)");
        writer.println(indent(level++) + "{");
        writer.println(indent(level) + "var edge = new[,]");
        writer.println(indent(level++) + "{");
        for (int i = 0; i < transitions.length; ++i) {
            writer.print(indent(level) + "{");
            for (int j = 0; j < transitions[i].length; ++j) {
                writer.print(transitions[i][j]);
                if (j != transitions[i].length - 1) {
                    writer.print(", ");
                }
            }
            writer.print("}");
            if (i != transitions.length - 1) {
                writer.print(",");
            }
            writer.println();
        }
        writer.println(indent(--level) + "};");
        writer.println();
        writer.print(indent(level) + "var final = new[] {");
        for (int i = 0, size = finalStates.size(); i < size; ++i) {
            writer.print(finalStates.get(i) ? "true" : "false");
            if (i != size - 1) {
                writer.print(", ");
            }
        }
        writer.println("};");
        writer.println();
        writer.println(indent(level) + "var map = new Func<char, int>(x =>");
        writer.println(indent(level++) + "{");
        writer.println(indent(level) + "switch (x)");
        writer.println(indent(level++) + "{");
        for (int i = 0, size = getAlphabet().size(); i < size; ++i) {
            writer.println(indent(level) + "case '" + alphabet.get(i) + "': return " + i + ";");
        }
        writer.println(indent(level) + "default : return " + getAlphabet().size() + ";");
        writer.println(indent(--level) + "}");
        writer.println(indent(--level) + "});");
        writer.println();
        writer.println(indent(level) + "if (str != null)");
        writer.println(indent(level++) + "{");
        writer.print(indent(level) + "var state = str.Aggregate(");
        writer.print(initialState + 1);
        writer.println(", (current, c) => edge[current, map(c)]);");
        writer.println(indent(level) + "return final[state];");
        writer.println(indent(--level) + "}");
        writer.println(indent(level) + "return false;");
        writer.println(indent(--level) + "}");
        writer.println(indent(level) + "static void Main()");
        writer.println(indent(level++) + "{");
        writer.println(indent(level) + "var str = Console.ReadLine();");
        writer.println(indent(level) + "Console.WriteLine(Accept(str) ? \"accept\" : \"reject\");");
        writer.println(indent(--level) + "}");
        writer.println(indent(--level) + "}");
        writer.println(indent(--level) + "}");
    }

    private String indent(int level) {
        String res = "";
        for (int i = 0; i < level; ++i) {
            res += '\t';
        }
        return res;
    }

    private boolean _needsDeterminismUpdate = false;
    private Set<Character> _alphabet = new HashSet<>();
    private String _initialState;
    private Set<String> _finalStates = new HashSet<>();
    private Map<String, Set<Edge>> _nodes = new LinkedHashMap<>(); //for efficient iteration
    private String _name = "";
    private boolean _deterministic = true;
}
