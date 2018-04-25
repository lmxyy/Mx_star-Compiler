package com.lmxyy.mxcompiler.utils;

import com.lmxyy.mxcompiler.ast.Location;

public class SemanticError extends Error {
    private Location location;
    private String msg;

    public SemanticError(Location _location,String _msg) {
        location = _location;
        msg = _msg;
    }
}
