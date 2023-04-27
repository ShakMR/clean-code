package com.cleancode.main;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntegerArgumentMarshaler implements ArgumentMarshaler {
    private Integer value = 0;

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        String parameter = null;
        try {
            parameter = currentArgument.next();
            set(parameter);
        } catch (NoSuchElementException e) {
            throw new ArgsException(ArgsException.ErrorCode.MISSING_INTEGER);
        } catch (ArgsException e) {
            throw new ArgsException(ArgsException.ErrorCode.INVALID_INTEGER, parameter);
        }
    }

    private void set(String parameter) throws ArgsException {
        try {
            value = Integer.parseInt(parameter);
        } catch (NumberFormatException e) {
            throw new ArgsException();
        }
    }

    @Override
    public Object get() {
        return value;
    }
}
