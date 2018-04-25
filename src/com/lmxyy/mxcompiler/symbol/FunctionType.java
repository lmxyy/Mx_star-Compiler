package com.lmxyy.mxcompiler.symbol;

import com.lmxyy.mxcompiler.ast.VartypeNode;

import java.util.List;

public class FunctionType extends VartypeNode{
    private String name;
    private List<VartypeNode> argTypes;
    private List<String> argNames;

    public FunctionType(VartypeNode _returnType,String _name,List<VartypeNode> _argTypes,List<String> _argNames) {
        super(_returnType);
        name = _name;
        argTypes = _argTypes;
        argNames = _argNames;
    }

    public VartypeNode getReturnType() {
        return new VartypeNode(super.getType(),super.getName());
    }
    public String getName() {
        return name;
    }
    public List<VartypeNode> getArgTypes() {
        return argTypes;
    }
    public List<String> getArgNames() {
        return argNames;
    }
}
