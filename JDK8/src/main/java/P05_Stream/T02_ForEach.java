package P05_Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: okhoogh
 * @date: 2021/10/28 14:36
 * @description: 遍历流中的数据
 */
public class T02_ForEach {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "amy", "bili", "candy", "des", "eva");
        list.stream().forEach(System.out::println);
    }
}
