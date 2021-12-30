package P05_Stream;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author: okhoogh
 * @date: 2021/11/22 12:51
 * @description: ForkJoin框架
 * parallelStream使用的是Fork/Join框架
 * Fork/Join框架自JDK 7引入，它可以将一个大任务拆分为多个小任务来异步执行
 * Fork/Join框架主要包含三个模块：
 * 1. 线程池：ForkJoinPool
 * 2. 任务对象：ForkJoinTask
 * 3. 执行任务的线程：ForkJoinWorkerThread
 *
 * 工作窃取（work-stealing）算法：
 * Fork/Join最核心的地方就是利用了现代硬件设备多核，在一个操作时候会有空闲的cpu，那么如何利用好这个空闲的
 * cpu就成了提高性能的关键，而这里我们要提到的工作窃取（work-stealing）算法就是整个Fork/Join框架的核心理念
 * Fork/Join工作窃取（work-stealing）算法是指某个线程从其他队列里窃取任务来执行。
 *
 * 那么为什么需要使用工作窃取算法呢？假如我们需要做一个比较大的任务，我们可以把这个任务分割为若干互不依赖
 * 的子任务，为了减少线程间的竞争，于是把这些子任务分别放到不同的队列里，并为每个队列创建一个单独的线程来
 * 执行队列里的任务，线程和队列一一对应，比如A线程负责处理A队列里的任务。但是有的线程会先把自己队列里的
 * 任务干完，而其他线程对应的队列里还有任务等待处理。干完活的线程与其等着，不如去帮其他线程干活，于是它就
 * 去其他线程的队列里窃取一个任务来执行。而在这时它们会访问同一个队列，所以为了减少窃取任务线程和被窃取任
 * 务线程之间的竞争，通常会使用双端队列，被窃取任务线程永远从双端队列的头部拿任务执行，而窃取任务的线程永
 * 远从双端队列的尾部拿任务执行。
 *
 * 工作窃取算法的优点是充分利用线程进行并行计算，并减少了线程间的竞争，其缺点是在某些情况下还是存在竞争，
 * 比如双端队列里只有一个任务时。并且消耗了更多的系统资源，比如创建多个线程和多个双端队列。
 *
 * 上文中已经提到了在Java 8引入了自动并行化的概念。它能够让一部分Java代码自动地以并行的方式执行，
 * 也就是ForkJoinPool的ParallelStream。
 *
 * 对于ForkJoinPool通用线程池的线程数量，通常使用默认值就可以了，即运行时计算机的处理器数量。可以通过设置
 * 系统属性：java.util.concurrent.ForkJoinPool.common.parallelism=N （N为线程数量），来调整ForkJoinPool的线
 * 程数量，可以尝试调整成不同的参数来观察每次的输出结果。
 *
 * @result: Addition(1~500b, i5-1137G | 16G) forkJoin 10s292ms for-loop 20s21ms
 * 1. parallelStream是线程不安全的
 * 2. parallelStream适用的场景是CPU密集型的，只是做到别浪费CPU，假如本身电脑CPU的负载很大，那还到处用
 * 并行流，那并不能起到作用
 * 3. I/O密集型 磁盘I/O、网络I/O都属于I/O操作，这部分操作是较少消耗CPU资源，一般并行流中不适用于I/O密集
 * 型的操作，就比如使用并流行进行大批量的消息推送，涉及到了大量I/O，使用并行流反而慢了很多
 * 4. 在使用并行流的时候是无法保证元素的顺序的，也就是即使你用了同步集合也只能保证元素都正确但无法保证
 * 其中的顺序
 */
public class T28_ForkJoin {

    private static final Long range = 50_000_000_000L;

    @Test
    public void forAdd() {
        long start = System.currentTimeMillis();
        long result = 0;
        for(long i = 0; i <= range; ++i) {
            result += i;
        }
        System.out.println("result = " + result);
        long end = System.currentTimeMillis();
        System.out.println("花费时间：" + (end - start));
    }

    @Test
    public void forkJoin() {
        long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        SumRecursiveTask task = new SumRecursiveTask(0, range);
        Long result = forkJoinPool.invoke(task);
        System.out.println("result = " + result);
        long end = System.currentTimeMillis();
        System.out.println("花费时间：" + (end - start));
    }
}

class SumRecursiveTask extends RecursiveTask<Long> {

    // 拆分阈值
    private static final long THRESHOLD = 3000L;

    // 左边界
    private final long start;

    // 右边界
    private final long end;

    public SumRecursiveTask(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;
        if (length <= THRESHOLD) {
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum += i;
            }
//            System.out.println("计算: " + start + " -> " + end + ",结果为: " + sum);
            return sum;
        }
        long mid = (start + end) >> 1;
//        System.out.println("拆分: 左边 " + start + " -> " + mid + ", 右边 " + (mid + 1) + " -> " + end);

        SumRecursiveTask left = new SumRecursiveTask(start, mid);
        left.fork();
        SumRecursiveTask right = new SumRecursiveTask(mid + 1, end);
        right.fork();
        return left.join() + right.join();
    }
}
