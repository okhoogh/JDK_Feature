package P05_Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: okhoogh
 * @date: 2021/11/21 20:05
 * @description: 对流中数据进行拼接 Collectors.joining(分隔符, 前缀, 后缀)
 * @result:
 *  (^_^) abc (>_<) def (>_<) ghi (>_<) jk (^v^)
 */
public class T23_Joining {
    public static void main(String[] args) {
        Stream<Student3> student3Stream = Stream.of(
                new Student3("abc", 58, 95),
                new Student3("def", 56, 88),
                new Student3("ghi", 56, 99),
                new Student3("jk", 52, 37));
        String collect = student3Stream
                .map(Student3::getName)
                .collect(Collectors.joining(" (>_<) ", " (^_^) ", " (^v^) "));
        System.out.println(collect);
    }
}

@Data
@AllArgsConstructor
class Student3 {
    private String name;

    private Integer age;

    private Integer score;
}
