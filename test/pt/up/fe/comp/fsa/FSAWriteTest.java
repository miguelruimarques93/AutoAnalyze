package pt.up.fe.comp.fsa;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import org.junit.Test;
import pt.up.fe.comp.dot.DotVisitor;
import pt.up.fe.comp.dot.ir.DotGraph;
import pt.up.fe.comp.dot.parser.dotLexer;
import pt.up.fe.comp.dot.parser.dotParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Set;

public class FSAWriteTest {

    @Test
    public void testToDot() {
        ANTLRInputStream input = null;
        try {
            input = new ANTLRInputStream(new FileInputStream("dot_dfa_examples/fsm.gv"));
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
        dotLexer lex = new dotLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lex);
        dotParser parser = new dotParser(tokens);
        ParseTree tree = parser.graph();

        DotVisitor eva = new DotVisitor();
        DotGraph graph = eva.visit(tree);

        FSA automaton = FSABuilder.buildFrom(graph);

        PrintStream stream;
        try {
            stream = new PrintStream("dot_dfa_examples/testToDot.gv");
            automaton.writeDot(stream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fail();
        }

        ANTLRInputStream newInput = null;
        try {
            newInput = new ANTLRInputStream(new FileInputStream("dot_dfa_examples/testToDot.gv"));
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
        dotLexer newLex = new dotLexer(newInput);
        CommonTokenStream newTokens = new CommonTokenStream(newLex);
        dotParser newParser = new dotParser(newTokens);
        ParseTree newTree = newParser.graph();

        DotVisitor newEva = new DotVisitor();
        DotGraph newGraph = newEva.visit(newTree);

        FSA newAut = FSABuilder.buildFrom(newGraph);

        assertTrue(compareSets(automaton.getFinalStates(), newAut.getFinalStates()));
        assertTrue(compareSets(automaton.getNodes(),newAut.getNodes()));

        for (String node: automaton.getNodes()) {
            try {
                assertTrue(compareSets(automaton.getNodeEdges(node),newAut.getNodeEdges(node)));
            } catch (NoSuchNodeException e) {
                e.printStackTrace();
                fail();
            }
        }
    }

    @Test
    public void testToHaskell() {
        ANTLRInputStream input = null;
        try {
            input = new ANTLRInputStream(new FileInputStream("dot_dfa_examples/COMP_HW1.gv"));
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
        dotLexer lex = new dotLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lex);
        dotParser parser = new dotParser(tokens);
        ParseTree tree = parser.graph();

        DotVisitor eva = new DotVisitor();
        DotGraph graph = eva.visit(tree);

        FSA automaton = FSABuilder.buildFrom(graph);


        try {
            PrintStream stream = new PrintStream("dot_dfa_examples/COMP_HW1.hs");
            automaton.write_haskell("COMP_HW1", stream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fail();
        }
        System.out.println(automaton);
        System.out.println("To test this you must run the Haskell code");
    }

    @Test
    public void testToHaskellNonDeterministic() {
        ANTLRInputStream input = null;
        try {
            input = new ANTLRInputStream(new FileInputStream("dot_dfa_examples/COMP_HW1_NFA.gv"));
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
        dotLexer lex = new dotLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lex);
        dotParser parser = new dotParser(tokens);
        ParseTree tree = parser.graph();

        DotVisitor eva = new DotVisitor();
        DotGraph graph = eva.visit(tree);

        FSA automaton = FSABuilder.buildFrom(graph);

        try {
            PrintStream stream = new PrintStream("dot_dfa_examples/COMP_HW1_NFA.hs");
            automaton.write_haskell("COMP_HW1_NFA", stream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fail();
        }
        System.out.println("To test this you must run the Haskell code");
    }

    @Test
    public void testToProlog() {
        ANTLRInputStream input = null;
        try {
            input = new ANTLRInputStream(new FileInputStream("dot_dfa_examples/COMP_HW1.gv"));
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
        dotLexer lex = new dotLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lex);
        dotParser parser = new dotParser(tokens);
        ParseTree tree = parser.graph();

        DotVisitor eva = new DotVisitor();
        DotGraph graph = eva.visit(tree);

        FSA automaton = FSABuilder.buildFrom(graph);


        try {
            PrintStream stream = new PrintStream("dot_dfa_examples/COMP_HW1.pl");
            automaton.write_prolog("COMP_HW1", stream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fail();
        }
        System.out.println("To test this you must run the Prolog code");
    }

    @Test
    public void testToCSharp() {
        ANTLRInputStream input = null;
        try {
            input = new ANTLRInputStream(new FileInputStream("dot_dfa_examples/COMP_HW1.gv"));
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
        dotLexer lex = new dotLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lex);
        dotParser parser = new dotParser(tokens);
        ParseTree tree = parser.graph();

        DotVisitor eva = new DotVisitor();
        DotGraph graph = eva.visit(tree);

        FSA automaton = FSABuilder.buildFrom(graph);

        try {
            PrintStream stream = new PrintStream("dot_dfa_examples/COMP_HW1.cs");
            automaton.write_csharp("COMP_HW1", stream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fail();
        }
        System.out.println(automaton);
        System.out.println("To test this you must run the C# code");
    }

    @Test
    public void testToCSharpNonDeterministic() {
        ANTLRInputStream input = null;
        try {
            input = new ANTLRInputStream(new FileInputStream("dot_dfa_examples/COMP_HW1_NFA.gv"));
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
        dotLexer lex = new dotLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lex);
        dotParser parser = new dotParser(tokens);
        ParseTree tree = parser.graph();

        DotVisitor eva = new DotVisitor();
        DotGraph graph = eva.visit(tree);

        FSA automaton = FSABuilder.buildFrom(graph);

        try {
            PrintStream stream = new PrintStream("dot_dfa_examples/COMP_HW1_NFA.cs");
            automaton.write_csharp("COMP_HW1_NFA", stream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fail();
        }
        System.out.println("To test this you must run the C# code");
    }

    private static <T> boolean compareSets(Set<T> s1, Set<T> s2){
        if (s1.size() != s2.size())
            return false;

        LinkedList<T> newS2 = new LinkedList<>(s2);

        for (T elem : s1) {
            if (!newS2.contains(elem))
                return false;
            newS2.removeFirstOccurrence(elem);
        }

        return newS2.isEmpty();
    }
}
