package edu.programBasic;

// 这是文档注释

/**
 * @author caozhiyuan216
 * @since 2023.10.08
 */
public class Main {
    public static void func(String[] args) {
        System.out.println("Hello World!"); 
        System.out.println("YYDS!");
        
        String[] str = new String[10];
        for(int i = 0; i <str.length;i++){
            str[i] = new String( i * i); 
        }
        str.foreach(System.out::println);
        int a = 10, b = 15;
        System.out.println("a = " + a + ", b = " + b);
        final int c = 158;
        System.out.println(c);
    }
}
