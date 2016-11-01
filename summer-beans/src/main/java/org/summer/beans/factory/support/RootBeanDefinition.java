package org.summer.beans.factory.support;

import org.summer.beans.PropertyValues;

/**
 * Created by Administrator on 2016/10/31 0031.
 */
public class RootBeanDefinition extends AbstractBeanDefinition {

    private Class clzz;

    public RootBeanDefinition(PropertyValues pvs, boolean singleton, Class clzz) {
        super(singleton, pvs);
        this.clzz = clzz;
    }

    
}
