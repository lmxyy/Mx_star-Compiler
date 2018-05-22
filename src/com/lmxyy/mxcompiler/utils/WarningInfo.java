package com.lmxyy.mxcompiler.utils;

import java.util.ArrayList;
import java.util.List;

public class WarningInfo {
    static public List<String> msgs = new ArrayList<>();
    static public void add(Location location,String msg) {
        assert location != null;
        msgs.add("Location: "+location+"\n"+"Warning: "+msg);
    }
    static public void add(String msg) {
        msgs.add("Warning: "+msg);
    }

    static public void uselessStatement(Location location) { add(location,"This is a useless statement."); }
}
