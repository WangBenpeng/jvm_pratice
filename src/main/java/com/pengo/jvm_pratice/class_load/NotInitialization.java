package com.pengo.jvm_pratice.class_load;

/**
 * 非主动使用类字段演示
 * @author benpeng
 * @date 2022/11/21 16:06
 */
public class NotInitialization {
    public static void main(String[] args) {
        test3();
    }

    /**
     * 被动使用类字段演示三:
     * 常量在编译阶段会存入调用类的常量池中，本质上没有直接引用到定义常量的类，因此不会触发定义常量的
     * 类的初始化
     */
    static void test3() {
        System.out.println(ConstClass.HELLOWORLD);
    }

    /**
     * 被动使用类字段演示二:
     * 通过数组定义来引用类，不会触发此类的初始化
     */
    static void test2() {
        SuperClass[] sca = new SuperClass[10];
    }

    /**
     * 被动使用类字段演示一:
     * 通过子类引用父类的静态字段，不会导致子类初始化
     */
    static void test1() {
        System.out.println(SubClass.value);
    }
}

class SuperClass {
    static {
        System.out.println("SuperClass init!");
    }

    public static int value = 123;
}

class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init!");
    }
}

class ConstClass{
    static {
        System.out.println("ConstClass init!");
    }

    public static final String HELLOWORLD = "hello world!";
}