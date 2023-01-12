package com.pengo.jvm_pratice.engine;

/**
 * 单分派、多分派演示
 * @author Benpeng
 * @date 2022/12/26
 */
public class Dispatch {
    static class QQ{}
    static class _360{}

    public static class Father{
        public void hardChoice(QQ arg) {
            System.out.println("father choose qq");
        }

        public void hardChoice(_360 arg) {
            System.out.println("father choose 360");
        }
    }

    public static class Son extends Father{
        @Override
        public void hardChoice(QQ arg) {
            System.out.println("son choose QQ");
        }

        @Override
        public void hardChoice(_360 arg) {
            System.out.println("son choose 360");
        }
    }

    public static void main(String[] args) {
        Father father = new Father();
        Son son = new Son();
        father.hardChoice(new _360());
        son.hardChoice(new QQ());
    }
}
