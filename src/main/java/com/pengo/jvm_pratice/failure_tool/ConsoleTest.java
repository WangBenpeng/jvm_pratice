package com.pengo.jvm_pratice.failure_tool;

import java.util.ArrayList;
import java.util.List;

/**
 * @author benpeng
 * @date 2022/11/11 10:40
 */
public class ConsoleTest {
    static class OOMObject{
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }
//        System.gc();
//        Thread.sleep(500);
    }
    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
        System.gc();
        Thread.sleep(1000);
    }
}
