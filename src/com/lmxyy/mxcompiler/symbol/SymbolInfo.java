package com.lmxyy.mxcompiler.symbol;

import com.lmxyy.mxcompiler.ast.VartypeNode;
import com.lmxyy.mxcompiler.ir.Register;
import com.lmxyy.mxcompiler.ir.VirtualRegister;

public class SymbolInfo {
    private VartypeNode type;
    private boolean isClassGlobal = false;
    public Register register;
    public boolean used;

    public SymbolInfo(VartypeNode _type,boolean _isClassGlobal) {
        isClassGlobal = _isClassGlobal;
    }

    public VartypeNode getType() {
        return type;
    }
}
