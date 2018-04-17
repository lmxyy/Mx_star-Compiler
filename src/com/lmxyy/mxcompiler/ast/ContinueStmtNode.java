package com.lmxyy.mxcompiler.ast;

public class ContinueStmtNode extends StmtNode {
    private Location location;

    public void setLocation(Location _location) {
        location = _location;
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
