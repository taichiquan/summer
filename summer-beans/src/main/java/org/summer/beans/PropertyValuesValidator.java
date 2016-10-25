package org.summer.beans;

/**
 * @author yc
 * @date 2016/10/24
 * @description
 */
public interface PropertyValuesValidator  {

    void validatePropertyValues(PropertyValues pvs) throws InvalidPropertyValuesException;

}
