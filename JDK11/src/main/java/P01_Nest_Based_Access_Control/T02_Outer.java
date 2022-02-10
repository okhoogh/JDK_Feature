package P01_Nest_Based_Access_Control;

import java.lang.reflect.Field;

/**
 * @author: okhoogh
 * @date: 2022/1/4 10:49
 * @description: JDK 11开始，嵌套是一种访问控制上下文，它允许多个class同属一个逻辑代码块，但是被编译成多个分散的class文
 * 件，它们访问彼此的私有成员无需通过编译器添加访问扩展方法，而是可以直接进行访问，如果上述代码可以直接通
 * 过反射访问外部类的私有成员，而不会出现权限问题
 */
public class T02_Outer {
    private int outerInt;

    class Inner {
        public void test() throws Exception {
            System.out.println("Outer int = " + outerInt);
            // JDK 11之前，如下代码报出异常：IllegalAccessException
            Class c = T02_Outer.class;
            Field f = c.getDeclaredField("outerInt");
            f.set(T02_Outer.this, 23);
        }
    }

    public static void main(String[] args) throws Exception {
        new T02_Outer().new Inner().test();
    }
}
