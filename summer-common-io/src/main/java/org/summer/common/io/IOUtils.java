package org.summer.common.io;

import org.summer.common.io.output.StringBuilderWriter;

import java.io.*;

/**
 * Created by Administrator on 2016/11/14 0014.
 */
public abstract class IOUtils {

    private static final String LINE_SEPARATOR;

    static {
        final StringBuilderWriter stringBuilderWriter = new StringBuilderWriter();
        final PrintWriter printWriter = new PrintWriter(stringBuilderWriter);
        printWriter.println();
        LINE_SEPARATOR = stringBuilderWriter.toString();
        printWriter.close();
    }


    public static void closeQuietly(final Writer writer) {
        closeQuietly(writer);
    }

    public static void closeQuietly(final InputStream inputStream) {
        closeQuietly(inputStream);
    }

    public static void closeQuietly(final OutputStream outputStream) {
        closeQuietly(outputStream);
    }


    public static void closeQuietly(final Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (final IOException e) {

            }
        }
    }
}
