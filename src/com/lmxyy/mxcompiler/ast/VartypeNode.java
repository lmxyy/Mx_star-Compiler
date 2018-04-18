package com.lmxyy.mxcompiler.ast;
import com.lmxyy.mxcompiler.symbol.Type;

public class VartypeNode extends Node{
    private Type type;
    String name;
    private Location location;

    public VartypeNode(Type _type,String _name) {
        type = _type;
        name = _name;
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

    @Override
    public Location location() { return location; }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
