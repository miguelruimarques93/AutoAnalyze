// Generated from dot.g4 by ANTLR 4.1
package dot;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link dotParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface dotVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link dotParser#attr_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttr_stmt(@NotNull dotParser.Attr_stmtContext ctx);

	/**
	 * Visit a parse tree produced by {@link dotParser#port}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPort(@NotNull dotParser.PortContext ctx);

	/**
	 * Visit a parse tree produced by {@link dotParser#edgeop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEdgeop(@NotNull dotParser.EdgeopContext ctx);

	/**
	 * Visit a parse tree produced by {@link dotParser#stmt_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt_list(@NotNull dotParser.Stmt_listContext ctx);

	/**
	 * Visit a parse tree produced by {@link dotParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(@NotNull dotParser.StmtContext ctx);

	/**
	 * Visit a parse tree produced by {@link dotParser#edgeRHS}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEdgeRHS(@NotNull dotParser.EdgeRHSContext ctx);

	/**
	 * Visit a parse tree produced by {@link dotParser#compass_pt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompass_pt(@NotNull dotParser.Compass_ptContext ctx);

	/**
	 * Visit a parse tree produced by {@link dotParser#node_id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNode_id(@NotNull dotParser.Node_idContext ctx);

	/**
	 * Visit a parse tree produced by {@link dotParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(@NotNull dotParser.IdContext ctx);

	/**
	 * Visit a parse tree produced by {@link dotParser#subgraph}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubgraph(@NotNull dotParser.SubgraphContext ctx);

	/**
	 * Visit a parse tree produced by {@link dotParser#graph}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGraph(@NotNull dotParser.GraphContext ctx);

	/**
	 * Visit a parse tree produced by {@link dotParser#a_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitA_list(@NotNull dotParser.A_listContext ctx);

	/**
	 * Visit a parse tree produced by {@link dotParser#attr_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttr_list(@NotNull dotParser.Attr_listContext ctx);

	/**
	 * Visit a parse tree produced by {@link dotParser#edge_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEdge_stmt(@NotNull dotParser.Edge_stmtContext ctx);

	/**
	 * Visit a parse tree produced by {@link dotParser#node_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNode_stmt(@NotNull dotParser.Node_stmtContext ctx);
}