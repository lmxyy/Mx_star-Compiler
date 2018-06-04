package com.lmxyy.mxcompiler.nasm;

import com.lmxyy.mxcompiler.ir.IRVisitor;
import com.lmxyy.mxcompiler.ir.PhysicalRegister;

public class NASMRegister extends PhysicalRegister {
    private final int id;
    private final String name;
    private final String name_8;
    private final boolean isGeneral;
    private final boolean isCallerSave;
    private final boolean isCalleeSave;
    private final boolean isFunArg;
    private boolean flag = false;

    public NASMRegister(int _id,String _name,String _name_8,boolean _isGeneral,boolean _isCallerSave,boolean _isCalleeSave) {
        id = _id;
        name = _name;
        name_8 = _name_8;
        isGeneral = _isGeneral;
        isCallerSave = _isCallerSave;
        isCalleeSave = _isCalleeSave;
        isFunArg = false;
    }
    public NASMRegister(int _id,String _name,String _name_8,boolean _isGeneral,boolean _isCallerSave,boolean _isCalleeSave,boolean _isFunArg) {
        id = _id;
        name = _name;
        name_8 = _name_8;
        isGeneral = _isGeneral;
        isCallerSave = _isCallerSave;
        isCalleeSave = _isCalleeSave;
        isFunArg = _isFunArg;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        if (!flag) return name;
        else return name_8;
    }

    public void setFlag(boolean _flag) {
        flag = _flag;
    }

    public boolean isGeneral() {
        return isGeneral;
    }

    public boolean isFunArg() {
        return isFunArg;
    }
    @Override
    public boolean isCallerSave() {
        return isCallerSave;
    }

    @Override
    public boolean isCalleeSave() {
        return isCalleeSave;
    }

    @Override
    public void accept(IRVisitor visitor) { visitor.visit(this); }
}
