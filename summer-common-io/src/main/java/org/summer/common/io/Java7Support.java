package org.summer.common.io;

import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/11/21 0021.
 */
public final class Java7Support {

    private static boolean IS_JAVA7;

    private static Method isSymbolicLink;

    private static Method delete;

    private static Method toPath;

    private static Method exists;

    private static Method toFile;

    private static Method readSymlink;

    private static Method createSymlink;

    private static Object emptyLinkOpts;

    private static Object emptyFileAttributes;

    static {
        IS_JAVA7 = true;
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        try {
            Class<?> files = cl.loadClass("java.nio.file.Files");
            Class<?> path = cl.loadClass("java.nio.file.Path");
            Class<?> fa = cl.loadClass("java.nio.file.attribute.FileAttribute");
            Class<?> linkOption = cl.loadClass("java.nio.file.LinkOption");
            isSymbolicLink = files.getMethod("isSymbolicLink", path);
            delete = files.getMethod("delete", path);
            readSymlink = files.getMethod("readSymbolicLink", path);

            emptyFileAttributes = Array.newInstance(fa, 0);
            createSymlink = files.getMethod("createSymbolicLink", path, path, emptyFileAttributes.getClass());
            emptyLinkOpts = Array.newInstance(linkOption, 0);
            exists = files.getMethod("exists", path, emptyLinkOpts.getClass());
            toPath = File.class.getMethod("toPath");
            toFile = path.getMethod("toFile");
        } catch (ClassNotFoundException e) {
            IS_JAVA7 = false;
        } catch (NoSuchMethodException e) {
            IS_JAVA7 = false;
        }
    }


}
