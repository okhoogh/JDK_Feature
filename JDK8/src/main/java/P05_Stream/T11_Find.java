package P05_Stream;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author: okhoogh
 * @date: 2021/10/28 15:41
 * @description: 找到某些数据
 */
public class T11_Find {
    public static void main(String[] args) {
        Optional<Integer> first = Stream.of(5, 3, 6, 1).findFirst();
        System.out.println(first.get());
        Optional<Integer> second = Stream.of(5, 3, 6, 1).findAny();
        System.out.println(second.get());
    }
}
