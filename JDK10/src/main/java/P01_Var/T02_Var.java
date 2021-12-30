package P01_Var;

import java.util.ArrayList;

/**
 * @author: okhoogh
 * @date: 2021/12/17 16:53
 * @description: JDK10 use of local variable type inference (var)
 * 1. Local variables
 * 2. Variables in the loop
 */
public class T02_Var {
    public static void main(String[] args) {
        var str = "abc";                             // Inferred to be a String
        var longNum = 77L;                           // Inferred to be a long number
        var flag = true;                             // Inferred to be a boolean
        var list = new ArrayList<Integer>();         // Inferred to be a ArrayList<Integer>
        var stream = list.stream();  // Inferred to be a Stream<String>

        for (var i = 0; i < 5; ++i) {
            list.add(i);
        }

        for (var val : list) {
            System.out.println(val);
        }
    }
}
