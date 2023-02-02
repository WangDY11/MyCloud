package com.wdy.common.util;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 计算时间类
 * 
 * @author zhm
 * @version 2017年6月28日
 */
@Component
public class IntervalUtil {

	public static String getInterval(String createtime) { // 传入的时间格式必须类似于2012-8-21
															// 17:53:20这样的格式
		String interval = null;

		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ParsePosition pos = new ParsePosition(0);
		Date d1 = (Date) sd.parse(createtime, pos);

		// 用现在距离1970年的时间间隔new
		// Date().getTime()减去以前的时间距离1970年的时间间隔d1.getTime()得出的就是以前的时间与现在时间的时间间隔
		long time = new Date().getTime() - d1.getTime();// 得出的时间间隔是毫秒

		if (time / 1000 < 10 && time / 1000 >= 0) {
			// 如果时间间隔小于10秒则显示“刚刚”time/10得出的时间间隔的单位是秒
			interval = "刚刚";

		} else if (time / 1000 < 60 && time / 1000 > 0) {
			// 如果时间间隔小于60秒则显示多少秒前
			int se = (int) ((time % 60000) / 1000);
			interval = se + "秒前";

		} else if (time / 60000 < 60 && time / 60000 > 0) {
			// 如果时间间隔小于60分钟则显示多少分钟前
			int m = (int) ((time % 3600000) / 60000);// 得出的时间间隔的单位是分钟
			interval = m + "分钟前";

		} else if (time / 3600000 < 24 && time / 3600000 >= 0) {
			// 如果时间间隔小于24小时则显示多少小时前
			int h = (int) (time / 3600000);// 得出的时间间隔的单位是小时
			interval = h + "小时前";

		} else {
			// 大于24小时，则显示正常的时间，但是不显示秒
			// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			//
			// ParsePosition pos2 = new ParsePosition(0);
			// Date d2 = (Date) sdf.parse(createtime, pos2);
			//
			// interval = sdf.format(d2);
			try {
				// 时间转换类
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date1 = sdf.parse(createtime);
				String str = sdf.format(new Date());
				Date date2 = sdf.parse(str);
				// 将转换的两个时间对象转换成Calendard对象
				Calendar can1 = Calendar.getInstance();
				can1.setTime(date1);
				Calendar can2 = Calendar.getInstance();
				can2.setTime(date2);
				// 拿出两个年份
				int year1 = can1.get(Calendar.YEAR);
				int year2 = can2.get(Calendar.YEAR);
				// 天数
				int days = 0;
				Calendar can = null;
				// 如果can1 < can2
				// 减去小的时间在这一年已经过了的天数
				// 加上大的时间已过的天数
				if (can1.before(can2)) {
					days -= can1.get(Calendar.DAY_OF_YEAR);
					days += can2.get(Calendar.DAY_OF_YEAR);
					can = can1;
				} else {
					days -= can2.get(Calendar.DAY_OF_YEAR);
					days += can1.get(Calendar.DAY_OF_YEAR);
					can = can2;
				}
				for (int i = 0; i < Math.abs(year2 - year1); i++) {
					// 获取小的时间当前年的总天数
					days += can.getActualMaximum(Calendar.DAY_OF_YEAR);
					// 再计算下一年。
					can.add(Calendar.YEAR, 1);
				}
				interval = days + "天前";
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
		return interval;
	}
	
	
	/**  
     * 计算两个日期之间相差的天数  
     * @param smdate 较小的时间 
     * @param bdate  较大的时间 
     * @return 相差天数 
     * @throws ParseException  
     */    
    public static int daysBetween(Date smdate,Date bdate) throws ParseException    
    {    
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        smdate=sdf.parse(sdf.format(smdate));  
        bdate=sdf.parse(sdf.format(bdate));  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(smdate);    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(bdate);    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
            
       return Integer.parseInt(String.valueOf(between_days));           
    }    
}
