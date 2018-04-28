package com.lmxyy.mxcompiler.compiler;

import com.lmxyy.mxcompiler.ast.ProgNode;
import com.lmxyy.mxcompiler.frontend.ASTBuilder;
import com.lmxyy.mxcompiler.frontend.SemanticChecker;
import com.lmxyy.mxcompiler.parser.Mx_starLexer;
import com.lmxyy.mxcompiler.parser.Mx_starParser;
import com.lmxyy.mxcompiler.parser.SyntaxErrorListener;
import com.lmxyy.mxcompiler.symbol.GlobalSymbolTable;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Compiler {
    private InputStream inS;
    private OutputStream outS;
    private ProgNode ast;

    public Compiler(InputStream _inS,OutputStream _outS) {
        inS = _inS;
        outS = _outS;
    }

    private boolean buildAST() throws Exception{
        boolean ret = true;
        CharStream input = CharStreams.fromStream(inS);
        Mx_starLexer lexer = new Mx_starLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Mx_starParser parser = new Mx_starParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new SyntaxErrorListener());
        ParseTree tree = parser.prog();
        if (!(((SyntaxErrorListener)parser.getErrorListeners().get(0)).syntaxError.msgs.isEmpty()))
            ret = false;
        ASTBuilder builder = new ASTBuilder();
        ast = (ProgNode) builder.visit(tree);
        SemanticChecker semanticChecker = new SemanticChecker(new GlobalSymbolTable());
        semanticChecker.visit(ast);
        if (!semanticChecker.semanticError.msgs.isEmpty())
            ret = false;
        return ret;
    }

    public boolean run() throws Exception{
        SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss",Locale.US);
        System.err.println("Compilation started at "+formatter.format(new java.util.Date()));
        boolean ret = buildAST();
        return ret;
    }
}
