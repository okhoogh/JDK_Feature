package P06_Optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.Optional;

/**
 * @author: okhoogh
 * @date: 2021/11/23 9:53
 * @description: Optional高级
 * @result:
 * Optional是一个可以为null的容器对象，避免对null的判断，写出更加优雅的代码
 * ifPresent : 如果Optional不是空实例，则执行传入的消费者函数
 * ifPresentOrElse : 如果Optional不是空实例，则执行传入的消费者函数1；否则，执行消费者函数2
 * orElse(T t) : 如果调用对象包含值，返回该值，否则返回参数t
 * orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回 s 获取的值
 * map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()
 */
public class T02_OptionalAdvance {

    @Test
    public void Test1() {
        Optional<String> userNameO = Optional.of("Mike");
//        Optional<String> userNameO = Optional.empty();
        // 存在做的
        userNameO.ifPresent(s -> System.out.println("用户名为" + s));
        // 存在做的,不存在做点
        userNameO.ifPresentOrElse(s -> System.out.println("用户名为" + s)
                , () -> System.out.println("用户名不存在"));
    }

    @Test
    public void Test2() {
        // Optional<String> userNameO = Optional.of("凤姐");
        Optional<String> userNameO = Optional.empty();
        // 如果调用对象包含值，返回该值，否则返回参数t
        System.out.println("用户名为" + userNameO.orElse("null"));
        // 如果调用对象包含值，返回该值，否则返回参数Supplier得到的值
        String s1 = userNameO.orElseGet(() -> "未知用户名");
        System.out.println("s1 = " + s1);
    }

    @Test
    public void test05() {
//         User u = new User("AA", 18);
//         User u = new User(null, 18);
         User u = null;
         System.out.println(getUpperCaseUserName1(u));
        // 我们将可能会为null的变量构造成Optional类型
//        User u = new User("aa", 18);
//        User u = new User(null, 18);
//        Optional<User> uO = Optional.of(u);
//        System.out.println(getUpperCaseUserName2(uO));
    }

    public String getUpperCaseUserName2(Optional<User> uO) {
        // map将返回值包装成Option<>(返回值)并返回
        return uO.map(u -> u.getUserName())
                .map(name -> name.toUpperCase())
                .orElse("null");
    }

    public String getUpperCaseUserName1(User u) {
        if (u != null) {
            return u.getUserName();
        } else {
            return null;
        }
    }

}

@Data
@AllArgsConstructor
class User {
    String userName;

    int age;
}
