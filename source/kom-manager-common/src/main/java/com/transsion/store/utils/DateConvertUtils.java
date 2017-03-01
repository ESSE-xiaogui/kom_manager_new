package com.transsion.store.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateConvertUtils {

	/**
	 * 根据输入的日期返回当前周所有日期
	 * @author guihua.zhang on 2017-02-28
	 */
	public static List<String> getAllWeekDays(String date) {
		List<String> list = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式
		Date dt = new Date();
		try {
			dt = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		// 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
		int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
		if (1 == dayWeek) {
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}
		cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天
		int day = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
		cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
		list.add(sdf.format(cal.getTime()));
		for(int i=0;i<5;i++){
			cal.add(Calendar.DATE, 1);
			list.add(sdf.format(cal.getTime()));
		}
		//本周周日
		cal.add(Calendar.DATE, -6);
		list.add(sdf.format(cal.getTime()));
		return list;
	}
	
	/*public static void main(String[] args) {
		String date = "2017-03-08";
		List<String> list = getAllWeekDays(date);
		System.out.println(list);
	}*/
/*	public static void main(String[] args) {
		String planDate = "2017-04-01";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式
		Date date = new Date();
		try {
			date = sdf.parse(planDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		// 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
		int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
		if (1 == dayWeek) {
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}
		System.out.println("要计算日期为:" + sdf.format(cal.getTime())); // 输出要计算日期
		cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
		int day = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
		cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
		String Monday = sdf.format(cal.getTime());
		System.out.println("所在周星期一的日期：" + Monday);
		cal.add(Calendar.DATE, 1);
		String Tuesday = sdf.format(cal.getTime());
		System.out.println("所在周星期二的日期：" + Tuesday);
		cal.add(Calendar.DATE, 1);
		String Wednesday = sdf.format(cal.getTime());
		System.out.println("所在周星期三的日期：" + Wednesday);
		cal.add(Calendar.DATE, 1);
		String Thursday = sdf.format(cal.getTime());
		System.out.println("所在周星期四的日期：" + Thursday);
		cal.add(Calendar.DATE, 1);
		String Friday = sdf.format(cal.getTime());
		System.out.println("所在周星期五的日期：" + Friday);
		cal.add(Calendar.DATE, 1);
		String Saturday = sdf.format(cal.getTime());
		System.out.println("所在周星期六的日期：" + Saturday);
		cal.add(Calendar.DATE, -6);
		String Sunday = sdf.format(cal.getTime());
		System.out.println("所在周星期日的日期：" + Sunday);
	}*/
}
