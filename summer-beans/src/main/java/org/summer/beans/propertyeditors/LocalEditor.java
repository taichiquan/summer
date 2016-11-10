package org.summer.beans.propertyeditors;

import org.summer.StringUtils;

import java.beans.PropertyEditorSupport;
import java.util.Locale;

/**
 * Created by Administrator on 2016/11/10 0010.
 */
public class LocalEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[] parts = StringUtils.delimitedListToStringArray(text, "_");
        String language = parts.length > 0 ? parts[0] : "";
        String country = parts.length > 1 ? parts[1] : "";
        String variant = parts.length > 2 ? parts[2] : "";
        setValue(language.length() > 0 ? new Locale(language, country, variant) : null);
    }
}
