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
    private final static FunctionType stringLength = new FunctionType(
            intType,
            "string.length",
            new ArrayList<>(),
            new ArrayList<>()
    );
    private final static FunctionType stringSubString = new FunctionType(
            stringType,
            "string.substring",
            new ArrayList<>() {{
                add(intType);
                add(intType);
            }},
            new ArrayList<>() {{
                add("arg0");
                add("arg1");
            }}
    );
    private final static FunctionType stringParseInt = new FunctionType(
            intType,
            "string.parseInt",
            new ArrayList<>(),
            new ArrayList<>()
    );
    private final static FunctionType stringOrd = new FunctionType(
            intType,
            "string.ord",
            new ArrayList<>() {{
                add(intType);
            }},
            new ArrayList<>() {{
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
    private final static FunctionType arraySize = new FunctionType(
            intType,
            "array.size",
            new ArrayList<>(),
            new ArrayList<>()
    );
    private final static Map<String,FunctionType> arrayBuiltinMethods  = Collections.unmodifiableMap(
            new HashMap<String,FunctionType>() {{
                put("size",arraySize);
            }}
    );

    // Builtin functions
    private final static FunctionType funcPrint = new FunctionType(
            voidType,
            "print",
            new ArrayList<>() {{
                add(stringType);
            }},
            new ArrayList<>() {{
                add("arg0");
            }}
    );
    private final static FunctionType funcPrintln = new FunctionType(
            voidType,
            "println",
            new ArrayList<>() {{
                add(stringType);
            }},
            new ArrayList<>() {{
                add("arg0");
            }}
    );
    private final static FunctionType funcGetString = new FunctionType(
            stringType,
            "getString",
            new ArrayList<>(),
            new ArrayList<>()
    );
    private final static FunctionType funcGetInt = new FunctionType(
            intType,
            "getInt",
            new ArrayList<>(),
            new ArrayList<>()
    );
    private final static FunctionType funcToString = new FunctionType(
            stringType,
            "toString",
            new ArrayList<>() {{
                add(intType);
            }},
            new ArrayList<>() {{
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
            new HashSet<>() {{
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

    private Map<String, VartypeNode> typeMap = new LinkedHashMap<>();
    private Map<String, FunctionType> constructorMap = new LinkedHashMap<>();

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
        constructorMap.put(name,type);
    }
    public FunctionType resolveConstructor(String name) {
        return constructorMap.get(name);
    }
}
