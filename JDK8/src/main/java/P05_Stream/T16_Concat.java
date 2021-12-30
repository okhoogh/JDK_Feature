package P05_Stream;

import java.util.stream.Stream;

/**
 * @author: okhoogh
 * @date: 2021/11/8 17:20
 * @description: 两个流合并成为一个流
 */
public class T16_Concat {
    public static void main(String[] args) {
        Stream<String> streamA = Stream.of("aa");
        Stream<String> streamB = Stream.of("bb");
        Stream<String> result = Stream.concat(streamA, streamB);
        result.forEach(System.out::println);
    }
}
