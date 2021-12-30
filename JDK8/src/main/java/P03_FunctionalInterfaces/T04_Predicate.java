package P03_FunctionalInterfaces;

import java.util.function.Predicate;

/**
 * @author: okhoogh
 * @date: 2021/8/11 16:30
 * @description: 接受一个参数做判断并返回结果
 */
public class T04_Predicate {
    public static void main(String[] args) {
        Predicate1(s -> s.length() >= 3);
        Predicate2(s -> s.contains("W"), s -> s.contains("H"), "Hello World");
        Predicate3(s -> s.contains("W"), s -> s.contains("H"), "Hello world");
        Predicate4(s -> s.contains("W"), "Hello World");
    }

    private static void Predicate1(Predicate<String> predicate) {
        boolean test = predicate.test("你好啊");
        System.out.println(test ? "正确" : "错误");
    }

    private static void Predicate2(Predicate<String> predicate1, Predicate<String> predicate2, String str) {
        boolean res = predicate1.and(predicate2).test(str);
        if (res) {
            System.out.println("即包含W也包含H");
        }
    }

    private static void Predicate3(Predicate<String> predicate1, Predicate<String> predicate2, String str) {
        boolean res = predicate1.or(predicate2).test(str);
        if (res) {
            System.out.println("包含W或者包含H");
        }
    }

    private static void Predicate4(Predicate<String> predicate, String str) {
        boolean res = predicate.negate().test(str);
        if (res) {
            System.out.println("不包含W");
        }
    }
}
