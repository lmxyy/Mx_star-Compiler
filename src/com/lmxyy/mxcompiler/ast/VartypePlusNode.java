package com.lmxyy.mxcompiler.ast;

import com.lmxyy.mxcompiler.symbol.Type;
import java.util.List;

public class VartypePlusNode extends Node {
    private Type type;
    private String name;
    private List<Integer> dims;
    private Location location;

    public VartypePlusNode(Type _type,String _name,List<Integer> _dims) {
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
    public List<Integer> getDims() {
        return dims;
    }

    @Override
    public Location location() { return location; }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
