package P05_Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: okhoogh
 * @date: 2021/10/28 14:43
 * @description: 过滤数据，返回符合过滤条件的数据
 */
public class T04_Filter {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "amy", "bili", "candy", "des", "eva");
        list.stream().filter(s -> s.length() == 3).forEach(System.out::println);
    }
}
