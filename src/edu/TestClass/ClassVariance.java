package edu.TestClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ClassVariance {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException,
            InvocationTargetException, NoSuchMethodException, ClassNotFoundException {
        String name = "xiaoming";
        System.out.println(name instanceof String);
        System.out.println(name.getClass() == String.class);
        Double[] q = {3.5e6};
        System.out.println(q.getClass().getSuperclass());
        for (Class<?> anInterface : q.getClass().getInterfaces()) {
            System.out.println(anInterface);
        }

        ClassVariance.test();

        // 使用类中的方法
        method();

        // 使用类中的字段
        method2();

    }

    public static void method2() {
        try {
            Class<?> clazz = Class.forName("edu.TestClass.Teacher");
            Object o = clazz.newInstance();
            Field field = clazz.getDeclaredField("ch");
            field.setAccessible(true);
            field.set(o, 'D');
            Method method = clazz.getMethod("getCh");
            System.out.println(method.invoke(o, null));
        } catch (ClassNotFoundException | NoSuchFieldException |
                 InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }


    }


    public static void test() throws InstantiationException, IllegalAccessException,
            NoSuchMethodException, InvocationTargetException {
        Class<Teacher> clazz = Teacher.class;
        Teacher teacher = clazz.newInstance();

        teacher.test();

        // 新的构造方法
        Constructor<Teacher> constructor = clazz.getConstructor(String.class, int.class);
        Teacher teacher1 = constructor.newInstance("xiaoliang", 20);
        teacher1.test();

        // 如果构造方法不是public的
        Constructor<Teacher> declaredConstructor = clazz.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        Teacher teacher2 = declaredConstructor.newInstance("LI");
        teacher2.test();


    }

    /*
     * 如果构造方法不是public的，就会出现IllegalAccessException
     * 如果构造方法没有无参的，就会有InstantiationException
     * 如果Class.forName没找到这个类，就会出现ClassNotFoundException*/
    public static void method() throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // 使用类中的方法
        Class<?> clazz = Class.forName("edu.TestClass.Teacher");
        Object o = clazz.getConstructor(String.class, int.class).newInstance("Li Gang", 38);

        Method method = clazz.getMethod("test");
        method.invoke(o, null);
        method = clazz.getDeclaredMethod("getSum");
        System.out.println(Arrays.toString(method.getTypeParameters()));
        method.invoke(o, null);
        method = clazz.getDeclaredMethod("getSum2");
        method.setAccessible(true);
        method.invoke(o, null);
        method = clazz.getDeclaredMethod("getParmeter", String[].class);
        method.setAccessible(true);
        String[] str = {"new ", "world ", "time", "day"};
        method.invoke(o, (Object) str);
        System.out.println(method.getReturnType());
        System.out.println(Arrays.toString(method.getParameterTypes()));
    }


}

class Teacher {
    private static double sum = 3.5;
    private final Character ch;
    private int age;
    private String name;

    {
        name = "xiaogang";
        age = 18;
        ch = 'A';
    }

    public Teacher() {
    }

    private Teacher(String name) {
        this.name = name;
    }

    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static double getSum() {
        System.out.println(sum);
        return sum *= 2;
    }

    private static double getSum2() {
        System.out.println("Get private sum = " + sum);
        return sum;
    }

    public Character getCh() {
        return ch;
    }

    private String getParmeter(String... arrs) {
        StringBuilder builder = new StringBuilder();
        for (String s :
                arrs) {
            System.out.println(s);
            builder.append(s);
        }

        return " ".concat(builder.toString());
    }

    public void test() {
        System.out.println(name + ":lbwnb!");
    }
}
