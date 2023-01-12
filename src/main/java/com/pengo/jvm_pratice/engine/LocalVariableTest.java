package com.pengo.jvm_pratice.engine;

/**
 * @author Benpeng
 * @date 2022/12/22
 */
public class LocalVariableTest {
    public static void main(String[] args) {
        {
            byte[] placeHolder = new byte[64 * 1024 * 1024];
        }
        int a = 0;
        System.gc();
//        int b;
//        System.out.println(b);
    }
}
