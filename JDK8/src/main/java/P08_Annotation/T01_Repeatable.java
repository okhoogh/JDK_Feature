package P08_Annotation;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author: okhoogh
 * @date: 2021/11/23 16:32
 * @description: 重复注解@Repeatable
 * 注解有一个很大的限制是：在同一个地方不能多次使用同一个注解。
 * JDK8引入了重复注解的概念，允许在同一个地方多次使用同一个注解，使用@Repeatable注解定义重复注解。
 */
public class T01_Repeatable {
    public static void main(String[] args) throws NoSuchMethodException {
        // 解析类上的指定注解
        System.out.println("On Class");
        Mytest[] mytests = AnnoTest.class.getAnnotationsByType(Mytest.class);
        for (Mytest mytest : mytests) {
            System.out.println(mytest.value());
        }

        // 解析方法上的指定注解
        System.out.println("On Method");
        Mytest[] tests = T01_Repeatable.class.getMethod("test").getAnnotationsByType(Mytest.class);
        for (Mytest test : tests) {
            System.out.println(test.value());
        }
    }

    @Mytest("1")
    @Mytest("2")
    public void test() {

    }
}

@Mytest("123")
@Mytest("456")
@Mytest("789")
class AnnoTest {

}

@Retention(RetentionPolicy.RUNTIME)
@interface Mytests {
    Mytest[] value();
}

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Mytests.class)
@interface Mytest {
    String value();
}
