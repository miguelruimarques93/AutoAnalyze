package pt.up.fe.comp.aa;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import pt.up.fe.comp.aa.parser.aaBaseVisitor;
import pt.up.fe.comp.aa.parser.aaLexer;
import pt.up.fe.comp.aa.parser.aaParser;
import pt.up.fe.comp.fsa.FSA;
import pt.up.fe.comp.fsa.FSALoader;
import pt.up.fe.comp.utils.SymbolTable;

import java.io.IOException;

public class AaVisitor extends aaBaseVisitor<FSA> {

    public class AaBooleanVisitor extends aaBaseVisitor<Boolean> {
        @Override
        public Boolean visitPredicate(@NotNull aaParser.PredicateContext ctx) {
            return super.visitPredicate(ctx);
        }
    }
    private AaBooleanVisitor _boolVisitor = new AaBooleanVisitor();

    private SymbolTable<FSA> _symbols = new SymbolTable<>();

    @Override
    public FSA visitStmt_list(@NotNull aaParser.Stmt_listContext ctx) {
        _symbols.beginScope();
        FSA result = null;
        for (aaParser.StmtContext stmt : ctx.stmt())
            result = visit(stmt);
        _symbols.endScope();
        return result;
    }

    @Override
    public FSA visitAttribution(@NotNull aaParser.AttributionContext ctx) {
        String name = ctx.attribution_lhs().IDENTIFIER().getText();
        aaParser.Attribution_rhsContext rhs = ctx.attribution_rhs();

        FSA value = null;
        if (rhs.operation() != null)
            value = visit(rhs.operation());
        else if (rhs.IDENTIFIER() != null)
            value = _symbols.get(rhs.IDENTIFIER().getText());
        else if (rhs.STRING() != null)
            try {
                value = FSALoader.LoadFromFile(rhs.STRING().getText());
            } catch (IOException e) {
                e.printStackTrace();
            }

        if (value != null)
            _symbols.addSymbol(name, value);

        return null;
    }

    @Override
    public FSA visitControl_expr(@NotNull aaParser.Control_exprContext ctx) {
        boolean predEval = _boolVisitor.visit(ctx.predicate());
        if (predEval) {
            return visit(ctx.trueCase);
        } else if (ctx.falseCase != null) {
            return visit(ctx.falseCase);
        }
        return null;
    }

    @Override
    public FSA visitStmt(@NotNull aaParser.StmtContext ctx) {
        assert(ctx.getChildCount() == 1);
        return visit(ctx.getChild(0));
    }

    @Override
    public FSA visitOperation(@NotNull aaParser.OperationContext ctx) {
        return super.visitOperation(ctx);
    }

    @Override
    public FSA visitArg_list(@NotNull aaParser.Arg_listContext ctx) {
        return super.visitArg_list(ctx);
    }

    @Override
    public FSA visitP_operator(@NotNull aaParser.P_operatorContext ctx) {
        return super.visitP_operator(ctx);
    }

    @Override
    public FSA visitOperator(@NotNull aaParser.OperatorContext ctx) {
        return super.visitOperator(ctx);
    }

    public static void main(String[] args) {
        String[] vals = {
                "a = \"somefile.gv\"",
                "b = \"someotherfile.gv\"",
                "c = a",
                "d = union a (diff b c)"
        };

        AaVisitor eval = new AaVisitor();

        for (String code: vals) {
            ANTLRInputStream input = new ANTLRInputStream(code);
            aaLexer lexer = new aaLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            aaParser parser = new aaParser(tokens);
            ParseTree tree = parser.attribution(); // parse
            eval.visit(tree);
        }
    }
}
