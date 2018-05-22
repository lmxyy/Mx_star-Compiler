package com.lmxyy.mxcompiler.ast;

import com.lmxyy.mxcompiler.utils.Location;

import java.util.List;

public class BlockNode extends StmtNode {
    private List<Node> stmts;
    private Location location;

    public BlockNode(List<Node> _stmts) {
        stmts = _stmts;
    }
    public void setLocation(Location _location) {
        location = _location;
    }

    public List<Node> getStmts() {
        return stmts;
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
