package P05_Stream;

import java.util.stream.Stream;

/**
 * @author: okhoogh
 * @date: 2021/11/22 9:55
 * @description: 默认流是串行流
 * @result:
 * Thread[main,5,main] 4
 * Thread[main,5,main] 5
 * Thread[main,5,main] 6
 * Thread[main,5,main] 7
 * Thread[main,5,main] 9
 * Thread[main,5,main] 3
 */
public class T24_SerialStream {
    public static void main(String[] args) {
        Stream.of(4, 5, 6, 7, 9, 3)
                .forEach(s -> System.out.println(Thread.currentThread() + " " + s));
    }
}
