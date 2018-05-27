package com.lmxyy.mxcompiler.symbol;

import com.lmxyy.mxcompiler.ast.VartypeNode;

import java.util.*;

public class GlobalSymbolTable {
    // Builtin Types
    public final static VartypeNode intType = new VartypeNode(new Type(Type.Types.INT,0),"int");
    public final static VartypeNode boolType = new VartypeNode(new Type(Type.Types.BOOL,0),"bool");
    public final static VartypeNode voidType = new VartypeNode(new Type(Type.Types.VOID,0),"void");
    public final static VartypeNode nullType = new VartypeNode(new Type(Type.Types.NULL,0),"null");
    public final static VartypeNode stringType = new VartypeNode(new Type(Type.Types.STRING,0),"string");
    public final static VartypeNode ubType = new VartypeNode(new Type(Type.Types.UB,0),"ub");

    // Builtin string functions
    public final static FunctionType stringLength = new FunctionType(
            intType,
            "string.length",
            new ArrayList<VartypeNode>(),
            new ArrayList<String>()
    );
    public final static FunctionType stringSubString = new FunctionType(
            stringType,
            "string.substring",
            new ArrayList<VartypeNode>() {{
                add(intType);
                add(intType);
            }},
            new ArrayList<String>() {{
                add("arg0");
                add("arg1");
            }}
    );
    public final static FunctionType stringParseInt = new FunctionType(
            intType,
            "string.parseInt",
            new ArrayList<VartypeNode>(),
            new ArrayList<String>()
    );
    public final static FunctionType stringOrd = new FunctionType(
            intType,
            "string.ord",
            new ArrayList<VartypeNode>() {{
                add(intType);
            }},
            new ArrayList<String>() {{
                add("arg0");
            }}
    );
    private final static Map<String,FunctionType> stringBuiltinMethods  = Collections.unmodifiableMap(
            new HashMap<String,FunctionType>() {{
                put("length",stringLength);
                put("substring",stringSubString);
                put("parseInt",stringParseInt);
                put("ord",stringOrd);
            }}
    );

    // Builtin array functions
    public final static FunctionType arraySize = new FunctionType(
            intType,
            "_array.size",
            new ArrayList<VartypeNode>(),
            new ArrayList<String>()
    );
    private final static Map<String,FunctionType> arrayBuiltinMethods  = Collections.unmodifiableMap(
            new HashMap<String,FunctionType>() {{
                put("size",arraySize);
            }}
    );

    // Builtin functions
    public final static FunctionType funcPrint = new FunctionType(
            voidType,
            "print",
            new ArrayList<VartypeNode>() {{
                add(stringType);
            }},
            new ArrayList<String>() {{
                add("arg0");
            }}
    );
    public final static FunctionType funcPrintln = new FunctionType(
            voidType,
            "println",
            new ArrayList<VartypeNode>() {{
                add(stringType);
            }},
            new ArrayList<String>() {{
                add("arg0");
            }}
    );
    public final static FunctionType funcGetString = new FunctionType(
            stringType,
            "getString",
            new ArrayList<VartypeNode>(),
            new ArrayList<String>()
    );
    public final static FunctionType funcGetInt = new FunctionType(
            intType,
            "getInt",
            new ArrayList<VartypeNode>(),
            new ArrayList<String>()
    );
    public final static FunctionType funcToString = new FunctionType(
            stringType,
            "toString",
            new ArrayList<VartypeNode>() {{
                add(intType);
            }},
            new ArrayList<String>() {{
                add("arg0");
            }}
    );
    private final static Map<String,FunctionType> builtinMethods  = Collections.unmodifiableMap(
            new HashMap<String,FunctionType>() {{
                put(funcPrint.getName(),funcPrint);
                put(funcPrintln.getName(),funcPrintln);
                put(funcGetString.getName(),funcGetString);
                put(funcGetInt.getName(),funcGetInt);
                put(funcToString.getName(),funcToString);
            }}
    );

    private final Set<FunctionType> builtinMethodSet = Collections.unmodifiableSet(
            new HashSet<FunctionType>() {{
                add(stringLength);
                add(stringSubString);
                add(stringParseInt);
                add(stringOrd);
                add(arraySize);
                add(funcPrint);
                add(funcPrintln);
                add(funcGetString);
                add(funcGetInt);
                add(funcToString);
            }}
    );

    public boolean isBuiltinMethod(FunctionType functionType) {
        return builtinMethodSet.contains(functionType);
    }

    private Map<String,VartypeNode> typeMap = new LinkedHashMap<>();
    private Map<String,FunctionType> constructorMap = new LinkedHashMap<>();

    public SymbolTable globals = SymbolTable.creatGlobalSymbalTable();

    public GlobalSymbolTable() {
        typeMap.put("void",voidType);
        typeMap.put("int",intType);
        typeMap.put("bool",boolType);
        typeMap.put("string",stringType);
        builtinMethodSet.forEach(method->globals.define(method.getName(),(VartypeNode) method));
    }

    public void defineType(String name,VartypeNode type) {
        typeMap.put(name,type);

    }

    public VartypeNode resolveType(String name) {
        return typeMap.get(name);
    }

    public void defineConstructor(String name,FunctionType type) {
        defineType(name+"."+name,type);
        constructorMap.put(name,type);
    }
    public FunctionType resolveConstructor(String name) {
        return constructorMap.get(name);
    }
}
