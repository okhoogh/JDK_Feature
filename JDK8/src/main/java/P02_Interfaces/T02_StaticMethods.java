package P02_Interfaces;

/**
 * @author: okhoogh
 * @date: 2021/8/10 16:08
 * @description: 接口静态方法
 */
public class T02_StaticMethods {
    public static void main(String[] args) {
        // 调用各自的静态方法
        AAA.test1();
        BBB.test1();
    }
}

interface AAA {
    static void test1() {
        System.out.println("AAA接口静态方法");
    }
}

interface BBB extends AAA {
//    @Override // 静态方法不能重写
    static void test1() {
        System.out.println("BBB接口静态方法");
    }
}