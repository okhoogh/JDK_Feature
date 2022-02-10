package P03_New_Api;

import java.util.List;

/**
 * @author: okhoogh
 * @date: 2022/1/4 11:49
 * @description:
 */
public class T02_List {
    public static void main(String[] args) {
        List<Integer> list = List.of(10, 11, 12);
        System.out.println(list);
        // list为不可变集合，添加新元素会报出：UnsupportedOperationException
        // System.out.println(list.add(13));
        // 把List集合转换成数组
        // JDK 11前的方式
        Integer[] nums1 = list.toArray(new Integer[0]);
        // JDK 11开始之后新增方式
        Integer[] nums2 = list.toArray(Integer[]::new);
    }
}
