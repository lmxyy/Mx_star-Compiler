package com.lmxyy.mxcompiler.ast;

import com.lmxyy.mxcompiler.symbol.Type;
import com.lmxyy.mxcompiler.utils.Location;

import java.util.List;

public class VartypePlusNode extends Node {
    private Type type;
    private String name;
    private List<ExpressionNode> dims;
    private Location location;

    public VartypePlusNode(Type _type,String _name,List<ExpressionNode> _dims) {
        type = _type;
        name = _name;
        dims = _dims;
    }
    public void setLocation(Location _location) {
        location = _location;
    }

    public Type getType() {
        return type;
    }
    public String getName() {
        return name;
    }
    public List<ExpressionNode> getDims() {
        return dims;
    }

    public VartypeNode toVartypeNode() {
        return new VartypeNode(type,name);
    }
    public int getRegisterSize() {
        return toVartypeNode().getRegisterSize();
    }

    @Override
    public Location location() { return location; }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
