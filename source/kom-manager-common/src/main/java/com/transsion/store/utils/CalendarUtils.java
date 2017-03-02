package com.transsion.store.utils;

import com.shangkang.tools.DateHelper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by liuzh on 17-3-1.
 */
public class CalendarUtils {
    public final static String[] DAYS = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    public final static String[] MONTHS = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    /**
     * 取得当前日期的年份数
     * @return
     */
    public static int getYear() {
        return getYear(Calendar.getInstance().getTime());
    }

    /**
     * 取得当前日期的月份数
     * @return
     */
    public static int getMonth() {
        return getMonth(Calendar.getInstance().getTime());
    }

    /**
     * 根据输入日期取得年份数
     * @param date
     * @return
     */
    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar.get(Calendar.YEAR);
    }

    /**
     * 根据输入日期取得月份数
     * @param date
     * @return
     */
    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 根据输入日期取得所在月份的第几周
     * @param date
     * @return
     */
    public static int getWeekOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);
        return calendar.get(Calendar.WEEK_OF_MONTH);
    }

    /**
     * 根据输入日期取得所在年份的第几周
     * @param date
     * @return
     */
    public static int getWeekOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 根据输入日期取得所在星期的第几天，以星期日为一周的第一天
     * @param date
     * @return
     */
    public static int getDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 根据输入日期取得所在月份的日期数
     * @param date
     * @return
     */
    public static int getDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static int getDayOfWeekInMonth(Date date) {
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
    }

    /**
     * 根据输入日期取得该日期在此年度的第几天
     * @param date
     * @return
     */
    public static int getDayOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * 根据输入日期返回英文月份（如2017-01-22返回Jan）
     * @param date
     * @return
     */
    public static String getMonthEn(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return MONTHS[calendar.get(Calendar.MONTH)];
    }

    /**
     * 根据输入日期返回英文星期,一周以星期日为第一天(如2017-03-01返回Wed)
     * @param date
     * @return
     */
    public static String getDayOfWeekEn(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return DAYS[calendar.get(Calendar.DAY_OF_WEEK) - 1];
    }

    /**
     * 根据输入日期和周期数取得之前或之后第n周的开始日期（即第n周的第一天)（n为负数则为第前n周，为正数则为第后n周,为0则为本周)(以星期日为每周的第一天）
     * 如输入日期为2017-03-01则之后第1周返回值为2017-03-05,之后第2周返回2017-03-12;
     * 之前第1周返回为2017-02-19,之前第2周返回2017-02-12
     * @param date
     * @param n
     * @return
     */
    public static Date getWeekFirstDay(Date date, int n) {
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        calendar.add(Calendar.DATE, (7 - dayOfWeek + 1) + 7 * (n - 1));

        return calendar.getTime();
    }

    /**
     * 根据输入日期和周期数取得之前或之后第n周的结束日期（即第n周的最后1天)（n为负数则为第前n周，为正数则为第后n周,为0则为本周)(以星期六为每周的最后一天）
     * 如输入日期为2017-03-01则之后第1周返回值为2017-03-11,之后第2周返回2017-03-18;
     * 之前第1周返回为2017-02-25,之前第2周返回2017-02-18
     * @param date
     * @param n
     * @return
     */
    public static Date getWeekEndDay(Date date, int n) {
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        calendar.add(Calendar.DATE, (7 - dayOfWeek) + 7 * n);

        return calendar.getTime();
    }
    
	public static Date getFirstDayOfMonth(String referenceDate) {
		Calendar c = Calendar.getInstance();
		Date convertedDate = DateHelper.parseDate(referenceDate);
		c.setTime(convertedDate);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
		return c.getTime();
	}

    public static void main(String[] s) {
        System.out.println(CalendarUtils.getMonth());
        System.out.println(CalendarUtils.getYear());
        System.out.println(CalendarUtils.getMonthEn(new Date()));
        System.out.println(CalendarUtils.getWeekOfMonth(new Date()));
        System.out.println(CalendarUtils.getWeekOfYear(new Date()));
        System.out.println(CalendarUtils.getDayOfWeek(new Date()));
        System.out.println(CalendarUtils.getDayOfMonth(DateHelper.parseDate("2017-02-23")));
        System.out.println(CalendarUtils.getDayOfWeekInMonth(DateHelper.parseDate("2017-02-23")));
        System.out.println(CalendarUtils.getDayOfYear(new Date()));
        System.out.println(CalendarUtils.getDayOfWeekEn(new Date()));
        System.out.println(CalendarUtils.getWeekFirstDay(DateHelper.parseDate("2017-03-05"), 3));

        System.out.println(CalendarUtils.getWeekEndDay(DateHelper.parseDate("2017-03-01"), 0));
        
        System.out.println("****");
        System.out.println(CalendarUtils.getFirstDayOfMonth("2017-03-09"));


    }
}
