package edu.programBasic;

// 这是文档注释

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author caozhiyuan216
 * @since 2023.10.08
 */
public class Main {
    public static void func(String[] args) {
        System.out.println("Hello World!");
        System.out.println("YYDS!");

        String[] str = new String[10];
        Arrays.fill(str, "Hello world!");
        List<String> stringList = Arrays.stream(str)
                .map(s -> s + s.length())
                .collect(Collectors.toList());
        stringList.forEach(System.out::println);
        int a = 10, b = 15;
        System.out.println("a = " + a + ", b = " + b);
        final int c = 158;
        System.out.println(c);
    }
}
