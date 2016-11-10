package org.summer.beans;

import org.junit.Assert;
import org.junit.Test;
import org.summer.beans.propertyeditors.ClassEditor;

/**
 * Created by Administrator on 2016/11/10 0010.
 */
public class ClassEditorTest {

    @Test
    public void testClassEditor() {
        ClassEditor classEditor = new ClassEditor();
        classEditor.setAsText(Person.class.getName());

        Class value = (Class) classEditor.getValue();

        Assert.assertEquals(Person.class,value);
    }
}
