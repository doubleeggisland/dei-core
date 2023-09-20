package com.ioiox.dei.core.utils;

import com.ioiox.dei.core.constant.DeiGlobalConstant;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateUtil {
    public static final String PATTERN_YYYY_MM_DD_SLIM = "yyyyMMdd";
    public static final String PATTERN_YYYY_MM = "yyyy-MM";
    public static final String PATTERN_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String PATTERN_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public static final String PATTERN_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_HH_MM_SS = "HH:mm:ss";
    public static final String PATTERN_HH_MM = "HH:mm";
    public static final String PATTERN_MM_DD_CN = "MM月dd日";
    public static final String PATTERN_YYYY_MM_DD_CN = "yyyy年MM月dd日";
    public static final String PATTERN_YYYY_MM_CN = "yyyy年MM月";
    public static final String PATTERN_MM_DD_HH_MM_CN = "MM月dd日HH时mm分";
    public static final long MILLI_SECONDS_OF_A_DAY = 86400000;
    public static final Map<Integer, String> DAYS_OF_WEEK_CN = new HashMap<>(7);
    static {
        DAYS_OF_WEEK_CN.put(Calendar.MONDAY, "星期一");
        DAYS_OF_WEEK_CN.put(Calendar.TUESDAY, "星期二");
        DAYS_OF_WEEK_CN.put(Calendar.WEDNESDAY, "星期三");
        DAYS_OF_WEEK_CN.put(Calendar.THURSDAY, "星期四");
        DAYS_OF_WEEK_CN.put(Calendar.FRIDAY, "星期五");
        DAYS_OF_WEEK_CN.put(Calendar.SATURDAY, "星期六");
        DAYS_OF_WEEK_CN.put(Calendar.SUNDAY, "星期日");
    }

    public static String format(final Date date, final String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }

    public static Date parse(final String dateStr, final String pattern) {
        Date date = null;
        try {
            date = new SimpleDateFormat(pattern).parse(dateStr);
        } catch (ParseException ignored) {}
        return date;
    }

    public static Date givenDate(final int year, final int month, final int dayOfMonth) {
        return givenTime(year, month, dayOfMonth, 0, 0, 0, 0);
    }

    public static Date givenTime(final int year, final int month, final int dayOfMonth,
                                 final int hourOfDay, final int minute, final int second, final int ms) {
        final Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        cal.set(Calendar.HOUR_OF_DAY, hourOfDay);
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.SECOND, second);
        cal.set(Calendar.MILLISECOND, ms);
        return cal.getTime();
    }

    public static Date currentTime() {
        return new Date(System.currentTimeMillis());
    }

    public static Date firstDayOfMonth(final Date givenDate) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(givenDate);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    public static Date lastDayOfMonth(final Date givenDate) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(givenDate);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    public static Date firstDayOfYear(final Date givenDate) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(givenDate);
        final int firstDay = cal.getActualMinimum(Calendar.DAY_OF_YEAR);
        cal.set(Calendar.DAY_OF_YEAR, firstDay);
        return cal.getTime();
    }

    public static Date lastDayOfYear(final Date givenDate) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(givenDate);
        final int firstDay = cal.getActualMaximum(Calendar.DAY_OF_YEAR);
        cal.set(Calendar.DAY_OF_YEAR, firstDay);
        return cal.getTime();
    }

    public static Date beginningOfGivenDate(final Date givenDate) {
        return setTime(givenDate, 0, 0, 0, 0);
    }

    public static Date endingOfGivenDate(final Date givenDate) {
        return setTime(givenDate, 23, 59, 59, 999);
    }

    public static Date endingOfGivenDate(final Date givenDate, final int ms) {
        return setTime(givenDate, 23, 59, 59, ms);
    }

    public static int daysGap(final Date startDate, final Date endDate) {
        final Date beginningOfStartDate = beginningOfGivenDate(startDate);
        final Date beginningOfEndDate = beginningOfGivenDate(endDate);
        final long gapInMs = beginningOfEndDate.getTime() - beginningOfStartDate.getTime();
        return  (int) gapInMs / DeiGlobalConstant.MILLISECONDS_OF_A_DAY;
    }

    public static long gapInMs(final Date startTime, final Date endTime) {
        return endTime.getTime() - startTime.getTime();
    }

    public static Date setTime(final Date givenTime, final int hourOfDay, final int minute, final int second, final int ms) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(givenTime);
        cal.set(Calendar.HOUR_OF_DAY, hourOfDay);
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.SECOND, second);
        cal.set(Calendar.MILLISECOND, ms);
        return cal.getTime();
    }

    public static Date addHours(final Date givenDate, final int amount) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(givenDate);
        cal.add(Calendar.HOUR_OF_DAY, amount);
        return cal.getTime();
    }

    public static Date addMinutes(final Date givenDate, final int amount) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(givenDate);
        cal.add(Calendar.MINUTE, amount);
        return cal.getTime();
    }

    public static Date addDays(final Date givenDate, final int amount) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(givenDate);
        cal.add(Calendar.DAY_OF_MONTH, amount);
        return cal.getTime();
    }

    public static Date addMonths(final Date givenDate, final int amount) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(givenDate);
        cal.add(Calendar.MONTH, amount);
        return cal.getTime();
    }

    public static Date addYears(final Date givenDate, final int amount) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(givenDate);
        cal.add(Calendar.YEAR, amount);
        return cal.getTime();
    }

    public static int getSeconds(final Date givenDate) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(givenDate);
        return cal.get(Calendar.SECOND);
    }

    public static int getMinutes(final Date givenDate) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(givenDate);
        return cal.get(Calendar.MINUTE);
    }

    public static int getHours(final Date givenDate) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(givenDate);
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    public static int getYear(final Date givenDate) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(givenDate);
        return cal.get(Calendar.YEAR);
    }

    public static int getMonth(final Date givenDate) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(givenDate);
        return cal.get(Calendar.MONTH) + 1;
    }

    public static int getDayOfMonth(final Date givenDate) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(givenDate);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 返回星期几
     */
    public static String dayOfWeekInCN(final Date givenDate) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(givenDate);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return DAYS_OF_WEEK_CN.get(dayOfWeek);
    }

    /**
     * 判断是否是周末
     */
    public static boolean weekend(final Date givenDate) {
        final Calendar ca   = Calendar.getInstance();
        ca.setTime(givenDate);
        final int dayOfWeek = ca.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek == Calendar.SATURDAY
                || dayOfWeek == Calendar.SUNDAY;
    }

    public static void main(String [] args) {
        final Date currentTime = new Date(System.currentTimeMillis());
        System.out.println(getHours(currentTime));
        System.out.println(getMinutes(currentTime));
        System.out.println(getSeconds(currentTime));

        System.out.println(format(firstDayOfMonth(currentTime), PATTERN_YYYY_MM_DD));
        System.out.println(format(lastDayOfMonth(currentTime), PATTERN_YYYY_MM_DD));
        System.out.println(format(firstDayOfYear(currentTime), PATTERN_YYYY_MM_DD));
        System.out.println(format(lastDayOfYear(currentTime), PATTERN_YYYY_MM_DD));

        System.out.println(format(givenTime(2022, 2, 1, 11, 23,45, 44), PATTERN_YYYY_MM_DD_HH_MM_SS));

        System.out.println(Time.valueOf("08:00:00").getTime());
    }
}
