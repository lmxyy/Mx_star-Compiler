package com.lmxyy.mxcompiler.ast;

import java.util.List;

public class VariableNode extends TermNode {
    private VariableNode base;
    private IdentifierNode name;
    private List<ExpressionNode> dim;

    public VariableNode(VariableNode _base,IdentifierNode _name,List<ExpressionNode> _dim) {
        base = _base;
        name = _name;
        dim = _dim;
    }

    public VariableNode getBase() {
        return base;
    }
    public IdentifierNode getName() {
        return name;
    }
    public List<ExpressionNode> getDim() {
        return dim;
    }

    @Override
    public Location location() {
        if (base != null) return base.location();
        else return name.location();
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
