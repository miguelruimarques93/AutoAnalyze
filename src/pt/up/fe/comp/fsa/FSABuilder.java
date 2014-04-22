package pt.up.fe.comp.fsa;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import pt.up.fe.comp.dot.ir.DotGraph;

public class FSABuilder {
    public static FSA buildFrom(DotGraph ir) {
        String initialState = getInitialState(ir);
        
        if (initialState == null)
            return null;
        
        FSA fsa = null;
        try {
            fsa = new FSA(ir.name, initialState, ir.getNodes());
        } catch (DuplicateElementException e) {
            System.out.println(e);
            return null;
        }
        
        
        fsa.setFinalStates(getFinalStates(ir));
        
        for (String state : ir.getNodes()) {
            for (DotGraph.Edge edge : ir.getNodeEdges(state)) {
                try {
                    fsa.addEdges(state, edge.attributes.get("label"), edge.destination);
                } catch (NoSuchNodeException e) {
                    System.out.println(e);
                    return null;
                } catch (DuplicateElementException e) {
                    System.out.println(e);
                    return null;
                }
            }
        }
        
        return fsa;
    }
    
    private static Set<String> getFinalStates(DotGraph ir) {
        Set<String> finalStates = new HashSet<String>();
        
        for (String state : ir.getNodes()) {
            Map<String, String> attr = ir.getNodeAttributes(state);
            if (attr != null) {
                String shape = attr.get("shape");
                if (shape != null && shape.equals("doublecircle"))
                    finalStates.add(state);
            }
        }
        
        return finalStates;
    }
    
    private static String getInitialState(DotGraph ir) {
        for (String state : ir.getNodes())
            return state;
        return null;
    }
}
