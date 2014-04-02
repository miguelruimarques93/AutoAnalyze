package pt.up.fe.comp.dot;

import pt.up.fe.comp.dot.parser.dotBaseVisitor;
import pt.up.fe.comp.dot.parser.dotParser.A_listContext;
import pt.up.fe.comp.dot.parser.dotParser.Attr_listContext;
import pt.up.fe.comp.dot.parser.dotParser.Attr_stmtContext;
import pt.up.fe.comp.dot.parser.dotParser.EdgeRHSContext;
import pt.up.fe.comp.dot.parser.dotParser.Edge_stmtContext;
import pt.up.fe.comp.dot.parser.dotParser.EdgeopContext;
import pt.up.fe.comp.dot.parser.dotParser.GraphContext;
import pt.up.fe.comp.dot.parser.dotParser.IdContext;
import pt.up.fe.comp.dot.parser.dotParser.Node_idContext;
import pt.up.fe.comp.dot.parser.dotParser.Node_stmtContext;
import pt.up.fe.comp.dot.parser.dotParser.PortContext;
import pt.up.fe.comp.dot.parser.dotParser.StmtContext;
import pt.up.fe.comp.dot.parser.dotParser.Stmt_listContext;
import pt.up.fe.comp.dot.parser.dotParser.SubgraphContext;

public class MyDotVisitor extends dotBaseVisitor<Object> {

    @Override
    public Object visitAttr_stmt(Attr_stmtContext ctx) {
        // TODO Auto-generated method stub
        return super.visitAttr_stmt(ctx);
    }

    @Override
    public Object visitPort(PortContext ctx) {
        // TODO Auto-generated method stub
        return super.visitPort(ctx);
    }

    @Override
    public Object visitEdgeop(EdgeopContext ctx) {
        // TODO Auto-generated method stub
        return super.visitEdgeop(ctx);
    }

    @Override
    public Object visitStmt_list(Stmt_listContext ctx) {
        // TODO Auto-generated method stub
        return super.visitStmt_list(ctx);
    }

    @Override
    public Object visitStmt(StmtContext ctx) {
        // TODO Auto-generated method stub
        return super.visitStmt(ctx);
    }

    @Override
    public Object visitEdgeRHS(EdgeRHSContext ctx) {
        // TODO Auto-generated method stub
        return super.visitEdgeRHS(ctx);
    }

    @Override
    public Object visitNode_id(Node_idContext ctx) {
        // TODO Auto-generated method stub
        return super.visitNode_id(ctx);
    }

    @Override
    public Object visitId(IdContext ctx) {
        // TODO Auto-generated method stub
        return super.visitId(ctx);
    }

    @Override
    public Object visitSubgraph(SubgraphContext ctx) {
        // TODO Auto-generated method stub
        return super.visitSubgraph(ctx);
    }

    @Override
    public Object visitGraph(GraphContext ctx) {
        // TODO Auto-generated method stub
        return super.visitGraph(ctx);
    }

    @Override
    public Object visitA_list(A_listContext ctx) {
        // TODO Auto-generated method stub
        return super.visitA_list(ctx);
    }

    @Override
    public Object visitAttr_list(Attr_listContext ctx) {
        // TODO Auto-generated method stub
        return super.visitAttr_list(ctx);
    }

    @Override
    public Object visitEdge_stmt(Edge_stmtContext ctx) {
        // TODO Auto-generated method stub
        return super.visitEdge_stmt(ctx);
    }

    @Override
    public Object visitNode_stmt(Node_stmtContext ctx) {
        // TODO Auto-generated method stub
        return super.visitNode_stmt(ctx);
    }
}
