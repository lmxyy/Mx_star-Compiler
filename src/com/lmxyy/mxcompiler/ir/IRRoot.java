package com.lmxyy.mxcompiler.ir;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class IRRoot {
    public Map<String,Function> functions = new LinkedHashMap<>();
    public List<StaticData> dataList = new ArrayList<>();
    public Map<String,StaticString> stringPool = new LinkedHashMap<>();

    public IRRoot() {
        stringPool.put("\\n",new StaticString("\n"));
    }

    public Function stringSubString;
    public Function stringParseInt;

    public Function funcPrintln;
    public Function funcPrint;
    public Function funcPrintlnInt;
    public Function funcPrintInt;
    public Function funcGetString;
    public Function funcGetInt;
    public Function funcToString;
}
