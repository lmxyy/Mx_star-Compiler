package com.lmxyy.mxcompiler.ir;

import com.lmxyy.mxcompiler.symbol.FunctionType;

import java.util.ArrayList;
import java.util.List;

public class Function {
    FunctionType type;
    public BasicBlock startBasicBlock = null,exitBasicBlock = null;
    public List<VirtualRegister> argVarRegList = new ArrayList<>();
    public List<ReturnInstruction> retInstruction = new ArrayList<>();

    public Function(FunctionType _type) {
        type = _type;
        startBasicBlock = new BasicBlock(this,"$"+type.getName()+".entry");
    }

    public FunctionType getType() {
        return type;
    }
    public String getName() {
        if (type == null) return null;
        else return type.getName();
    }

    @Override
    public String toString() {
        return getName();
    }

    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
