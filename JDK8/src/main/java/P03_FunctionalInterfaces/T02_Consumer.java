package P03_FunctionalInterfaces;

import java.util.function.Consumer;

/**
 * @author: okhoogh
 * @date: 2021/8/10 16:44
 * @description: 消费者
 */

public class T02_Consumer {

    public static final String HELLO_WORLD = "hello world";

    public static void main(String[] args) {
        PrintString1(s -> System.out.println(s.toUpperCase()));
        PrintString2(s -> System.out.println(s.toLowerCase()), s -> System.out.println(s.toUpperCase()));
    }

    private static void PrintString1(Consumer<String> consumer) {
        consumer.accept(HELLO_WORLD);
    }

    private static void PrintString2(Consumer<String> c1, Consumer<String> c2) {
        c1.andThen(c2).accept(HELLO_WORLD);
    }

}
