package com.cleancode.main;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleArgumentMarshaler implements ArgumentMarshaler {
    private double value = 0;

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        String parameter = null;
        try {
            parameter = currentArgument.next();
            value = Double.parseDouble(parameter);
        } catch (NoSuchElementException e) {
            throw new ArgsException(ArgsException.ErrorCode.MISSING_DOUBLE);
        } catch (NumberFormatException e) {
            throw new ArgsException(ArgsException.ErrorCode.INVALID_DOUBLE, parameter);
        }
    }

    @Override
    public Object get() {
        return value;
    }
}
