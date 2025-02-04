package org.compiler;

import org.compiler.parser.CLangBaseListener;
import org.compiler.parser.CLangParser;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SemanticAnalyzer extends CLangBaseListener {

    // Symbol Table Stack for block scoping
    private final Stack<Map<String, String>> symbolTableStack = new Stack<>();

    @Override
    public void enterBlock(CLangParser.BlockContext ctx) {
        // Push a new scope when entering a block
        symbolTableStack.push(new HashMap<>());
    }

    @Override
    public void exitBlock(CLangParser.BlockContext ctx) {
        // Pop the scope when exiting a block
        symbolTableStack.pop();
    }

    @Override
    public void enterDeclarationStatement(CLangParser.DeclarationStatementContext ctx) {
        String variable;
        String type = null;
        boolean flag = false;

        // Handle variable declarations with optional type specifier
        if (ctx.typeSpecifier() != null) {
            type = ctx.typeSpecifier().getText();
            variable = ctx.IDENTIFIER().getText();
        } else {
            variable = ctx.IDENTIFIER().getText();
            type = lookupType(variable);
            flag = true;
            if (type == null) {
                System.err.println("Error: Variable '" + variable + "' is not declared.");
                return;
            }
        }

        // Check for duplicate declarations in the current scope
        if (symbolTableStack.peek().containsKey(variable) && !flag) {
            System.err.println("Error: Variable '" + variable + "' already declared in this scope.");
        } else {
            symbolTableStack.peek().put(variable, type);
        }

        // Type check for assignments during declarations
        if (ctx.expression() != null) {
            String exprType = evaluateExpression(ctx.expression());
            flag = false;
            if (type.equals("float") && exprType.equals("int")) {
                flag = true;
            }
            if (!type.equals(exprType) && !flag) {
                System.err.println("Error: Type mismatch for variable '" + variable + "'. Expected: " + type +
                        ", Found: " + exprType);
            }
        }
    }

    @Override
    public void enterExpressionStatement(CLangParser.ExpressionStatementContext ctx) {
        // Handle standalone expressions such as assignments
        if (ctx.expression() != null) {
            evaluateExpression(ctx.expression());
        }
    }

    private String evaluateExpression(CLangParser.ExpressionContext ctx) {
        if (ctx.primary().size() == 1) {
            return evaluatePrimary(ctx.primary(0));
        } else {
            String leftType = evaluatePrimary(ctx.primary(0));
            String rightType = evaluatePrimary(ctx.primary(1));

            if (!leftType.equals(rightType)) {
                System.err.println("Error: Type mismatch in expression. Found: " + leftType + " and " + rightType);
            }
            return leftType;
        }
    }

    private String evaluatePrimary(CLangParser.PrimaryContext ctx) {
        if (ctx.IDENTIFIER() != null) {
            String varName = ctx.IDENTIFIER().getText();
            return isDeclared(varName) ? lookupType(varName) : "error";
        } else if (ctx.CONSTANT() != null) {
            if (ctx.CONSTANT().getText().contains(".")) {

                if (ctx.CONSTANT().getText().substring(ctx.CONSTANT().getText().lastIndexOf(".") + 1).length() > 8) {
                    System.err.println("Error: Not a float number : " + ctx.CONSTANT().getText());
                }
                return "float";
            }
            return "int";
        } else if (ctx.STRING_LITERAL() != null) {
            return "string";
        } else if (ctx.CHAR_LITERAL() != null) {
            return "char";
        }
        return "unknown";
    }

    private boolean isDeclared(String variable) {
        for (Map<String, String> scope : symbolTableStack) {
            if (scope.containsKey(variable)) {
                return true;
            }
        }
        return false;
    }

    private String lookupType(String variable) {
        for (Map<String, String> scope : symbolTableStack) {
            if (scope.containsKey(variable)) {
                //System.out.println("lookupType variable: " + variable + " type: " + scope.get(variable) );
                return scope.get(variable);
            }
        }
        return null;
    }
}
