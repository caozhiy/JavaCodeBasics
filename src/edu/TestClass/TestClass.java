package edu.TestClass;

public class TestClass {
    public static void main(String[] args) throws Exception {
        f1();
    }

    public static void f1() throws ClassNotFoundException {
        Class<Student> clazz = Student.class;
        Class<?> aClass = Class.forName("edu.TestClass.Student");
        Class<? extends Student> xiaoming = new Student(165., 25, "小明").getClass();
        System.out.println(clazz);
        System.out.println(aClass);
        System.out.println(xiaoming);
    }
}
