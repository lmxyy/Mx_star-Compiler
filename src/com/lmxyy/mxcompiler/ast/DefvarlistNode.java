package com.lmxyy.mxcompiler.ast;

import com.lmxyy.mxcompiler.utils.Location;

import java.util.List;

public class DefvarlistNode extends DefNode {
    private List<DefvarNode> vars;
    private Location location;

    public DefvarlistNode(List<DefvarNode> _vars) {
        vars = _vars;
    }
    public void setLocation(Location _location) {
        location = _location;
    }

    public List<DefvarNode> getVars() {
        return vars;
    }

    @Override
    public Location location() {
        if (vars.isEmpty())
            return vars.get(0).location();
        else return location;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
