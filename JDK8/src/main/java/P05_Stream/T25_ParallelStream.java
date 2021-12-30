package P05_Stream;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @author: okhoogh
 * @date: 2021/11/22 10:02
 * @description: 并行执行的流。
 * 它通过默认的ForkJoinPool可以提高多线程任务的速度
 */
public class T25_ParallelStream {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        // 1.直接获取并行的流
        // Stream<Integer> stream = list.parallelStream();
        // 2.将串行流转成并行流
        Stream<Integer> stream = list.stream().parallel();
        // 3.并行流实例
        Stream.of(4, 5, 6, 7, 9, 3)
                .parallel()
                .forEach(s -> System.out.println(Thread.currentThread() + " " + s));
    }
}