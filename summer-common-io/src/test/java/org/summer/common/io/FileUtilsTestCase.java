package org.summer.common.io;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.summer.common.io.tools.FileBasedTestCase;
import org.summer.common.io.tools.TestUtils;

import java.io.*;
import java.math.BigInteger;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/11/22 0022.
 */
public class FileUtilsTestCase extends FileBasedTestCase {

    private final File testFile1;
    private final File testFile2;

    private final int testFile1Size;
    private final int testFile2Size;

    public FileUtilsTestCase() {
        testFile1 = new File(getTestDirectory(), "file1-test.txt");
        testFile2 = new File(getTestDirectory(), "file1a-test.txt");

        testFile1Size = (int) testFile1.length();
        testFile2Size = (int) testFile2.length();
    }


    @After
    public void setUp() throws IOException {

        getTestDirectory().mkdirs();
        if (!testFile1.getParentFile().exists()) {
            throw new IOException("Cannot create file " + testFile1
                    + " as the parent directory does not exist");
        }
        final BufferedOutputStream output3 =
                new BufferedOutputStream(new FileOutputStream(testFile1));
        try {
            TestUtils.generateTestData(output3, (long) testFile1Size);
        } finally {
            IOUtils.closeQuietly(output3);
        }
        if (!testFile2.getParentFile().exists()) {
            throw new IOException("Cannot create file " + testFile2
                    + " as the parent directory does not exist");
        }

        final BufferedOutputStream output2 =
                new BufferedOutputStream(new FileOutputStream(testFile2));
        try {
            TestUtils.generateTestData(output2, (long) testFile2Size);
        } finally {
            IOUtils.closeQuietly(output2);
        }
        FileUtils.deleteDirectory(getTestDirectory());
        getTestDirectory().mkdirs();
        if (!testFile1.getParentFile().exists()) {
            throw new IOException("Cannot create file " + testFile1
                    + " as the parent directory does not exist");
        }
        final BufferedOutputStream output1 =
                new BufferedOutputStream(new FileOutputStream(testFile1));
        try {
            TestUtils.generateTestData(output1, (long) testFile1Size);
        } finally {
            IOUtils.closeQuietly(output1);
        }
        if (!testFile2.getParentFile().exists()) {
            throw new IOException("Cannot create file " + testFile2
                    + " as the parent directory does not exist");
        }
        final BufferedOutputStream output =
                new BufferedOutputStream(new FileOutputStream(testFile2));
        try {
            TestUtils.generateTestData(output, (long) testFile2Size);
        } finally {
            IOUtils.closeQuietly(output);
        }
    }

    @After
    public void tearDown() throws Exception {
        FileUtils.deleteDirectory(getTestDirectory());
    }

    private String getName() {
        return this.getClass().getSimpleName();
    }

    @Test
    public void testGetFile() {
        final File expected_A = new File("src");
        final File expected_B = new File(expected_A, "main");
        final File expected_C = new File(expected_B, "java");

        Assert.assertEquals("A", expected_A, FileUtils.getFile("src"));
        Assert.assertEquals("B", expected_B, FileUtils.getFile("src", "main"));
        Assert.assertEquals("C", expected_C, FileUtils.getFile("src","main","java"));

        try {
            FileUtils.getFile((String[]) null);
            fail("Expected NullPointerException");
        } catch (final NullPointerException e) {
            // expected
        }
    }


    @Test
    public void testParentFile() {
        final File parent = new File("parent");
        final File excepted_A = new File(parent,"src");
        final File excepted_B = new File(excepted_A, "main");
        final File excepted_C = new File(excepted_B, "java");

        Assert.assertEquals("a", excepted_A, FileUtils.getFile(parent, "src"));
        Assert.assertEquals("b", excepted_B, FileUtils.getFile(parent,"src","main"));
        Assert.assertEquals("c", excepted_C, FileUtils.getFile(parent, "src", "main", "java"));

        try {
            FileUtils.getFile(parent, (String[]) null);
            fail("Expected NullPointerException");
        } catch (final NullPointerException e) {
            // expected
        }
        try {
            FileUtils.getFile((File) null, "src");
            fail("Expected NullPointerException");
        } catch (final NullPointerException e) {
            // expected
        }
    }

    @Test
    public void testGetTempDirectoryPath() {
        Assert.assertEquals(System.getProperty("java.io.tmpdir"), FileUtils.getTempDirectoryPath());
        System.out.println(FileUtils.getTempDirectoryPath());
    }

    @Test
    public void testGetTempDirectory() {
        Assert.assertEquals(new File(System.getProperty("java.io.tmpdir")), FileUtils.getTempDirectory());
    }

    @Test
    public void testUserDirectoryPath() {
        Assert.assertEquals(System.getProperty("user.home"),
                FileUtils.getUserDirectoryPath());

        System.out.println(FileUtils.getUserDirectoryPath());
    }

    @Test
    public void testUserDirectory() {
        Assert.assertEquals(new File(System.getProperty("user.home")),
                FileUtils.getUserDirectory());
    }

    @Test
    public void testOpenInputStream() throws IOException {
        final File file = new File(getTestDirectory(), "test.txt");
        TestUtils.createLineBaseFile(file, new String[]{"hello world"});

        FileInputStream in = null;

        try{
            in = FileUtils.openInputStream(file);
            Assert.assertEquals('h',in.read());
        }finally {
            IOUtils.closeQuietly(in);
        }
    }

    @Test
    public void testOpenInputStreamExitsButIsDirectory() throws IOException {
        final File directory = new File(getTestDirectory(), "subdir");
        directory.mkdirs();

        FileInputStream in = null;
        try{
            in = FileUtils.openInputStream(directory);
            fail();
        } catch (final IOException ioe) {
            // expected
        }finally {
            IOUtils.closeQuietly(in);
        }
    }


    private void openOutputStreamNoParent(boolean createFile) throws IOException {
        final File file = new File("test.txt");
        assertNull(file.getParentFile());

        try{
            if (createFile) {
                TestUtils.createLineBaseFile(file, new String[]{"hello"});
            }
            FileOutputStream out = null;
            try{
                out = FileUtils.openOutputStream(file);
                out.write(0);
            }finally {
                IOUtils.closeQuietly(out);
            }
            assertTrue(file.exists());
        }finally {
            if (!file.delete()) {
                file.deleteOnExit();
            }
        }
    }

    @Test
    public void testOpenOutStreamNoParentCreateFile() throws IOException {
        openOutputStreamNoParent(true);
    }

    @Test
    public void testOpenOutStreamNoParentNoFile() throws IOException {
        openOutputStreamNoParent(false);
    }


    @Test
    public void test_openOutputStream_notExistsCannotCreate() throws Exception {
        // according to Wikipedia, most filing systems have a 256 limit on filename
        final String longStr =
                "abcdevwxyzabcdevwxyzabcdevwxyzabcdevwxyzabcdevwxyz" +
                        "abcdevwxyzabcdevwxyzabcdevwxyzabcdevwxyzabcdevwxyz" +
                        "abcdevwxyzabcdevwxyzabcdevwxyzabcdevwxyzabcdevwxyz" +
                        "abcdevwxyzabcdevwxyzabcdevwxyzabcdevwxyzabcdevwxyz" +
                        "abcdevwxyzabcdevwxyzabcdevwxyzabcdevwxyzabcdevwxyz" +
                        "abcdevwxyzabcdevwxyzabcdevwxyzabcdevwxyzabcdevwxyz";  // 300 chars
        final File file = new File(getTestDirectory(), "a/" + longStr + "/test.txt");
        FileOutputStream out = null;
        try {
            out = FileUtils.openOutputStream(file);
            fail();
        } catch (final IOException ioe) {
            ioe.printStackTrace();
            // expected
        } finally {
            IOUtils.closeQuietly(out);
        }
    }


    @Test
    public void testByteCountToDisplaySizeBigInteger() {
        final BigInteger b1023 = BigInteger.valueOf(1023);
        final BigInteger b1025 = BigInteger.valueOf(1025);
        final BigInteger KB1 = BigInteger.valueOf(1024);
        final BigInteger MB1 = KB1.multiply(KB1);
        final BigInteger GB1 = MB1.multiply(KB1);
        final BigInteger GB2 = GB1.add(GB1);
        final BigInteger TB1 = GB1.multiply(KB1);
        final BigInteger PB1 = TB1.multiply(KB1);
        final BigInteger EB1 = PB1.multiply(KB1);

        assertEquals(FileUtils.byteCountToDisplaySize(GB2), "2 GB");
        assertEquals(FileUtils.byteCountToDisplaySize(GB2.subtract(BigInteger.ONE)), "1 GB");
        assertEquals(FileUtils.byteCountToDisplaySize(TB1), "1 TB");
        assertEquals(FileUtils.byteCountToDisplaySize(PB1), "1 PB");
        assertEquals(FileUtils.byteCountToDisplaySize(EB1), "1 EB");
        assertEquals(FileUtils.byteCountToDisplaySize(BigInteger.valueOf(Long.MAX_VALUE)), "7 EB");
        // Other MAX_VALUEs
        assertEquals(FileUtils.byteCountToDisplaySize(BigInteger.valueOf(Character.MAX_VALUE)), "63 KB");
        assertEquals(FileUtils.byteCountToDisplaySize(BigInteger.valueOf(Short.MAX_VALUE)), "31 KB");
        assertEquals(FileUtils.byteCountToDisplaySize(BigInteger.valueOf(Integer.MAX_VALUE)), "1 GB");
    }


}
