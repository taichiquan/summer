package org.summer.beans;

import org.junit.Test;
import org.summer.beans.propertyeditors.CustomNumberEditor;

import java.text.NumberFormat;

/**
 * Created by Administrator on 2016/11/10 0010.
 */
public class CustomNumberEditorTest {

    @Test
    public void testCustomNumberEditor() {
        NumberFormat numberFormat = NumberFormat.getInstance();
        CustomNumberEditor customNumberEditor = new CustomNumberEditor(Long.class, numberFormat, true);

        customNumberEditor.setAsText("223,444");

        System.out.println(customNumberEditor.getValue());
    }
}
