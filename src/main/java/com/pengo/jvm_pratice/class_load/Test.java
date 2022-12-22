package com.pengo.jvm_pratice.class_load;

/**
 * @author Benpeng
 * @date 2022/12/20
 */
public class Test {
    static {
        //编译报错：Illegal forward reference
        A = 0;
//        System.out.println(A);
    }
    static int A = 1;

    public static void main(String[] args) {
        System.out.println(A);
    }

}
