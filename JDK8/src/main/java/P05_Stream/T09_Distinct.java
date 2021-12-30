package P05_Stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.stream.Stream;

/**
 * @author: okhoogh
 * @date: 2021/10/28 15:13
 * @description: 去除重复数据
 */
public class T09_Distinct {
    public static void main(String[] args) {
        Stream.of(22, 33, 22, 11, 33)
                .distinct()
                .forEach(System.out::println);

        Stream.of(
                new Person2("aa", 18),
                new Person2("bb", 26),
                new Person2("cc", 36),
                new Person2("dd", 42))
                .distinct()
                .forEach(System.out::println);
    }
}

@Data
@AllArgsConstructor
class Person2 {
    private String name;
    private Integer age;
}