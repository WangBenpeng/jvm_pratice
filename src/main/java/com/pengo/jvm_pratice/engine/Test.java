package com.pengo.jvm_pratice.engine;

/**
 * @author Benpeng
 * @date 2022/12/30
 */
public class Test {
    public static void main(String[] args) {
        calc();
    }

    /**
     * javap -c *.class 查看字节码
     * @return
     */
    public static int calc() {
        int a = 100;
        int b = 200;
        int c = 300;
        return a + b * c;
    }
}
