package com.lmxyy.mxcompiler.symbol;

import com.lmxyy.mxcompiler.ast.VartypeNode;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ClassType extends VartypeNode {
    private Map<String, VartypeNode> memMap = new LinkedHashMap<>();

    public ClassType(VartypeNode type,Map<String, VartypeNode> _memMap) {
        super(type);
        memMap = _memMap;
    }

    public VartypeNode resolveMem(String name) {
        return memMap.get(name);
    }
    public void define(String name,VartypeNode mem) {
        memMap.put(name,mem);
    }
}
