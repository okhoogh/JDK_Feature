package P05_Stream;

import java.util.stream.Stream;

/**
 * @author: okhoogh
 * @date: 2021/10/28 18:03
 * @description: 将所有数据归纳得到一个数据
 */
public class T13_Reduce {
    public static void main(String[] args) {
        Integer reduce1 = Stream.of(4, 5, 3, 9).reduce(0, (a, b) -> {
            System.out.println("a = " + a + ", b = " + b);
            return a + b;
        });
        System.out.println(reduce1);
        System.out.println("---------");
        Integer reduce2 = Stream.of(4, 5, 3, 9).reduce(0, (a, b) -> Integer.sum(a, b));
        System.out.println(reduce2);
        Integer reduce3 = Stream.of(4, 5, 3, 9).reduce(0, Integer::sum);
        System.out.println(reduce3);
    }
}
