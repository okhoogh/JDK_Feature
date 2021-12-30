package P03_FunctionalInterfaces;

import java.util.function.Function;

/**
 * @author: okhoogh
 * @date: 2021/8/10 17:13
 * @description: 接受一个参数返回一个结果
 */
public class T03_Function {
    public static void main(String[] args) {
        Function(Integer::parseInt);
    }

    private static void Function(Function<String, Integer> function) {
        Integer res = function.apply("10");
        System.out.println("结果：" + res);
    }
}
