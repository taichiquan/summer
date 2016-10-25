package org.summer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yc
 * @date 2016/10/25
 * @description
 */
public abstract class StringUtils {


    public static String[] commaDelimitedListToStringArray(String s) {
        return delimitedListToStringArray(s, ",");
    }

    public static String[] delimitedListToStringArray(String s, String delimiter) {
        if (s == null) {
            return new String[0];
        }

        if (delimiter == null) {
            return new String[]{s};
        }

        List l = new LinkedList();
        int delpos = 0;
        int pos = 0;

        while ((delpos = s.indexOf(delimiter, pos)) != -1) {
            l.add(s.substring(pos, delpos));
            pos = delpos + delimiter.length();
        }

        if (pos <= s.length()) {
            l.add(s.substring(pos));
        }

        return (String[]) l.toArray(new String[]{});

    }

}
