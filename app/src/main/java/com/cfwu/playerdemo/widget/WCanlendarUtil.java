package com.cfwu.playerdemo.widget;

import java.util.ArrayList;
import java.util.List;

public class WCanlendarUtil {


    static int getMonthEndDiff(int year, int month, int weekStart) {
        return getMonthEndDiff(year, month, getMonthDaysCount(year, month), weekStart);
    }

    public static int getMonthEndDiff(int year, int month, int day, int weekStart) {
        java.util.Calendar date = java.util.Calendar.getInstance();
        date.set(year, month - 1, day);
        int week = date.get(java.util.Calendar.DAY_OF_WEEK);
        if (weekStart == WCanlendarConfig.WEEK_START_WITH_SUN) {
            return 7 - week;
        }
        if (weekStart == WCanlendarConfig.WEEK_START_WITH_MON) {
            return week == 1 ? 0 : 7 - week + 1;
        }
        return week == 7 ? 6 : 7 - week - 1;
    }

    public static int getMonthViewStartDiff(int year, int month, int weekStart) {
        java.util.Calendar date = java.util.Calendar.getInstance();
        date.set(year, month - 1, 1);
        int week = date.get(java.util.Calendar.DAY_OF_WEEK);
        if (weekStart == WCanlendarConfig.WEEK_START_WITH_SUN) {
            return week - 1;
        }
        if (weekStart == WCanlendarConfig.WEEK_START_WITH_MON) {
            return week == 1 ? 6 : week - weekStart;
        }
        return week == WCanlendarConfig.WEEK_START_WITH_SAT ? 0 : week;
    }

    public static int getMonthDaysCount(int year, int month) {
        int count = 0;
        //判断大月份
        if (month == 1 || month == 3 || month == 5 || month == 7
                || month == 8 || month == 10 || month == 12) {
            count = 31;
        }

        //判断小月
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            count = 30;
        }

        //判断平年与闰年
        if (month == 2) {
            if (isLeapYear(year)) {
                count = 29;
            } else {
                count = 28;
            }
        }
        return count;
    }

    /**
     * 是否是闰年
     *
     * @param year year
     * @return 是否是闰年
     */
    static boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }

    public static List<Calendar> initCalendarForMonthView(int year, int month, Calendar currentDate, int weekStar) {
        java.util.Calendar date = java.util.Calendar.getInstance();

        date.set(year, month - 1, 1);

        int mPreDiff = getMonthViewStartDiff(year, month, weekStar);//获取月视图其实偏移量

        int monthDayCount = getMonthDaysCount(year, month);//获取月份真实天数

        int preYear, preMonth;
        int nextYear, nextMonth;

        int size = 42;

        List<Calendar> mItems = new ArrayList<>();

        int preMonthDaysCount;
        if (month == 1) {//如果是1月
            preYear = year - 1;
            preMonth = 12;
            nextYear = year;
            nextMonth = month + 1;
            preMonthDaysCount = mPreDiff == 0 ? 0 : getMonthDaysCount(preYear, preMonth);
        } else if (month == 12) {//如果是12月
            preYear = year;
            preMonth = month - 1;
            nextYear = year + 1;
            nextMonth = 1;
            preMonthDaysCount = mPreDiff == 0 ? 0 : getMonthDaysCount(preYear, preMonth);
        } else {//平常
            preYear = year;
            preMonth = month - 1;
            nextYear = year;
            nextMonth = month + 1;
            preMonthDaysCount = mPreDiff == 0 ? 0 : getMonthDaysCount(preYear, preMonth);
        }
        int nextDay = 1;
        for (int i = 0; i < size; i++) {
            Calendar calendarDate = new Calendar();
            if (i < mPreDiff) {
                calendarDate.setYear(preYear);
                calendarDate.setMonth(preMonth);
                calendarDate.setDay(preMonthDaysCount - mPreDiff + i + 1);
            } else if (i >= monthDayCount + mPreDiff) {
                calendarDate.setYear(nextYear);
                calendarDate.setMonth(nextMonth);
                calendarDate.setDay(nextDay);
                ++nextDay;
            } else {
                calendarDate.setYear(year);
                calendarDate.setMonth(month);
                calendarDate.setCurrentMonth(true);
                calendarDate.setDay(i - mPreDiff + 1);
            }
            if (calendarDate.equals(currentDate)) {
                calendarDate.setCurrentDay(true);
            }
            mItems.add(calendarDate);
        }
        return mItems;
    }
}
