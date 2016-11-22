package org.summer.common.io;

import java.io.*;

/**
 * Created by Administrator on 2016/11/14 0014.
 */
public abstract class FileUtils {

    public static File getFile(final File directory, final String... names) {
        if (directory == null) {
            throw new NullPointerException("directory must not be null");
        }
        if (names == null) {
            throw new NullPointerException("names must not be null");
        }

        File file = directory;
        for (String name : names) {
            file = new File(file, name);
        }

        return file;
    }



    public static void forceDelete(final File file) throws IOException {
        if (file.isDirectory()) {
            // delete directory
        }else{

            if (!file.exists()) {
                throw new FileNotFoundException("File does not exist: " + file);
            }

            if (!file.delete()) {
                final String message =
                        "Unable to delete file: " + file;
                throw new IOException(message);
            }
        }
    }

    public static void deleteDirectory(final File directory) {

    }
}
