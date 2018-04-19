package com.lmxyy.mxcompiler.ast;

public interface Visitor {
    void visit(DefunNode node);
    void visit(DefvarNode node);
    void visit(DefclassNode node);
    void visit(VartypeNode node);
    void visit(IfStmtNode node);
    void visit(WhileStmtNode node);
    void visit(ForStmtNode node);
    void visit(ExpressionStmtNode node);
    void visit(AssignmentStmtNode node);
    void visit(ContinueStmtNode node);
    void visit(BreakStmtNode node);
    void visit(ReturnStmtNode node);
    void visit(BlankStmtNode node);
    void visit(BlockNode node);
    void visit(IdentifierNode node);
    void visit(StringliteralNode node);
    void visit(IntegerliteralNode node);
    void visit(BooleanliteralNode node);
    void visit(NullNode node);
    void visit(VariableNode node);
    void visit(CallfunNode node);
    void visit(AssignmentNode node);
    void visit(ExpressionNode node);
    void visit(ProgNode node);
}
