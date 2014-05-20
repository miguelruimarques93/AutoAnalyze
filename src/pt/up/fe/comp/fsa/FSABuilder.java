package pt.up.fe.comp.fsa;

import com.sun.javaws.exceptions.InvalidArgumentException;
import pt.up.fe.comp.dot.ir.DotGraph;

import java.util.*;

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
            if (ir.attributes.get("alphabethasnull") != null && ir.attributes.get("alphabethasnull").toLowerCase().equals("true"))
                toAdd.add(null);
            if (ir.attributes.get("alphabethasdoublequote") != null && ir.attributes.get("alphabethasdoublequote").toLowerCase().equals("true"))
                toAdd.add('"');

            for (char c : alph.toCharArray())
                toAdd.add(c);

            fsa.addToAlphabet(toAdd);
        }

        fsa.setFinalStates(getFinalStates(ir));

        Map<String, String> newNames = new LinkedHashMap<>();
        for (String state : ir.getNodes())
            newNames.put(state, state);

        for (String state : ir.getNodes()) {
            for (DotGraph.Edge edge : ir.getNodeEdges(state)) {
                try {
                    if (edge.attributes.get("regex") != null && edge.attributes.get("regex").equals("true")) {
                        try {
                            if (edge.attributes.get("label").length() < 2)
                                throw new Error("Regex must have double quotes: " + edge.attributes.get("label"));

                            String quoteLess = edge.attributes.get("label").substring(1, edge.attributes.get("label").length()-1);
                            FSA aut = new FSA("temp", quoteLess);
                            Set<String> originalNames = new LinkedHashSet<>(fsa.getNodes());

                            fsa.insertFSA(newNames.get(state), aut, newNames.get(edge.destination));
                            Set<String> alteredNames = new LinkedHashSet<>(fsa.getNodes());

                            alteredNames.removeAll(originalNames);
                            alteredNames.removeAll(aut.getNodes());

                            if (!alteredNames.isEmpty()) {
                                Map<String, String> _newNames = new LinkedHashMap<>();
                                int counter = 0;
                                Iterator<String> it = newNames.keySet().iterator();
                                for (String s : fsa.getNodes()) {
                                    if (counter >= newNames.size())
                                        break;
                                    _newNames.put(it.next(), s);
                                    ++counter;
                                }
                                newNames = _newNames;
                            }

                        } catch (InvalidArgumentException e) {
                            e.printStackTrace();
                            throw new Error("Invalid regex: " + edge.attributes.get("regex"));
                        }
                    }
                    else {
                        fsa.addEdges(newNames.get(state), edge.attributes.get("label"), newNames.get(edge.destination));
                    }
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
