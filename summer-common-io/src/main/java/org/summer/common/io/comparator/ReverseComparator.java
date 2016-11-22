package org.summer.common.io.comparator;

import java.io.File;
import java.util.Comparator;

/**
 * Created by Administrator on 2016/11/21 0021.
 */
public class ReverseComparator extends AbstractFileComparator {

    private Comparator<File> delegate;

    public ReverseComparator(final Comparator<File> delegate) {
        if (delegate == null) {
            throw new IllegalArgumentException("Delegate comparator is missing");
        }
        this.delegate = delegate;
    }

    public int compare(File o1, File o2) {
        return delegate.compare(o1, o2);
    }

    @Override
    public String toString() {
        return super.toString() + "[" + delegate.toString() + "]";
    }
}
