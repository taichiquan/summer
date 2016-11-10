package org.summer.beans;

/**
 * @author yc
 * @date 2016/10/24
 * @description
 */
public interface PropertyValues {

    PropertyValue[] getPropertyValues();

    boolean contains(String name);

    PropertyValue getPropertyValue(String name);

    PropertyValues changeSince(PropertyValues old);
}
