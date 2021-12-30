package P02_NewApi;

import java.util.*;

/**
 * @author: okhoogh
 * @date: 2021/12/29 18:11
 * @description: java.util 包下的List、Set、Map新增加了一个静态方法 copyOf
 * copyOf 方法将元素复制到一个不可修改的集合并返回
 */
public class T01_CopyOf {
    public static void main(String[] args) {
        var list = new ArrayList<String>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");
        var list2 = List.copyOf(list);
        System.out.println(list2);
        System.out.println(list2.getClass());
//        list2.add("ee");    // UnsupportedOperationException

        System.out.println("---------------");
        var set = new HashSet<String>();
        set.add("b");
        set.add("a");
        set.add("c");
        set.add("d");
        var set2 = Set.copyOf(set);
        for (String string : set2) {
            System.out.println(string);
        }
        System.out.println(set2.getClass());
//        set2.add("ee");   // UnsupportedOperationException

        System.out.println("---------------");
        var map = new HashMap<>();
        map.put("k1", "v1");
        map.put("k2", "v2");
        var map2 = Map.copyOf(map);
        var keys = map2.keySet();
        for (Object object : keys) {
            System.out.println(map2.get(object));
        }
        System.out.println(map2.getClass());
//        map2.put("123", "456");   // UnsupportedOperationException
    }
}
