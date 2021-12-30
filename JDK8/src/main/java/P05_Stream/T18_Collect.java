package P05_Stream;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: okhoogh
 * @date: 2021/11/8 18:04
 * @description: 收集Stream流中的结果
 */
public class T18_Collect {
    public static void main(String[] args) {
        Stream<String> stream1 = Stream.of("aa", "bb", "cc");
        Stream<String> stream2 = Stream.of("aa", "bb", "cc");
        List<String> list = stream1.collect(Collectors.toList());
        Set<String> set = stream2.collect(Collectors.toSet());
//        ArrayList<String> list = stream1.collect(Collectors.toCollection(ArrayList::new));
//        HashSet<String> set = stream2.collect(Collectors.toCollection(HashSet::new));
        System.out.println(list);
        System.out.println(set);
    }
}
