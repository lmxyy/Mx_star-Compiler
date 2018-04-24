package com.lmxyy.mxcompiler.symbol;

public class SymbolInfo {
    private TypeBase type;

    public SymbolInfo(TypeBase _type) {
        type = _type;
    }

    public TypeBase getType() {
        return type;
    }
}
