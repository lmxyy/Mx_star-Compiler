package com.lmxyy.mxcompiler.ast;
import com.lmxyy.mxcompiler.symbol.Type;

public class VartypeNode extends Node {
    private Type type;
    private String name;
    private Location location;

    public VartypeNode(Type _type,String _name) {
        type = _type;
        name = _name;
    }
    public VartypeNode(VartypeNode other) {
        type = other.getType();
        name = other.getName();
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

    public boolean isBool() {
        return type.getType() == Type.Types.BOOL&&type.getDimension() == 0;
    }
    public boolean isInt() {
        return type.getType() == Type.Types.INT&&type.getDimension() == 0;
    }
    public boolean isString() {
        return type.getType() == Type.Types.STRING&&type.getDimension() == 0;
    }
    public boolean isNull() {
        return type.getType() == Type.Types.NULL&&type.getDimension() == 0;
    }
    public boolean isClass() { return type.getType() == Type.Types.CLASS&&type.getDimension() == 0; }
    public boolean isUB() { return type.getType() == Type.Types.UB; }

    @Override
    public Location location() { return location; }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
