package P04_InterfacePrivateMethod;

/**
 * @author: okhoogh
 * @date: 2021/11/24 17:01
 * @description:
 */
public interface UserMapperB {

    default void methodA() {
        System.out.println("methodA");
        common();
    }

    default void methodB() {
        System.out.println("methodB");
        common();
    }

    private void common() {
        System.out.println("123");
        System.out.println("456");
        System.out.println("789");
    }
}
