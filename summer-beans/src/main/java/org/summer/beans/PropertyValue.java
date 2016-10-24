package org.summer.beans;

/**
 * @author yc
 * @date 2016/10/24
 * @description
 */
public class PropertyValue {

    private String name;
    private Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "PropertyValue name: '" + name + "' value=[ '" + value + "' ]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PropertyValue)) {
            return false;
        }

        PropertyValue pvoOther = (PropertyValue) obj;

        return this == obj || pvoOther.name.equals(this.name) && pvoOther.value == this.value;
    }
}
