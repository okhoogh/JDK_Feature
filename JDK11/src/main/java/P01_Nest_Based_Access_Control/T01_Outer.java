package P01_Nest_Based_Access_Control;

/**
 * @author: okhoogh
 * @date: 2022/1/4 9:50
 * @description: 虽然从逻辑上讲，内部类是与外部类相同的代码实体的一部分，但它被编译为一个单独的类。
 * 因此，它需要编译器创建合成桥接方法，以提供对外部类的私有字段的访问。
 * 这种方案一个很大的坑是反射的时候会有问题。当使用反射在内部类中访问外部类的私有成员outerInt时会报
 * IllegalAccessError错误。这个是让人不能理解的，因为反射还是源码级访问的权限。
 */
public class T01_Outer {

    private int outerInt;

    class Inner {
        public void test() {
            System.out.println("Outer int = " + outerInt);
        }
    }
}