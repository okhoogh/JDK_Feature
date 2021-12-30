package P04_FunctionReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author: okhoogh
 * @date: 2021/10/28 11:34
 * @description: 类名::new引用构造器
 */
public class T04_RefConstructorByClass {
    public static void main(String[] args) {
        Supplier<Person1> supplier1 = () -> new Person1();
        System.out.println(supplier1.get());
        Supplier<Person1> supplier2 = Person1::new;
        System.out.println(supplier2.get());
        Function<String, Person1> func = Person1::new;
        System.out.println(func.apply("mike"));
        BiFunction<String, Integer, Person1> bi = Person1::new;
        System.out.println(bi.apply("amy", 20));
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Person1 {
    private String name;
    private Integer age;

    public Person1(String name) {
        this.name = name;
    }
}
