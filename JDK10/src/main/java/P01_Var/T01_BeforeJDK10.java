package P01_Var;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @author: okhoogh
 * @date: 2021/12/17 16:52
 * @description: Problems with defining variables before JDK10
 * Many people complain that Java is strongly typed and requires a lot of boilerplate code.
 * It is clear that type declarations are often considered unnecessary.
 * In Java code prior to JDK10, declaring a variable was cumbersome.
 * Many popular programming languages already support some form of local variable type inference, such as JS(var)
 */
public class T01_BeforeJDK10 {
    public static void main(String[] args) {
        String str = "abc";
        long l = 10L;
        boolean b = true;
        ArrayList<String> list = new ArrayList();
        Stream<String> stream = list.stream();
    }
}
