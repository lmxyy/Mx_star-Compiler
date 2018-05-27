package com.lmxyy.mxcompiler.ir;

import com.lmxyy.mxcompiler.ast.VartypeNode;
import com.lmxyy.mxcompiler.symbol.FunctionType;
import com.lmxyy.mxcompiler.symbol.GlobalSymbolTable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class IRRoot {
    public Map<String,Function> functions = new LinkedHashMap<>();
    public List<StaticData> dataList = new ArrayList<>();
    public Map<String,StaticString> stringPool = new LinkedHashMap<>();

    public IRRoot() {
        stringPool.put("\\n",new StaticString("\\n"));
    }

    public Function stringSubString = new Function(GlobalSymbolTable.stringSubString);
    public Function stringParseInt = new Function(GlobalSymbolTable.stringParseInt);
    public Function stringConcat = new Function(new FunctionType(
            GlobalSymbolTable.stringType,
            "string.concat",
            new ArrayList<VartypeNode>() {{
                add(GlobalSymbolTable.stringType);
                add(GlobalSymbolTable.stringType);
            }},
            new ArrayList<String>() {{
                add("arg0");
                add("arg1");
            }})
    );
    public Function stringEqual = new Function(new FunctionType(
            GlobalSymbolTable.stringType,
            "string.equal",
            new ArrayList<VartypeNode>() {{
                add(GlobalSymbolTable.stringType);
                add(GlobalSymbolTable.stringType);
            }},
            new ArrayList<String>() {{
                add("arg0");
                add("arg1");
            }})
    );
    public Function stringLess = new Function(new FunctionType(
            GlobalSymbolTable.stringType,
            "string.less",
            new ArrayList<VartypeNode>() {{
                add(GlobalSymbolTable.stringType);
                add(GlobalSymbolTable.stringType);
            }},
            new ArrayList<String>() {{
                add("arg0");
                add("arg1");
            }})
    );
    public Function stringLeq= new Function(new FunctionType(
            GlobalSymbolTable.stringType,
            "string.leq",
            new ArrayList<VartypeNode>() {{
                add(GlobalSymbolTable.stringType);
                add(GlobalSymbolTable.stringType);
            }},
            new ArrayList<String>() {{
                add("arg0");
                add("arg1");
            }})
    );

    public Function funcPrintln = new Function(GlobalSymbolTable.funcPrintln);
    public Function funcPrint = new Function(GlobalSymbolTable.funcPrint);
    public Function funcPrintlnInt = new Function(new FunctionType(
            GlobalSymbolTable.voidType,
            "_printlnint",
            new ArrayList<VartypeNode>() {{
                add(GlobalSymbolTable.intType);
            }},
            new ArrayList<String>() {{
                add("arg0");
            }})
    );
    public Function funcPrintInt = new Function(new FunctionType(
            GlobalSymbolTable.voidType,
            "_printint",
            new ArrayList<VartypeNode>() {{
                add(GlobalSymbolTable.intType);
            }},
            new ArrayList<String>() {{
                add("arg0");
            }})
    );;
    public Function funcGetString = new Function(GlobalSymbolTable.funcGetString);
    public Function funcGetInt = new Function(GlobalSymbolTable.funcGetInt);
    public Function funcToString = new Function(GlobalSymbolTable.funcToString);

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
