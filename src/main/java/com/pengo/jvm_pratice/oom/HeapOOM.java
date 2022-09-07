package com.pengo.jvm_pratice.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * Java堆溢出
 * @author benpeng
 * @date 2022/9/6 23:36
 */
public class HeapOOM {
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
            System.out.println(list.size());
        }
    }

    static class OOMObject {
    }
}
