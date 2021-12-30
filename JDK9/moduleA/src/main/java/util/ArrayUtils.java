package util;

/**
 * @author: okhoogh
 * @date: 2021/11/24 9:06
 * @description: Array工具类
 */
public class ArrayUtils {
    public static int getMax(int[] arr) {
        int Max = -1;
        for (int i = 0; i < arr.length; i++) {
            if (Max < arr[i]) {
                int t = Max;
                Max = arr[i];
                arr[i] = t;
            }
        }
        return Max;
    }
}
