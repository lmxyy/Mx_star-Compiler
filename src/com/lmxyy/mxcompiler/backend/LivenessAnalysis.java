package com.lmxyy.mxcompiler.backend;

import com.lmxyy.mxcompiler.ir.IRRoot;

public class LivenessAnalysis {
    private IRRoot irRoot;

    public LivenessAnalysis(IRRoot _irRoot) {
        irRoot = _irRoot;
    }
}
