package org.summer.beans;

import java.beans.MethodDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author yc
 * @date 2016/10/25
 * @description
 */
public class CashedIntrospectionResultTest {

    public void testForClass() throws InvocationTargetException, IllegalAccessException {
        CashedIntrospectionResult result = CashedIntrospectionResult.forClass(Person.class);

        MethodDescriptor descriptor = result.getMethodDescriptor("getName");
        Method method = descriptor.getMethod();

        Person person = new Person("chenyao", 29);

        method.invoke(person, null);
    }

    class Person{

        public Person(String name, int age) {
            this.name = name;
            this.age = age;

        }

        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
