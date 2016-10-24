package org.summer.beans.factory;

import org.summer.beans.BeansException;

/**
 * @author yc
 * @date 2016/10/24
 * @description
 */
public interface BeanFactory {

    Object getBeans(String beanName) throws BeansException;


    Object getBeans(String beanName, Class requiredType) throws BeansException;


    boolean isSingleton(String name) throws NoSuchBeanDefinitionException;


    String[] getAliases(String name);


}
