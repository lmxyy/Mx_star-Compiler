package com.lmxyy.mxcompiler.nasm;

import com.lmxyy.mxcompiler.ir.PhysicalRegister;

public class NASMRegister extends PhysicalRegister {
    private final int id;
    private final String name;
    private final boolean isGeneral;
    private final boolean isCallerSave;
    private final boolean isCalleeSave;

    public NASMRegister(int _id,String _name,boolean _isGeneral,boolean _isCallerSave,boolean _isCalleeSave) {
        id = _id;
        name = _name;
        isGeneral = _isGeneral;
        isCallerSave = _isCallerSave;
        isCalleeSave = _isCalleeSave;
    }
}
