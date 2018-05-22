package com.lmxyy.mxcompiler.ir;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class IRRoot {
    public Map<String,Function> functions = new LinkedHashMap<>();
    public List<StaticData> dataList;

    public IRRoot() {

    }
}
