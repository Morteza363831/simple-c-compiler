// Generated from /home/morteza-mahdi-zadeh/Documents/compiler/src/main/java/org/compiler/antlr/CLang.g4 by ANTLR 4.13.2
package org.compiler.parser;
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
	 * Enter a parse tree produced by {@link CLangParser#declarationStatement}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationStatement(CLangParser.DeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLangParser#declarationStatement}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationStatement(CLangParser.DeclarationStatementContext ctx);
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
	 * Enter a parse tree produced by {@link CLangParser#printfStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintfStatement(CLangParser.PrintfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLangParser#printfStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintfStatement(CLangParser.PrintfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLangParser#printfExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrintfExpression(CLangParser.PrintfExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLangParser#printfExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrintfExpression(CLangParser.PrintfExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLangParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(CLangParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLangParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(CLangParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLangParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(CLangParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLangParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(CLangParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLangParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(CLangParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLangParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(CLangParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLangParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(CLangParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLangParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(CLangParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLangParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void enterForUpdate(CLangParser.ForUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLangParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void exitForUpdate(CLangParser.ForUpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link CLangParser#comparisonExpression}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpression(CLangParser.ComparisonExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLangParser#comparisonExpression}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpression(CLangParser.ComparisonExpressionContext ctx);
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
	 * Enter a parse tree produced by {@link CLangParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void enterComparisonOperator(CLangParser.ComparisonOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CLangParser#comparisonOperator}.
	 * @param ctx the parse tree
	 */
	void exitComparisonOperator(CLangParser.ComparisonOperatorContext ctx);
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