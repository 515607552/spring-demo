package com.demo.utils;

import cn.hutool.core.date.ChineseDate;
import cn.hutool.core.date.DateUtil;

import java.util.Date;

/**
 * @program: demo-test
 * @description: 假期工具类
 * @author: czchen
 * @date: 2022-02-14 11:46:05
 */
public class HolidayUtil {

    public final static String SATURDAY = "周六";
    public final static String NEWYEARDAY = "元旦节";
    public final static String CHINESENEWYEARGREGORIANFESTIVAL = "春节";
    public final static String QINGMINGFESTIVAL = "清明节";
    public final static String LABORDAY = "劳动节";
    public final static String DRAGONBOATGREGORIANFESTIVAL = "端午节";
    public final static String MIDAUTUMNGREGORIANFESTIVAL = "中秋节";
    public final static String NATIONALDAY = "国庆节";
    public final static String EPIDEMICSITUATION = "疫情";
    public final static String BIRTHDAY = "生日";
    public final static String SXBIRTHDAY = "申星生日";

    /**
     * 获取假期时间
     * @param holidayName 假期名称
     * @param year 当前年份
     * @return
     */
    public static Date getHoliday(String holidayName, int year) {
        switch (holidayName) {
            case SATURDAY:
                int i = DateUtil.dayOfWeek(new Date());
                return DateUtil.offsetDay(new Date(),7-i);
            case NEWYEARDAY:
                return DateUtil.parse(year + "-1-1");
            case CHINESENEWYEARGREGORIANFESTIVAL:
                ChineseDate chinesenewYearFestival = new ChineseDate(year, 1, 1);
                return chinesenewYearFestival.getGregorianDate();
            case QINGMINGFESTIVAL:
                int param = year - 2000;
                int qingmingDay = (int) (param * 0.2422 + 4.81) - param / 4;
                return DateUtil.parse(year + "-4-" + qingmingDay);
            case LABORDAY:
                return DateUtil.parse(year + "-5-1");
            case DRAGONBOATGREGORIANFESTIVAL:
                ChineseDate dragonBoatFestival = new ChineseDate(year, 5, 5);
                return dragonBoatFestival.getGregorianDate();
            case MIDAUTUMNGREGORIANFESTIVAL:
                ChineseDate midAutumnFestival = new ChineseDate(year, 8, 15);
                return midAutumnFestival.getGregorianDate();
            case NATIONALDAY:
                return DateUtil.parse(year + "-10-1");
            case EPIDEMICSITUATION:
                return DateUtil.parse("2019-12-12");
            case BIRTHDAY:
                ChineseDate birthday = new ChineseDate(year, 9, 30);
                if (birthday.getGregorianYear() < 0){
                    birthday = new ChineseDate(year, 9, 29);
                }
                return birthday.getGregorianDate();
            case SXBIRTHDAY:
                ChineseDate sxbirthday = new ChineseDate(year, 9, 30);
                if (sxbirthday.getGregorianYear() < 0){
                    sxbirthday = new ChineseDate(year, 9, 29);
                }
                return sxbirthday.getGregorianDate();
            default:
                return new Date();
        }
    }

}
