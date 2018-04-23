package com.lmxyy.mxcompiler.compiler;

import com.lmxyy.mxcompiler.ast.ProgNode;
import com.lmxyy.mxcompiler.frontend.ASTBuilder;
import com.lmxyy.mxcompiler.parser.Mx_starLexer;
import com.lmxyy.mxcompiler.parser.Mx_starParser;
import com.lmxyy.mxcompiler.parser.SyntaxErrorListener;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.InputStream;
import java.io.OutputStream;

public class Compiler {
    private InputStream inS;
    private OutputStream outS;
    private ProgNode ast;

    public Compiler(InputStream _inS,OutputStream _outS) {
        inS = _inS;
        outS = _outS;
    }

    private void buildAST() throws Exception {
        CharStream input = CharStreams.fromStream(inS);
        Mx_starLexer lexer = new Mx_starLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Mx_starParser parser = new Mx_starParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new SyntaxErrorListener());
        try {
            ParseTree tree = parser.prog();
            ASTBuilder builder = new ASTBuilder();
            ast = (ProgNode) builder.visit(tree);
        } catch (Error error) {
            throw error;
        }
    }

    public void run() throws Exception {
        System.out.println("Compiling...");
        buildAST();
        System.out.println("Compiled");
    }
}
