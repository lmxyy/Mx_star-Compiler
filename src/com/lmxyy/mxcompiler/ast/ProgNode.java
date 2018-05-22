package com.lmxyy.mxcompiler.ast;

import com.lmxyy.mxcompiler.utils.Location;

import java.util.List;

public class ProgNode extends Node {
    private List<DefNode> defs;
    public ProgNode(List<DefNode> _defs) {
        defs = _defs;
    }

    public List<DefNode> getDefs() {
        return defs;
    }

    @Override
    public Location location() {
        if (defs.isEmpty()) return null;
        else return defs.get(0).location();
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
