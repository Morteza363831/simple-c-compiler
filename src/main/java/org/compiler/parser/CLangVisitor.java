// Generated from /home/morteza-mahdi-zadeh/Documents/compiler/src/main/java/org/compiler/org/compiler/CLang.g4 by ANTLR 4.13.2
package org.compiler.parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CLangParser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(CLangParser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link CLangParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(CLangParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CLangParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(CLangParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link CLangParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(CLangParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link CLangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(CLangParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(CLangParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CLangParser#declarationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationStatement(CLangParser.DeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CLangParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(CLangParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CLangParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(CLangParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(CLangParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CLangParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(CLangParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link CLangParser#typeSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeSpecifier(CLangParser.TypeSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CLangParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(CLangParser.OperatorContext ctx);
}