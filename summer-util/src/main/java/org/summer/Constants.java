package org.summer;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/10 0010.
 */
public class Constants {

    private Map map = new HashMap();
    private final Class clazz;

    public Constants(Class clazz) {
        this.clazz = clazz;

        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            if (Modifier.isFinal(field.getModifiers())
                    && Modifier.isStatic(field.getModifiers())
                    && Modifier.isPublic(field.getModifiers())) {
                String name = field.getName();
                try {
                    Object value = field.get(null);
                    map.put(name, value);
                } catch (IllegalAccessException e) {

                }
            }
        }
    }


    public int getSize() {
        return this.map.size();
    }

    public int getInt(String code) {
        Object obj = getObject(code);
        if (!(obj instanceof Integer)) {
            throw new ConstantException(code, this.clazz, "not an int");
        }

        return ((Integer) obj).intValue();
    }

    public String getString(String code) {
        return getObject(code).toString();
    }

    public Object getObject(String code) {
        Object obj = this.map.get(code);
        if (obj == null) {
            throw new ConstantException(code, this.clazz, "not found");
        }
        return obj;
    }

}
