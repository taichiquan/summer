package org.summer.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/10 0010.
 */
public class MutablePropertyValues implements PropertyValues {

    private List<PropertyValue> propertyValuesList;

    public MutablePropertyValues() {
        propertyValuesList = new ArrayList<PropertyValue>(10);
    }


    public MutablePropertyValues(PropertyValues other) {
        if (other == null) {
            propertyValuesList = new ArrayList<PropertyValue>(0);
        }else{
            PropertyValue[] propertyValues = other.getPropertyValues();
            propertyValuesList = new ArrayList<PropertyValue>(propertyValues.length);
            for (PropertyValue propertyValue : propertyValues) {
                addPropertyValue(new PropertyValue(propertyValue.getName(),propertyValue.getValue()));
            }
        }
    }


    public MutablePropertyValues(Map<?, ?> original) {
        if (original == null) {
            propertyValuesList = new ArrayList<PropertyValue>(0);
        }else{
            propertyValuesList = new ArrayList<PropertyValue>(original.size());
            for (Map.Entry<?, ?> entry : original.entrySet()) {
                addPropertyValue(new PropertyValue(entry.getKey().toString(),entry.getValue()));
            }
        }
    }


    private void addPropertyValue(PropertyValue propertyValue) {
        this.propertyValuesList.add(propertyValue);
    }


    public PropertyValue[] getPropertyValues() {
        return this.propertyValuesList.toArray(new PropertyValue[this.propertyValuesList.size()]);
    }

    public boolean contains(String name) {
        return getPropertyValue(name) != null ||
                (this.propertyValuesList != null &&this.propertyValuesList.contains(getPropertyValue(name)));
    }


    public PropertyValue getPropertyValue(String name) {
        for (PropertyValue propertyValue : propertyValuesList) {
            if (propertyValue.getName().equals(name)) {
                return propertyValue;
            }
        }
        return null;
    }


    public PropertyValues changeSince(PropertyValues old) {
        PropertyValues change = new MutablePropertyValues();
        if (this == old) {
            return change;
        }


        return null;
    }
}
