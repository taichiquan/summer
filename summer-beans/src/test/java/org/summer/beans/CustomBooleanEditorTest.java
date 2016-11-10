package org.summer.beans;

import org.junit.Assert;
import org.junit.Test;
import org.summer.beans.propertyeditors.CustomBooleanEditor;

/**
 * Created by Administrator on 2016/11/10 0010.
 */
public class CustomBooleanEditorTest {

    @Test
    public void testTrueCustomBooleanEditor() {
        CustomBooleanEditor customBooleanEditor = new CustomBooleanEditor(true);
        customBooleanEditor.setAsText("true");

        Assert.assertEquals(Boolean.TRUE,customBooleanEditor.getValue());
    }

    @Test
    public void testFalseCustomBooleanEditor() {
        CustomBooleanEditor customBooleanEditor = new CustomBooleanEditor(true);
        customBooleanEditor.setAsText("FALSE");

        Assert.assertEquals(Boolean.FALSE,customBooleanEditor.getValue());
    }

    public void testNullCustomBooleanEditor() {
        CustomBooleanEditor customBooleanEditor = new CustomBooleanEditor(true);
        customBooleanEditor.setAsText("");
        Assert.assertEquals(null,customBooleanEditor.getValue());
    }
}
