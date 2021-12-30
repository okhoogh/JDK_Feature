package P04_FunctionReference;

import java.util.function.Supplier;

/**
 * @author: okhoogh
 * @date: 2021/10/28 11:27
 * @description: 类名::引用静态方法
 */
public class T02_RefStaticFunctionByClass {
    public static void main(String[] args) {
        Supplier<Long> supplier1 = () -> System.currentTimeMillis();
        System.out.println(supplier1.get());
        Supplier<Long> supplier2 = System::currentTimeMillis;
        System.out.println(supplier2.get());
    }
}
