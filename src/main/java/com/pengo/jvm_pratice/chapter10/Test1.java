package com.pengo.jvm_pratice.chapter10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Benpeng
 * @date 2023/1/3
 */
public class Test1 {
    public static void main(String[] args) {
        test4();
    }

    static void test4() {
        if (true) {
            System.out.println("block 1");
        } else {
            System.out.println("block 2");
        }
//        while (false) {
//            System.out.println("");
//        }
    }

    static void test3() {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d); //true
        System.out.println(e == f); //false
        System.out.println(c == (a + b)); //true
        System.out.println(c.equals(a + b)); //true
        System.out.println(g == (a + b)); //true
        System.out.println(g.equals(a + b));//false

    }

//    public static String method(List<String> list) {
//        System.out.println("invoke method(List<String> list)");
//        return "";
//    }
//    public static int method(List<Integer> list) {
//        System.out.println("invoke method(List<Integer> list)");
//        return 1;
//    }

    static void test2() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("hello", "你好");
        map.put("how are you?", "吃了没?");
        System.out.println(map.get("hello"));
        System.out.println(map.get("how are you?"));
    }

    static void test1() {
        Object[] arr = new String[10];
        arr[0] = 10;
        ArrayList things = new ArrayList();
        things.add(Integer.valueOf(10));
    }
}
