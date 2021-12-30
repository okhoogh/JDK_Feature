package P04_InterfacePrivateMethod;

/**
 * @author: okhoogh
 * @date: 2021/11/24 16:57
 * @description:
 */
public class PrivateMethodTest {
    public static void main(String[] args) {
        UserMapperBImpl userMapperB = new UserMapperBImpl();
        userMapperB.methodA();
        userMapperB.methodB();
    }
}
