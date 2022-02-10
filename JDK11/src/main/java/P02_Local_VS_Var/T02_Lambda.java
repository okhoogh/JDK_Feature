package P02_Local_VS_Var;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: okhoogh
 * @date: 2022/1/4 11:34
 * @description: 在声明隐式类型的lambda表达式的形参时允许使用var, 使用var的好处是在使用lambda表达式时给参数加上注解
 * Lambda是用于简化函数式接口的匿名内部类的形式
 */
public class T02_Lambda {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        Collections.addAll(nums, 9, 10, 3);
        nums.sort((var o2, var o1) -> o2 - o1);
        System.out.println(nums);
    }
}
