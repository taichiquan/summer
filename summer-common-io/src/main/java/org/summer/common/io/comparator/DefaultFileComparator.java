package org.summer.common.io.comparator;

import java.io.File;
import java.io.Serializable;

/**
 * Created by Administrator on 2016/11/21 0021.
 */
public class DefaultFileComparator extends AbstractFileComparator implements Serializable {

    public static final  DefaultFileComparator DEFAULT_FILE_COMPARATOR = new DefaultFileComparator();
    public static final ReverseComparator REVERSE_COMPARATOR = new ReverseComparator(DEFAULT_FILE_COMPARATOR);

    public int compare(File o1, File o2) {
        return o1.compareTo(o2);
    }

}
