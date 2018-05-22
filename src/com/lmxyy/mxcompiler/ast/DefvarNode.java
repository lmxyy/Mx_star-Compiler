package com.lmxyy.mxcompiler.ast;

import com.lmxyy.mxcompiler.utils.Location;

public class DefvarNode extends DefNode {
    private VartypeNode type;
    private String name;
    private ExpressionNode init;
    private boolean ommit;

    public DefvarNode(VartypeNode _type,String _name,ExpressionNode _init) {
        type = _type;
        name = _name;
        init = _init;
        ommit = false;
    }

    public VartypeNode getType() {
        return type;
    }
    public String getName() {
        return name;
    }
    public ExpressionNode getInit() {
        return init;
    }
    public void setOmmit() {
        ommit = true;
    }

    public boolean isOmmit() {
        return ommit;
    }

    @Override
    public Location location() {
        return type.location();
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
