package org.summer.beans.propertyeditors;

import java.beans.PropertyEditorSupport;

/**
 * @author yc
 * @date 2016/10/25
 * @description
 */
public class ClassEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Class clazz = null;

        try {
            clazz = Class.forName(text);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Invalid class name [" + text + "]: " + e.getMessage());
        }

        setValue(clazz);
    }
}
