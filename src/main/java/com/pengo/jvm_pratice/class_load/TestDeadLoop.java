package com.pengo.jvm_pratice.class_load;

/**
 * @author Benpeng
 * @date 2022/12/20
 */
public class TestDeadLoop {
    static class DeadLoopClass{
        static {
            // 如果不加上这个if语句，编译器将提示“Initializer does not complete normally” 并拒绝编译
            if (true) {
                System.out.println(Thread.currentThread() + " init DeadLoopClass");
                while (true){}
            }
        }
    }

    public static void main(String[] args) {
        Runnable script = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " started");
                DeadLoopClass deadLoopClass = new DeadLoopClass();
                System.out.println(Thread.currentThread() + " run over");
            }
        };

        Thread thread1 = new Thread(script);
        Thread thread2 = new Thread(script);

        thread1.start();
        thread2.start();
    }
}
