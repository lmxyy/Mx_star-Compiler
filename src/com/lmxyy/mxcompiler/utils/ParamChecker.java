package com.lmxyy.mxcompiler.utils;

import com.lmxyy.mxcompiler.ast.VartypeNode;

import java.util.List;

public class ParamChecker {
    public static boolean isSame(List<VartypeNode> a,List<VartypeNode> b) {
        if (a.size() != b.size()) return false;
        int len = a.size();
        for (int i = 0;i < len;++i)
            if (!a.get(i).equals(b.get(i))) return false;
        return true;
    }
}
