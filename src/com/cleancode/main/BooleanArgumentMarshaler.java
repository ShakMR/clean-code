package com.cleancode.main;

import java.util.Iterator;

public class BooleanArgumentMarshaler implements ArgumentMarshaler {
    private boolean value = false;
    public void set(Iterator<String> currentArgument) throws ArgsException {
        value = true;
    }

    public Object get() {
        return value;
    }
}
