package com.sunhome.boot.formatter.autoconfigure;

public class DefaultFormatter implements Formatter {

    @Override
    public String format(Object object) {
        return String.valueOf(object);
    }
}
