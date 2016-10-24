package org.summer.beans.factory.support;

import org.summer.beans.PropertyValues;

/**
 * @author yc
 * @date 2016/10/24
 * @description
 */
public abstract class AbstractBeanDefinition {

    private boolean singleton;

    private PropertyValues pvs;


    public AbstractBeanDefinition(boolean singleton, PropertyValues pvs) {
        this.singleton = singleton;
        this.pvs = pvs;
    }

    public AbstractBeanDefinition() {
        this.singleton = true;
    }


    public boolean isSingleton() {
        return singleton;
    }

    public PropertyValues getPropertyValues() {
        return pvs;
    }

    public void setPropertyValues(PropertyValues pvs) {
        this.pvs = pvs;
    }


    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AbstractBeanDefinition)) {
            return false;
        }
        AbstractBeanDefinition other = (AbstractBeanDefinition) obj;

        return this.singleton = other.singleton &&
                this.pvs.changeSince(other.pvs).getPropertyValues().length == 0;
    }
}
