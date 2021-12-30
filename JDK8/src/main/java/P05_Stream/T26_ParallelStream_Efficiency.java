package P05_Stream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.LongStream;

/**
 * @author: okhoogh
 * @date: 2021/11/22 10:27
 * @description: 并行流的效率
 * @result: parallelStream > forAdd > serialStream
 * Stream并行处理的过程会分而治之，也就是将一个大任务切分成多个小任务，这表示每个任务都是一个操作
 */
public class T26_ParallelStream_Efficiency {

    // 执行次数500亿
    private static long times = 50_000_000_000L;

    private static long start;

    @Before
    public void timeStart() {
        start = System.currentTimeMillis();
    }

    @After
    public void timeEnd() {
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
    }

    // parallelStream: 耗时：5s827ms
    @Test
    public void parallelStream() {
        long reduce = LongStream.range(0, times).parallel().reduce(0, Long::sum);
        System.out.print("parallelStream: ");
    }

    // serialStream: 耗时：1m31s322ms
    @Test
    public void serialStream() {
        long reduce = LongStream.range(0, times).reduce(0, Long::sum);
        System.out.print("serialStream: ");
    }

    // forAdd: 耗时：12s763ms
    @Test
    public void forAdd() {
        long sum = 0;
        for(long i = 1; i <= times; ++i) sum += i;
        System.out.print("forAdd: ");
    }
}
