
package org.compiler;

import org.compiler.parser.CLangBaseVisitor;
import org.compiler.parser.CLangParser;

import java.util.ArrayList;
import java.util.List;

public class TACGenerator extends CLangBaseVisitor<Void> { // or <String> if you want to return a value

    private List<TACInstruction> tacInstructions = new ArrayList<>();
    private int tempVariableCounter = 0;

    // Helper method to generate unique temporary variable names
    private String generateTempVariable() {
        return "temp" + tempVariableCounter++;
    }

    public List<TACInstruction> getTacInstructions() {
        return tacInstructions;
    }

    // Override visitor methods for the nodes you want to process

    @Override
    public Void visitExpression(CLangParser.ExpressionContext ctx) {
        if (ctx.primary().size() > 1){
            String left = visitPrimaryAndGetResult(ctx.primary(0));
            for (int i = 0; i < ctx.operator().size(); i++) {
                String op = ctx.operator(i).getText();
                String right = visitPrimaryAndGetResult(ctx.primary(i + 1));
                String temp = generateTempVariable();
                tacInstructions.add(new TACInstruction(op, left, right, temp));
                left = temp;
            }
            return null;
        }
        return visitChildren(ctx);
    }

    private String visitPrimaryAndGetResult(CLangParser.PrimaryContext ctx) {
        if (ctx.IDENTIFIER() != null) {
            return ctx.IDENTIFIER().getText();
        } else if (ctx.CONSTANT() != null) {
            return ctx.CONSTANT().getText();
        } else {
            // Handle other primary types or nested expressions if needed
            return null;
        }
    }

    @Override
    public Void visitDeclarationStatement(CLangParser.DeclarationStatementContext ctx) {
        String variableName = ctx.IDENTIFIER().getText();
        if (ctx.expression() != null) {
            String expressionResult = visitExpressionAndGetResult(ctx.expression());
            tacInstructions.add(new TACInstruction("=", expressionResult, null, variableName));
        }
        return null;
    }

    private String visitExpressionAndGetResult(CLangParser.ExpressionContext ctx) {
        //This method is similar to visitExpression but returns the result
        if (ctx.primary().size() > 1) {
            String left = visitPrimaryAndGetResult(ctx.primary(0));
            for (int i = 0; i < ctx.operator().size(); i++) {
                String op = ctx.operator(i).getText();
                String right = visitPrimaryAndGetResult(ctx.primary(i + 1));
                String temp = generateTempVariable();
                tacInstructions.add(new TACInstruction(op, left, right, temp));
                left = temp;
            }
            return left;
        } else {
            return visitPrimaryAndGetResult(ctx.primary(0));
        }
    }


    @Override
    public Void visitReturnStatement(CLangParser.ReturnStatementContext ctx) {
        if (ctx.expression() != null) {
            String expressionResult = visitExpressionAndGetResult(ctx.expression());
            tacInstructions.add(new TACInstruction("return", expressionResult, null, null));
        } else {
            tacInstructions.add(new TACInstruction("return", null, null, null));
        }
        return null;
    }

    @Override
    public Void visitIfStatement(CLangParser.IfStatementContext ctx) {
        String labelTrue = generateLabel();
        String labelFalse = generateLabel();
        String labelEnd = (ctx.statement(1) != null) ? generateLabel() : labelFalse; // Label after 'else' block, if present

        String conditionResult = visitComparisonExpressionAndGetResult(ctx.comparisonExpression());
        tacInstructions.add(new TACInstruction("(ifTrueGoToThisLabel)", conditionResult, null, labelTrue));
        tacInstructions.add(new TACInstruction("goto", null, null, labelFalse));

        tacInstructions.add(new TACInstruction("(ifTrueLabel):", labelTrue, null, null));
        visit(ctx.statement(0)); // Visit 'then' block

        if (ctx.statement(1) != null) {
            tacInstructions.add(new TACInstruction("goto", null, null, labelEnd)); // Jump over 'else' block
            tacInstructions.add(new TACInstruction("(ifFalseLabel):", labelFalse, null, null));
            visit(ctx.statement(1)); // Visit 'else' block
            tacInstructions.add(new TACInstruction("(ifLoopEndsLabel):", labelEnd, null, null));
        } else {
            tacInstructions.add(new TACInstruction("(ifFalseLabel):", labelFalse, null, null));
        }
        return null;
    }


    private String visitComparisonExpressionAndGetResult(CLangParser.ComparisonExpressionContext ctx) {
        String left = visitExpressionAndGetResult(ctx.expression(0));
        String right = visitExpressionAndGetResult(ctx.expression(1));
        String op = ctx.comparisonOperator().getText();
        String temp = generateTempVariable();
        tacInstructions.add(new TACInstruction(op, left, right, temp));
        return temp;
    }

    private int labelCounter = 0;
    private String generateLabel() {
        return "label" + labelCounter++;
    }

    @Override
    public Void visitWhileStatement(CLangParser.WhileStatementContext ctx) {
        String labelStart = generateLabel();
        String labelTrue = generateLabel();
        String labelFalse = generateLabel();

        tacInstructions.add(new TACInstruction("(StartingLoopLabel):", labelStart, null, null));

        String conditionResult = visitComparisonExpressionAndGetResult(ctx.comparisonExpression());
        tacInstructions.add(new TACInstruction("(ifTrueGoToThisLabel)", conditionResult, null, labelTrue));
        tacInstructions.add(new TACInstruction("goto", null, null, labelFalse));

        tacInstructions.add(new TACInstruction("(ifTrueLabel):", labelTrue, null, null));
        visit(ctx.block()); // Visit loop body
        tacInstructions.add(new TACInstruction("goto", null, null, labelStart)); // Jump back to the beginning

        tacInstructions.add(new TACInstruction("(ifFalseLabel):", labelFalse, null, null));
        return null;
    }

    @Override
    public Void visitForStatement(CLangParser.ForStatementContext ctx) {
        String labelStart = generateLabel();
        String labelTrue = generateLabel();
        String labelFalse = generateLabel();

        // Initialize
        visit(ctx.forInit());

        tacInstructions.add(new TACInstruction("(StartingLoopLabel):", labelStart, null, null));

        // Condition
        if (ctx.comparisonExpression() != null) {
            String conditionResult = visitComparisonExpressionAndGetResult(ctx.comparisonExpression());
            tacInstructions.add(new TACInstruction("(ifTrueGoToThisLabel)", conditionResult, null, labelTrue));
            tacInstructions.add(new TACInstruction("goto", null, null, labelFalse));
        } else {
            // No condition, always true
            tacInstructions.add(new TACInstruction("goto", null, null, labelTrue));
        }

        tacInstructions.add(new TACInstruction("(ifTrueLabel):", labelTrue, null, null));
        visit(ctx.block()); // Loop body

        // Update
        if (ctx.forUpdate() != null) {
            visit(ctx.forUpdate());
        }
        tacInstructions.add(new TACInstruction("goto", null, null, labelStart));

        tacInstructions.add(new TACInstruction("(ifFalseLabel):", labelFalse, null, null));
        return null;
    }

    @Override
    public Void visitForInit(CLangParser.ForInitContext ctx) {
        String variableName = ctx.IDENTIFIER().getText();
        String expressionResult = visitExpressionAndGetResult(ctx.expression());
        tacInstructions.add(new TACInstruction("=", expressionResult, null, variableName));
        return null;
    }

    @Override
    public Void visitForUpdate(CLangParser.ForUpdateContext ctx) {
        String variableName = ctx.IDENTIFIER().getText();
        String op = ctx.getChild(1).getText(); // Get "++" or "--"
        if (op.equals("++")) {
            tacInstructions.add(new TACInstruction("+", variableName, "1", variableName));
        } else if (op.equals("--")) {
            tacInstructions.add(new TACInstruction("-", variableName, "1", variableName));
        }
        return null;
    }

}
