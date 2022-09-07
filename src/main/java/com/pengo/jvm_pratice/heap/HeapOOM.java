package com.pengo.jvm_pratice.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author benpeng
 * @date 2022/9/6 23:36
 */
public class HeapOOM {
    public static void main(String[] args) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
            System.out.println(list.size());
        }
    }

    static class    OOMObject{}
}
