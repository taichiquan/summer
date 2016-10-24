package org.summer.beans;

import org.summer.core.NestedRuntimeException;

/**
 * @author yc
 * @date 2016/10/24
 * @description
 */
public class BeansException extends NestedRuntimeException {

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable rootCause) {
        super(message, rootCause);
    }
}
