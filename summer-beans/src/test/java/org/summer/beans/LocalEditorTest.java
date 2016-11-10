package org.summer.beans;

import org.junit.Test;
import org.summer.beans.propertyeditors.LocalEditor;

import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;

/**
 * Created by Administrator on 2016/11/10 0010.
 */
public class LocalEditorTest {

    @Test
    public void testLocalEditor() {
        LocalEditor localEditor = new LocalEditor();
        localEditor.setAsText(Locale.getDefault().toString());
        Properties properties = System.getProperties();
        Enumeration enumeration = properties.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
        System.out.println(localEditor.getValue());
    }
}
