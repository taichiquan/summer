package org.summer;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author yc
 * @date 2016/10/25
 * @description
 */

public class StringUtilsTest {

    @Test
    public void testDelimitedListToStringArray() {
        String s = "abcde,hghak,dddd,";
        String[] as = StringUtils.delimitedListToStringArray(s, ",");

        Assert.assertEquals("","abcde",as[0]);
    }


    @Test
    public void testArrayToDelimitedString() {
        String[] arrays = {"adb","edf", "xxx"};
        Assert.assertEquals("adb-edf-xxx",StringUtils.arrayToDelimitedString(arrays, "-"));
    }
}
