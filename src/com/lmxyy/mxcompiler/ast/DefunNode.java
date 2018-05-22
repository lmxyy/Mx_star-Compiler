package com.lmxyy.mxcompiler.ast;
import com.lmxyy.mxcompiler.utils.Location;

import java.util.List;

public class DefunNode extends DefNode {
    private boolean inline;
    private VartypeNode returnType;
    private String name;
    private List <DefvarNode> parameterList;
    private BlockNode body;
    private boolean ommit = false;

    public DefunNode(boolean _inline,VartypeNode _returnType,String _name,List <DefvarNode> _parameterList,BlockNode _body) {
        inline = _inline;
        returnType = _returnType;
        name = _name;
        parameterList = _parameterList;
        body = _body;
    }
    public void setOmmit() {
        ommit = true;
    }

    public boolean isInline() {
        return inline;
    }
    public VartypeNode getReturnType() {
        return returnType;
    }
    public String getName() {
        return name;
    }
    public List<DefvarNode> getParameterList() {
        return parameterList;
    }
    public BlockNode getBody() {
        return body;
    }
    public boolean isOmmit() {
        return ommit;
    }

    @Override
    public Location location() {
        return returnType.location();
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
