package com.lmxyy.mxcompiler.nasm;

import com.lmxyy.mxcompiler.ir.Function;
import com.lmxyy.mxcompiler.ir.IRRoot;
import com.lmxyy.mxcompiler.utils.CompilerOption;

public class IRTransformer {
    private IRRoot irRoot;
    private final int sizeWord = CompilerOption.getSizeInt();

    public IRTransformer(IRRoot _irRoot){
        irRoot = _irRoot;
    }


    private void processFunction(Function function) {
        function.getReversePostOrder().forEach(basicBlock -> basicBlock.transform());
    }

    public void run() {
        for (Function function:irRoot.functions.values())
            processFunction(function);
    }
}
