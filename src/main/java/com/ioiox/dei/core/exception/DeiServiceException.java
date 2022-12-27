package com.ioiox.dei.core.exception;

public class DeiServiceException extends RuntimeException {
    private Integer code;

    public DeiServiceException(final String message) {
        super(message);
    }

    public DeiServiceException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public DeiServiceException(final Integer code, final String message) {
        this(message);
        this.code = code;
    }

    public DeiServiceException(final Integer code, final String message, final Throwable cause) {
        this(message, cause);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
