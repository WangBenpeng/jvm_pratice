package com.pengo.jvm_pratice.oom;

import java.util.HashSet;
import java.util.Set;

/**
 * 方法区和运行时常量池溢出
 *
 * VM Args:-XX:PermSize=6M -XX:MaxPermSize=6M
 * @author benpeng
 * @date 2022/9/7 13:34
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        testIntern();
    }

    /**
     * jdk6中为False，False
     * jdk7及以后为True，False，原因是"java"在JVM加载sun.misc.Version这个类的时候进入常量池的。
     * https://www.zhihu.com/question/51102308/answer/124441115
     */
    static void testIntern() {
        String str1 = new StringBuilder("计算机").append("软件").toString(); System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }

    /**
     * -Xmx6M
     */
    static void testOOM() {
        // 使用Set保持着常量池引用，避免Full GC回收常量池行为
        Set<String> set = new HashSet<String>();
        // 在short范围内足以让6MB的PermSize产生OOM了
        short i = 0;
        while (true) {
            set.add(String.valueOf(i++).intern());
        }
    }
}
