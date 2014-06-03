package pt.up.fe.comp.cli;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import pt.up.fe.comp.aa.AaVisitor;
import pt.up.fe.comp.aa.parser.aaLexer;
import pt.up.fe.comp.aa.parser.aaParser;
import pt.up.fe.comp.utils.CounterErrorListener;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length == 1 && args[0].equals("-repl")) { // repl mode

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

                    throw new InputMismatchException(recognizer);
                }
            });

            AaVisitor eval = new AaVisitor(false, false);
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
                CounterErrorListener cel = new CounterErrorListener();
                lexer.addErrorListener(cel);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                parser.setTokenStream(tokens);

                try {
                    ParseTree tree = parser.stmt_list();
                    if (cel.getNumErrors() == 0 && parser.getNumberOfSyntaxErrors() == 0)
                        eval.visit(tree);
                } catch (InputMismatchException e) {
                    if (e.getOffendingToken().getType() != Token.EOF) {
                        System.err.println(e.getMessage());
                    } else {
                        continue;
                    }
                } catch (Exception | Error e) {
                    System.err.println(e.getMessage());
                }

                input = "";
            }

        } else if (args.length == 1) { // read & process file
            String fileName = args[0];

            ANTLRInputStream input = new ANTLRFileStream(fileName);
            aaLexer lexer = new aaLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            CounterErrorListener cel = new CounterErrorListener();

            lexer.addErrorListener(cel);

            aaParser parser = new aaParser(tokens);
            ParseTree tree = parser.stmt_list(); // parse

            if (parser.getNumberOfSyntaxErrors() == 0 && cel.getNumErrors() == 0) {
                AaVisitor eval = new AaVisitor();
                try {
                    eval.visit(tree);
                } catch (Error e) {
                    System.err.println(e.getMessage());
                    System.exit(1);
                }
            }

        } else { // usage
            System.err.println("Usage: java pt.up.fe.comp.cli.Main (-repl | file)");
            System.err.println("-repl : Start repl mode");
            System.err.println("file : File to execute");
        }
    }
}
