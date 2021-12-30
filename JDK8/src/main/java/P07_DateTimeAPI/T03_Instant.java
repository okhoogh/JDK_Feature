package P07_DateTimeAPI;

import java.time.Instant;

/**
 * @author: okhoogh
 * @date: 2021/11/23 13:58
 * @description: 时间戳,方便操作秒和纳秒,一般是给程序使用的
 */
public class T03_Instant {
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println("当前时间戳 = " + now);
        // 获取1970年1月1日 00:00:00的秒
        System.out.println(now.getNano());
        System.out.println(now.getEpochSecond());
        System.out.println(now.toEpochMilli());
        System.out.println(System.currentTimeMillis());
        Instant instant = Instant.ofEpochSecond(5);
        System.out.println(instant);
    }
}
