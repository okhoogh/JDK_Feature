package P02_Local_VS_Var;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: okhoogh
 * @date: 2022/1/4 11:27
 * @description: 局部变量类型推断就是左边的类型直接使用 var 定义，而不用写具体的类型
 * 编译器能根据右边的表达式自动推断类型
 *
 * 1.var a; 这样不可以, 因为无法推断
 * 2.类的属性的数据类型不可以使用var
 * 3.var不同于js,类型依然是静态类型，var不可以在lambda表达式中混用
 */
public class T01_Basic {
    public static void main(String[] args) {
        var str = "Hello";  // == String str = "Hello"
        System.out.println(str);

        Map<String,Integer> maps = new HashMap<>();
        maps.put("iphoneX" , 1);
        maps.put("huawei" , 8);
        maps.put("Java" , 1);
        System.out.println(maps);

        // 1.传统方式
//        long start1 = System.currentTimeMillis();
//        Set<Map.Entry<String, Integer>> entries1 = maps.entrySet();
//        for(Map.Entry<String,Integer> entry : entries1){
//            String key = entry.getKey();
//            Integer value = entry.getValue();
//            System.out.println(key +"---->"+value);
//        }
//        long end1 = System.currentTimeMillis();
//        System.out.println(end1 - start1);

        System.out.println("----------------");

        // 2.局部变量推断对于较复杂的类型也有很好的简化作用
        long start2 = System.currentTimeMillis();
        var entries2 = maps.entrySet();
        for(var entry : entries2){
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key +"---->"+value);
        }
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - start2);
    }
}
