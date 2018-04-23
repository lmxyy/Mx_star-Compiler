package com.lmxyy.mxcompiler.parser;

import com.lmxyy.mxcompiler.ast.Location;
import com.lmxyy.mxcompiler.utils.SyntaxError;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class SyntaxErrorListener extends BaseErrorListener {
    @Override
    public void syntaxError(Recognizer<?,?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg,RecognitionException e) {
        throw new SyntaxError(new Location(line,charPositionInLine),msg);
    }
}
