package P04_FunctionReference;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author: okhoogh
 * @date: 2021/10/28 11:30
 * @description: 类名::引用实例方法
 */
public class T03_RefInstanceFunctionByClass {
    public static void main(String[] args) {
        Function<String, Integer> fun1 = s -> s.length();
        System.out.println(fun1.apply("abc"));
        Function<String, Integer> fun2 = String::length;
        System.out.println(fun2.apply("abc"));
        BiFunction<String, Integer, String> bi = String::substring;
        System.out.println(bi.apply("hello", 2));
    }
}
