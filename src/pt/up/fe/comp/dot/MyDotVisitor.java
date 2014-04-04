package pt.up.fe.comp.dot;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import pt.up.fe.comp.dot.ir.DotGraph;
import pt.up.fe.comp.dot.parser.dotBaseVisitor;
import pt.up.fe.comp.dot.parser.dotLexer;
import pt.up.fe.comp.dot.parser.dotParser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyDotVisitor extends dotBaseVisitor<DotGraph> {

    private class StringDotVisitor extends dotBaseVisitor<String> {
        @Override
        public String visitNode_id(@NotNull dotParser.Node_idContext ctx) {
            return ctx.id().getText();
        }
    }

    private class AttributesDotVisitor extends dotBaseVisitor<Map<String, String>> {
        @Override
        public Map<String, String> visitA_list(@NotNull dotParser.A_listContext ctx) {
            List<dotParser.IdContext> ids = ctx.id();
            HashMap<String, String> result = new HashMap<>();

            for (int i = 0; i < ids.size(); i += 2) {
                String lhs = ids.get(i).getText();
                String rhs = ids.get(i + 1).getText();
                result.put(lhs, rhs);
            }

            return result;
        }

        @Override
        public Map<String, String> visitAttr_list(@NotNull dotParser.Attr_listContext ctx) {
            Map<String, String> result = new HashMap<>();

            for (dotParser.A_listContext a_list : ctx.a_list()) {
                result.putAll(visit(a_list));
            }

            return result;
        }
    }

    private StringDotVisitor _stringVisitor = new StringDotVisitor();
    private AttributesDotVisitor _stringListVisitor = new AttributesDotVisitor();
    private DotGraph _graph = new DotGraph();

    @Override
    public DotGraph visitGraph(@NotNull dotParser.GraphContext ctx) {
        _graph.strict = ctx.STRICT() != null;
        _graph.bidirectional = ctx.directed.getType() == dotLexer.DIGRAPH;
        _graph.name = ctx.id().getText();
        return visit(ctx.stmt_list());
    }

    @Override
    public DotGraph visitEdge_stmt(@NotNull dotParser.Edge_stmtContext ctx) {
        String lhs_id = _stringVisitor.visit(ctx.lhs);
        String rhs_id = _stringVisitor.visit(ctx.rhs);
        Map<String, String> attributes = _stringListVisitor.visit(ctx.attributes);

        List<DotGraph.Edge> edgeList = _graph.nodes.get(lhs_id);
        if (edgeList == null) {
            _graph.nodes.put(lhs_id, new ArrayList<DotGraph.Edge>());
            edgeList = _graph.nodes.get(lhs_id);
        }
        DotGraph.Edge edge = new DotGraph.Edge();
        edge.destination = rhs_id;
        edge.attributes.putAll(attributes);
        edge.directed = ctx.op.getType() == dotLexer.DIEDGE_OP;
        edgeList.add(edge);

        return _graph;
    }

    @Override
    public DotGraph visitStmt_list(@NotNull dotParser.Stmt_listContext ctx) {
        List<dotParser.StmtContext> stmts = ctx.stmt();
        for (dotParser.StmtContext stmt : stmts) {
            visit(stmt);
        }
        return _graph;
    }

    public static void main(String[] args) throws IOException {
        String inputFile = "dot_dfa_examples/fsm.gv";
        if ( args.length>0 ) inputFile = args[0];
        InputStream is = System.in;
        if ( inputFile!=null ) is = new FileInputStream(inputFile);
        ANTLRInputStream input = new ANTLRInputStream(is);
        dotLexer lexer = new dotLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        dotParser parser = new dotParser(tokens);
        ParseTree tree = parser.graph(); // parse

        MyDotVisitor eval = new MyDotVisitor();
        DotGraph graph = eval.visit(tree);
        System.out.println(graph);
    }
}
