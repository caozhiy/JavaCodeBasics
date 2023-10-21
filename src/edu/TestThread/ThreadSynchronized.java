package edu.TestThread;

public class ThreadSynchronized {
    private static int value = 0;

    public static synchronized void f() {
        value -= 10;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                synchronized (ThreadSynchronized.class) {  //使用synchronized关键字创建同步代码块
                    value++;
                }
                if (i % 25 == 0)
                    f();
            }
            System.out.println("线程1完成");
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                synchronized (ThreadSynchronized.class) {
                    value++;
                }
                if (i % 25 == 0)
                    f();
            }
            System.out.println("线程2完成");
        });
        t1.start();
        t2.start();
        Thread.sleep(1000);  //主线程停止1秒，保证两个线程执行完成
        System.out.println(value);
    }
}
