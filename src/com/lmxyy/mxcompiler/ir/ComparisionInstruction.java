package com.lmxyy.mxcompiler.ir;

import java.util.Map;

public class ComparisionInstruction extends BinaryOperationInstruction {
    public ComparisionInstruction(BasicBlock _basicBlock,Register _dest,Operator _operator, IntValue _lhs,IntValue _rhs) {
        super(_basicBlock,_dest,_operator,_lhs,_rhs);
        reloadUsedRegisterCollection();
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public IRInstruction copyAndRename(Map<Object, Object> renameMap) {
        return new ArithmeticInstruction(
                (BasicBlock) renameMap.getOrDefault(basicBlock,basicBlock),
                (Register) renameMap.getOrDefault(getDest(),getDest()),
                getOperator(),
                (IntValue) renameMap.getOrDefault(getLhs(),getLhs()),
                (IntValue) renameMap.getOrDefault(getRhs(),getRhs())
        );
    }
}
