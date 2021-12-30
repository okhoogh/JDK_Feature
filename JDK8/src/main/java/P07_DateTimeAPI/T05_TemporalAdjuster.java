package P07_DateTimeAPI;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;

/**
 * @author: okhoogh
 * @date: 2021/11/23 16:07
 * @description: 时间校正器
 * 将日期调整到“下一个月的第一天”等操作。可以通过时间校正器来进行。
 * TemporalAdjuster : 时间校正器。
 * TemporalAdjusters : 该类通过静态方法提供了大量的常用TemporalAdjuster的实现
 */
public class T05_TemporalAdjuster {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        // 下一个月的第一天
        TemporalAdjuster firsWeekDayOfNextMonth = temporal -> {
            LocalDateTime dateTime = (LocalDateTime) temporal;
            LocalDateTime nextMonth = dateTime.plusMonths(1).withDayOfMonth(1);
            return nextMonth;
        };
        LocalDateTime nextMonth = now.with(firsWeekDayOfNextMonth);
        System.out.println("nextMonth = " + nextMonth);
    }
}
