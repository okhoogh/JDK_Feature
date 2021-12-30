package P05_Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: okhoogh
 * @date: 2021/11/9 15:39
 * @description: 聚合计算
 * 当我们使用Stream流处理数据后，可以像数据库的聚合函数一样对某个字段进行操作。比如获取最大值，获取最小
 * 值，求总和，平均值，统计数量。
 * TODO: 需要了解stream.collect()和Collectors
 */
public class T20_AggregateComputing {
    public static void main(String[] args) {
        Stream<Student> studentStream = Stream.of(
                new Student("abc", 58, 95),
                new Student("def", 56, 88),
                new Student("ghi", 56, 99),
                new Student("jk", 52, 77));
        // 获取最大值
        Optional<Student> max = studentStream.collect(Collectors.maxBy(((o1, o2) -> o1.getScore() - o2.getScore())));
//        Optional<Student> max1 = studentStream.max((Comparator.comparingInt(Student::getScore)));
        System.out.println(max.get());

        // 获取最小值
//        Optional<Student> min = studentStream.collect(Collectors.minBy(((o1, o2) -> o1.getScore() - o2.getScore())));
//        Optional<Student> min1 = studentStream.min((o1, o2) -> o1.getScore() - o2.getScore());
//        System.out.println(min.get());

        // 求和
//        Integer sum = studentStream.collect(Collectors.summingInt(Student::getScore));
//        Integer sum1 = studentStream.mapToInt(Student::getScore).sum();
//        System.out.println(sum);

        // 平均值
//        Double avg = studentStream.collect(Collectors.averagingInt(Student::getScore));
//        System.out.println(avg);

        // 统计数量
//        Long count = studentStream.collect(Collectors.counting());
//        long count1 = studentStream.count();
//        System.out.println(count);
    }
}

@Data
@AllArgsConstructor
class Student {
    private String name;

    private Integer age;

    private Integer score;
}
