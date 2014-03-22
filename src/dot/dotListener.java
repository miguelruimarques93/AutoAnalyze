// Generated from dot.g4 by ANTLR 4.1
package dot;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link dotParser}.
 */
public interface dotListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link dotParser#attr_stmt}.
	 * @param ctx the parse tree
	 */
	void enterAttr_stmt(@NotNull dotParser.Attr_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link dotParser#attr_stmt}.
	 * @param ctx the parse tree
	 */
	void exitAttr_stmt(@NotNull dotParser.Attr_stmtContext ctx);

	/**
	 * Enter a parse tree produced by {@link dotParser#port}.
	 * @param ctx the parse tree
	 */
	void enterPort(@NotNull dotParser.PortContext ctx);
	/**
	 * Exit a parse tree produced by {@link dotParser#port}.
	 * @param ctx the parse tree
	 */
	void exitPort(@NotNull dotParser.PortContext ctx);

	/**
	 * Enter a parse tree produced by {@link dotParser#edgeop}.
	 * @param ctx the parse tree
	 */
	void enterEdgeop(@NotNull dotParser.EdgeopContext ctx);
	/**
	 * Exit a parse tree produced by {@link dotParser#edgeop}.
	 * @param ctx the parse tree
	 */
	void exitEdgeop(@NotNull dotParser.EdgeopContext ctx);

	/**
	 * Enter a parse tree produced by {@link dotParser#stmt_list}.
	 * @param ctx the parse tree
	 */
	void enterStmt_list(@NotNull dotParser.Stmt_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link dotParser#stmt_list}.
	 * @param ctx the parse tree
	 */
	void exitStmt_list(@NotNull dotParser.Stmt_listContext ctx);

	/**
	 * Enter a parse tree produced by {@link dotParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(@NotNull dotParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link dotParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(@NotNull dotParser.StmtContext ctx);

	/**
	 * Enter a parse tree produced by {@link dotParser#edgeRHS}.
	 * @param ctx the parse tree
	 */
	void enterEdgeRHS(@NotNull dotParser.EdgeRHSContext ctx);
	/**
	 * Exit a parse tree produced by {@link dotParser#edgeRHS}.
	 * @param ctx the parse tree
	 */
	void exitEdgeRHS(@NotNull dotParser.EdgeRHSContext ctx);

	/**
	 * Enter a parse tree produced by {@link dotParser#compass_pt}.
	 * @param ctx the parse tree
	 */
	void enterCompass_pt(@NotNull dotParser.Compass_ptContext ctx);
	/**
	 * Exit a parse tree produced by {@link dotParser#compass_pt}.
	 * @param ctx the parse tree
	 */
	void exitCompass_pt(@NotNull dotParser.Compass_ptContext ctx);

	/**
	 * Enter a parse tree produced by {@link dotParser#node_id}.
	 * @param ctx the parse tree
	 */
	void enterNode_id(@NotNull dotParser.Node_idContext ctx);
	/**
	 * Exit a parse tree produced by {@link dotParser#node_id}.
	 * @param ctx the parse tree
	 */
	void exitNode_id(@NotNull dotParser.Node_idContext ctx);

	/**
	 * Enter a parse tree produced by {@link dotParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(@NotNull dotParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link dotParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(@NotNull dotParser.IdContext ctx);

	/**
	 * Enter a parse tree produced by {@link dotParser#subgraph}.
	 * @param ctx the parse tree
	 */
	void enterSubgraph(@NotNull dotParser.SubgraphContext ctx);
	/**
	 * Exit a parse tree produced by {@link dotParser#subgraph}.
	 * @param ctx the parse tree
	 */
	void exitSubgraph(@NotNull dotParser.SubgraphContext ctx);

	/**
	 * Enter a parse tree produced by {@link dotParser#graph}.
	 * @param ctx the parse tree
	 */
	void enterGraph(@NotNull dotParser.GraphContext ctx);
	/**
	 * Exit a parse tree produced by {@link dotParser#graph}.
	 * @param ctx the parse tree
	 */
	void exitGraph(@NotNull dotParser.GraphContext ctx);

	/**
	 * Enter a parse tree produced by {@link dotParser#a_list}.
	 * @param ctx the parse tree
	 */
	void enterA_list(@NotNull dotParser.A_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link dotParser#a_list}.
	 * @param ctx the parse tree
	 */
	void exitA_list(@NotNull dotParser.A_listContext ctx);

	/**
	 * Enter a parse tree produced by {@link dotParser#attr_list}.
	 * @param ctx the parse tree
	 */
	void enterAttr_list(@NotNull dotParser.Attr_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link dotParser#attr_list}.
	 * @param ctx the parse tree
	 */
	void exitAttr_list(@NotNull dotParser.Attr_listContext ctx);

	/**
	 * Enter a parse tree produced by {@link dotParser#edge_stmt}.
	 * @param ctx the parse tree
	 */
	void enterEdge_stmt(@NotNull dotParser.Edge_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link dotParser#edge_stmt}.
	 * @param ctx the parse tree
	 */
	void exitEdge_stmt(@NotNull dotParser.Edge_stmtContext ctx);

	/**
	 * Enter a parse tree produced by {@link dotParser#node_stmt}.
	 * @param ctx the parse tree
	 */
	void enterNode_stmt(@NotNull dotParser.Node_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link dotParser#node_stmt}.
	 * @param ctx the parse tree
	 */
	void exitNode_stmt(@NotNull dotParser.Node_stmtContext ctx);
}