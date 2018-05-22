package com.lmxyy.mxcompiler.symbol;

import com.lmxyy.mxcompiler.ast.VartypeNode;
import com.lmxyy.mxcompiler.ir.Register;

public class SymbolInfo {
    private VartypeNode type;
    public Register register;

    public SymbolInfo(VartypeNode _type) {
        type = _type;
    }

    public VartypeNode getType() {
        return type;
    }
}
