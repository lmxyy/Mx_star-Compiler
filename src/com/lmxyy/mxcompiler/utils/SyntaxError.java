package com.lmxyy.mxcompiler.utils;

import java.util.ArrayList;
import java.util.List;

public class SyntaxError extends Error {
    public List <String> msgs;


    public SyntaxError() {
        msgs = new ArrayList<>();
    }
    public void add(Location location,String msg) {
        assert location != null;
        System.err.println("Location: "+location+"\n"+"Syntax Error: "+msg);
        msgs.add("Location: "+location+"\n"+"Syntax Error: "+msg);
    }
}
