package P05_Stream;

import java.util.stream.Stream;

/**
 * @author: okhoogh
 * @date: 2021/11/8 18:18
 * @description: 将结果放到一个数组中
 */
public class T19_ToArray {
    public static void main(String[] args) {
        Stream<String> stream1 = Stream.of("aa", "bb", "cc");
        Stream<String> stream2 = Stream.of("aa", "bb", "cc");
        Object[] objects = stream1.toArray();
        for (Object obj : objects) {
            System.out.println(obj);
        }
        System.out.println("------------------");
        // String[]::new <==> size -> new String[size]
        String[] strings = stream2.toArray(String[]::new);
        for (String str : strings) {
            System.out.println(str);
        }
    }
}
