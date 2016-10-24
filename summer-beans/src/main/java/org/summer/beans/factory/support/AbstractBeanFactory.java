package org.summer.beans.factory.support;

import org.summer.beans.factory.BeanFactory;
import org.summer.beans.factory.FactoryBean;
import org.summer.beans.factory.NoSuchBeanDefinitionException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yc
 * @date 2016/10/24
 * @description
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    public static final String FACTORY_BEAN_PREFIX = "&";


    private BeanFactory parentBeanFactory;

    private Map sharedInstanceCache = new HashMap();

    private Map aliasMap = new HashMap();


    protected String defaultParentBean;


    public AbstractBeanFactory() {

    }

    public AbstractBeanFactory(BeanFactory parentBeanFactory) {
        this.parentBeanFactory = parentBeanFactory;
    }


    public BeanFactory getParentBeanFactory() {
        return parentBeanFactory;
    }


    public final Object getBean(String name) {
        return null;
    }


    public Object getBeanInternal(String name, Map newlyCreateBeans) {
        if (name == null) {
            throw new NoSuchBeanDefinitionException(null);
        }

        if (newlyCreateBeans != null && newlyCreateBeans.containsKey(name)) {
            return newlyCreateBeans.get(name);
        }

        AbstractBeanDefinition abstractBeanDefinition = getBeanDefinition(transformedBeanName(name));

        return abstractBeanDefinition.isSingleton() ? getBeanDefinition(name) : null;
    }


    private synchronized final Object getSharedIntance(String name, Map newlyCreateBean) {
        String pname = transformedBeanName(name);
        Object bean = this.sharedInstanceCache.get(pname);

        if (bean == null) {
            if (newlyCreateBean == null) {
                newlyCreateBean = new HashMap();
            }
            bean = createBean(pname, newlyCreateBean);
            this.sharedInstanceCache.put(pname, bean);
        }

        if (isFactoryDereference(name) && !(bean instanceof BeanFactory)) {

        }

        if (bean instanceof FactoryBean) {
            if (!isFactoryDereference(name)) {
                FactoryBean factory = (FactoryBean) bean;
                bean = factory.getObject();

                if (factory.getPropertyValues() != null) {
                    return null;
                }
            }
        }

        return bean;

    }


    private Object createBean(String name, Map newlyCreateBean) {
        return null;
    }

    private boolean isFactoryDereference(String name) {
        return name.startsWith(FACTORY_BEAN_PREFIX);
    }

    private String transformedBeanName(String name) {
        if (name.startsWith(FACTORY_BEAN_PREFIX)) {
            name = name.substring(FACTORY_BEAN_PREFIX.length());
        }

        String canonicalName = (String) this.aliasMap.get(name);

        return canonicalName == null ? name : canonicalName;
    }



    protected abstract AbstractBeanDefinition getBeanDefinition(String beanName) throws NoSuchBeanDefinitionException;
}
