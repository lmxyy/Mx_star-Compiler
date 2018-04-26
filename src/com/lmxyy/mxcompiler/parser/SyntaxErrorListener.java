package com.lmxyy.mxcompiler.parser;

import com.lmxyy.mxcompiler.utils.Location;
import com.lmxyy.mxcompiler.utils.SyntaxError;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class SyntaxErrorListener extends BaseErrorListener {
    public SyntaxError syntaxError = new SyntaxError();
    @Override
    public void syntaxError(Recognizer<?,?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg,RecognitionException e) {
        syntaxError.add(new Location(line,charPositionInLine),msg);
    }
}
