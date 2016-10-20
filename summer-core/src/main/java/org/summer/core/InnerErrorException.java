package org.summer.core;

/**
 * @author yc
 * @date 2016/10/20
 * @description
 */
public class InnerErrorException extends NestedRuntimeException {

    public InnerErrorException() {
        super("inner error exception");
    }

    public InnerErrorException(String message) {
        super(message);
    }

    public InnerErrorException(String message, Throwable rootCause) {
        super(message, rootCause);
    }
}
