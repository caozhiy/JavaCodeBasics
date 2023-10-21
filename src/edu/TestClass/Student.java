package edu.TestClass;

import java.util.Arrays;

public class Student extends Thread {

    private static final String[] time;

    static {
        time = new String[]{"User", "Name", "Age", "Sex", "Nationality"};
        for (String t :
                time) {
            System.out.printf("%-10s\t", t);
        }
        System.out.println();
    }

    public final double sum;
    public int val;
    protected Double task;
    Integer value;
    private String name;

    {
        sum = 19;
        val = 25;
        value = 15;
        System.out.printf("sum = %+5.3f, val = %+4d, value = %-4d\n", sum, val, value);
//        task = 3;  报错,提示是需要double类型,而不是int类型
    }

    public Student(Double task, Integer value, String name) {
        this.task = task;
        this.value = value;
        this.name = name;
    }

    public static void staticMethod() {
        System.out.println(Arrays.toString(time));
    }

    @Override
    public String toString() {
        return "Student{" +
                "sum=" + sum +
                ", val=" + val +
                ", task=" + task +
                ", value=" + value +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public void run() {
        System.out.println(this);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
