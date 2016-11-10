package org.summer.beans;

import org.junit.Assert;
import org.junit.Test;
import org.summer.beans.propertyeditors.StringArrayPropertyEditor;

/**
 * Created by Administrator on 2016/11/10 0010.
 */
public class StringArrayPropertyEditorTest {

    @Test
    public void testStingArrayPropertyEditor() {
        StringArrayPropertyEditor stringArrayPropertyEditor = new StringArrayPropertyEditor();
        stringArrayPropertyEditor.setAsText("qupaicloud,huanxin");
        String[] values = (String[]) stringArrayPropertyEditor.getValue();
        String[] tempValue = {"qupaicloud","huanxin"};
        Assert.assertArrayEquals(tempValue,values);
    }
}
