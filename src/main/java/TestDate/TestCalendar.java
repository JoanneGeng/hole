package TestDate;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Time      2017/11/12 下午8:01
 * Author    JoanneGeng
 * File      TestCalendar.java
 * Software  IntelliJ IDEA
 */
public class TestCalendar {

    /**
     * 获取指定时间段内每周（一／二／三。。。）日期
     * 排除黑名单日期
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String start = "2014-02-01";
        String end = "2014-03-02";
        String black = "2014-02-02";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dBegin = sdf.parse(start);
        Date dEnd = sdf.parse(end);
        List<String> list = new ArrayList<>();
        list.add("Sun");
        list.add("Mon");
        Set<String> stringSet = new HashSet<>(list);
        List<Date> blackDate = new ArrayList<>();
        blackDate.add(sdf.parse(black));
        List<Date> lDate = findDates(dBegin, dEnd, stringSet);
        if (!blackDate.isEmpty()) {
            lDate.removeIf(blackDate::contains);
        }
        for (Date date : lDate) {
            System.out.println(sdf.format(date));
        }
    }

    /**
     * 获取时间段内每一天日期
     * 支持获取时间段内星期内某一天的日期
     * @param dBegin
     * @param dEnd
     * @param stringSet
     * @return
     */
    public static List<Date> findDates(Date dBegin, Date dEnd, Set<String> stringSet) {
        List lDate = new ArrayList();
        //lDate.add(dBegin);
        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(dEnd);
        while (dEnd.after(calBegin.getTime())) {
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            if (stringSet.isEmpty()) {
                lDate.add(calBegin.getTime()); continue;
            }
            if (stringSet.contains(WeekEnum.Week.MON.getCode())
                    && calBegin.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
                lDate.add(calBegin.getTime()); continue;
            }
            if (stringSet.contains(WeekEnum.Week.SUN.getCode())
                    && calBegin.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                lDate.add(calBegin.getTime()); continue;
            }
        }
        return lDate;
    }
}
