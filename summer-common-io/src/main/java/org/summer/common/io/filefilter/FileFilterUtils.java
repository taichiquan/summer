package org.summer.common.io.filefilter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/23 0023.
 */
public abstract class FileFilterUtils {

    public static File[] filter(final IOFileFilter filter,
                              final File... files) {
        if (files == null) {
            return new File[0];
        }

        if (filter == null) {
            throw new IllegalArgumentException("file filter is null");
        }

        final List<File> fileList = new ArrayList<File>();
        for (File file : files) {
            if (file == null) {
                throw new IllegalArgumentException("file array contains null");
            }
            if (filter.accept(file)) {
                fileList.add(file);
            }
        }

        return fileList.toArray(new File[fileList.size()]);
    }


}
