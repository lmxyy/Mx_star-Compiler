package com.lmxyy.mxcompiler.ast;

public class BooleanliteralNode extends ExprNode {
    private boolean val;
    private Location location;

    public BooleanliteralNode(boolean _val) {
        val = _val;
    }
    public void setLocation(Location _location) {
        location = _location;
    }

    public boolean getVal() {
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
