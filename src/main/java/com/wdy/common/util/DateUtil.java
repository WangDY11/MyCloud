package com.wdy.common.util;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * @desc 日期工具类
 * @date 2019/6/18
 * @author wjy
 */
@Component
public class DateUtil {

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    DateTimeFormatter dateFormatter = DateTimeFormat.forPattern("yyyy-MM-dd");
    /**
     * @desc 格式化
     * @date 2019/6/18
     * @author wjy
     */
    public DateTimeFormatter getFormat() {
        return DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
    }

    /**
     * @desc 获取当前时间字符串
     * @date 2019/6/18
     * @author wjy
     */
    public String getTime() {
        return this.getFormat().print(new DateTime());
    }

    /**
     * @desc 获取当前日期
     * @author syz
     */
    public String getDate() {
        return this.dateFormatter.print(new DateTime());
    }
    /**
     * 获取day天之后的日期
     * @param day 天数
     * @return
     */
    public String getAfterAFewDate(int day){
        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.DATE, day);
        Date time = calendar1.getTime();
        return DateFormatUtils.format(time, "yyyy-MM-dd");
    }

    /**
     * 获取两个时间之间的间隔天数
     *
     * @param startDate yyyyMMdd
     * @param endDate   yyyyMMdd
     * @return
     */
    public static long getRangeCountOfDate(String startDate, String endDate) {
        java.time.format.DateTimeFormatter dateTimeFormatter = java.time.format.DateTimeFormatter.ofPattern(DATE_FORMAT);
        LocalDate startLocalDate = LocalDate.parse(startDate, dateTimeFormatter);
        LocalDate endLocalDate = LocalDate.parse(endDate, dateTimeFormatter);
        long count = ChronoUnit.DAYS.between(startLocalDate, endLocalDate);
        return count;

    }

}
