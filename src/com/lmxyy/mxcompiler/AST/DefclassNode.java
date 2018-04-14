package com.lmxyy.mxcompiler.ast;
import java.util.List;

public class DefclassNode extends DefNode {
    private String name;
    private List<DefvarNode> varMembers;
    private List<DefunNode> funMembers;
    private DefunNode constructor;
    private Location location;

    public DefclassNode(String _name,List <DefvarNode> _varMembers,List <DefunNode> _funMembers,DefunNode _constructor) {
        name = _name;
        varMembers = _varMembers;
        funMembers = _funMembers;
        constructor = _constructor;
    }
    public void setLocation(Location _location) {
        location = _location;
    }

    public String getName() {
        return name;
    }
    public List<DefvarNode> getVarMembers() {
        return varMembers;
    }
    public List<DefunNode> getFunMembers() {
        return funMembers;
    }
    public DefunNode getConstructor() {
        return constructor;
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
