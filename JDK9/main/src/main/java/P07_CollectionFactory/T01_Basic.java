package P07_CollectionFactory;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: okhoogh
 * @date: 2021/11/24 18:17
 * @description:
 * 调用集合中静态方法 of()，可以将不同数量的参数传输到此工厂方法中。此功能可用于 Set 和 List，也
 * 可用于 Map 的类似形式。此时得到的集合，是不可变的。如果对其做修改操作，会抛出UnsupportedOperationException
 */
public class T01_Basic {
    public static void main(String[] args) {
        //1. 创建只读List
        List<String> list = List.of("张三", "李四", "王五");
        System.out.println("list集合的内容：" + list);
        //2. 创建只读Set
        Set<String> set = Set.of("张三", "李四", "王五");
        System.out.println("set集合的内容:" + set);
        //3. 创建只读Map
        Map<Integer, String> map = Map.of(1, "张三", 2, "李四", 3, "王五");
        System.out.println("map集合的内容:" + map);
    }
}
