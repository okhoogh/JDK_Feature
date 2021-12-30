package P05_Stream;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author: okhoogh
 * @date: 2021/10/28 14:10
 * @description: 获取流
 */
public class T01_GetStream {
    public static void main(String[] args) {
        // 1.Get Stream through Collection
        List<Integer> list = new ArrayList<>();
        Stream<Integer> stream1 = list.stream();
        Set<String> set = new HashSet<>();
        Stream<String> stream2 = set.stream();

        Map<String, Integer> map = new HashMap<>();
        Stream<String> stream3 = map.keySet().stream();
        Stream<Integer> stream4 = map.values().stream();
        Stream<Map.Entry<String, Integer>> stream5 = map.entrySet().stream();

        // 2.the static methods of stream and how to get stream
        Stream<String> stream6 = Stream.of("aa", "bb", "cc");

        String[] arr = {"aa", "bb", "cc"};
        Stream<String> stream7 = Stream.of(arr);

        Integer[] arr2 = {11, 22, 33};
        Stream<Integer> stream8 = Stream.of(arr2);

        int[] arr3 = {11, 22, 33};
        Stream<int[]> stream9 = Stream.of(arr3);
        stream9.forEach(System.out::println);
    }
}
