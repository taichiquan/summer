package org.summer.beans.propertyeditors;

import java.beans.PropertyEditorSupport;

/**
 * @author yc
 * @date 2016/10/25
 * @description
 */
public class CustomBooleanEditor extends PropertyEditorSupport {

    private boolean allowEmpty;

    public CustomBooleanEditor(boolean allowEmpty){
        this.allowEmpty = allowEmpty;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (this.allowEmpty && text.trim().equals("")) {
            setValue(null);
        }

        if (text.equalsIgnoreCase("true")) {
            setValue(Boolean.TRUE);
        } else if (text.equalsIgnoreCase("false")) {
            setValue(Boolean.FALSE);
        }else{
            throw new IllegalArgumentException("Invalid Boolean value [\" + text + \"]");
        }
    }
}
