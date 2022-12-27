package com.ioiox.dei.core.orm.mybatis.service;

public class DeiDbException extends RuntimeException {

    public DeiDbException(final String message) {
        super(message);
    }

    public DeiDbException(String message, Throwable cause) {
        super(message, cause);
    }
}
