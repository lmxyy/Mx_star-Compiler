package com.lmxyy.mxcompiler.ast;

import com.lmxyy.mxcompiler.utils.Location;

import java.util.List;

public class ForStmtNode extends StmtNode {
    private DefvarlistNode init1;
    private List<Node> init2;
    private ExpressionNode cond;
    private List<Node> step;
    private StmtNode block;
    private Location location;

    public ForStmtNode(DefvarlistNode _init1,
                       List<Node> _init2,
                       ExpressionNode _cond,
                       List<Node> _step,
                       StmtNode _block) {
        init1 = _init1;
        init2 = _init2;
        cond = _cond;
        step = _step;
        block = _block;
    }
    public void setLocation(Location _location) {
        location = _location;
    }

    public DefvarlistNode getInit1() {
        return init1;
    }
    public List<Node> getInit2() {
        return init2;
    }
    public ExpressionNode getCond() {
        return cond;
    }
    public List<Node> getStep() {
        return step;
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
