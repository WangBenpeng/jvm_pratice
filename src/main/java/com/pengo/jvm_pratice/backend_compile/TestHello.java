package com.pengo.jvm_pratice.backend_compile;

/**
 * @author Benpeng
 * @date 2023/1/5
 */
public class TestHello {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    static class B {
        int value;
        final int get() {
            return value;
        }
    }

    public void foo() {
        B b = new B();
        int y = b.value;
        System.out.println("Hello World!");
    }

}
