package pt.up.fe.comp.fsa;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import pt.up.fe.comp.dot.DotVisitor;
import pt.up.fe.comp.dot.parser.dotLexer;
import pt.up.fe.comp.dot.parser.dotParser;

import java.io.IOException;

public class FSALoader {
    public static FSA LoadFromFile(String fileName) throws IOException {

        ANTLRInputStream input = new ANTLRFileStream(fileName);
        dotLexer lexer = new dotLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        dotParser parser = new dotParser(tokens);
        ParseTree tree = parser.graph(); // parse

        DotVisitor eval = new DotVisitor();
        return FSABuilder.buildFrom(eval.visit(tree));
    }
}
