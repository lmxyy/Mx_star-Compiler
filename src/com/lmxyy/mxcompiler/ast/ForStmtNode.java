package com.lmxyy.mxcompiler.ast;

public class ForStmtNode extends StmtNode {
    private DefvarNode init1;
    private ExpressionNode init2;
    private ExpressionNode cond;
    private AssignmentNode step1;
    private ExpressionNode step2;
    private StmtNode block;
    private Location location;

    public ForStmtNode(DefvarNode _init1,ExpressionNode _init2,ExpressionNode _cond,AssignmentNode _step1,ExpressionNode _step2,StmtNode _block) {
        init1 = _init1;
        init2 = _init2;
        cond = _cond;
        step1 = _step1;
        step2 = _step2;
    }
    public void setLocation(Location _location) {
        location = _location;
    }

    public DefvarNode getInit1() {
        return init1;
    }
    public ExpressionNode getInit2() {
        return init2;
    }
    public ExpressionNode getCond() {
        return cond;
    }
    public AssignmentNode getStep1() {
        return step1;
    }
    public ExpressionNode getStep2() {
        return step2;
    }
    public StmtNode getBlock() {
        return block;
    }

    @Override
    public Location location() {
        return location;
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
