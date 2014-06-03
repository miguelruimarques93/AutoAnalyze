package pt.up.fe.comp.utils;

import org.antlr.v4.runtime.ParserRuleContext;

public class SemanticError extends Error {
    public SemanticError(ParserRuleContext ctx, Throwable ex) {
        super(ex);
        _ctx = ctx;
    }

    public SemanticError(ParserRuleContext ctx, String str) {
        this(ctx, new Throwable(str));
    }

    @Override
    public String getMessage() {
        return "line " + _ctx.getStart().getLine() + ":" + _ctx.getStart().getCharPositionInLine() + " " + getCause().getMessage();
    }

    private ParserRuleContext _ctx;
}
