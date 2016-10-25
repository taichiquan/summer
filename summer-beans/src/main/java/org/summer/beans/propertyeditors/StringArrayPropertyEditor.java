package org.summer.beans.propertyeditors;

import org.summer.StringUtils;

import java.beans.PropertyEditorSupport;

/**
 * @author yc
 * @date 2016/10/25
 * @description
 */
public class StringArrayPropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[] array = StringUtils.commaDelimitedListToStringArray(text);
        setValue(array);
    }

}
