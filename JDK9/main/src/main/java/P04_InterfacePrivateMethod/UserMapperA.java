package P04_InterfacePrivateMethod;

/**
 * @author: okhoogh
 * @date: 2021/11/24 16:59
 * @description:
 */
public interface UserMapperA {

    default void methodA() {
        System.out.println("methodA");
        System.out.println("123");
        System.out.println("456");
        System.out.println("789");
    }

    default void methodB() {
        System.out.println("methodB");
        System.out.println("123");
        System.out.println("456");
        System.out.println("789");
    }
}
