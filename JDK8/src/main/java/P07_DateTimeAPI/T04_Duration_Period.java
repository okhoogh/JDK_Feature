package P07_DateTimeAPI;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

/**
 * @author: okhoogh
 * @date: 2021/11/23 15:53
 * @description:
 * 1. Duration：用于计算2个时间(LocalTime，时分秒)的距离
 * 2. Period：用于计算2个日期(LocalDate，年月日)的距离
 */
public class T04_Duration_Period {
    public static void main(String[] args) {
        // Duration计算时间的距离
        LocalTime now = LocalTime.now();
        LocalTime time = LocalTime.of(14, 15, 20);
        Duration duration = Duration.between(time, now);
        System.out.println("相差的天数:" + duration.toDays() + "d");
        System.out.println("相差的天数:" + duration.toDays() + "h");
        System.out.println("相差的小时数:" + duration.toHours() + "h");
        System.out.println("相差的分钟数:" + duration.toMinutes() + "mins");
        System.out.println("相差的秒数:" + duration.toSeconds() + "s");
        System.out.println("---------------------------");
        // Period计算日期的距离
        LocalDate nowDate = LocalDate.now();
        LocalDate date = LocalDate.of(1998, 8, 8);
        // 让后面的时间减去前面的时间
        Period period = Period.between(date, nowDate);
        System.out.println("相差的年:" + period.getYears());
        System.out.println("相差的 :" + period.getMonths());
        System.out.println("相差的天:" + period.getDays());
    }
}
