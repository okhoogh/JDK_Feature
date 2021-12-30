package P08_Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author: okhoogh
 * @date: 2021/11/23 16:45
 * @description: 类型注解
 * JDK 8为@Target元注解新增了两种类型：TYPE_PARAMETER、TYPE_USE
 * TYPE_PARAMETER：表示该注解能写在类型参数的声明语句中。 类型参数声明如： <T> 、
 * TYPE_USE：表示注解可以在任何用到类型的地方使用
 */
public class T02_Type {
    public static void main(String[] args) {
        @NotNull int x = 1;
        @NotNull String s = null;
    }

    <@TypeParam t> void test() {
    }
}

@Target(ElementType.TYPE_USE)
@interface NotNull {}

@Target(ElementType.TYPE_PARAMETER)
@interface TypeParam {}

