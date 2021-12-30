package P05_Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: okhoogh
 * @date: 2021/11/10 18:14
 * @description: 可以根据某个属性将数据分组，多个标签的map
 * @result:
 * 不及格 [Student{name='jk', age=52, score=37}]
 * 优秀 [Student{name='abc', age=58, score=95}, Student{name='ghi', age=56, score=99}]
 * 及格 [Student{name='def', age=56, score=88}]
 */
public class T21_Group {
    public static void main(String[] args) {
        Stream<Student> studentStream = Stream.of(
                new Student("abc", 58, 95),
                new Student("def", 56, 88),
                new Student("ghi", 56, 99),
                new Student("jk", 52, 37));
//        Map<Integer, List<Student>> byAge = studentStream.collect(Collectors.groupingBy(Student::getAge));
//        byAge.entrySet().forEach(System.out::println);

        studentStream.collect(Collectors.groupingBy(s -> s.getScore() > 60 ? (s.getScore() >= 95 ? "优秀" : "及格") : "不及格"))
                .forEach((k, v) -> System.out.println(k + " " + v));
    }
}

@Data
@AllArgsConstructor
class Student1 {
    private String name;

    private Integer age;

    private Integer score;
}
