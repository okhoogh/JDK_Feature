package P05_Stream;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author: okhoogh
 * @date: 2021/10/28 16:11
 * @description: 获取最大和最小值
 */
public class T12_Max_Min {
    public static void main(String[] args) {
        Optional<Integer> max = Stream.of(5, 3, 6, 1).max((o1, o2) -> o1 - o2);
        System.out.println("max = " + max.get());
        Optional<Integer> min = Stream.of(5, 3, 6, 1).min((o1, o2) -> o1 - o2);
        System.out.println("min = " + min.get());
    }
}
