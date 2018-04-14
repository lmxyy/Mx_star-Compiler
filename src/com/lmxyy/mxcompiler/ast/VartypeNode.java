package com.lmxyy.mxcompiler.ast;
import com.lmxyy.mxcompiler.symbol.Type;

public class VartypeNode extends Node{
    private Type type;
    private Location location;

    public VartypeNode(Type _type) {
        type = _type;
    }
    public void setLocation(Location _location) {
        location = _location;
    }

    public Type getType() {
        return type;
    }
    
    @Override
    public Location location() { return location; }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
