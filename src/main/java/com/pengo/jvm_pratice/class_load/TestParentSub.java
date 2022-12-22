package com.pengo.jvm_pratice.class_load;

/**
 * @author Benpeng
 * @date 2022/12/20
 */
public class TestParentSub {
    static class Parent{
        public static int A = 1;
        static {
            A = 2;
        }
    }

    static class Sub extends Parent{
        public static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Sub.B);
    }
}
