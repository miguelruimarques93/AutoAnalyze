package pt.up.fe.comp.dot.ir;

import java.util.*;

public class DotGraph {
    public static class Edge {
        public String destination;
        public Map<String, String> attributes = new HashMap<>();
        public boolean directed;

        @Override
        public String toString() {
            return (directed ? "directed " : "") + destination + " " + attributes.toString();
        }

        @Override
        public boolean equals(Object rhs) {
            if (rhs instanceof Edge) {
                Edge other = (Edge) rhs;
                return other.destination.equals(destination) && other.attributes.equals(attributes);
            }
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s\nStrict: %s\nBidirectional: %s\n", this.name, this.strict, this.bidirectional));

        for (Map.Entry<String, List<Edge>> node : nodes.entrySet()) {
            sb.append(node.getKey() + " -> ");
            sb.append(node.getValue().toString());
            sb.append("\n");
        }

        return sb.toString();
    }

    public boolean strict = false;
    public boolean bidirectional = false;
    public String name;
    public Set<String> finalStates = new HashSet<>();
    public Map<String, List<Edge>> nodes = new HashMap<>();
}
