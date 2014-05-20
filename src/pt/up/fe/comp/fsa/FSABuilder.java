package pt.up.fe.comp.fsa;

import pt.up.fe.comp.dot.ir.DotGraph;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FSABuilder {
    public static FSA buildFrom(DotGraph ir) {
        String initialState = getInitialState(ir);

        if (initialState == null)
            return null;

        FSA fsa;
        try {
            fsa = new FSA(ir.name, initialState, ir.getNodes());
        } catch (DuplicateElementException e) {
            e.printStackTrace();
            return null;
        }

        if (ir.attributes.containsKey("alphabet") && ir.attributes.get("alphabet") != null) {
            String alph = ir.attributes.get("alphabet");
            alph = alph.replaceAll("^\"|\"$", "");
            Set<Character> toAdd = new HashSet<>();
            if (ir.attributes.get("alphabethasnull") != null && ir.attributes.get("alphabethasnull").equals("true"))
                toAdd.add(null);
            if (ir.attributes.get("alphabethasdoublequote") != null && ir.attributes.get("alphabethasdoublequote").equals("true"))
                toAdd.add('"');

            for (char c : alph.toCharArray())
                toAdd.add(c);

            fsa.addToAlphabet(toAdd);
        }

        fsa.setFinalStates(getFinalStates(ir));

        for (String state : ir.getNodes()) {
            for (DotGraph.Edge edge : ir.getNodeEdges(state)) {
                try {
                    fsa.addEdges(state, edge.attributes.get("label"), edge.destination);
                } catch (NoSuchNodeException e) {
                    e.printStackTrace();
                    return null;
                } catch (DuplicateElementException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }

        return fsa;
    }

    private static Set<String> getFinalStates(DotGraph ir) {
        Set<String> finalStates = new HashSet<>();

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
        if (ir.attributes.containsKey("initialstate"))
            return ir.attributes.get("initialstate");

        if (!ir.getNodes().isEmpty())
            return ir.getNodes().iterator().next();
        return null;
    }
}
