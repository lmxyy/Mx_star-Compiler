package com.lmxyy.mxcompiler.ast;

public class IntegerliteralNode extends TermNode {
    private int val;
    private Location location;

    public IntegerliteralNode(int _val) {
        val = _val;
    }
    public void setLocation(Location _location) {
        location = _location;
    }

    public int getVal() {
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
