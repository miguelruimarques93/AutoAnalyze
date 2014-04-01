package pt.up.fe.comp.dot.ir;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DotGraph {
    public class Edge {
        public String destination;
        Map<String, String> attributes = new HashMap<String, String>();
        
        @Override
        public boolean equals(Object rhs) {
            if (rhs instanceof Edge) {
                Edge other = (Edge) rhs;
                return other.destination.equals(destination) && other.attributes.equals(attributes);
            }
            return false;
        }
    }
    
    public Set<String> finalStates = new HashSet<String>();
    public Map<String, List<Edge>> nodes = new HashMap<String, List<Edge>>();
}
