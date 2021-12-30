package P01_Lambda;

/**
 * @author: okhoogh
 * @date: 2021/8/9 16:41
 * @description: 无参数无返回值Lambda
 */
public class T01_NoArgsAndReturns {
    public static void main(String[] args) {
        goSwimming(() -> System.out.println("去游泳啦！"));
    }
    public static void goSwimming(Swimmable swimmable) {
        swimmable.swimming();
    }
}

@FunctionalInterface
interface Swimmable {
    void swimming();
}