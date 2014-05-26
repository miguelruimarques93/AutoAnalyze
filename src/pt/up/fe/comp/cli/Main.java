package pt.up.fe.comp.cli;

import org.antlr.runtime.MissingTokenException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.IntervalSet;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import pt.up.fe.comp.aa.AaVisitor;
import pt.up.fe.comp.aa.parser.aaLexer;
import pt.up.fe.comp.aa.parser.aaParser;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length == 1) { // read & process file
            String fileName = args[0];

            ANTLRInputStream input = new ANTLRFileStream(fileName);
            aaLexer lexer = new aaLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            aaParser parser = new aaParser(tokens);
            ParseTree tree = parser.stmt_list(); // parse

            AaVisitor eval = new AaVisitor();

            eval.visit(tree);
        } else if (args.length == 0) { // repl mode

            Scanner keyboard = new Scanner(System.in);
            aaParser parser = new aaParser(null);

            parser.setErrorHandler(new DefaultErrorStrategy() {
                @Override
                public void reportError(@NotNull Parser recognizer, @NotNull RecognitionException e) {
                    throw e;
                }

                @Override
                protected void reportMissingToken(@NotNull Parser recognizer) {
                    if (inErrorRecoveryMode(recognizer)) {
                        return;
                    }

                    beginErrorCondition(recognizer);

                    Token t = recognizer.getCurrentToken();
                    IntervalSet expecting = getExpectedTokens(recognizer);

                    throw new InputMismatchException(recognizer);
                }
            });

            AaVisitor eval = new AaVisitor(false);
            String input = "";
            while (true) {
                if (input.isEmpty())
                    System.out.print("\naa> ");
                else
                    System.out.print("  | ");

                String line;

                try {
                     line = keyboard.nextLine();
                } catch (NoSuchElementException e) {
                    System.out.println("\nAborted...");
                    break;
                }

                if (line == null) continue;

                input += line.trim();

                if (input.equals(":quit")) {
                    break;
                } else if ((!line.isEmpty() && !input.endsWith(";")) || input.isEmpty()) {
                    continue;
                }

                ANTLRInputStream in = new ANTLRInputStream(input);
                aaLexer lexer = new aaLexer(in);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                parser.setTokenStream(tokens);

                try {
                    ParseTree tree = parser.stmt();
                    eval.visit(tree);
                } catch (InputMismatchException e) {
                    if (e.getOffendingToken().getType() != Token.EOF) {
                        System.err.println("1: " + e);
                        System.err.println(e.getMessage());
                    } else {
                        continue;
                    }
                } catch (Error e) {
                    System.err.println("2: " + e);
                    System.err.println(e.getMessage());
                } catch (Exception e) {
                    System.err.println("3: " + e);
                    System.err.println(e.getMessage());
                }

                input = "";
            }

        } else { // usage
            System.err.println("Usage: java pt.up.fe.comp.cli.Main [file]");
            System.err.println("If no file is provided, the program will be initiated in REPL mode.");
        }
    }
}
