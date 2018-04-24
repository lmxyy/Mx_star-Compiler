package com.lmxyy.mxcompiler.symbol;

import java.util.List;

public class FunctionType extends TypeBase {
    private Type returnType;
    private String name;
    private List<Type> argTypes;
    private List<String> argNames;

    public FunctionType(Type _returnType,String _name,List<Type> _argTypes,List<String> _argNames) {
        returnType = _returnType;
        name = _name;
        argTypes = _argTypes;
        argNames = _argNames;
    }

    public Type getReturnType() {
        return returnType;
    }
    public String getName() {
        return name;
    }
    public List<Type> getArgTypes() {
        return argTypes;
    }
    public List<String> getArgNames() {
        return argNames;
    }
}
