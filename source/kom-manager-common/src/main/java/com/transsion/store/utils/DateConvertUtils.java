package com.transsion.store.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateConvertUtils {

	/**
	 * 根据输入的日期返回当前周每天的日期
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
		//默认周日是第一天
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
	
	//获取周的第一天日期
    public static String getWeekFirstDay(String date, int n) {
    	
        Calendar calendar = Calendar.getInstance();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式
        
		Date dt = new Date();
		
		try {
			dt = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        calendar.setTime(dt);

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        calendar.add(Calendar.DATE, (7 - dayOfWeek + 1) + 7 * (n - 1));
       
        String result = sdf.format(calendar.getTime());
        
        return  result;
    }
    
    
	
	/**
	 * 根据输入日期获取当前周 周六和周日的日期
	 * @author guihua.zhang on 2017-02-28
	 * */
	public static String getWeekDays(String date) {
		StringBuffer result = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式
		Date dt = new Date();
		try {
			dt = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天
		int day = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
		cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
		cal.add(Calendar.DATE, 5);
		String Saturday = sdf.format(cal.getTime());
		result.append(Saturday+",");
		cal.add(Calendar.DATE, -6);
		String Sunday = sdf.format(cal.getTime());
		result.append(Sunday);
		return result.toString();
	}
/*	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("planDate1", "2017-03-08");
		map.put("planQty2", "1");
		map.put("planDate3", "2017-03-09");
		map.put("planQty4", "1");
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("planDate1", "2017-03-08");
		map1.put("planDate3", "2017-03-09");
		map1.put("planQty5", "0");
		map1.putAll(map);
		System.out.println(map1);
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
