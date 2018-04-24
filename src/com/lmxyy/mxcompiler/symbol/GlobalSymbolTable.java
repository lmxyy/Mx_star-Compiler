package com.lmxyy.mxcompiler.symbol;

import java.util.*;

public class GlobalSymbolTable {
    // Builtin Types
    /*public final static Type intType = new Type(Type.Types.INT,false,0);
    public final static Type boolType = new Type(Type.Types.BOOL,false,0);
    public final static Type voidType = new Type(Type.Types.VOID,false,0);
    public final static Type nullType = new Type(Type.Types.NULL,false,0);
    public final static Type stringType = new Type(Type.Types.STRING,false,0);
*/
    // Builtin string functions
    public final static FunctionType stringLength = new FunctionType(
            new Type(Type.Types.INT,true,0),
            "string.length",
            new ArrayList<>(),
            new ArrayList<>()
    );
    public final static FunctionType stringSubString = new FunctionType(
            new Type(Type.Types.STRING,true,0),
            "string.substring",
            new ArrayList<>() {{
                add(new Type(Type.Types.INT,false,0));
                add(new Type(Type.Types.INT,false,0));
            }},
            new ArrayList<>() {{
                add("arg0");
                add("arg1");
            }}
    );
    public final static FunctionType stringParseInt = new FunctionType(
            new Type(Type.Types.INT,true,0),
            "string.parseInt",
            new ArrayList<>(),
            new ArrayList<>()
    );
    public final static FunctionType stringOrd = new FunctionType(
            new Type(Type.Types.INT,true,0),
            "string.ord",
            new ArrayList<>() {{
                add(new Type(Type.Types.INT,false,0));
            }},
            new ArrayList<>() {{
                add("arg0");
            }}
    );
    public final static Map<String,FunctionType> stringBuiltinMethods  = Collections.unmodifiableMap(
            new HashMap<String,FunctionType>() {{
                put("length",stringLength);
                put("substring",stringSubString);
                put("parseInt",stringParseInt);
                put("ord",stringOrd);
            }}
    );

    // Builtin array functions
    public final static FunctionType arraySize = new FunctionType(
            new Type(Type.Types.INT,true,0),
            "array.size",
            new ArrayList<>(),
            new ArrayList<>()
    );
    public final static Map<String,FunctionType> arrayBuiltinMethods  = Collections.unmodifiableMap(
            new HashMap<String,FunctionType>() {{
                put("size",arraySize);
            }}
    );

    // Builtin functions
    public final static FunctionType funcPrint = new FunctionType(
            new Type(Type.Types.VOID,true,0),
            "print",
            new ArrayList<>() {{
                add(new Type(Type.Types.STRING,false,0));
            }},
            new ArrayList<>() {{
                add("arg0");
            }}
    );
    public final static FunctionType funcPrintln = new FunctionType(
            new Type(Type.Types.VOID,true,0),
            "println",
            new ArrayList<>() {{
                add(new Type(Type.Types.STRING,false,0));
            }},
            new ArrayList<>() {{
                add("arg0");
            }}
    );
    public final static FunctionType funcGetString = new FunctionType(
            new Type(Type.Types.STRING,true,0),
            "getString",
            new ArrayList<>(),
            new ArrayList<>()
    );
    public final static FunctionType funcGetInt = new FunctionType(
            new Type(Type.Types.INT,true,0),
            "getInt",
            new ArrayList<>(),
            new ArrayList<>()
    );
    public final static FunctionType funcToString = new FunctionType(
            new Type(Type.Types.STRING,true,0),
            "toString",
            new ArrayList<>() {{
                add(new Type(Type.Types.INT,false,0));
            }},
            new ArrayList<>() {{
                add("arg0");
            }}
    );
    public final static Map<String,FunctionType> builtinMethods  = Collections.unmodifiableMap(
            new HashMap<String,FunctionType>() {{
                put(funcPrint.getName(),funcPrint);
                put(funcPrintln.getName(),funcPrintln);
                put(funcGetString.getName(),funcGetString);
                put(funcGetInt.getName(),funcGetInt);
                put(funcToString.getName(),funcToString);
            }}
    );
}
