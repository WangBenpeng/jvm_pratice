package com.pengo.jvm_pratice.oom;

/**
 * 虚拟机栈和本地方法栈溢出
 * 使用-Xss参数减少栈内存容量
 * 结果:抛出StackOverflowError异常，异常出现时输出的堆栈深度相应缩小
 *
 * VM Args:-Xss144k
 * @author benpeng
 * @date 2022/9/7 10:41
 */
public class JavaVMStackSOF1 {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF1 javaVMStackSOF1 = new JavaVMStackSOF1();
        try {
            javaVMStackSOF1.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + javaVMStackSOF1.stackLength);
            throw e;
        }
    }
}
