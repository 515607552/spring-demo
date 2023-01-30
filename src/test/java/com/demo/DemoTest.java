package com.demo;

import cn.hutool.core.date.DateUtil;
import com.demo.utils.HolidayUtil;
import com.demo.utils.ParamsResolverHelper;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tanwei
 * @version 1.0
 * @date 2023/01/30
 */
@SpringBootTest
public class DemoTest {

    private static final String TEMPLATE = "【摸鱼总办】提醒您：\n" +
            "\n" +
            "{{date}} {{dateStr}}，摸鱼人！\n" +
            "工作再累，一定不要忘记摸鱼哦，有事没事起身去茶水间，去厕所，去廊道走走别老在工位上坐着，钱是老板的,但命是自己的。\n" +
            "\n" +
            "距离【周六】还有{{saturday}}天\n" +
            "距离【清明】还有{{qingmingfestival}}天\n" +
            "距离【劳动节】还有{{laborday}}天\n" +
            "距离【端午】还有{{dragonboatgregorianfestival}}天\n" +
            "距离【中秋】还有{{midautumngregorianfestival}}天\n" +
            "距离【国庆节】还有{{nationalday}}天\n" +
            "距离【元旦】还有{{newyearday}}天\n" +
            "距离【春节】还有{{chinesenewyeargregorianfestival}}天\n" +
            "距离【生日】还有{{birthday}}天\n" +
            "距离【疫情】开始已有{{epidemicsituation}}天\n" +
            "\n" +
            "认认真真上班，这根本就不叫赚钱，那是用劳动换取报酬。只有在上班的时候摸鱼划水，你才是从老板手里赚到了钱。最后，祝愿天下所有摸鱼人都能愉快的渡过每一天！";
    @Test
    public void test1(){
        List<String> saturday = List.of(HolidayUtil.SATURDAY,HolidayUtil.QINGMINGFESTIVAL);
        Date date = new Date();
        int year = DateUtil.year(date);
        Map<String,Object> map = new HashMap<>();
        map.put("date", DateUtil.today());
        map.put("dateStr", dateStr());
        map.put("saturday", saturday());
        map.put("qingmingfestival", qingmingfestival());
        map.put("laborday", laborday());
        map.put("dragonboatgregorianfestival", dragonboatgregorianfestival());
        map.put("midautumngregorianfestival", midautumngregorianfestival());
        map.put("nationalday", nationalday());
        map.put("chinesenewyeargregorianfestival", chinesenewyeargregorianfestival());
        map.put("epidemicsituation", epidemicsituation());
        map.put("newyearday", newyearday());
        map.put("birthday", birthday());
        String s = ParamsResolverHelper.resolveParams(map, TEMPLATE);
        System.out.println(s);
    }

    private long saturday(){
        Date date = new Date();
        int year = DateUtil.year(date);
        Date holiday = HolidayUtil.getHoliday(HolidayUtil.SATURDAY, year);
        if (DateUtil.year(holiday) > year){
            holiday = HolidayUtil.getHoliday(HolidayUtil.SATURDAY, year+1);
        }
        return DateUtil.betweenDay(date, holiday, true);
    }

    private long qingmingfestival(){
        Date date = new Date();
        int year = DateUtil.year(date);
        Date holiday = HolidayUtil.getHoliday(HolidayUtil.QINGMINGFESTIVAL, year);
        if (DateUtil.year(holiday) > year){
            holiday = HolidayUtil.getHoliday(HolidayUtil.QINGMINGFESTIVAL, year+1);
        }
        return DateUtil.betweenDay(date, holiday, true);
    }

    private long laborday(){
        Date date = new Date();
        int year = DateUtil.year(date);
        Date holiday = HolidayUtil.getHoliday(HolidayUtil.LABORDAY, year);
        if (holiday.compareTo(date) < 0){
            holiday = HolidayUtil.getHoliday(HolidayUtil.LABORDAY, year+1);
        }
        return DateUtil.betweenDay(date, holiday, true);
    }

    private long dragonboatgregorianfestival(){
        Date date = new Date();
        int year = DateUtil.year(date);
        Date holiday = HolidayUtil.getHoliday(HolidayUtil.DRAGONBOATGREGORIANFESTIVAL, year);
        if (holiday.compareTo(date) < 0){
            holiday = HolidayUtil.getHoliday(HolidayUtil.DRAGONBOATGREGORIANFESTIVAL, year+1);
        }
        return DateUtil.betweenDay(date, holiday, true);
    }

    private long midautumngregorianfestival(){
        Date date = new Date();
        int year = DateUtil.year(date);
        Date holiday = HolidayUtil.getHoliday(HolidayUtil.MIDAUTUMNGREGORIANFESTIVAL, year);
        if (holiday.compareTo(date) < 0){
            holiday = HolidayUtil.getHoliday(HolidayUtil.MIDAUTUMNGREGORIANFESTIVAL, year+1);
        }
        return DateUtil.betweenDay(date, holiday, true);
    }

    private long nationalday(){
        Date date = new Date();
        int year = DateUtil.year(date);
        Date holiday = HolidayUtil.getHoliday(HolidayUtil.NATIONALDAY, year);
        if (holiday.compareTo(date) < 0){
            holiday = HolidayUtil.getHoliday(HolidayUtil.NATIONALDAY, year+1);
        }
        return DateUtil.betweenDay(date, holiday, true);
    }

    private long chinesenewyeargregorianfestival(){
        Date date = new Date();
        int year = DateUtil.year(date);
        Date holiday = HolidayUtil.getHoliday(HolidayUtil.CHINESENEWYEARGREGORIANFESTIVAL, year);
        if (holiday.compareTo(date) < 0){
            holiday = HolidayUtil.getHoliday(HolidayUtil.CHINESENEWYEARGREGORIANFESTIVAL, year+1);
        }
        return DateUtil.betweenDay(date, holiday, true);
    }

    private long epidemicsituation(){
        Date date = new Date();
        int year = DateUtil.year(date);
        Date holiday = HolidayUtil.getHoliday(HolidayUtil.EPIDEMICSITUATION, year);
        if (holiday.compareTo(date) < 0){
            holiday = HolidayUtil.getHoliday(HolidayUtil.EPIDEMICSITUATION, year+1);
        }
        return DateUtil.betweenDay(date, holiday, true);
    }

    private long newyearday(){
        Date date = new Date();
        int year = DateUtil.year(date);
        Date holiday = HolidayUtil.getHoliday(HolidayUtil.NEWYEARDAY, year);
        if (holiday.compareTo(date) < 0){
            holiday = HolidayUtil.getHoliday(HolidayUtil.NEWYEARDAY, year+1);
        }
        return DateUtil.betweenDay(date, holiday, true);
    }

    private Long birthday(){
        Date date = new Date();
        int year = DateUtil.year(date);
        Date holiday = HolidayUtil.getHoliday(HolidayUtil.BIRTHDAY, year);
        if (holiday.compareTo(date) < 0){
            holiday = HolidayUtil.getHoliday(HolidayUtil.BIRTHDAY, year+1);
        }
        return DateUtil.betweenDay(date, holiday, true);
    }

    private String dateStr(){
        int hour = DateUtil.hour(new Date(), true);
        if (hour >= 0 && hour < 6) {
            return "凌晨好";
        }
        if (hour >= 6 && hour <= 8) {
            return "早上好";
        }
        if (hour > 9 && hour < 12) {
            return "上午好";
        }
        if (hour >= 12 && hour <= 13) {
            return "中午好";
        }
        if (hour > 13 && hour <= 17) {
            return "下午好";
        }
        if (hour >= 18 && hour <= 24) {
            return "晚上好";
        }
        return "";
    }
}
