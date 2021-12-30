package P05_Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: okhoogh
 * @date: 2021/10/28 14:51
 * @description: 对流进行截取，只取用前n个
 */
public class T05_Limit {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "amy", "bili", "candy", "des", "eva");
        list.stream().limit(3).forEach(System.out::println);
    }
}
