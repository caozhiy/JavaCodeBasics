package edu.TestThread;

public class ThreadInterrupt {
    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            System.out.println("线程开始运行！");
            while (true) {
                if (Thread.currentThread().isInterrupted()) {   //判断是否存在中断标志
                    System.out.println("发现中断信号，复位，继续运行...");
                    Thread.interrupted();  //复位中断标记（返回值是当前是否有中断标记，这里不用管）
                    System.out.println(Thread.interrupted());
                    break;
                }
            }
            f();
        });

        t.start();

        try {
            Thread.sleep(3000);   //休眠3秒，一定比线程t先醒来
            t.interrupt();   //调用t的interrupt方法
            System.out.println("\n\n\n");
            u();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void f() {

        Thread t1 = new Thread(() -> {
            System.out.println("线程1开始运行！");
            for (int i = 0; i < 50; i++) {
                if (i % 7 == 0) {
                    System.out.println("让位！");
                    Thread.yield();
                }
                System.out.println("1打印：" + i);
            }
            System.out.println("线程1结束！");
        });


        Thread t2 = new Thread(() -> {
            System.out.println("线程2开始运行！");
            Thread t = Thread.currentThread();
            for (int i = 0; i < 50; i++) {
                System.out.println("2打印：" + i);
                if (i % 17 == 3) {
                    t.setPriority(Thread.MAX_PRIORITY);
                    System.out.println("线程2切换成最高优先级!");
                    System.out.println("线程2让位!");
                    Thread.yield();
                }
            }
        });

        Thread t3 = new Thread(() -> {
            System.out.println("线程3开始运行!");
            for (int i = 0; i < 30; i++) {
                try {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + "打印" + i);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " 遭到中断! 让位!");
                    Thread.yield();
                }
            }
        }, "线程3");

        t1.start();
        t2.start();
        t3.start();

        while (!t2.isAlive() || t1.isAlive()) {
            System.out.println(Thread.currentThread().getName() + "正在运行!");
            t3.interrupt();
            if (!t3.isAlive())
                break;
        }
    }

    public static void u() {

        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "开始运行！");
            for (int i = 0; i < 50; i++) {
                System.out.println(Thread.currentThread().getName() + "打印：" + i);
            }
            System.out.println("线程1结束！");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("线程2开始运行！");
            for (int i = 0; i < 50; i++) {
                System.out.println(Thread.currentThread().getName() + "打印：" + i);
                if (i == 10) {
                    try {
                        System.out.printf("线程%s加入到此线程!\n",t1.getName());
                        t1.join();    //在i==10时，让线程1加入，先完成线程1的内容，在继续当前内容
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        t2.start();

    }

}
