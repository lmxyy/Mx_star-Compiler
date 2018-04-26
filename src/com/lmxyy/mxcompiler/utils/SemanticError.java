package com.lmxyy.mxcompiler.utils;

import com.lmxyy.mxcompiler.ast.VartypeNode;
import com.lmxyy.mxcompiler.symbol.Type;

import java.util.ArrayList;
import java.util.List;

public class SemanticError extends Error {
    public List<String> msgs;

    public SemanticError() {
        msgs = new ArrayList<>();
    }

    public void add(Location location,String msg) {
        assert location != null;
        System.err.println("Location: "+location+"\n"+"Semantic Error: "+msg);
        msgs.add("Location: "+location+"\n"+"Semantic Error: "+msg);
    }
    public void add(String msg) {
        System.err.println("Semantic Error: "+msg);
        msgs.add("Semantic Error: "+msg);
    }
    public void canNotResolveToTheType(Location location,String type) {
        add(location,"Cannot resolve to the type \""+type+"\".");
    }
    public void canNotResolveToTheIdentifier(Location location,String name) {
        add(location,"Cannot resolve to the identifier \""+name+"\".");
    }
    public void hasAlreadyBeenDeclared(Location location,String name) {
        add(location,"\""+name+"\" has already been declared.");
    }
    public void expectType(Location location,VartypeNode type1,VartypeNode type2) {
        String str1 = type1.getName(),str2 = type2.getName();
        for (int i = 1;i < type1.getType().getDimension();++i)
            str1 += "[]";
        for (int i = 1;i < type2.getType().getDimension();++i)
            str2 += "[]";
        add(location,"Expect "+str1+" type, but get "+str2+" type.");
    }
    public void hasNoMember(Location location,VartypeNode type,String name) {
        String str = type.getName();
        for (int i = 1;i < type.getType().getDimension();++i)
            str += "[]";
        add(location,str+" has no member. \""+name+"\".");
    }
    public void isNotArray(Location location,VartypeNode type) {
        String str = type.getName();
        for (int i = 1;i < type.getType().getDimension();++i)
            str += "[]";
        add(location,str+" is not an array type.");
    }
    public void parameterListDoesNotMatch(Location location) {
        add(location,"Parameter list does not match.");
    }
    public void areNotTheSameType(Location location,VartypeNode type1,VartypeNode type2) {
        String str1 = type1.getName(),str2 = type2.getName();
        for (int i = 1;i < type1.getType().getDimension();++i)
            str1 += "[]";
        for (int i = 1;i < type2.getType().getDimension();++i)
            str2 += "[]";
        add(location,str1+"\" type and "+str2+" are not the same type.");
    }
    public void doNotSupportTheOperation(Location location,VartypeNode type) {
        String str = type.getName();
        for (int i = 1;i < type.getType().getDimension();++i)
            str += "[]";
        add(location,"Type "+str+" do not the support the operation.");
    }
}
