package P03_New_Api;

/**
 * @author: okhoogh
 * @date: 2022/1/4 17:54
 * @description: JEP 333: ZGC 可伸缩低延迟垃圾收集器(Experimental实验性) 不建议用到生产环境
 *
 * GC是Java主要优势之一。然而，当GC停顿太长，就会开始影响应用的响应时间。消除或者减少GC停顿时长，Java将
 * 对更广泛的应用场景是一个更有吸引力的平台。此外，现代系统中可用内存不断增长，用户和程序员希望JVM能够以
 * 高效的方式充分利用这些内存，并且无需长时间的GC暂停时间。
 * 今天，应用程序同时为数千甚至数百万用户提供服务的情况并不少见。这些应用程序需要大量内存。但是，管理所有
 * 内存可能会轻易影响应用程序性能。为了解决这个问题，Java 11引入了Z垃圾收集器（ZGC）作为实验性垃圾收集器实现
 *
 * ZGC全称是Z Garbage Collector，是一款可伸缩(scalable)的低延迟(low latency garbage)、并发(concurrent)垃圾回
 * 收器，旨在实现以下几个目标：
 * 停顿时间不超过10ms
 * 停顿时间不随heap大小或存活对象大小增大而增大
 * 可以处理从几百G到几TB的内存大小,远剩余前一代的G1。
 * 初始只支持64位系统
 *
 * 可以使用以下命令行选项启用ZGC:
 * -XX: +UnlockExperimentalVMOptions -XX: +UseZGC
 * 请注意：因为ZGC还处于实验阶段，所以需要通过JVM参数UnlockExperimentalVMOptions 来解锁这个特性
 */
public class T08_ZGC {}
