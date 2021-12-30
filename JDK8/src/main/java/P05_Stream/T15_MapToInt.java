package P05_Stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author: okhoogh
 * @date: 2021/11/8 16:59
 * @description: Stream中的Integer类型数据转成int类型
 */
public class T15_MapToInt {
    public static void main(String[] args) {
        // Integer占用的内存比int多,在Stream流操作中会自动装箱和拆箱
        Stream<Integer> stream1 = Arrays.stream(new Integer[]{1, 2, 3, 4, 5});
        Stream<Integer> stream2 = Arrays.stream(new Integer[]{1, 2, 3, 4, 5});
        // 把大于3的和打印出来
        Integer result = stream1
                .filter(i -> i.intValue() > 3)
                .reduce(0, Integer::sum);
        System.out.println(result);

        // 先将流中的Integer数据转成int,后续都是操作int类型
        IntStream intStream = stream2.mapToInt(Integer::intValue);
        int reduce = intStream
                .filter(i -> i > 3)
                .reduce(0, Integer::sum);
        System.out.println(reduce);

        // 将IntStream转化为Stream<Integer>
        IntStream intStream1 = IntStream.rangeClosed(1, 10);
        Stream<Integer> boxed = intStream1.boxed();
        boxed.forEach(s -> System.out.println(s.getClass() + ", " + s));
    }
}
