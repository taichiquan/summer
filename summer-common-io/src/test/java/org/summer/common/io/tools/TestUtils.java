package org.summer.common.io.tools;

import org.junit.Assert;
import org.summer.common.io.FileUtils;
import org.summer.common.io.IOUtils;

import java.io.*;
import java.util.Arrays;

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


    public static File newFile(final File testDirectory, final String name) throws IOException {
        final File file = new File(testDirectory, name);
        if (file.exists()) {
            FileUtils.forceDelete(file);
        }
        return file;
    }


    public static void checkFile(final File file) {
        Assert.assertTrue(file.exists());

    }


    private static void assertEqualsContent(final File f0, final File f1) {
        try{
            final InputStream is0 = new FileInputStream(f0);
            final InputStream is1 = new FileInputStream(f1);

            final byte[] buf0 = new byte[1024];
            final byte[] buf1 = new byte[1024];

            int n0 = 0,n1;
            while (-1 != n0) {
                try {
                    n0 = is0.read(buf0);
                    n1 = is1.read(buf1);

                    Assert.assertTrue(n0 == n1);
                    Assert.assertTrue(Arrays.equals(buf0, buf1));

                } catch (IOException e) {

                }finally {
                    IOUtils.closeQuietly(is0);
                    IOUtils.closeQuietly(is1);
                }
            }

        }catch (FileNotFoundException e) {

        }
    }

    public static void sleep(long ms) throws InterruptedException {
        long finishAt = System.currentTimeMillis() + ms;
        long remaining = ms;
        do {
            Thread.sleep(remaining);
            remaining = finishAt - System.currentTimeMillis();
        } while (remaining > 0);
    }

}
