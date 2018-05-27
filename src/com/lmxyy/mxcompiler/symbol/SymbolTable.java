package com.lmxyy.mxcompiler.symbol;

import com.lmxyy.mxcompiler.ast.VartypeNode;
import com.lmxyy.mxcompiler.ir.Function;

import java.util.LinkedHashMap;
import java.util.Map;

public class SymbolTable {
    private Map<String,SymbolInfo> map = new LinkedHashMap<>();
    private SymbolTable enclosingScope;
    private boolean isLoop = false;
    private boolean isClass = false;
    private String className = null;
    private FunctionType inFun = null;
    private Map<String,Integer> sizeMap = new LinkedHashMap<>();
    private Map<String,Integer> offsetMap = new LinkedHashMap<>();

    public SymbolTable(SymbolTable _enclosingScope) {
        enclosingScope = _enclosingScope;
        if (enclosingScope != null) {
            isLoop = enclosingScope.isLoop;
            isClass = enclosingScope.isClass;
            className = enclosingScope.className;
            inFun = enclosingScope.inFun;
        }
    }

    public static SymbolTable creatGlobalSymbalTable() {
        SymbolTable sym = new SymbolTable(null);
        return sym;
    }

    public void setLoop() {
        isLoop = true;
    }
    public void setClass(String _className) {
        isClass = true;
        className = _className;
    }
    public void setInFun(FunctionType fun) {
        inFun = fun;
    }

    public void define(String name,VartypeNode type) {
        map.put(name,new SymbolInfo(type,false));
        if (!(type instanceof FunctionType)&&name.contains(".")) {
            String className  = name.split("[.]")[0];
            Integer offset = sizeMap.get(className);
            if (offset == null) {
                sizeMap.put(className, type.getRegisterSize());
                offsetMap.put(name, 0);
            } else {
                sizeMap.replace(className, offset + type.getRegisterSize());
                offsetMap.put(name, 0);
            }
        }
    }
    public void define(String name,VartypeNode type,boolean isClassGlobal) {
        map.put(name,new SymbolInfo(type,isClassGlobal));
        if (!(type instanceof FunctionType)&&name.contains(".")) {
            String className = name.split("[.]")[0];
            Integer offset = sizeMap.get(className);
            if (offset == null) {
                sizeMap.put(className, type.getRegisterSize());
                offsetMap.put(name, 0);
            } else {
                sizeMap.replace(className, offset + type.getRegisterSize());
                offsetMap.put(name, 0);
            }
        }
    }

    public SymbolInfo getCurInfo(String name) {
        return map.get(name);
    }
    public VartypeNode getCurTypeInfo(String name) {
        SymbolInfo ret = getCurInfo(name);
        if (ret == null) return null;
        else return ret.getType();
    }

    public boolean isLoop() {
        return isLoop;
    }
    public boolean isClass() {
        return isClass;
    }
    public String getClassName() {
        return className;
    }
    public FunctionType getInFun() {
        return inFun;
    }

    public SymbolInfo getInfo(String name) {
        SymbolInfo ret = map.get(name);
        if (ret != null) return ret;
        else if (enclosingScope != null) return enclosingScope.getInfo(name);
        else return null;
    }
    public VartypeNode getTypeInfo(String name) {
        SymbolInfo ret = getInfo(name);
        if (ret == null) return null;
        else return ret.getType();
    }
    public SymbolTable getEnclosingScope() {
        return enclosingScope;
    }

    public int getMemorySize(String name) {
        return sizeMap.get(name);
    }
    public int getOffset(String name) {
        return offsetMap.get(name);
    }
}
