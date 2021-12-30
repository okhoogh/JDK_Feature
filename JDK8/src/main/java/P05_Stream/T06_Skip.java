package P05_Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: okhoogh
 * @date: 2021/10/28 14:52
 * @description: 跳过前几个元素
 */
public class T06_Skip {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "amy", "bili", "candy", "des", "eva");
        list.stream().skip(2).forEach(System.out::println);
    }
}
