package com.lmxyy.mxcompiler.ast;

import com.lmxyy.mxcompiler.utils.Location;

public class IdentifierNode extends ExprNode {
    private String name;
    Location location;
    public IdentifierNode(String _name) {
        name = _name;
    }
    public void setLocation(Location _location) {
        location = _location;
    }

    public String getName() {
        return name;
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
