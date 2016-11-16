package org.summer.common.io.tools;

import java.io.File;

/**
 * Created by Administrator on 2016/11/14 0014.
 */
public abstract class FileBasedTestCase {

    private static volatile File testDir;


    public static File getTestDirectory() {
        if (testDir == null) {
            testDir = new File("test/io/").getAbsoluteFile();
        }
        testDir.mkdirs();
        return testDir;
    }

}
