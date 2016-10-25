package org.summer.beans;

import java.beans.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yc
 * @date 2016/10/25
 * @description
 */
final class CashedIntrospectionResult {

    private static Map $cache = new HashMap();

    private BeanInfo beanInfo;

    private HashMap propertyDescriptorMap;

    private HashMap methodDescriptorMap;



    private CashedIntrospectionResult(Class clazz) {
        try {
            beanInfo = Introspector.getBeanInfo(clazz);

            initPropertyDescriptorMap();

            initMethodDescriptorMap();

        } catch (IntrospectionException e) {
            throw new FatalBeanException("Cannot get BeanInfo for object of class [" + clazz.getName() + "]", e);
        }
    }

    private void initMethodDescriptorMap() {
        methodDescriptorMap = new HashMap();
        MethodDescriptor[] methodDescriptors = beanInfo.getMethodDescriptors();
        for (MethodDescriptor md : methodDescriptors) {
            methodDescriptorMap.put(md.getName(), md);
        }
    }

    private void initPropertyDescriptorMap() {
        propertyDescriptorMap = new HashMap();
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor pd : propertyDescriptors) {
            propertyDescriptorMap.put(pd.getName(), pd);
        }
    }

    public static CashedIntrospectionResult forClass(Class clazz) {
        Object o = $cache.get(clazz);

        if (o == null) {
            try {
                o = new CashedIntrospectionResult(clazz);
            } catch (BeansException be) {
                o = be;
            }
            $cache.put(clazz, o);
        }

        if (o instanceof BeansException) {
            throw (BeansException) o;
        }

        return (CashedIntrospectionResult) o;
    }

    public BeanInfo getBeanInfo() {
        return this.getBeanInfo();
    }

    public Class getBeanClass() {
        return beanInfo.getBeanDescriptor().getBeanClass();
    }

    public PropertyDescriptor getPropertyDescriptor(String propertyName) {
        PropertyDescriptor pd = (PropertyDescriptor) this.propertyDescriptorMap.get(propertyName);
        if (pd == null) {
            throw new FatalBeanException("No property [" + propertyName + "] in class [" + getBeanClass() + "]", null);
        }
        return pd;
    }

    public MethodDescriptor getMethodDescriptor(String methodName) {
        MethodDescriptor md = (MethodDescriptor) this.methodDescriptorMap.get(methodName);
        if (md == null) {
            throw new FatalBeanException("No method [" + methodName + "] in class [" + getBeanClass() + "]", null);
        }
        return md;
    }
}
