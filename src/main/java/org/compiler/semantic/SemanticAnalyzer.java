package org.compiler.semantic;

import org.compiler.parser.CLangBaseListener;
import org.compiler.parser.CLangParser;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SemanticAnalyzer extends CLangBaseListener {

    // Symbol Table Stack for block scoping
    private final Stack<Map<String, String>> symbolTableStack = new Stack<>();
    private boolean error = false;

    @Override
    public void enterFunctionDeclaration(CLangParser.FunctionDeclarationContext ctx) {
        String functionName = ctx.IDENTIFIER().getText();
        String functionReturnType = ctx.typeSpecifier().getText();

        if (symbolTableStack.isEmpty()) {
            symbolTableStack.push(new HashMap<>());
        } else {
            // Check if the function is already declared
            if (symbolTableStack.peek().containsKey(functionName)) {
                System.err.println("Error: Function '" + functionName + "' already declared.");
                error = true;
            }
        }

        symbolTableStack.peek().put(functionName, functionReturnType);
    }

    @Override
    public void exitFunctionDeclaration(CLangParser.FunctionDeclarationContext ctx) {
        String functionName = ctx.IDENTIFIER().getText();
        String functionReturnType = ctx.typeSpecifier().getText();
        boolean hasMatchingReturnType = false;

        for (CLangParser.StatementContext statementCtx : ctx.block().statement()) {
            if (statementCtx.returnStatement() != null) {
                String returnType = evaluateExpression(statementCtx.returnStatement().expression());
                if (!functionReturnType.equals(returnType)) {
                    System.err.println("Error: Type mismatch in function '" + functionName + "'. Expected return type: " +
                            functionReturnType + ", found: " + returnType);
                    error = true;
                } else {
                    hasMatchingReturnType = true;
                }
            }
        }

        if (!functionReturnType.equals("void") && !hasMatchingReturnType) {
            System.err.println("Error: Missing return statement with matching type in function '" + functionName + "'.");
            error = true;
        }

        // Pop the function-level symbol table after completing function validation
        symbolTableStack.pop();
    }

    @Override
    public void enterBlock(CLangParser.BlockContext ctx) {
        // Use the same function scope if inside a function, but add a map only for nested block scoping
        //symbolTableStack.push(new HashMap<>());
    }

    @Override
    public void exitBlock(CLangParser.BlockContext ctx) {
        //symbolTableStack.pop();
    }



    private void putFunction(String functionName, String functionReturnType, CLangParser.StatementContext x) {
        if (functionReturnType.equals("void") && x.returnStatement() != null) {
            System.err.println("Error: type mismatch in 'function'. function type : " + functionReturnType +  ", return type : void");
            error = true;
        }
        symbolTableStack.peek().put(functionName, functionReturnType);
    }

    @Override
    public void enterIfStatement(CLangParser.IfStatementContext ctx) {
        if (ctx.comparisonExpression() != null) {
            String leftConditionType = evaluateExpression(ctx.comparisonExpression().expression(0));
            String rightConditionType = evaluateExpression(ctx.comparisonExpression().expression(1));
            if (!leftConditionType.equals(rightConditionType)) {
                System.err.println("Error: Comparison expression types in 'if' does not match. left type : " + leftConditionType + ", right type : " + rightConditionType);
                error = true;
            }
        }
    }

    @Override
    public void enterWhileStatement(CLangParser.WhileStatementContext ctx) {
        if (ctx.comparisonExpression() != null) {
            String leftConditionType = evaluateExpression(ctx.comparisonExpression().expression(0));
            String rightConditionType = evaluateExpression(ctx.comparisonExpression().expression(1));
            if (!leftConditionType.equals(rightConditionType)) {
                System.err.println("Error: Comparison expression types in 'while' does not match. left type : " + leftConditionType + ", right type : " + rightConditionType);
                error = true;
            }
        }
    }

    @Override
    public void enterForStatement(CLangParser.ForStatementContext ctx) {
        // Validate the initialization statement
        if (ctx.forInit() != null) {
            putVariable(ctx.forInit().IDENTIFIER().getText(), ctx.forInit().typeSpecifier().getText(), false, ctx.forInit().expression());
        }

        // Validate the condition
        if (ctx.comparisonExpression() != null) {
            String leftConditionType = evaluateExpression(ctx.comparisonExpression().expression(0));
            String rightConditionType = evaluateExpression(ctx.comparisonExpression().expression(1));
            if (!leftConditionType.equals(rightConditionType)) {
                System.err.println("Error: Comparison expression types in 'for' does not match. left type : " + leftConditionType + ", right type : " + rightConditionType);
                error = true;
            }
        }

        // Validate the update expression
        if (ctx.forUpdate() != null) {
            String variable = ctx.forUpdate().IDENTIFIER().getText();
            if (!isDeclared(variable)) {
                System.err.println("Error: Variable '" + variable + "' not declared before update.");
                error = true;
            }
        }
    }

    @Override
    public void exitForStatement(CLangParser.ForStatementContext ctx) {
        symbolTableStack.peek().remove(ctx.forInit().IDENTIFIER().getText());
    }

    @Override
    public void enterDeclarationStatement(CLangParser.DeclarationStatementContext ctx) {
        String variable;
        String type = null;
        boolean flag = false;

        if (ctx.typeSpecifier() != null) {
            type = ctx.typeSpecifier().getText();
            variable = ctx.IDENTIFIER().getText();
        } else {
            variable = ctx.IDENTIFIER().getText();
            type = lookupType(variable);
            flag = true;
            if (type == null) {
                System.err.println("Error: Variable '" + variable + "' is not declared.");
                error = true;
                return;
            }
        }

        putVariable(variable, type, flag, ctx.expression());
    }

    private void putVariable(String variable, String type, boolean flag, CLangParser.ExpressionContext expression) {
        if (symbolTableStack.peek().containsKey(variable) && !flag) {
            System.err.println("Error: Variable '" + variable + "' already declared in this scope.");
            error = true;
        } else {
            symbolTableStack.peek().put(variable, type);
        }

        if (expression != null) {
            String exprType = evaluateExpression(expression);
            flag = false;
            if (type.equals("float") && exprType.equals("int")) {
                flag = true;
            }
            if (!type.equals(exprType) && !flag) {
                System.err.println("Error: Type mismatch for variable '" + variable + "'. Expected: " + type +
                        ", Found: " + exprType);
                error = true;
            }
        }
    }

    /*@Override
    public void enterForInit(CLangParser.ForInitContext ctx) {
        String variable;
        String type = null;
        boolean flag = false;

        if (ctx.typeSpecifier() != null) {
            type = ctx.typeSpecifier().getText();
            variable = ctx.IDENTIFIER().getText();
        } else {
            variable = ctx.IDENTIFIER().getText();
            type = lookupType(variable);
            flag = true;
            if (type == null) {
                System.err.println("Error: Variable '" + variable + "' is not declared.");
                error = true;
                return;
            }
        }
        System.out.println(symbolTableStack.peek().get(variable));
        putVariable(variable, type, flag, ctx.expression());
    }*/

    @Override
    public void exitForInit(CLangParser.ForInitContext ctx) {
        symbolTableStack.peek().remove(ctx.IDENTIFIER().getText());
    }


    @Override
    public void enterExpressionStatement(CLangParser.ExpressionStatementContext ctx) {
        if (ctx.expression() != null) {
            evaluateExpression(ctx.expression());
        }
    }

    private String evaluateExpression(CLangParser.ExpressionContext ctx) {
        if (ctx.primary().size() == 1) {
            if (ctx.primary().get(0).IDENTIFIER() != null) {
                return evaluatePrimary(ctx.primary().get(0));
            }
            return evaluatePrimary(ctx.primary(0));
        } else {
            String leftType = evaluatePrimary(ctx.primary(0));
            String rightType = evaluatePrimary(ctx.primary(1));

            if (!leftType.equals(rightType)) {
                System.err.println("Error: Type mismatch in expression. Found: " + leftType + " and " + rightType);
                error = true;
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
                    System.err.println("Error: Not a float number: " + ctx.CONSTANT().getText());
                    error = true;
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
                return scope.get(variable);
            }
        }
        return null;
    }

    public boolean hasError() {
        return error;
    }
}
