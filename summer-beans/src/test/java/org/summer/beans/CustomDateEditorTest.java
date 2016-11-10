package org.summer.beans;

import org.junit.Test;
import org.summer.beans.propertyeditors.CustomDateEditor;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/11/10 0010.
 */
public class CustomDateEditorTest {

    @Test
    public void testCustomDateEditorTest() {
        DateFormat dateFormat = DateFormat.getDateInstance();
        CustomDateEditor customDateEditor = new CustomDateEditor(dateFormat, true);
        customDateEditor.setAsText("2016-11-10");

        Date date = (Date) customDateEditor.getValue();

        System.out.println(date);
        System.out.println(customDateEditor.getAsText());
    }
}
