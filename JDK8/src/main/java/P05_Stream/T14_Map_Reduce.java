package P05_Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.stream.Stream;

/**
 * @author: okhoogh
 * @date: 2021/10/29 10:38
 * @description: Stream流的map和reduce组合使用
 */
public class T14_Map_Reduce {
    public static void main(String[] args) {
        // 求出所有年龄的总和
        Integer sum = Stream.of(
                new Person3("aa", 1),
                new Person3("bb", 2),
                new Person3("cc", 3),
                new Person3("dd", 4)).map(Person3::getAge).reduce(0, Integer::sum);
        System.out.println(sum);

        // 找出最大年龄
        Integer max = Stream.of(
                new Person3("aa", 1),
                new Person3("bb", 2),
                new Person3("cc", 3),
                new Person3("dd", 4)).map(Person3::getAge).reduce(0, Integer::max);
        System.out.println(max);

        // 统计数字2出现的次数
        Integer count = Stream.of(1, 2, 2, 1, 3, 2).map((i) -> i == 2 ? 1 : 0).reduce(0, Integer::sum);
        System.out.println(count);

    }
}

@Data
@AllArgsConstructor
class Person3 {
    private String name;

    private Integer age;
}
