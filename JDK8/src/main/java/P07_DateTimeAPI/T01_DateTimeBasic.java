package P07_DateTimeAPI;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author: okhoogh
 * @date: 2021/11/23 10:44
 * @description: LocalDate、LocalTime、LocalDateTime创建及获取
 * 1. ***.of()                          创建指定的日期时间
 * 2. ***.get***()                      获取对应的数值
 * 3. ***.with***()                     设置指定的数值(创建新的副本，不会对原来的造成影响)
 * 4. ***.plus***()                     加上指定的数值
 * 5. ***.minus***()                    减去指定的数值
 * 6. *** == ***                        直接比较两个日期时间相不相等
 * 7. isBefore() isAfter() equals()     比较日期时间之前、之后、相等
 */
public class T01_DateTimeBasic {
    // LocalDate:获取日期时间的信息。格式为 2019-10-16
    @Test
    public void test01() {
        // 指定日期
        LocalDate localDate = LocalDate.of(1985, 9, 23);
        // 1985-09-23
        System.out.println("指定日期: " + localDate);
        // 当前日期
        LocalDate nowDate = LocalDate.now();
        System.out.println("今天: " + nowDate);
        // 获取日期信息
        System.out.println("年: " + nowDate.getYear());
        System.out.println("月: " + nowDate.getMonthValue());
        System.out.println("日: " + nowDate.getDayOfMonth());
        System.out.println("星期: " + nowDate.getDayOfWeek());
    }

    // LocalTime类: 获取时间信息。格式为 16:38:54.158549300
    @Test
    public void test02() {
        // 指定时间
        LocalTime time = LocalTime.of(12, 15, 28, 129_900_000);
        System.out.println("指定时间: " + time);
        // 当前时间
        LocalTime nowTime = LocalTime.now();
        System.out.println("当前时间: " + nowTime);
        // 获取时间信息
        System.out.println("小时: " + nowTime.getHour());
        System.out.println("分钟: " + nowTime.getMinute());
        System.out.println("秒: " + nowTime.getSecond());
        System.out.println("纳秒: " + nowTime.getNano());
    }

    // LocalDateTime类: 获取日期时间信息。格式为 2018-09-06T15:33:56.750
    @Test
    public void test03() {
        LocalDateTime localDateTime = LocalDateTime.of(1985, 9, 23, 9, 10, 20);
        System.out.println("localDateTime = " + localDateTime); // 1985-09-23T09:10:20
        // 当前日期时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前日期时间 = " + now);
        System.out.println("年: " + now.getYear());
        System.out.println("月: " + now.getMonthValue());
        System.out.println("日: " + now.getDayOfMonth());
        System.out.println("星期: " + now.getDayOfWeek());
        System.out.println("小时: " + now.getHour());
        System.out.println("分钟: " + now.getMinute());
        System.out.println("秒: " + now.getSecond());
        System.out.println("纳秒: " + now.getNano());
    }

    // 对日期时间的修改
    @Test
    public void test05() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前日期时间 = " + now);
        // 修改日期时间
        LocalDateTime setYear = now.withYear(2078);
        System.out.println("修改年份: " + setYear);
        System.out.println("now == setYear: " + (now == setYear));
        System.out.println("修改月份: " + now.withMonth(6));
        System.out.println("修改小时: " + now.withHour(9));
        System.out.println("修改分钟: " + now.withMinute(11));
        // 再当前对象的基础上加上或减去指定的时间
        LocalDateTime plusDays = now.plusDays(5);
        System.out.println("5天后: " + plusDays);
        System.out.println("now == plusDays: " + (now == plusDays));
        System.out.println("10年后: " + now.plusYears(10));
        System.out.println("20年后: " + now.plusYears(20));
        System.out.println("20年前: " + now.minusYears(20));
        System.out.println("5月前: " + now.minusMonths(5));
        System.out.println("100天前: " + now.minusDays(100));
    }

    // 日期时间的比较：用isBefore()、isAfter()、equals()来比较，也可直接进行比较。
    @Test
    public void test06() {
        LocalDate now = LocalDate.now();
        LocalDate date = LocalDate.of(2008, 8, 8);
        System.out.println(now.isBefore(date)); // false
        System.out.println(now.isAfter(date)); // true
    }


}
