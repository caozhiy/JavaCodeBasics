package edu.TestClass;

import java.util.Arrays;

public class TestClass {
    public static void main(String[] args) throws Exception {
        f1();
        System.out.println("====================\n");
        u();
        System.out.println("基本类型是否有class呢?");
        Class<Integer> clazz = int.class;
        System.out.println(clazz == Integer.TYPE);
        System.out.println(clazz == Integer.class);
    }

    public static void f1() throws ClassNotFoundException {
        Class<Student> clazz = Student.class;
        Class<?> aClass = Class.forName("edu.TestClass.Student");
        Class<?> xiaoming = new Student(165., 25, "小明").getClass();
        System.out.println(clazz);
        System.out.println(aClass);
        System.out.println(xiaoming);

        System.out.println("比较Class对象是否都一样？");
        System.out.println(aClass == clazz);
        System.out.println(aClass == xiaoming);
    }

    public static void u() {
        Class<String[]> clazz = String[].class;
        System.out.println(clazz.getName());
        System.out.println(Arrays.toString(clazz.getClasses()));
        System.out.println(clazz.getClassLoader());
        System.out.println(clazz.getTypeName());
        System.out.println(Arrays.toString(clazz.getAnnotations()));
    }
}
