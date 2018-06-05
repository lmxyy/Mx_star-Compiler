package com.lmxyy.mxcompiler.compiler;

import com.lmxyy.mxcompiler.ast.ProgNode;
import com.lmxyy.mxcompiler.backend.*;
import com.lmxyy.mxcompiler.frontend.ASTBuilder;
import com.lmxyy.mxcompiler.frontend.IRBuilder;
import com.lmxyy.mxcompiler.frontend.IRPrebuilder;
import com.lmxyy.mxcompiler.frontend.SemanticChecker;
import com.lmxyy.mxcompiler.ir.IRRoot;
import com.lmxyy.mxcompiler.nasm.*;
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
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Compiler {
    private InputStream inS;
    private OutputStream outS;
    private ProgNode ast;
    private GlobalSymbolTable globalSymbolTable;
    private IRRoot irRoot;

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
        globalSymbolTable = new GlobalSymbolTable();
        SemanticChecker semanticChecker = new SemanticChecker(globalSymbolTable);
        semanticChecker.visit(ast);
        if (!semanticChecker.semanticError.msgs.isEmpty())
            ret = false;
        return ret;
    }

    private void buildIR() throws Exception {
        irRoot = new IRRoot();
        IRPrebuilder irPrebuilder = new IRPrebuilder(globalSymbolTable,irRoot);
        ast.accept(irPrebuilder);
        IRBuilder irBuilder = new IRBuilder(globalSymbolTable,irRoot);

        irBuilder.visit(ast);
        String irInfoPath = "/Users/limuyang/Desktop/Mx_star-Compiler/ir.txt";
        IRPrinter irPrinter = new IRPrinter(new PrintStream(irInfoPath));
        irPrinter.visit(irRoot);
        new IRTransformer(irRoot).run();
        new GlobalVariableResolver(irRoot).run();
        new RegisterInjector(irRoot).run();
        new GraphColoringAllocator(irRoot,NASMRegisterSet.general,NASMRegisterSet.R10,NASMRegisterSet.R11).run();
        new NASMIRTransformer(irRoot).run();
        String asmInfoPath = "/Users/limuyang/Desktop/Mx_star-Compiler/program.asm";
        NASMPrinter nasmPrinter = new NASMPrinter(new PrintStream(asmInfoPath));
//        NASMPrinter nasmPrinter = new NASMPrinter(new PrintStream(System.out));

        nasmPrinter.visit(irRoot);
        new NASMPrinter(System.err).visit(irRoot);
    }

    public boolean run() throws Exception{
        SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss",Locale.US);
        System.err.println("Compilation started at "+formatter.format(new java.util.Date()));
        boolean ret = buildAST();
        if (ret == false) {
            return false;
        }
        buildIR();
        return true;
    }
}
