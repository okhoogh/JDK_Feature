package P05_Stream;

import java.util.stream.Stream;

/**
 * @author: okhoogh
 * @date: 2021/10/28 14:54
 * @description: 将流中的元素映射到另一个流中
 */
public class T07_Map {
    public static void main(String[] args) {
        Stream<String> original = Stream.of("11", "22", "33");
        Stream<Integer> result = original.map(Integer::parseInt);
        result.forEach(s -> System.out.println(s + 10));
    }
}
