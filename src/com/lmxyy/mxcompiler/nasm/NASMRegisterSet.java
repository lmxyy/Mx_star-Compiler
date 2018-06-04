package com.lmxyy.mxcompiler.nasm;

import com.lmxyy.mxcompiler.ir.PhysicalRegister;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class NASMRegisterSet {
    /*
    R0  R1  R2  R3  R4  R5  R6  R7  R8  R9  R10  R11  R12  R13  R14  R15
    RAX RCX RDX RBX RSP RBP RSI RDI
     */
    public static NASMRegister RAX = new NASMRegister(0,"rax","al",false,true,false);
    public static NASMRegister RCX = new NASMRegister(0,"rcx","cl",false,true,false,true);
    public static NASMRegister RDX = new NASMRegister(0,"rdx","dl",false,true,false,true);
    public static NASMRegister RBX = new NASMRegister(0,"rbx","bl",false,false,true);
    public static NASMRegister RSP = new NASMRegister(0,"rsp","spl",false,true,false);
    public static NASMRegister RBP = new NASMRegister(0,"rbp","bpl",false,false,true);
    public static NASMRegister RSI = new NASMRegister(0,"rsi","sil",false,true,false,true);
    public static NASMRegister RDI = new NASMRegister(0,"rdi","dil",false,true,false,true);
    public static NASMRegister R8 = new NASMRegister(0,"r8","r8b",false,true,false,true);
    public static NASMRegister R9 = new NASMRegister(0,"r9","r9b",false,true,false,true);
    public static NASMRegister R10 = new NASMRegister(0,"r10","r10b",false,true,false);
    public static NASMRegister R11 = new NASMRegister(0,"r11","r11b",false,true,false);
    public static NASMRegister R12 = new NASMRegister(0,"r12","r12b",true,false,true);
    public static NASMRegister R13 = new NASMRegister(0,"r13","r13b",true,false,true);
    public static NASMRegister R14 = new NASMRegister(0,"r14","r14b",true,false,true);
    public static NASMRegister R15 = new NASMRegister(0,"r15","r15b",true,false,true);

    public static final Collection<PhysicalRegister> all;
    public static final Collection<PhysicalRegister> funArg;
    public static final Collection<PhysicalRegister> general;
    public static final Collection<PhysicalRegister> callerSave;
    public static final Collection<PhysicalRegister> calleeSave;


    static {
        Collection<NASMRegister> tmp_all        = new ArrayList<>();
        Collection<NASMRegister> tmp_general    = new ArrayList<>();
        Collection<NASMRegister> tmp_callerSave = new ArrayList<>();
        Collection<NASMRegister> tmp_calleeSave = new ArrayList<>();
        Collection<NASMRegister> tmp_funArg = new ArrayList<>();

        tmp_all.add(RAX);
        tmp_all.add(RCX);
        tmp_all.add(RDX);
        tmp_all.add(RBX);
        tmp_all.add(RSP);
        tmp_all.add(RBP);
        tmp_all.add(RSI);
        tmp_all.add(RDI);
        tmp_all.add(R8);
        tmp_all.add(R9);
        tmp_all.add(R10);
        tmp_all.add(R11);
        tmp_all.add(R12);
        tmp_all.add(R13);
        tmp_all.add(R14);
        tmp_all.add(R15);

        tmp_all.stream().filter(NASMRegister::isGeneral).forEach(tmp_general::add);
        tmp_all.stream().filter(NASMRegister::isCallerSave).forEach(tmp_callerSave::add);
        tmp_all.stream().filter(NASMRegister::isCalleeSave).forEach(tmp_calleeSave::add);
        tmp_all.stream().filter(NASMRegister::isFunArg).forEach(tmp_funArg::add);

        all        = Collections.unmodifiableCollection(tmp_all);
        general    = Collections.unmodifiableCollection(tmp_general);
        callerSave = Collections.unmodifiableCollection(tmp_callerSave);
        calleeSave = Collections.unmodifiableCollection(tmp_calleeSave);
        funArg = Collections.unmodifiableCollection(tmp_funArg);
    }
}
