package edu.TestThread;

public class TestThread {

    private static int val = 1;

    public static void main(String[] args) {
        f1();
    }

    /*
     * 测试线程之间的切换运行
     * */
    public static void f1() {
        new Thread(() -> {
            try {
                Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
                run();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.printf("%s: %d\n", Thread.currentThread().getName(), i);
        }

        new Thread(() -> {
            try {
                Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
                run();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();


    }

    public static void f2() {
        Thread t1 = new Thread(() -> {
            try {
                run();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "has been Interrupted!");
                throw new RuntimeException(e);
            }
        });

        t1.start();

        Thread t2 = new Thread(() -> {
            try {
                run();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "has been Interrupted!");
                throw new RuntimeException(e);
            }
        });

        t2.start();

        Thread t3 = new Thread(() -> {
            try {
                Thread.sleep(5000);
                t1.interrupt();
                t2.interrupt();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });


    }

    public static void run() throws InterruptedException {
        Thread t = Thread.currentThread();
        for (int i = 0; i < 100; i++) {
            Thread.sleep(200);
            System.out.printf("%s: %d\n", t.getName(), i);
            val = val + 1;

        }
    }
}
