package P02_Interfaces;

/**
 * @author: okhoogh
 * @date: 2021/8/10 16:03
 * @description: 接口默认方法
 */
public class T01_DefaultMethods {
    public static void main(String[] args) {
        BB b = new BB();
        b.test2();  // b调用接口默认方法
        CC c = new CC();
        c.test2();  // c调用自身覆盖接口的默认方法
    }
}

interface AA {
    void test1();
//    void test2();
    // 默认方法
    default void test2() {
        System.out.println("AA Test2");
    }
}

class BB implements AA {

    @Override
    public void test1() {
        System.out.println("BB Test1");
    }
}

class CC implements AA{

    @Override
    public void test1() {
        System.out.println("CC Test1");
    }

    @Override
    public void test2() {
        System.out.println("CC Test2");
    }
}
