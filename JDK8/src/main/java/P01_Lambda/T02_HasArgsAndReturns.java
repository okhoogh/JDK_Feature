package P01_Lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: okhoogh
 * @date: 2021/8/9 16:54
 * @description: 有参数无返回值Lambda
 */
public class T02_HasArgsAndReturns {
    public static void main(String[] args) {
        List<T02_Person> list = new ArrayList<>();
        list.add(new T02_Person("张三", "男", 10));
        list.add(new T02_Person("李四", "女", 30));
        list.add(new T02_Person("王五", "男", 20));
        // 年龄逆序
        list.sort((o1, o2) -> o2.getAge() - o1.getAge());
        list.forEach(System.out::println);
    }
}


