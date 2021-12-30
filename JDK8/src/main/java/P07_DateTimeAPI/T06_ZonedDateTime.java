package P07_DateTimeAPI;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author: okhoogh
 * @date: 2021/11/23 16:12
 * @description: Java8 中加入了对时区的支持，LocalDate、LocalTime、LocalDateTime是不带时区的
 * 带时区的日期时间类分别为：ZonedDate、ZonedTime、ZonedDateTime。
 * 其中每个时区都对应着一个ID，ID的格式为 “区域/城市” 例如：Asia/Shanghai
 * ZoneDate/ZoneTime/ZoneDateTime
 */
public class T06_ZonedDateTime {
    public static void main(String[] args) {
        // 1.获取所有的时区ID
//        ZoneId.getAvailableZoneIds().forEach(System.out::println);
        // 不带时间,获取计算机的当前时间
        LocalDateTime now = LocalDateTime.now(); // 中国使用的东八区的时区.比标准时间早8个小时
        System.out.println("now = " + now);
        // 2.操作带时区的类
        // now(Clock.systemUTC()): 创建世界标准时间
        ZonedDateTime bz = ZonedDateTime.now(Clock.systemUTC());
        System.out.println("bz = " + bz);
        // now(): 使用计算机的默认的时区,创建日期时间
        ZonedDateTime now1 = ZonedDateTime.now();
        System.out.println("now1 = " + now1); // 2021-11-23T16:19:02.233278700+08:00[Asia/Shanghai]
        // 使用指定的时区创建日期时间
        ZonedDateTime now2 = ZonedDateTime.now(ZoneId.of("America/Vancouver"));
        System.out.println("now2 = " + now2); // 2021-11-23T00:19:02.234279-08:00[America/Vancouver]
    }
}
