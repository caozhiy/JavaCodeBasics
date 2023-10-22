package edu.TestAnnotation;

import edu.TestClass.TestClass;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@MyAnnotation("TestAnnotation for Class")
public class TestAnnotation {
    public static void main(String[] args) {
        test();
    }

    @MyAnnotation("static method annotation")
    public static void test() {

        // 获取类的注解
        Class<TestAnnotation> clazz = TestAnnotation.class;
        MyAnnotation annotation = clazz.getAnnotation(MyAnnotation.class);
        System.out.println(annotation.value());


        // 利用反射机制获取方法的注解
        try {
            Method method = clazz.getMethod("test");
            annotation = method.getAnnotation(MyAnnotation.class);
            System.out.println(annotation.value());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

}
