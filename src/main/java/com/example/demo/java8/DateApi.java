package com.example.demo.java8;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <功能说明>
 * java8的时间api,替掉之前的Date  线程安全
 *
 * @author zhanjiantong
 * @version Revision 1.0.0
 * 修改时间 2021/5/24  | 修改内容
 */
public class DateApi {

    //1.Instant 时间戳
    public static void instant() {
        Instant instant = Instant.now();
        //2021-05-24T07:15:54.738Z
        System.out.println(instant);

        //解决办法:加上8个小时
        Instant instant1 = Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8));
        System.out.println(instant1);
        //plusMillis():增加时间戳时间 以毫秒为单位,也有增加纳秒和秒的方法
        //minusNanos():增加时间戳时间 以纳秒为单位
        //minusSeconds():增加时间戳时间 以秒为单位
        //TimeUnit.HOURS.toMillis():将小时转化为毫秒

        //获取从1970 1月1日到现在的 毫秒
        System.out.println(instant.toEpochMilli());
        //判断 instant 是否在目标时间之后这里应该是true
        System.out.println(instant.isAfter(instant1));
        //判断 instant 是否在目标时间之前这里应该是true
        System.out.println(instant.isBefore(instant1));
        //判断两个时间戳是否相等 返回true
        System.out.println(instant.equals(instant1));
    }


    //2.LocalDateTime
    public static void LocalDateTimeTest() {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        //localDateTime.format会调用formatter.format方法
        System.out.println(localDateTime.format(formatter));
        System.out.println(formatter.format(localDateTime));

        //时间计算
        LocalDateTime localDateTime1 = localDateTime.plusHours(2).plusMinutes(2);
        System.out.println(localDateTime1.format(formatter));

        //时间比较
        System.out.println(localDateTime.isBefore(localDateTime1));
        System.out.println(localDateTime.isAfter(localDateTime1));
        System.out.println(localDateTime.isEqual(localDateTime1));
    }

    //Localdate 和 LocalTime
    public static void LocatDateAndTimeTest() {
        LocalDate localDate = LocalDate.now();
        localDate = LocalDate.ofYearDay(2005, 86); // 获得2005年的第86天 (27-Mar-2005)
        System.out.println(localDate);
        LocalDate localDate2 = LocalDate.of(2013, Month.AUGUST, 10); //2013年8月10日
        System.out.println(localDate2);
        System.out.println(ChronoUnit.DAYS.between(localDate, localDate2));

        LocalTime localTime = LocalTime.of(1, 0); //10:33 PM
        LocalTime localTime3 = LocalTime.now();
        System.out.println(localTime);
        System.out.println(localTime.minusMinutes(1));
        System.out.println(localTime.minusMinutes(2));
        System.out.println(localTime3.isAfter(localTime));
        LocalTime localTime2 = LocalTime.ofSecondOfDay(4503); // 返回一天中的第4503秒 (1:15:30 AM)
        System.out.println(localTime2);
        //时间差
        long hoursBetween = ChronoUnit.HOURS.between(localTime, localTime2);
        System.out.println(hoursBetween);

    }

//    public static void getDaysBefor(LocalDate localDate, int days){
    public static void getDaysBefor(){
        LocalDate localDate= LocalDate.now();
        int monthdays = localDate.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
        int dayOfMonth = localDate.getDayOfMonth();
        int days = 0;
        if(dayOfMonth == monthdays){
            //今天是这个月的最后一天
            days = monthdays;
        }else {
            //今天不是这个月的最后一天
            days = Integer.valueOf(ChronoUnit.DAYS.between(localDate.minusMonths(1), localDate) + "");
        }

        List<String> list = new ArrayList<>();
        for(int i = days-1; i >= 0; i--){
            String format = localDate.minusDays(i).format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
            list.add(format);
        }
//        System.out.println(localDate.minusMonths(1).plusDays(1).format(DateTimeFormatter.ofPattern("yyyy.MM.dd")));
        System.out.println(list);
        System.out.println(list.size());
    }

    public static void str2LocalDateTime(String timeStr, DateTimeFormatter formatter){
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime parse = LocalDateTime.parse(timeStr, formatter);
        long between = ChronoUnit.MINUTES.between(parse,currentTime);
        System.out.println(between);

    }

    static DateTimeFormatter yyyyMMddHHmm =
            DateTimeFormatter.ofPattern("yyyyMMddHHmm");

    public static void main(String[] args) throws Exception {
//        instant();
//        LocalDateTimeTest();
//        LocatDateAndTimeTest();

//        getDaysBefor(LocalDate.now(), 30);
//        getDaysBefor();

        str2LocalDateTime("202107301110", yyyyMMddHHmm);


//        LocalDateTime end = LocalDateTime.now().withHour(23).withMinute(59).withSecond(59);
//        LocalDateTime start = end.minusDays(30).withHour(0).withMinute(0).withSecond(0);
//        System.out.println(start);
//        System.out.println(end);

//        System.out.println(LocalDate.now(ZoneId.of("Asia/Shanghai")).format(DateTimeFormatter.BASIC_ISO_DATE));
//
//        LocalDate localDate = LocalDate.now();
//        System.out.println(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
//
//
//
//
//        LocalDateTime end = LocalDateTime.now().minusHours(2L);
//        System.out.println(Date.from(end.atZone(ZoneId.systemDefault()).toInstant()));
//
//        String dateStr = "20210608";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
//        Date date = simpleDateFormat.parse(dateStr);
//        System.out.println(date);
//
//        System.out.println(LocalDateTime.now().minusMinutes(5).format(DateTimeFormatter.ofPattern("yyyyMMddHHmm")));



//        LocalDateTime end = LocalDateTime.now().minusMinutes(10).withSecond(0).withNano(0);
//        LocalDateTime start = end.minusMinutes(10);
//        System.out.println(end);
//        System.out.println(start);


    }


}
