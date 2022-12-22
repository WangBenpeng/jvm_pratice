package com.pengo.jvm_pratice.class_load;

/**
 * 字段解析
 * @author Benpeng
 * @date 2022/12/20
 */
public class FieldResolution {
    interface Interface0{
        int A = 0;
    }

    interface Interface1 extends Interface0{
        int A = 1;
    }

    interface Interface2{
        int A = 2;
    }

    static class Parent implements Interface1{
        public static int A = 3;
    }

    static class Sub extends Parent implements Interface2{
        //如果注释掉，会编译失败，Reference to 'A' is ambiguous, both 'Parent.A' and 'Interface2.A' match
        public static int A = 4;
    }

    public static void main(String[] args) {
        System.out.println(Sub.A);
    }
}
