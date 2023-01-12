package com.pengo.jvm_pratice.chapter12_concurrency;

/**
 * @author Benpeng
 * @date 2023/1/12
 */
public class StringTest {
    public static void main(String[] args) {
        concatString("a", "b", "c");
    }

    static String concatString(String s1, String s2, String s3) {
        return s1 + s2 + s3;
    }
}
