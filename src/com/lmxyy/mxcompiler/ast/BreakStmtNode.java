package com.lmxyy.mxcompiler.ast;

import com.lmxyy.mxcompiler.utils.Location;

public class BreakStmtNode extends StmtNode {
    private Location location;

    public void setLocation(Location _location) {
        location = _location;
    }

    @Override
    public Location location() {
        return location;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
