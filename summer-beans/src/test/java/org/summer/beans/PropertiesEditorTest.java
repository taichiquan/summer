package org.summer.beans;

import org.junit.Test;
import org.summer.beans.propertyeditors.PropertiesEditor;

/**
 * Created by Administrator on 2016/11/10 0010.
 */
public class PropertiesEditorTest {

    @Test
    public void testPropertiesEditor() {
        PropertiesEditor propertiesEditor = new PropertiesEditor();
        propertiesEditor.setAsText("hierarchy classloader");

        System.out.println(propertiesEditor.getValue());
    }

    @Test
    public void testMapPropertiesEditor() {
        PropertiesEditor propertiesEditor = new PropertiesEditor();
        propertiesEditor.setAsText("hierarchy:classloader");
    }
}
