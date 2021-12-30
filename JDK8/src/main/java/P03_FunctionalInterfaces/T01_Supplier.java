package P03_FunctionalInterfaces;

import java.util.Arrays;
import java.util.function.Supplier;

/**
 * @author: okhoogh
 * @date: 2021/8/10 16:37
 * @description: 供给者
 */

public class T01_Supplier {
    public static void main(String[] args) {
        PrintMax(() -> {
            int[] arr = {5, 4, 3, 2, 1};
            Arrays.sort(arr);
            return arr[arr.length - 1];
        });
    }


    private static void PrintMax(Supplier<Integer> supplier) {
        Integer max = supplier.get();
        System.out.println("Max = " + max);
    }
}
