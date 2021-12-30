package P07_DateTimeAPI;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author: okhoogh
 * @date: 2021/11/23 11:30
 * @description: 日期格式化及解析
 * @result:
 *
 */
public class T02_DateTimeFormat {
    public static void main(String[] args) {
        // 当前日期时间
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 将日期时间格式化为字符串
        String format = now.format(formatter);
        System.out.println("format = " + format);
        // 将字符串解析为日期时间
        LocalDateTime parse = LocalDateTime.parse("1985-09-23 10:12:22", formatter);
        System.out.println("parse = " + parse);
    }
}
