package P05_Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: okhoogh
 * @date: 2021/10/28 14:41
 * @description: 统计其中的元素个数
 */
public class T03_Count {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "amy", "bili", "candy", "des", "eva");
        System.out.println(list.stream().count());
    }
}
