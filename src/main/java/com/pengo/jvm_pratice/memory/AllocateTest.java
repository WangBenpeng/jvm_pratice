package com.pengo.jvm_pratice.memory;

/**
 *
 *
 * @author benpeng
 * @date 2022/9/15 09:43
 */
public class AllocateTest {

    private static final int _1MB = 1024 * 1024;


    public static void main(String[] args) {
        testHandlePromotion();
    }

    /**
     * 空间分配担保
     * VM参数:-Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:-HandlePromotionFailure
     *
     * -------------------------------------------------------------------------------------
     * Unrecognized VM option 'HandlePromotionFailure'
     * Did you mean '(+/-)PromotionFailureALot'? Error: Could not create the Java Virtual Machine.
     * Error: A fatal exception has occurred. Program will exit.
     * -------------------------------------------------------------------------------------
     */
    static void testHandlePromotion() {
        byte[] allocation1, allocation2, allocation3, allocation4, allocation5, allocation6, allocation7;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation1 = null;
        allocation4 = new byte[2 * _1MB];
        allocation5 = new byte[2 * _1MB];
        allocation6 = new byte[2 * _1MB];
        allocation4 = null;
        allocation5 = null;
        allocation6 = null;
        allocation7 = new byte[2 * _1MB];
    }

    /**
     * 动态对象年龄判定
     *
     * VM参数:-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15
     * * -XX:+PrintTenuringDistribution
     */
    static void testTenuringThreshold2() {
        byte[] allocation1, allocation2, allocation3, allocation4;

        // allocation1+allocation2大于survivo空间一半
        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[_1MB / 4];
        allocation3 = new byte[4 * _1MB];
        allocation4 = new byte[4 * _1MB];
        allocation4 = null;
        allocation4 = new byte[4 * _1MB];
    }

    /**
     * 长期存活的对象进入老年代
     *
     *VM参数:-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:Survivor-Ratio=8
     * -XX:MaxTenuringThreshold=1
     */
    static void testTenuringThreshold() {
        byte[] allocation1, allocation2, allocation3;
        // 什么时候进入老年代决定于-XX:MaxTenuringThreshold设置
        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }

    /**
     * 大对象直接进入老年代
     * VM参数:-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728 -XX:+UseSerialGC
     */
    static void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[4 * _1MB];
    }

    /**
     * 新生代Minor GC
     * VM参数:-verbose:gc -Xms20M -Xmx20M -Xmn10M -Xlog:gc* -XX:SurvivorRatio=8 -XX:+UseSerialGC
     */
    public static void testAllocation() throws Exception {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        Thread.sleep(100);
        allocation2 = new byte[2 * _1MB];
        Thread.sleep(100);
        allocation3 = new byte[2 * _1MB];
        Thread.sleep(100);
        //出现 Minor GC
        allocation4 = new byte[4 * _1MB];
        Thread.sleep(10000);
    }

}
