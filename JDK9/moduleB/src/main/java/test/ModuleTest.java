package test;

import util.ArrayUtils;

/**
 * @author: okhoogh
 * @date: 2021/11/24 9:30
 * @description:
 */
public class ModuleTest {
    public static void main(String[] args) {
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = i;
        }
        int max = ArrayUtils.getMax(arr);
        System.out.println(max);
    }
}
