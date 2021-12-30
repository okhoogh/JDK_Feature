package P05_Stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: okhoogh
 * @date: 2021/11/22 10:49
 * @description: 并行流的线程安全问题
 * @result:
 * 1.调用的方法加锁 synchronized
 * 2.使用线程安全集合 Vector HashSet Concurrent***
 * 3.将线程不安全集合转成安全集合 Collections.synchronized***()
 * 4.使用Collect或者toArray收集数据
 */
public class T27_ParallelStream_ThreadSafe {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            list.add(i);
        }
        List<Integer> newList = new ArrayList<>();
//        Vector<Integer> newList = new Vector<>();
        // 使用并行的流往集合中添加数据
//        list.parallelStream().forEach(newList::add);
//        System.out.println("size = " + newList.size());

//        List<Integer> newList1 = list.parallelStream().filter(num -> num >= 500).collect(Collectors.toList());
//        System.out.println("size = " + newList1.size());

//        long sum = list.parallelStream().reduce(0, Integer::sum);
//        System.out.println("size = " + sum);


        List<Integer> listOfIntegers = new ArrayList<>();
        for (int i = 1; i < 101; i++) {
            listOfIntegers.add(i);
        }
        List<Integer> parallelStorage = new ArrayList<>();
//        Collections.synchronizedList(parallelStorage);
        listOfIntegers
                .parallelStream()
                .filter(i -> i % 2 == 0)
                .forEach(i -> parallelStorage.add(i));

        parallelStorage
                .stream()
                .forEachOrdered(e -> System.out.print(e + " "));

        System.out.println("\n" + parallelStorage.size());
    }
}
