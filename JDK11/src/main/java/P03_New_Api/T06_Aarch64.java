package P03_New_Api;

import java.util.concurrent.TimeUnit;

/**
 * @author: okhoogh
 * @date: 2022/1/4 15:42
 * @description: JEP 315：改进 Aarch64 内在函数(Improve Aarch64 Intrinsics)
 * 改进现有的字符串和数组函数，并在Aarch64处理器上为java.lang.Math 下的sin, cos和log函数
 * 实现新的内联函数，从而实现专用的CPU架构下提高应用程序的性能。
 */
public class T06_Aarch64 {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        for (int i = 0; i < 10_000_000; i++) {
            Math.sin(i);
            Math.cos(i);
            Math.log(i);
        }
        // JDK8-5877ms
        // JDK11-783ms
        long endTime = System.nanoTime();
        System.out.println(TimeUnit.NANOSECONDS.toMillis(endTime - startTime) + "ms");
    }
}
