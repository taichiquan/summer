package org.summer.beans;

import java.beans.PropertyChangeListener;
import java.beans.PropertyDescriptor;
import java.beans.PropertyEditor;
import java.beans.VetoableChangeListener;
import java.util.Map;

/**
 * @author yc
 * @date 2016/10/24
 * @description
 */
public interface BeanWrapper {

    String NESTED_PROPERTY_SEPARATOR = ".";

    void setPropertyValue(String propertyName, Object value);

    void setPropertyValue(PropertyValue propertyValue);

    Object getPropertyValue(String propertyName);

    Object getIndexedPropertyValue(String propertyName, int index) throws BeansException;

    void setPropertyValues(Map m) throws BeansException;

    void setPropertyValues(PropertyValues pvs) throws BeansException;


    void setPropertyValues(PropertyValues pvs, boolean ignoreUnknown, PropertyValuesValidator pvsValidator) throws BeansException;

    PropertyDescriptor[] getPropertyDescriptors() throws BeansException;

    /** Get the property descriptor for a particular property, or null if there
     * is no such property
     * @param propertyName property to check status for
     * @return the property descriptor for a particular property, or null if there
     * is no such property
     */
    PropertyDescriptor getPropertyDescriptor(String propertyName) throws BeansException;

    /** Return whether this property is readable
     * @return whether this property is readable
     * @param propertyName property to check status for
     */
    boolean isReadableProperty(String propertyName);

    /**
     * Return whether this property is writable
     * @return whether this property is writable
     * @param propertyName property to check status for
     */
    boolean isWritableProperty(String propertyName);

    /**
     * Return the bean wrapped by this object.
     * Cannot be null
     * @return the bean wrapped by this object
     */
    Object getWrappedInstance();

    /**
     * Change the wrapped object. Implementations are required
     * to allow the type of the wrapped object to change.
     * @param obj wrapped object that we are manipulating
     */
    void setWrappedInstance(Object obj) throws BeansException;

    /**
     * This method is included for efficiency. If an implementation
     * caches all necessary information about the class,
     * it might be faster to instantiate a new instance in the
     * class than create a new wrapper to work with a new object
     */
    void newWrappedInstance() throws BeansException;

    /**
     * This method is included for efficiency. If an implementation
     * caches all necessary information about the class,
     * it might be <b>much</b> faster to instantiate a new wrapper copying
     * the cached information, than to use introspection again.
     * The wrapped instance is independent, as is the new BeanWrapper:
     * only the cached introspection information is copied. Does <b>not</b>
     * copy listeners.
     */
    BeanWrapper newWrapper(Object obj) throws BeansException;

    /**
     * Convenience method to return the class of the wrapped object
     * @return the class of the wrapped object
     */
    Class getWrappedClass();

    /**
     * Register the given custom property editor for the given type and
     * property, or for all properties of the given type.
     * @param requiredType type of the property, can be null if a property is
     * given but should be specified in any case for consistency checking
     * @param propertyPath path of the property (name or nested path), or
     * null if registering an editor for all properties of the given type
     * @param propertyEditor editor to register
     */
    void registerCustomEditor(Class requiredType, String propertyPath, PropertyEditor propertyEditor);

    /**
     * Find a custom property editor for the given type and property.
     * @param requiredType type of the property, can be null if a property is
     * given but should be specified in any case for consistency checking
     * @param propertyPath path of the property (name or nested path), or
     * null if looking for an editor for all properties of the given type
     * @return the registered editor, or null if none
     */
    PropertyEditor findCustomEditor(Class requiredType, String propertyPath);

    //---------------------------------------------------------------------
    // Bean event support
    //---------------------------------------------------------------------
    /**
     * Add a VetoableChangeListener that will be notified of property updates
     * @param l VetoableChangeListener notified of all property updates
     */
    void addVetoableChangeListener(VetoableChangeListener l);

    /**
     * Remove a VetoableChangeListener that will be notified of property updates
     * @param l VetoableChangeListener to remove
     */
    void removeVetoableChangeListener(VetoableChangeListener l);

    /**
     * Add a VetoableChangeListener that will be notified of updates to a single property
     * @param l VetoableChangeListener to add
     * @param propertyName name of property this listeners will listen to updates for
     */
    void addVetoableChangeListener(String propertyName, VetoableChangeListener l);

    /**
     * Remove a VetoableChangeListener that will be notified of updates to a single property
     * @param l VetoableChangeListener to remove
     * @param propertyName name of property this listeners formerly listened to updates for
     */
    void removeVetoableChangeListener(String propertyName, VetoableChangeListener l);

    /**
     * Add a PropertyChangeListener that will be notified of property updates
     * @param l PropertyChangeListener notified of all property updates
     */
    void addPropertyChangeListener(PropertyChangeListener l);

    /**
     *  Remove a PropertyChangeListener that was formerly notified of property updates
     * @param l PropertyChangeListener to remove
     */
    void removePropertyChangeListener(PropertyChangeListener l);

    /**
     * Add a PropertyChangeListener that will be notified of updates to a single property
     * @param propertyName property the listener is interested in
     * @param l PropertyChangeListener notified of property updates to this property
     */
    void addPropertyChangeListener(String propertyName, PropertyChangeListener l);

    /**
     * Remove a PropertyChangeListener that was notified of updates to a single property
     * @param propertyName property the listener is interested in
     * @param l PropertyChangeListener to remove
     */
    void removePropertyChangeListener(String propertyName, PropertyChangeListener l);

    /**
     * Should we send out event notifications?
     * Disabling this functionality (which is enabled by default)
     * may improve performance.
     * @return whether we notify listeners of property updates
     */
    boolean isEventPropagationEnabled();

    /**
     * Enable or disable event propogation
     * Any existing listeners will be preserved and will again be notified
     * of events when event propagation is reenabled.
     * However no new listeners can be added in this period:
     * calls to add or remove listeners will be ignored.
     * @param flag whether we notify listeners of property updates
     */
    void setEventPropagationEnabled(boolean flag);

    /**
     * Invoke the named method. This interface is designed
     * to encourage working with bean properties, rather than methods,
     * so this method shouldn't be used in most cases,
     * but it is necessary to provide a simple means to invoking
     * a named method.
     * @param methodName name of the method to invoke
     * @param args args to pass
     * @return follows java.util.Method.invoke(). Void calls
     * return null; primitives are wrapped as objects
     */
    Object invoke(String methodName, Object[] args) throws BeansException;
}
