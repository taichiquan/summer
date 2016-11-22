package org.summer.common.io.comparator;

import org.junit.Before;

import java.io.File;

/**
 * Created by Administrator on 2016/11/21 0021.
 */
public class DefaultFileComparatorTest extends ComparatorAbstractTestCase{

    @Before
    public void setUp() {
        comparator = (AbstractFileComparator) DefaultFileComparator.DEFAULT_FILE_COMPARATOR;
        reverse = DefaultFileComparator.REVERSE_COMPARATOR;
        equalFile1 = new File("foo");
        equalFile2 = new File("foo");
        lessFile   = new File("abc");
        moreFile   = new File("xyz");
    }
}
