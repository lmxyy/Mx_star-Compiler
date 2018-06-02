package com.lmxyy.mxcompiler.ast;

import com.lmxyy.mxcompiler.symbol.SymbolInfo;
import com.lmxyy.mxcompiler.utils.Location;

public class IdentifierNode extends ExprNode {
    private String name;
    private Location location;
    private SymbolInfo info = null;

    public IdentifierNode(String _name) {
        name = _name;
    }
    public void setLocation(Location _location) {
        location = _location;
    }
    public SymbolInfo getInfo() {
        return info;
    }
    public void setInfo(SymbolInfo _info) {
        info = _info;
    }

    public String getName() {
        return name;
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
