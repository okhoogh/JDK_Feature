package P04_FunctionReference;

import java.util.Date;
import java.util.function.Supplier;

/**
 * @author: okhoogh
 * @date: 2021/10/28 11:23
 * @description: 对象名::引用成员方法
 */
public class T01_RefMemberFunctionByObject {
    public static void main(String[] args) {
        Date now = new Date();
        Supplier<Long> supplier1 = () -> now.getTime();
        System.out.println(supplier1.get());
        Supplier<Long> supplier2 = now::getTime;
        System.out.println(supplier2.get());
    }
}
