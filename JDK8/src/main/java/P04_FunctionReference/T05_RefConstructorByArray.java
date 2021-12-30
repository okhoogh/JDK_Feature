package P04_FunctionReference;

import java.util.function.Function;

/**
 * @author: okhoogh
 * @date: 2021/10/28 11:41
 * @description: 数组::new 引用数组构造器
 */
public class T05_RefConstructorByArray {
    public static void main(String[] args) {
        Function<Integer, String[]> func1 = (len) -> new String[len];
        System.out.println(func1.apply(10).length);
        Function<Integer, String[]> func2 = String[]::new;
        System.out.println(func2.apply(20).length);
    }
}
