package org.compiler.config;


import com.fasterxml.jackson.core.StreamWriteConstraints;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.compiler.parser.CLangParser;
import org.compiler.lexer.CLangLexer;
import org.compiler.semantic.SemanticAnalyzer;
import org.compiler.tac.TacGenerator;
import org.compiler.tac.TacInstruction;

import java.io.*;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        CLangLexer lexer = new CLangLexer( new ANTLRFileStream("src/main/resources/input.c"));
        CommonTokenStream tokens = new CommonTokenStream( lexer );

        CLangParser parser = new CLangParser( tokens );

        ParseTree tree = parser.compilationUnit();

        ParseTreeWalker walker = new ParseTreeWalker();

        SemanticAnalyzer analyzer = new SemanticAnalyzer();
        walker.walk( analyzer , tree );

        TacGenerator tacGenerator = new TacGenerator();
        if (!analyzer.hasError()) {
            tacGenerator.visit(tree);  // Traverse the AST and generate TAC
        }


        String tacJson = objectMapper.writeValueAsString(tacGenerator.getTacInstructions());
        File tacFile = new File("src/main/resources/tac.json");

        if (tacFile.exists()) {
            tacFile.delete();
        }
        if (tacFile.createNewFile()) {
            FileWriter writer = new FileWriter(tacFile);
            writer.write(tacJson);
            writer.close();
        }


        System.out.println("FINISHED");
    }
}
