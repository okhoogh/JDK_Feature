package P05_Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: okhoogh
 * @date: 2021/11/21 19:58
 * @description: 对流中数据进行分区，两个标签(true和false)的map
 * @result:
 * false == [Student2{name='def', age=56, score=88}, Student2{name='jk', age=52, score=37}]
 * true == [Student2{name='abc', age=58, score=95}, Student2{name='ghi', age=56, score=99}]
 */
public class T22_PartitioningBy {
    public static void main(String[] args) {
        Stream<Student2> student2Stream = Stream.of(
                new Student2("abc", 58, 95),
                new Student2("def", 56, 88),
                new Student2("ghi", 56, 99),
                new Student2("jk", 52, 37));
        Map<Boolean, List<Student2>> map = student2Stream.collect(
                Collectors.partitioningBy(s ->s.getScore() > 90));
        map.forEach((k, v) -> System.out.println(k + " == " + v));
    }
}

@Data
@AllArgsConstructor
class Student2 {
    private String name;

    private Integer age;

    private Integer score;
}
