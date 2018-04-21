package com.lmxyy.mxcompiler.ast;

public class IntegerliteralNode extends TermNode {
    private Integer val;
    private Location location;

    public IntegerliteralNode(Integer _val) {
        val = _val;
    }
    public void setLocation(Location _location) {
        location = _location;
    }

    public Integer getVal() {
        return val;
    }

    @Override
    public Location location() {
        return location;
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
