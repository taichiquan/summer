package org.summer.beans;

import java.beans.*;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/31 0031.
 */
public class BeanWrapperImpl implements BeanWrapper {

    public static final boolean DEFAULT_EVENT_PROPAGATION_ENABLED = false;

    /** The wrapped object */
    private Object object;

    /**
     * Cached introspections results for this object, to prevent encountering the cost
     * of JavaBeans introspection every time.
     * */
    private CashedIntrospectionResult cachedIntrospectionResults;

    /** Standard java.beans helper object used to propagate events */
    private VetoableChangeSupport vetoableChangeSupport;

    /** Standard java.beans helper object used to propagate events */
    private PropertyChangeSupport	propertyChangeSupport;

    /** Should we propagate events to listeners? */
    private boolean	eventPropagationEnabled = DEFAULT_EVENT_PROPAGATION_ENABLED;

    /* Map with cached nested BeanWrappers */
    private Map nestedBeanWrappers;

    /** Map with custom PropertyEditor instances */
    private Map customEditors;

    public BeanWrapperImpl(Object object) {
        this(object, DEFAULT_EVENT_PROPAGATION_ENABLED);
    }

    public BeanWrapperImpl(Object obj, boolean eventPropagationEnabled) {
        this.eventPropagationEnabled = eventPropagationEnabled;
        setObject(obj);
    }

    public BeanWrapperImpl(Class clazz) {
        cachedIntrospectionResults = CashedIntrospectionResult.forClass(clazz);
        setObject(BeanUtils.instantiateClass(clazz));
    }

    public BeanWrapperImpl(CashedIntrospectionResult cachedIntrospectionResults, Object object) throws BeansException {
        this.cachedIntrospectionResults = cachedIntrospectionResults;
        setObject(object);
    }


    private void setObject(Object obj)throws BeansException {
        if (obj == null) {
            throw new FatalBeanException("Cannot set BeanWrapperImpl target to a null object", null);
        }

        this.object = obj;
        if (cachedIntrospectionResults == null ||
                !cachedIntrospectionResults.getBeanClass().equals(obj.getClass())) {
            cachedIntrospectionResults = CashedIntrospectionResult.forClass(obj.getClass());
        }

        this.setEventPropagationEnabled(this.eventPropagationEnabled);
    }


    public void setPropertyValue(String propertyName, Object value) {

    }

    public void setPropertyValue(PropertyValue propertyValue) {

    }

    public Object getPropertyValue(String propertyName) {
        return null;
    }

    public Object getIndexedPropertyValue(String propertyName, int index) throws BeansException {
        return null;
    }

    public void setPropertyValues(Map m) throws BeansException {

    }

    public void setPropertyValues(PropertyValues pvs) throws BeansException {

    }

    public void setPropertyValues(PropertyValues pvs, boolean ignoreUnknown, PropertyValuesValidator pvsValidator) throws BeansException {

    }

    public PropertyDescriptor[] getPropertyDescriptors() throws BeansException {
        return new PropertyDescriptor[0];
    }

    public PropertyDescriptor getPropertyDescriptor(String propertyName) throws BeansException {
        return null;
    }

    public boolean isReadableProperty(String propertyName) {
        return false;
    }

    public boolean isWritableProperty(String propertyName) {
        return false;
    }

    public Object getWrappedInstance() {
        return null;
    }

    public void setWrappedInstance(Object obj) throws BeansException {

    }

    public void newWrappedInstance() throws BeansException {

    }

    public BeanWrapper newWrapper(Object obj) throws BeansException {
        if (this.cachedIntrospectionResults.getBeanClass().equals(obj.getClass())) {
            throw new FatalBeanException("Cannot create new wrapper for object of class "
                    + obj.getClass().getName() + " using cached information for class "
                    + cachedIntrospectionResults.getBeanClass(), null);
        }

        return new BeanWrapperImpl(this.cachedIntrospectionResults, obj);
    }

    public Class getWrappedClass() {
        return null;
    }

    public void registerCustomEditor(Class requiredType, String propertyPath, PropertyEditor propertyEditor) {

    }

    public PropertyEditor findCustomEditor(Class requiredType, String propertyPath) {
        return null;
    }

    public void addVetoableChangeListener(VetoableChangeListener l) {

    }

    public void removeVetoableChangeListener(VetoableChangeListener l) {

    }

    public void addVetoableChangeListener(String propertyName, VetoableChangeListener l) {

    }

    public void removeVetoableChangeListener(String propertyName, VetoableChangeListener l) {

    }

    public void addPropertyChangeListener(PropertyChangeListener l) {

    }

    public void removePropertyChangeListener(PropertyChangeListener l) {

    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener l) {

    }

    public void removePropertyChangeListener(String propertyName, PropertyChangeListener l) {

    }

    public boolean isEventPropagationEnabled() {
        return false;
    }


    public void setEventPropagationEnabled(boolean flag) {
        this.eventPropagationEnabled = flag;
        if (eventPropagationEnabled &&
                (vetoableChangeSupport == null || propertyChangeSupport == null)) {
            vetoableChangeSupport = new VetoableChangeSupport(object);
            propertyChangeSupport = new PropertyChangeSupport(object);
        }
    }

    public Object invoke(String methodName, Object[] args) throws BeansException {
        return null;
    }
}
