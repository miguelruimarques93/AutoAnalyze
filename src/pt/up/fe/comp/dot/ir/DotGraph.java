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
        sb.append(this.attributes.toString()).append("\n");
        for (Map.Entry<String, List<Edge>> node : nodes.entrySet()) {
        	sb.append(String.format("  %s %s -> %s\n",
        			node.getKey(), nodesAttributes.get(node.getKey()).toString(),
        			node.getValue().toString()));
        }

        return sb.toString();
    }

    public void addNode(String node) {
        if (!nodes.containsKey(node))
            nodes.put(node, new ArrayList<Edge>());
        
        if (!nodesAttributes.containsKey(node))
        	nodesAttributes.put(node, new HashMap<String, String>());
    }
    
    public void addNodeAttributes(String node, Map<String, String> attributes) {
    	if (nodesAttributes.containsKey(node))
    		nodesAttributes.get(node).putAll(attributes);
    	else
    		nodesAttributes.put(node, attributes);
    }
    
    public void addAttribute(String attr, String value) {
    	attributes.put(attr, value);
    }

    public Set<String> getNodes() {
        return nodes.keySet();
    }

    public boolean hasNode(String node) {
        return nodes.containsKey(node);
    }
    
    public Map<String, String> getNodeAttributes(String node) {
    	return nodesAttributes.get(node);
    }
    
    public String getAttribute(String attr) {
    	return attributes.get(attr);
    }

    public Edge addNewEdge(String node) {
        List<Edge> nodeEdges = nodes.get(node);
        if (nodeEdges == null)
            throw new NoSuchElementException();

        Edge result = new Edge();
        nodeEdges.add(result);

        return result;
    }

    public List<Edge> getNodeEdges(String node) {
        List<Edge> result = nodes.get(node);
        if (result == null)
            throw new NoSuchElementException();
        return result;
    }


    public boolean strict = false;
    public boolean bidirectional = false;
    public String name;
    public Map<String, List<Edge>> nodes = new LinkedHashMap<>();
    public Map<String, Map<String, String>> nodesAttributes = new HashMap<>();
    public Map<String, String> attributes = new HashMap<>();
}
