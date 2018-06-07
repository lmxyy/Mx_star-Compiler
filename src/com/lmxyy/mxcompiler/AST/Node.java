package com.lmxyy.mxcompiler.ast;

import com.lmxyy.mxcompiler.ir.IntValue;
import com.lmxyy.mxcompiler.ir.VirtualRegister;
import com.lmxyy.mxcompiler.symbol.SymbolTable;
import com.lmxyy.mxcompiler.utils.Location;

import java.util.HashSet;
import java.util.Set;

public abstract class Node {
    public SymbolTable scope;
    public Set<IntValue> usedIntValue = new HashSet();

    public boolean canSkip() {
        if (usedIntValue.isEmpty()) return false;
        for (IntValue vr:usedIntValue) {
            if (vr.important&&vr instanceof VirtualRegister) return false;
        }
        return true;
    }

    public Node() {}
    abstract public Location location();
    abstract public void accept(ASTVisitor visitor);
}
