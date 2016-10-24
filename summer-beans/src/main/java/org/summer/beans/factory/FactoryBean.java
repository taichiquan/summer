package org.summer.beans.factory;

import org.summer.beans.PropertyValues;

/**
 * @author yc
 * @date 2016/10/24
 * @description
 */
public interface FactoryBean {

    Object getObject();

    boolean isSingleton();

    PropertyValues getPropertyValues();
}
