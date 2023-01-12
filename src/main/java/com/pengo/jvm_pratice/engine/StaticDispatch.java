package com.pengo.jvm_pratice.engine;

/**
 * @author Benpeng
 * @date 2022/12/26
 */
public class StaticDispatch {
    static abstract class Human{}
    static class Man extends Human{}
    static class Woman extends Human{}

    public void sayHello(Human guy) {
        System.out.println("Hello, guy!");
    }
    public void sayHello(Man guy) {
        System.out.println("Hello, gentleman!");
    }
    public void sayHello(Woman guy) {
        System.out.println("Hello, Lady!");
    }

    public static void main(String[] args) {

        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch staticDispatch = new StaticDispatch();
        /**
         * 虚拟机(或者准确地说是编译器)在重载时是通过参数的静态类型而不是实际类型作为 判定依据的
         */
        //编译时为(Human)man 和 (Human)woman
        //输出guy
        staticDispatch.sayHello(man);
        staticDispatch.sayHello(woman);
        //gentleman
        staticDispatch.sayHello((Man) man);
        //lady
        staticDispatch.sayHello((Woman) woman);
    }

}
