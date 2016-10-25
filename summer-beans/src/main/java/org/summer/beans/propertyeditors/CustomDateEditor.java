package org.summer.beans.propertyeditors;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;

/**
 * @author yc
 * @date 2016/10/25
 * @description
 */
public class CustomDateEditor extends PropertyEditorSupport {

    private boolean allowEmpty;
    private DateFormat dateFormat;

    public CustomDateEditor(DateFormat dateFormat, boolean allowEmpty) {
        this.dateFormat = dateFormat;
        this.allowEmpty = allowEmpty;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (allowEmpty && text.trim().equals("")) {
            setValue(null);
        }else{
            try {
                setValue(dateFormat.parse(text));
            } catch (ParseException e) {
                throw new IllegalArgumentException("Could not parse date: " + e.getMessage());
            }
        }
    }

    @Override
    public String getAsText() {
        return dateFormat.format(getValue());
    }
}
