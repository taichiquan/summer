package org.summer;

/**
 * Created by Administrator on 2016/11/10 0010.
 */
public class ConstantException extends IllegalArgumentException {

    public ConstantException(String field, Class clazz, String message) {
        super("Field '" + field + "' " + message + " in " + clazz);
    }
}
