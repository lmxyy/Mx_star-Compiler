package com.lmxyy.mxcompiler.symbol;

import com.lmxyy.mxcompiler.ast.VartypeNode;

public class SymbolInfo {
    private VartypeNode type;

    public SymbolInfo(VartypeNode _type) {
        type = _type;
    }

    public VartypeNode getType() {
        return type;
    }
}
