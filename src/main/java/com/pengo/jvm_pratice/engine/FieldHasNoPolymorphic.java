package com.pengo.jvm_pratice.engine;

/**
 * 字段不参与多态
 * @author Benpeng
 * @date 2022/12/26
 */
public class FieldHasNoPolymorphic {
    static class Father{
        public int money = 1;

        public Father() {
            money = 2;
            showMeTheMoney();
        }

        public void showMeTheMoney() {
            System.out.println("I am Father, I have $" + money);
        }
    }

    static class Son extends Father{
        public int money = 3;

        public Son() {
            money = 4;
            showMeTheMoney();
        }

        public void showMeTheMoney() {
            System.out.println("I am Son, I have $" + money);
        }
    }

    public static void main(String[] args) {
        Father guy = new Son();
        System.out.println("this guy have $" + guy.money);
    }
}
