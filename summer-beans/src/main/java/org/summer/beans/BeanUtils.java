package org.summer.beans;

/**
 * Created by Administrator on 2016/10/31 0031.
 */
public abstract class BeanUtils {

    public static Object instantiateClass(Class clazz) throws BeansException{
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            throw new FatalBeanException("Cannot instantiate [" + clazz + "]; is it an interface or an abstract class?", e);
        } catch (IllegalAccessException e) {
            throw new FatalBeanException("Cannot instantiate [" + clazz + "]; has class definition changed? Is there a public constructor?", e);
        }
    }


    public void copyBean() {

    }
}
