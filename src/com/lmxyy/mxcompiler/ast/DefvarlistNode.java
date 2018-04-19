package com.lmxyy.mxcompiler.ast;

import java.util.List;

public class DefvarlistNode extends DefNode {
    private List<DefvarNode> vars;

    public DefvarlistNode(List<DefvarNode> _vars) {
        vars = _vars;
    }

    public List<DefvarNode> getVars() {
        return vars;
    }

    @Override
    public Location location() {
        return vars.get(0).location();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
