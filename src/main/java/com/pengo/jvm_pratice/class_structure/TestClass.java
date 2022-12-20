package com.pengo.jvm_pratice.class_structure;

public class TestClass {
    private int m;
    public int inc() {
        return m + 1;
    }

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        System.out.println(testClass.inc2());
    }
    public int inc2() {
        int x;
        try {
            x = 1;
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
        }
    }

}
