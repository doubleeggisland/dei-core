package com.ioiox.dei.core.utils;

import com.ioiox.dei.core.constant.DeiGlobalConstant;
import org.apache.commons.lang3.StringUtils;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

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

        final String orderIds = "TR22325235352018147,TR22327154556676439,TR22329090759279025,TR22329122359879255,TR22329154232729289,TR22330154814533407,TR22330185453954163,TR22330213725553314,TR22330213725618457,TR22330222920669310,TR22331143419888077,TR22331183034631143,TR22331210043692272,TR22331213128853391,TR22331220155920315,TR22331220155953496,TR22331231322426142,TR22331232015449161,TR22332180321768489,TR22332202815435342,TR22332202815490305,TR22333181350096257,TR22333213716927269,TR22334115942315372,TR22334174642369197,TR22334174642396172,TR22334174642425456,TR22334174642453355,TR22334233327293009,TR22334233327333143,TR22335171151227029,TR22335171151294421,TR22335171151392177,TR22335171151424230,TR22336104052241332,TR22336144232628105,TR22336144232661029,TR22336152208326229,TR22336224617727207,TR22337012042078327,TR22337012042106049,TR22337012042145063,TR22337012042173221,TR22337171140086416,TR22338193813621350,TR22339234155255194,TR22341085926380010,TR22341090121509266,TR22341093038245136,TR22343105011475373,TR22344013557946428,TR22344143953975017,TR22345194119499227,TR22345194119526124,TR22346195642949168,TR22346200224666470,TR22347013658780343,TR22347014943534243,TR22347042248499358,TR22347193817621316,TR22349125854032197,TR22350134056253024,TR22350184135409472,TR22353231742216067,TR22355090408819058,TR22355090408879142,TR22355141734469401,TR22355193840532203,TR22355194117606120,TR22358183118659264,TR22360172710473256,TR22360172710500261,TR22361222822272284,TR22363230552760291,TR22363230552785276,TR22364093721971397,TR22365200837323314,TR22365200837351301,TR22365200837391171,TR22365200954504470,TR22365200954536157,TR22365200954563127,TR23001203816403275,TR23001203816431465,TR23002162409741163,TR23003092138713013,TR23004223724293232,TR23005091710946252,TR23007003142031141,TR23007122227269140,TR23007170004178274,TR23008133917871397,TR23008133917899134,TR23012125807543310,TR23013222046615400,TR23014145535902402,TR23016110638752319,TR23017115542254196,TR23028123908425003,TR23031105935882199,TR23044224906066436,TR23044224906119215,TR23050121513335201,TR23050121513435124,TR23060194712377450,TR23080200322427486,TR23082191119674286";
        final List<String> orderIdList = Arrays.asList(StringUtils.split(orderIds, ","));
        final int count = orderIdList.size() % 20 == 0 ? orderIdList.size() / 20 : orderIdList.size() / 20 + 1;
        for (int i = 0 ; i <  count ; i++) {
            final List<String> subOrderIds = DeiCollectionUtil.sublist(orderIdList, i * 20, 20);
            final String subOrderIdsStr = subOrderIds.stream().map(item -> String.format("\"%s\"", item)).collect(Collectors.joining(","));
            final String jobParam = String.format("{\"orderIds\": [%s]}", subOrderIdsStr);
            System.out.println(jobParam);
        }
    }
}
