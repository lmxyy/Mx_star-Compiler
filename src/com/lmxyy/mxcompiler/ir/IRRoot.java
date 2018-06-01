package com.lmxyy.mxcompiler.ir;

import com.lmxyy.mxcompiler.ast.VartypeNode;
import com.lmxyy.mxcompiler.nasm.NASMRegisterSet;
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
    public static List<Function> builtinFunctions = new ArrayList<>();

    public IRRoot() {
        builtinFunctions.add(stringSubString);
        builtinFunctions.add(stringParseInt);
        builtinFunctions.add(stringConcat);
        builtinFunctions.add(stringEqual);
        builtinFunctions.add(stringLess);
        builtinFunctions.add(stringLeq);

        builtinFunctions.add(funcPrintln);
        builtinFunctions.add(funcPrint);
        builtinFunctions.add(funcPrintlnInt);
        builtinFunctions.add(funcPrintInt);
        builtinFunctions.add(funcGetString);
        builtinFunctions.add(funcGetInt);
        builtinFunctions.add(funcToString);
        builtinFunctions.forEach(func->func.usedPhysicalGeneralRegister.addAll(NASMRegisterSet.all));
    }

    public static Function stringSubString = new Function(GlobalSymbolTable.stringSubString);
    public static Function stringParseInt = new Function(GlobalSymbolTable.stringParseInt);
    public static Function stringConcat = new Function(new FunctionType(
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
    public static Function stringEqual = new Function(new FunctionType(
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
    public static Function stringLess = new Function(new FunctionType(
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
    public static Function stringLeq= new Function(new FunctionType(
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
    /*public Function stringLength= new Function(new FunctionType(
            GlobalSymbolTable.stringType,
            "string.length",
            new ArrayList<VartypeNode>() {{
                add(GlobalSymbolTable.stringType);
            }},
            new ArrayList<String>() {{
                add("arg0");
            }})
    );*/

    public static Function funcPrintln = new Function(GlobalSymbolTable.funcPrintln);
    public static Function funcPrint = new Function(GlobalSymbolTable.funcPrint);
    public static Function funcPrintlnInt = new Function(new FunctionType(
            GlobalSymbolTable.voidType,
            "printlnint",
            new ArrayList<VartypeNode>() {{
                add(GlobalSymbolTable.intType);
            }},
            new ArrayList<String>() {{
                add("arg0");
            }})
    );
    public static Function funcPrintInt = new Function(new FunctionType(
            GlobalSymbolTable.voidType,
            "printint",
            new ArrayList<VartypeNode>() {{
                add(GlobalSymbolTable.intType);
            }},
            new ArrayList<String>() {{
                add("arg0");
            }})
    );;
    public static Function funcGetString = new Function(GlobalSymbolTable.funcGetString);
    public static Function funcGetInt = new Function(GlobalSymbolTable.funcGetInt);
    public static Function funcToString = new Function(GlobalSymbolTable.funcToString);

    public List<Function> getBuiltinFunctions() {
        return builtinFunctions;
    }

    public static boolean isBuiltinFunction(Function function) {
        return builtinFunctions.contains(function);
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
