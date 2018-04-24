package com.lmxyy.mxcompiler.symbol;

import java.util.LinkedHashMap;
import java.util.Map;

public class SymbolTable {
    private Map<String,SymbolInfo> map = new LinkedHashMap<>();
    private SymbolTable enclosingScope;
    private boolean isGlobal = false;

    public SymbolTable(SymbolTable _enclosingScope) {
        enclosingScope = _enclosingScope;
    }

    public static SymbolTable creatGlobalSymbalTable() {
        SymbolTable sym = new SymbolTable(null);
        sym.isGlobal = true;
        return sym;
    }

    public void define(String name,Type type) {
        map.put(name,new SymbolInfo(type));
    }
    public SymbolInfo getCurInfo(String name) {
        return map.get(name);
    }

    public SymbolInfo getInfo(String name) {
        SymbolInfo ret = map.get(name);
        if (ret != null) return ret;
        else if (enclosingScope != null) return enclosingScope.getInfo(name);
        else return null;
    }

    public SymbolTable getEnclosingScope() {
        return enclosingScope;
    }
}
