package P05_Stream;

import java.util.stream.Stream;

/**
 * @author: okhoogh
 * @date: 2021/10/28 15:11
 * @description: 根据元素的自然顺序排序，也可以指定比较器排序
 */
public class T08_Sorted {
    public static void main(String[] args) {
        Stream.of(33, 22, 11, 55).sorted().forEach(System.out::println);
        System.out.println("-----------------------");
        Stream.of(33, 22, 11, 55).sorted(((o1, o2) -> o2 - o1)).forEach(System.out::println);
    }
}
