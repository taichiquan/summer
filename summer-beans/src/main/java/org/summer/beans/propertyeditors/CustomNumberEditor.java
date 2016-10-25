package org.summer.beans.propertyeditors;

import java.beans.PropertyEditorSupport;
import java.text.NumberFormat;
import java.text.ParseException;

/**
 * @author yc
 * @date 2016/10/25
 * @description
 */
public class CustomNumberEditor extends PropertyEditorSupport {

    private Class clazz;
    private boolean allowEmpty;
    private NumberFormat numberFormat;

    public CustomNumberEditor(Class clazz, NumberFormat numberFormat, boolean allowEmpty) {
        if (!Number.class.isAssignableFrom(clazz)) {
            throw new IllegalArgumentException("Property class must be a subclass of Number");
        }

        this.clazz = clazz;
        this.numberFormat = numberFormat;
        this.allowEmpty = allowEmpty;
    }


    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (allowEmpty && text.trim().equals("")) {
            setValue(null);
        }else{
            try {
                Number number = this.numberFormat.parse(text);
                if (this.clazz.isInstance(number)) {
                    setValue(number);
                } else if (this.clazz.equals(Long.class)) {
                    setValue(new Long(number.longValue()));
                } else if (this.clazz.equals(Integer.class)) {
                    setValue(new Integer(number.intValue()));
                } else if (this.clazz.equals(Double.class)) {
                    setValue(new Double(number.doubleValue()));
                } else if (this.clazz.equals(Short.class)) {
                    setValue(new Short(number.shortValue()));
                } else if (this.clazz.equals(Float.class)) {
                    setValue(new Float(number.floatValue()));
                }else{
                    throw new IllegalArgumentException("Cannot convert [" + text + "] to [" + this.clazz + "]");
                }

            } catch (ParseException e) {
                throw new IllegalArgumentException("Cannot parse number: " + e.getMessage());
            }
        }
    }


    @Override
    public String getAsText() {
        return this.numberFormat.format(getValue());
    }
}
