package P05_Stream;

import java.util.stream.Stream;

/**
 * @author: okhoogh
 * @date: 2021/10/28 15:31
 * @description: 判断数据是否匹配指定的条件
 */
public class T10_Match {
    public static void main(String[] args) {
        boolean b = Stream.of(5, 3, 6, 1)
//                .allMatch(o -> o > 5)     // allMatch: 元素是否全部满足条件
//                .anyMatch(o -> o < 5)     // anyMatch: 元素是否任意有一个满足条件
                .noneMatch(o -> o == 1);    // noneMatch: 元素是否全部不满足条件
        System.out.println(b);
    }
}
