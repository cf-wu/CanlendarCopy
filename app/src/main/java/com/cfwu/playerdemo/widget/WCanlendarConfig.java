package com.cfwu.playerdemo.widget;

public class WCanlendarConfig {
    /**
     * 周起始：周日
     */
    static final int WEEK_START_WITH_SUN = 1;

    /**
     * 周起始：周一
     */
    static final int WEEK_START_WITH_MON = 2;

    /**
     * 周起始：周六
     */
    static final int WEEK_START_WITH_SAT = 7;

    public static int sWeekStart = 7;
    /**
     * 日历最小显示的年份
     */
    public static int sMinYear = 2000;
    /**
     * 日历最小显示的年份中的月份
     */
    public static int sMinYearMonth = 1;
    /**
     * 日历最大显示的年份
     */
    public static int sMaxYear = 2200;
    /**
     * 日历最大显示的年份中的月份
     */
    public static int sMaxYearMonth = 12;

    public  Calendar mCurrentDat;

    public Calendar getmCurrentDat() {
        return mCurrentDat;
    }

    public void setmCurrentDat(Calendar mCurrentDat) {
        this.mCurrentDat = mCurrentDat;
    }
}
