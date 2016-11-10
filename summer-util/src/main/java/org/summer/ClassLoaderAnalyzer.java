package org.summer;

/**
 * Created by Administrator on 2016/11/10 0010.
 */
public abstract class ClassLoaderAnalyzer {


    public static String showClassLoaderHierarchy(Object obj,
                                                  String role,
                                                  String delim,
                                                  String tabTest) {
        String s = "object of " + obj.getClass() + ": role is " + role + delim;
        return s += showClassLoaderHierarchy(obj.getClass().getClassLoader(), delim, tabTest, 0);
    }


    public static String showClassLoaderHierarchy(ClassLoader classLoader,
                                                  String delim,
                                                  String tabText,
                                                  int indent) {
        if (classLoader == null) {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            return "Context class loader=" + contextClassLoader + " hashCode=" + contextClassLoader.hashCode();
        }

        String s = "";
        for(int i = 0; i< indent; i++) {
            s += tabText;
        }
        s += classLoader + " hashCode=" + classLoader.hashCode() + delim;
        ClassLoader parent = classLoader.getParent();
        return showClassLoaderHierarchy(parent, delim, tabText, indent + 1);
    }
}
