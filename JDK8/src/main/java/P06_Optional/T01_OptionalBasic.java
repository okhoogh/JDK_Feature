package P06_Optional;

import java.util.Optional;

/**
 * @author: okhoogh
 * @date: 2021/11/23 9:44
 * @description: Optional基本用法
 *
 * Optional.of(T t) : 创建一个 Optional 实例
 * Optional.empty() : 创建一个空的 Optional 实例
 * Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例
 *
 * isPresent() : 判断是否包含值,包含值返回true，不包含值返回false
 * get() : 如果Optional有值则将其返回，否则抛出NoSuchElementException
 */
public class T01_OptionalBasic {
    public static void main(String[] args) {
        Optional<String> userName1 = Optional.of("Mike");
//        Optional<String> userName2 = Optional.of(null);
        Optional<String> userName3 = Optional.ofNullable(null);
        Optional<String> userName4 = Optional.empty();

        if(userName1.isPresent()) {
            System.out.println("用户名：" + userName1.get());
        } else {
            System.out.println("用户名不存在");
        }
    }
}
