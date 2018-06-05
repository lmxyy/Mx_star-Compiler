package com.lmxyy.mxcompiler.backend;

import com.lmxyy.mxcompiler.ir.Function;
import com.lmxyy.mxcompiler.ir.IRRoot;

import java.util.HashMap;
import java.util.Map;

public class FunctionInliner {
    private static class FuncInfo {
        int numInst = 0;
        int numUsed = 0;
        boolean skip = false;
    }

    private IRRoot irRoot;
    private Map<Function,FuncInfo> infoMap = new HashMap();

    public FunctionInliner(IRRoot _irRoot) {
        irRoot = _irRoot;
    }
}
