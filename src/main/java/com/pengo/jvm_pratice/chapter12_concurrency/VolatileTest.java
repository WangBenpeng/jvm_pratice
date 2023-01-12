package com.pengo.jvm_pratice.chapter12_concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Benpeng
 * @date 2023/1/11
 */
public class VolatileTest {

    public static volatile AtomicInteger race = new AtomicInteger(0);
//    public static volatile int race = 0;

    public static void increase() {
        race.getAndIncrement();
//        race++;
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        increase();
                    }
                    System.out.println(race);
                }
            });
            threads[i].start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
//        for (int i = 0; i < threads.length; i++) {
//            threads[i].join();
//        }
        System.out.println(race);
    }
}
