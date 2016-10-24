package org.summer.beans.factory;

import org.summer.beans.BeansException;

/**
 * @author yc
 * @date 2016/10/24
 * @description
 */
public class NoSuchBeanDefinitionException extends BeansException {

    private String name;

    public NoSuchBeanDefinitionException(String name) {
        super("No bean named [" + name + "] is defined", null);
        this.name = name;
    }

    public NoSuchBeanDefinitionException(String name, String message) {
        super("No bean named [" + name + "] is defined", null);
        this.name = name;
    }

    public String getBeanName() {
        return this.name;
    }
}
