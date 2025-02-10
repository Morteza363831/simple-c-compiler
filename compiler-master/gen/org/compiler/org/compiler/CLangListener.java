// Generated from /home/morteza-mahdi-zadeh/Documents/compiler/src/main/java/org/compiler/org/compiler/CLang.g4 by ANTLR 4.13.2
package org.compiler.org.compiler;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CLangParser}.
 */
public interface CLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CLangParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(CLangParser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLangParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(CLangParser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLangParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(CLangParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLangParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(CLangParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLangParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(CLangParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLangParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(CLangParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLangParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(CLangParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLangParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(CLangParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLangParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(CLangParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLangParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(CLangParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(CLangParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(CLangParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLangParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(CLangParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLangParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(CLangParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLangParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(CLangParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLangParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(CLangParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(CLangParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(CLangParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLangParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(CLangParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLangParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(CLangParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLangParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeSpecifier(CLangParser.TypeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLangParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeSpecifier(CLangParser.TypeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLangParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(CLangParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLangParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(CLangParser.OperatorContext ctx);
}