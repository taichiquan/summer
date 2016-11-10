package org.summer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Administrator on 2016/11/10 0010.
 */
public class ConstantsTest extends BaseTest{

    private Constants constants;

    @Before
    public void setUp() {
         constants = new Constants(Person.class);
    }

    @Test
    public void testConstantsConstruct() {
        Assert.assertEquals(2, constants.getSize());
    }

    @Test
    public void testGetObject() {
        Object value = constants.getObject("name");
        Assert.assertEquals("CHENYAO", value);
    }


    @Test
    public void testGetString() {
        String value = constants.getString("signature");
        Assert.assertEquals("chen jia gou", value);
    }
}
