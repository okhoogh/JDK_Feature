package P05_Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author: okhoogh
 * @date: 2021/11/8 17:30
 * @description: 综合案例
 * 现在有两个 ArrayList 集合存储队伍当中的多个成员姓名，要求使用传统的for循环（或增强for循环）依次进行以下
 * 若干操作步骤：
 * 1. 第一个队伍只要名字为3个字的成员姓名；
 * 2. 第一个队伍筛选之后只要前3个人；
 * 3. 第二个队伍只要姓张的成员姓名；
 * 4. 第二个队伍筛选之后不要前2个人；
 * 5. 将两个队伍合并为一个队伍；
 * 6. 根据姓名创建 Person 对象；
 * 7. 打印整个队伍的Person对象信息。
 */
public class T17_Cases {
    public static void main(String[] args) {
        List<String> one = List.of("迪丽热巴", "宋 桥", "苏星河", "老子", "庄子", "孙子", "洪七公");
        List<String> two = List.of("古力娜扎", "张无忌", "张三丰", "赵丽颖", "张二狗", "张天爱", "张三");

        // 1. 第一个队伍只要名字为3个字的成员姓名；
        Stream<String> stream1 = one.stream().filter(s -> s.length() == 3);
        // 2. 第一个队伍筛选之后只要前3个人；
        Stream<String> stream2 = stream1.limit(3);
        // 3. 第二个队伍只要姓张的成员姓名；
        Stream<String> stream3 = two.stream().filter(s -> s.startsWith("张"));
        // 4. 第二个队伍筛选之后不要前2个人；
        Stream<String> stream4 = stream3.skip(2);
        // 5. 将两个队伍合并为一个队伍；
        Stream<String> stream5 = Stream.concat(stream2, stream4);
        // 6. 根据姓名创建 Person 对象；
        Stream<Person4> stream6 = stream5.map(Person4::new);
        // 7. 打印整个队伍的Person对象信息。
        stream6.forEach(System.out::println);
    }
}

@Data
@AllArgsConstructor
class Person4 {
    private final String name;
}
