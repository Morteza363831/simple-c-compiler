package org.compiler;


import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.compiler.parser.CLangBaseListener;
import org.compiler.parser.CLangParser;
import org.compiler.lexer.CLangLexer;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        CLangLexer lexer = new CLangLexer( new ANTLRFileStream("src/main/resource/input.txt"));
        CommonTokenStream tokens = new CommonTokenStream( lexer );
        CLangParser parser = new CLangParser( tokens );
        ParseTree tree = parser.compilationUnit();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk( new CLangBaseListener(), tree );

        System.out.println(tree.getText());
        for (Token t : tokens.getTokens()) {
            System.out.println(t);
        }
        System.out.println(tree.toStringTree(parser));
        //System.out.println(tokens.getTokens().get(1));
    }
}
