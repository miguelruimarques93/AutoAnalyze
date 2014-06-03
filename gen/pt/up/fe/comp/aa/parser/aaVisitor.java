// Generated from aa.g4 by ANTLR 4.1


package pt.up.fe.comp.aa.parser;


import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link aaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface aaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link aaParser#arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg(@NotNull aaParser.ArgContext ctx);

	/**
	 * Visit a parse tree produced by {@link aaParser#operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperation(@NotNull aaParser.OperationContext ctx);

	/**
	 * Visit a parse tree produced by {@link aaParser#attribution_rhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribution_rhs(@NotNull aaParser.Attribution_rhsContext ctx);

	/**
	 * Visit a parse tree produced by {@link aaParser#arg_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg_list(@NotNull aaParser.Arg_listContext ctx);

	/**
	 * Visit a parse tree produced by {@link aaParser#attribution_lhs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribution_lhs(@NotNull aaParser.Attribution_lhsContext ctx);

	/**
	 * Visit a parse tree produced by {@link aaParser#stmt_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt_list(@NotNull aaParser.Stmt_listContext ctx);

	/**
	 * Visit a parse tree produced by {@link aaParser#control_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControl_expr(@NotNull aaParser.Control_exprContext ctx);

	/**
	 * Visit a parse tree produced by {@link aaParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(@NotNull aaParser.StmtContext ctx);

	/**
	 * Visit a parse tree produced by {@link aaParser#attribution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribution(@NotNull aaParser.AttributionContext ctx);
}