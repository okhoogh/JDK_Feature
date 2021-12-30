package P01_Var;

/**
 * @author: okhoogh
 * @date: 2021/12/17 17:58
 * @description: Local variable type inference (var) cannot use scenarios
 * 1. Member variables
 * 2. Method parameters
 * 3. Method return type
 */
public class T03_Attention {

//    var x = 0;                            // Member variables cannot use var

//    public static void test1(var a) {}    // Parameter cannot use var

//    public var test2() {}                 // Method return types cannot use var

/*********************************************************************************************************************/
// Considerations for local variable type inference

    /**
     * 1. Var is not a keyword but can be used as an identifier,
     * which means that a variable, method, or package name can be written as var.
     * But normally no one would write that, because that would violate the common naming conventions.
     */
    public static void test03() {
        var var = 10;
        System.out.println("var = " + var);
    }

    // Var cannot be used to declare variables that have no assigned value, or to declare multiple variables
    public static void test04() {
//        var x = null;                     // No, we can't figure out what type
        int x = 1, y = 2;                   // Yes
        // var m = 1, n = 2;                // No, declare multiple variables
    }

    public static void main(String[] args) {
//        test01(1);
//        test02();
//        test03();
//        test04();
    }
}