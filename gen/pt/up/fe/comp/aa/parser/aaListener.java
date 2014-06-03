// Generated from aa.g4 by ANTLR 4.1


package pt.up.fe.comp.aa.parser;


import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link aaParser}.
 */
public interface aaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link aaParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(@NotNull aaParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link aaParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(@NotNull aaParser.ArgContext ctx);

	/**
	 * Enter a parse tree produced by {@link aaParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterOperation(@NotNull aaParser.OperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link aaParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitOperation(@NotNull aaParser.OperationContext ctx);

	/**
	 * Enter a parse tree produced by {@link aaParser#attribution_rhs}.
	 * @param ctx the parse tree
	 */
	void enterAttribution_rhs(@NotNull aaParser.Attribution_rhsContext ctx);
	/**
	 * Exit a parse tree produced by {@link aaParser#attribution_rhs}.
	 * @param ctx the parse tree
	 */
	void exitAttribution_rhs(@NotNull aaParser.Attribution_rhsContext ctx);

	/**
	 * Enter a parse tree produced by {@link aaParser#arg_list}.
	 * @param ctx the parse tree
	 */
	void enterArg_list(@NotNull aaParser.Arg_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link aaParser#arg_list}.
	 * @param ctx the parse tree
	 */
	void exitArg_list(@NotNull aaParser.Arg_listContext ctx);

	/**
	 * Enter a parse tree produced by {@link aaParser#attribution_lhs}.
	 * @param ctx the parse tree
	 */
	void enterAttribution_lhs(@NotNull aaParser.Attribution_lhsContext ctx);
	/**
	 * Exit a parse tree produced by {@link aaParser#attribution_lhs}.
	 * @param ctx the parse tree
	 */
	void exitAttribution_lhs(@NotNull aaParser.Attribution_lhsContext ctx);

	/**
	 * Enter a parse tree produced by {@link aaParser#stmt_list}.
	 * @param ctx the parse tree
	 */
	void enterStmt_list(@NotNull aaParser.Stmt_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link aaParser#stmt_list}.
	 * @param ctx the parse tree
	 */
	void exitStmt_list(@NotNull aaParser.Stmt_listContext ctx);

	/**
	 * Enter a parse tree produced by {@link aaParser#control_expr}.
	 * @param ctx the parse tree
	 */
	void enterControl_expr(@NotNull aaParser.Control_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link aaParser#control_expr}.
	 * @param ctx the parse tree
	 */
	void exitControl_expr(@NotNull aaParser.Control_exprContext ctx);

	/**
	 * Enter a parse tree produced by {@link aaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(@NotNull aaParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link aaParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(@NotNull aaParser.StmtContext ctx);

	/**
	 * Enter a parse tree produced by {@link aaParser#attribution}.
	 * @param ctx the parse tree
	 */
	void enterAttribution(@NotNull aaParser.AttributionContext ctx);
	/**
	 * Exit a parse tree produced by {@link aaParser#attribution}.
	 * @param ctx the parse tree
	 */
	void exitAttribution(@NotNull aaParser.AttributionContext ctx);
}