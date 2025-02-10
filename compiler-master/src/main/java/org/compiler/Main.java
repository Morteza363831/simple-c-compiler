package org.compiler;


import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.compiler.parser.CLangParser;
import org.compiler.lexer.CLangLexer;

import java.io.*;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

        CLangLexer lexer = new CLangLexer( new ANTLRFileStream("src/main/resources/input.c"));
        CommonTokenStream tokens = new CommonTokenStream( lexer );
        CLangParser parser = new CLangParser( tokens );
        ParseTree tree = parser.compilationUnit();
        ParseTreeWalker walker = new ParseTreeWalker();
        SemanticAnalyzer analyzer = new SemanticAnalyzer();
        walker.walk( analyzer , tree );

        //System.out.println(tree.getText());
        /*for (Token t : tokens.getTokens()) {
            System.out.println(t);
        }*/
        //System.out.println(tree.toStringTree(parser));
        //System.out.println(tokens.getTokens().get(1));

        // TAC Generation
        TACGenerator tacGenerator = new TACGenerator();
        tacGenerator.visit(tree);  // Traverse the AST and generate TAC

        List<TACInstruction> tacInstructions = tacGenerator.getTacInstructions();

        // Print the TAC code
        System.out.println("TAC Code:");
        for (TACInstruction instruction : tacInstructions) {
            System.out.println(instruction);
        }
    }
}
