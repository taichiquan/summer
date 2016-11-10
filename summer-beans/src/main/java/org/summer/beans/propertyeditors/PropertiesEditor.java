package org.summer.beans.propertyeditors;

import java.beans.PropertyEditorSupport;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Administrator on 2016/11/10 0010.
 */
public class PropertiesEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null) {
            throw new IllegalArgumentException("Cannot set properties to null");
        }

        Properties properties = new Properties();
        try {
            properties.load(new ByteArrayInputStream(text.getBytes("ISO-8859-1")));
        } catch (IOException e) {
            throw new IllegalArgumentException(
                    "Failed to parse [" + text + "] into Properties", e);
        }

        setValue(properties);
    }


    @Override
    public void setValue(Object value) {
        if (!(value instanceof Properties)
                && (value instanceof Map)) {
            Properties properties = new Properties();
            properties.putAll((Map<?, ?>) value);
            super.setValue(properties);
        }else{
            super.setValue(value);
        }
    }
}
