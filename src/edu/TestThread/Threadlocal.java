package edu.TestThread;

public class Threadlocal {
    public static void main(String[] args) throws InterruptedException {
        ThreadLocal<String> local = new ThreadLocal<>();  //注意这是一个泛型类，存储类型为我们要存放的变量类型
        Thread t1 = new Thread(() -> {
            local.set("lbwnb");   //将变量的值给予ThreadLocal
            System.out.println("线程1变量值已设定！");
            try {
                Thread.sleep(2000);    //间隔2秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程1读取变量值:");
            System.out.println(local.get());   //尝试获取ThreadLocal中存放的变量
        });
        Thread t2 = new Thread(() -> {
            local.set("yyds");   //将变量的值给予ThreadLocal
            System.out.println("线程2变量值已设定！");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "读取变量值!");
            System.out.println(local.get());
        });
        t1.start();
        Thread.sleep(1000);    //间隔1秒
        t2.start();
    }
}
