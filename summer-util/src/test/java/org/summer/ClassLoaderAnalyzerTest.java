package org.summer;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/11/10 0010.
 */
public class ClassLoaderAnalyzerTest extends BaseTest {

    public void testShowNullClassLoaderHierarchy() {
        String hierarchy = ClassLoaderAnalyzer.showClassLoaderHierarchy(null, "", "", 0);
        System.out.println("no classloader " + hierarchy);
        Assert.assertNotNull(hierarchy);

    }

    @Test
    public void testShowClassLoaderHierarchy() {
        String hierarchy = ClassLoaderAnalyzer.showClassLoaderHierarchy(new String().getClass().getClassLoader(), "<br>", "-", 0);
        System.out.println(hierarchy);
        Assert.assertNotNull(hierarchy);
    }

    @Test
    public void testStringShowClassLoaderHierarchy() {
        String hierarchy = ClassLoaderAnalyzer.showClassLoaderHierarchy(new String(), "new String", "<br>", "-");
        print(hierarchy);

    }

    @Test
    public void testArrayListShowClassLoaderHierarchy() {
        String hierarchy = ClassLoaderAnalyzer.showClassLoaderHierarchy(new ArrayList(), "array list", "<br>", "-");
        print(hierarchy);
    }
}
