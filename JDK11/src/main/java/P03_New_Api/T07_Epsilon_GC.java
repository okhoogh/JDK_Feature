package P03_New_Api;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: okhoogh
 * @date: 2022/1/4 16:16
 * @description: JEP 318: Epsilon 无操作垃圾收集器(Epsilon: A No-Op Garbage Collector)
 * JDK上对这个特性的描述是: 一个处理内存分配但不实现任何实际内存回收机制的GC, 一旦java的堆被耗尽, JVM就直接关闭
 * 如果有System.gc()调用, 实际上什么也不会发生垃圾对象的回收操作(这种场景下和-XX:+DisableExplicitGC效果一样),
 * 因为没有内存回收, 这个实现可能会警告用户尝试强制GC是徒劳
 *
 * -XX:+UnlockExperimentalVMOptions 解锁隐藏的虚拟机参数
 * -XX:+UseEpsilonGC 使用Epsilon垃圾收集器
 *
 * Epsilon垃圾收集器主要用途
 * 1.Performance testing: 性能测试(它可以帮助过滤掉GC引起的性能假象)
 *
 * 2.Memory pressure testing, 在测试java代码时，确定分配内存的阈值有助于设置内存压力常量值。这时no-op就
 * 很有用，它可以简单地接受一个分配的内存分配上限，当内存超限时就失败。例如：测试需要分配小于1G的内
 * 存，就使用-Xmx1g参数来配置no-op GC，然后当内存耗尽的时候就直接crash
 *
 * 3.非常短的JOB任务(对象这种任务, 接受GC清理堆那都是浪费空间)
 *
 * 4.VM interface testing, 以VM开发视角，有一个简单的GC实现，有助于理解VM-GC的最小接口实现。
 * 它也用于证明VM-GC接口的健全性
 *
 * 5.Last-drop latency improvements, 对那些极端延迟敏感的应用，开发者十分清楚内存占用，或者是几乎没有垃
 * 圾回收的应用，此时耗时较长的GC周期将会是一件坏事
 *
 * 6.Last-drop throughput improvements, 即便对那些无需内存分配的工作，选择一个GC意味着选择了一系列的
 * GC屏障，所有的OpenJDK GC都是分代的，所以他们至少会有一个写屏障。避免这些屏障可以带来一点点的吞吐量提升
 */

/*
// G1一直回收对象，直到内存不够用
-Xms100m
-Xmx100m
*/

/*
// 发现很快就内存溢出了，因为Epsilon不会去回收对象
-XX:+UnlockExperimentalVMOptions
-XX:+UseEpsilonGC
-Xms100m
-Xmx100m
*/
public class T07_Epsilon_GC {
    public static void main(String[] args) {
        System.out.println("程序开始");
        List<Garbage> list = new ArrayList<>();
        long count = 0;
        while (true) {
            list.add(new Garbage(list.size() + 1));
            if (list.size() == 1000000 && count == 0) {
                list.clear();
                count++;
            }
        }
//        System.out.println("程序结束");
    }
}

class Garbage {

    private int number;

    public Garbage(int number) {
        this.number = number;
    }

    /**
     * GC在清除对象时，会调用finalize()方法
     */
    @Override
    public void finalize() {
        System.out.println(this + " : " + number + " is dying");
    }
}
