package com.lmxyy.mxcompiler.utils;

import com.lmxyy.mxcompiler.ast.Location;

public class SyntaxError extends Error {
    private Location location;
    private String msg;

    public SyntaxError(Location _location,String _msg) {
        location = _location;
        msg = _msg;
    }
}
