package com.lmxyy.mxcompiler.symbol;

import com.lmxyy.mxcompiler.ast.VartypeNode;

import java.util.LinkedHashMap;
import java.util.Map;

public class SymbolTable {
    private Map<String,SymbolInfo> map = new LinkedHashMap<>();
    private SymbolTable enclosingScope;
    private boolean isLoop = false;
    private boolean isClass = false;
    private String className = null;
    private FunctionType inFun = null;

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
        map.put(name,new SymbolInfo(type));
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
}
