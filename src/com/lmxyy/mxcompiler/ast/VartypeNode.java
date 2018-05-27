package com.lmxyy.mxcompiler.ast;
import com.lmxyy.mxcompiler.symbol.GlobalSymbolTable;
import com.lmxyy.mxcompiler.symbol.SymbolTable;
import com.lmxyy.mxcompiler.symbol.Type;
import com.lmxyy.mxcompiler.utils.CompilerOption;
import com.lmxyy.mxcompiler.utils.Location;

public class VartypeNode extends Node {
    private Type type;
    private String name;
    private Location location;

    public int getRegisterSize() {
        if (isBool()) return CompilerOption.getSizeBool();
        else if (isInt()) return CompilerOption.getSizeInt();
        else return CompilerOption.getSizePointer();
    }

    public VartypeNode(Type _type,String _name) {
        type = _type;
        name = _name;
    }
    public VartypeNode(VartypeNode other) {
        type = other.getType();
        name = other.getName();
    }
    public void setLocation(Location _location) {
        location = _location;
    }

    public Type getType() {
        return type;
    }
    public String getName() {
        return name;
    }

    public boolean isBool() {
        return type.getType() == Type.Types.BOOL&&type.getDimension() == 0;
    }
    public boolean isInt() {
        return type.getType() == Type.Types.INT&&type.getDimension() == 0;
    }
    public boolean isString() {
        return type.getType() == Type.Types.STRING&&type.getDimension() == 0;
    }
    public boolean isNull() {
        return type.getType() == Type.Types.NULL&&type.getDimension() == 0;
    }
    public boolean isVoid() { return type.getType() == Type.Types.VOID&&type.getDimension() == 0; }
    public boolean isClass() { return type.getType() == Type.Types.CLASS&&type.getDimension() == 0; }
    public boolean isUB() { return type.getType() == Type.Types.UB; }

    public VartypeNode getRecessionType(int index) {
        assert type.getDimension() >= index;
        return new VartypeNode(new Type(type.getType(),type.getDimension()-index), name);
    }

    @Override
    public Location location() { return location; }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    public boolean equals(VartypeNode other) {
        if (type.getType() == Type.Types.UB) return false;
        else if (other.type.getType() == Type.Types.UB) return false;
        else if (type.getDimension() == other.getType().getDimension()&&name.equals(other.name))
            return true;
        else if (type.getDimension() > 0&&other.getType().getType() == Type.Types.NULL)
            return true;
        else if (other.type.getDimension() > 0&&type.getType() == Type.Types.NULL)
            return true;
        else if (isClass()&&other.getType().getType() == Type.Types.NULL)
            return true;
        else if (other.isClass()&&type.getType() == Type.Types.NULL)
            return true;
        else return false;
    }
}
