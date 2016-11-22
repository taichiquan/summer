package org.summer.common.io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Administrator on 2016/11/21 0021.
 */
public class CompositerFileCompator extends AbstractFileComparator implements Serializable {

    private static final Comparator<?>[] NO_COMPARATOS = {};
    private Comparator<File>[] delegates;

    public CompositerFileCompator(Comparator<File>... delegates) {
        if (delegates == null) {
            this.delegates = (Comparator<File>[]) NO_COMPARATOS;
        }
        this.delegates = (Comparator<File>[]) new Comparator<?>[delegates.length];
        System.arraycopy(delegates, 0, this.delegates, 0, this.delegates.length);
    }


    public CompositerFileCompator(final Iterable<Comparator<File>> iterable) {
        if (iterable == null) {
            this.delegates = (Comparator<File>[]) NO_COMPARATOS;
        }

        final List<Comparator<File>> comparatorList = new ArrayList<Comparator<File>>();
        for (Comparator<File> comparator : iterable) {
            comparatorList.add(comparator);
        }
        this.delegates = (Comparator<File>[]) comparatorList.toArray(new Comparator<?>[comparatorList.size()]);
    }


    public int compare(File o1, File o2) {
        int result = 0;
        for (final Comparator<File> delegate : delegates) {
            result = delegate.compare(o1, o2);
            if (result != 0) {
                break;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append('{');
        for (int i = 0; i < delegates.length; i++) {
            if (i > 0) {
                builder.append(',');
            }
            builder.append(delegates[i]);
        }
        builder.append('}');
        return builder.toString();
    }
}
