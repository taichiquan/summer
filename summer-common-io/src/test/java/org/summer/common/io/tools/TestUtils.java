package org.summer.common.io.tools;

import org.summer.common.io.IOUtils;

import java.io.*;

/**
 * Created by Administrator on 2016/11/16 0016.
 */
public abstract class TestUtils {

    public static void createFile(final File file, final long size) throws IOException {
        if (!file.getParentFile().exists()) {
            throw new IOException("Cannot create file" + file + "as the parent directory does not exists");
        }

        final BufferedOutputStream outputStream = new BufferedOutputStream(
                new FileOutputStream(file)
        );

        try{
            generateTestData(outputStream,size);
        }finally {
            IOUtils.closeQuietly(outputStream);
        }

    }


    public static byte[] generateTestData(final long size) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            generateTestData(byteArrayOutputStream,size);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return byteArrayOutputStream.toByteArray();
    }


    public static void generateTestData(final OutputStream outputStream, final long size) throws IOException {
        for(int i = 0; i< size; i++) {
            outputStream.write((byte) ((i % 127) + 1));
        }
    }


    public static void createLineBaseFile(final File file, final String[] data) throws IOException {
        if (file.getParentFile() != null && !file.getParentFile().exists()) {
            throw new IOException("");
        }

        final PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
        try{
            for (String element : data) {
                printWriter.println(element);
            }
        }finally {
            IOUtils.closeQuietly(printWriter);
        }
    }


    public static void newFile(final File testDirectory, final String name) {

    }
}
