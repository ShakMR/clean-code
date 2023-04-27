package com.cleancode.main;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StringArgumentMarshaler implements ArgumentMarshaler {
    private String value = "";
    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        try {
            value = currentArgument.next();
        } catch (NoSuchElementException e) {
            throw new ArgsException(ArgsException.ErrorCode.MISSING_STRING);
        }
    }

    @Override
    public Object get() {
        return value;
    }
}
