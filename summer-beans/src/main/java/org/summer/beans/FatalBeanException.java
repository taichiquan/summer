package org.summer.beans;

/**
 * @author yc
 * @date 2016/10/25
 * @description
 */
public class FatalBeanException extends BeansException {

    public FatalBeanException(String message) {
        super(message);
    }

    public FatalBeanException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
