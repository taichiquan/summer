package org.summer.common.io.comparator;

import org.junit.After;
import org.junit.Test;
import org.summer.common.io.FileUtils;
import org.summer.common.io.tools.FileBasedTestCase;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;
import static junit.framework.TestCase.assertSame;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Administrator on 2016/11/14 0014.
 */
public abstract class ComparatorAbstractTestCase extends FileBasedTestCase {

    /** comparator instance */
    protected AbstractFileComparator comparator;

    /** reverse comparator instance */
    protected Comparator<File> reverse;

    /** File which compares equal to  "equalFile2" */
    protected File equalFile1;

    /** File which compares equal to  "equalFile1" */
    protected File equalFile2;

    /** File which is less than the "moreFile" */
    protected File lessFile;

    /** File which is more than the "lessFile" */
    protected File moreFile;

    /** @see junit.framework.TestCase#tearDown() */
    @After
    public void tearDown() throws Exception {
        comparator = null;
        reverse = null;
        equalFile1 = null;
        equalFile2 = null;
        lessFile = null;
        moreFile = null;
        FileUtils.deleteDirectory(getTestDirectory());
    }

    /**
     * Test the comparator.
     */
    @Test
    public void testComparator() {
        assertEquals("equal", 0, comparator.compare(equalFile1, equalFile2));
        assertTrue("less",  comparator.compare(lessFile, moreFile) < 0);
        assertTrue("more",  comparator.compare(moreFile, lessFile) > 0);
    }

    /**
     * Test the comparator reversed.
     */
    @Test
    public void testReverseComparator() {
        assertEquals("equal", 0, reverse.compare(equalFile1, equalFile2));
        assertTrue("less",  reverse.compare(moreFile, lessFile) < 0);
        assertTrue("more",  reverse.compare(lessFile, moreFile) > 0);
    }

    /**
     * Test comparator array sort is null safe.
     */
    @Test
    public void testSortArrayNull() {
        assertNull(comparator.sort((File[])null));
    }

    /**
     * Test the comparator array sort.
     */
    @Test
    public void testSortArray() {
        final File[] files = new File[3];
        files[0] = equalFile1;
        files[1] = moreFile;
        files[2] = lessFile;
        comparator.sort(files);
        assertSame("equal", lessFile, files[0]);
        assertSame("less",  equalFile1, files[1]);
        assertSame("more",  moreFile, files[2]);
    }



    /**
     * Test the comparator array sort.
     */
    @Test
    public void testSortList() {
        final List<File> files = new ArrayList<File>();
        files.add(equalFile1);
        files.add(moreFile);
        files.add(lessFile);
        comparator.sort(files);
        assertSame("equal", lessFile, files.get(0));
        assertSame("less",  equalFile1, files.get(1));
        assertSame("more",  moreFile, files.get(2));
    }

    /**
     * Test comparator list sort is null safe.
     */
    @Test
    public void testSortListNull() {
        assertNull(comparator.sort((List<File>)null));
    }

    /**
     * Test comparator toString.
     */
    @Test
    public void testToString() {
        assertNotNull("comparator", comparator.toString());
        assertTrue("reverse", reverse.toString().startsWith("ReverseComparator["));
    }

}
