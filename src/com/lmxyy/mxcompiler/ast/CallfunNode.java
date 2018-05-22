package com.lmxyy.mxcompiler.ast;

import com.lmxyy.mxcompiler.utils.Location;

import java.util.List;

public class CallfunNode extends ExprNode {
    private String name;
    private List<ExpressionNode> params;
    private Location location;
    public CallfunNode(String _name,List<ExpressionNode> _params) {
        name = _name;
        params = _params;
    }

    public void setLocation(Location _location) {
        location = _location;
    }

    public String getName() {
        return name;
    }
    public List<ExpressionNode> getParams() {
        return params;
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
