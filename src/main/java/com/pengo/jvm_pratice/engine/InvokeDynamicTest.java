package com.pengo.jvm_pratice.engine;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;

/**
 * @author Benpeng
 * @date 2022/12/29
 */
public class InvokeDynamicTest {
    public static void main(String[] args) {
        Son son = new InvokeDynamicTest().new Son();
        son.thinking();
    }

    class GrandFather{
        void thinking() {
            System.out.println("I am grandFather");
        }
    }

    class Father extends GrandFather {
        @Override
        void thinking() {
            System.out.println("I am father");
        }
    }

    class Son extends Father{
        //jdk7 之前输出I am grandFather，jdk7之后输出I am father
        @Override
        void thinking() {
            try {
                MethodType methodType = MethodType.methodType(void.class);
                MethodHandle methodHandle = MethodHandles.lookup().findSpecial(GrandFather.class, "thinking", methodType, getClass());
                methodHandle.invoke(this);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

}
