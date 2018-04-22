package com.lmxyy.mxcompiler.frontend;

import com.lmxyy.mxcompiler.ast.Visitor;

import java.io.PrintStream;

// public class ASTPrinter implements Visitor {
public class ASTPrinter {
    private static final String IDENT = "    ";
    private StringBuilder builder = new StringBuilder();
    private PrintStream out;

    public ASTPrinter(PrintStream _out) {
        out = _out;
    }

    private void indent() {
        builder.append(IDENT);
    }
    private void unindent() {
        builder.delete(builder.length()-IDENT.length(),builder.length());
    }

    private String getStr() {
        return builder.toString();
    }
    private void print(String str) {
        out.print(getStr()+str);
    }
    private void println(String str) {
        out.println(getStr()+str);
    }

}
