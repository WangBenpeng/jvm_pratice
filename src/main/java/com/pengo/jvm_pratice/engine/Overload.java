package com.pengo.jvm_pratice.engine;

import java.io.Serializable;

/**
 * @author Benpeng
 * @date 2022/12/26
 */
public class Overload {
    public static void sayHello(Object arg) {
        System.out.println("Hello Object");
    }
    public static void sayHello(int arg) {
        System.out.println("Hello int");
    }
    public static void sayHello(long arg) {
        System.out.println("Hello long");
    }
    public static void sayHello(Character arg) {
        System.out.println("Hello Character");
    }
    public static void sayHello(char arg) {
        System.out.println("Hello char");
    }
    public static void sayHello(char... arg) {
        System.out.println("Hello char...");
    }
    public static void sayHello(Serializable arg) {
        System.out.println("Hello Serializable");
    }

    public static void main(String[] args) {
        //方法选用顺序
        //char->int->long->charter->serial->object->char...
        sayHello('a');
    }
}
