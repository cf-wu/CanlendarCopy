package com.cfwu.playerdemo.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

public class WMonthView extends View {
    private int mYear;
    private int mMonth;
    private int mLineCount;
    private int mHeight;

    /**
     * 日历项
     */
    List<Calendar> mItems;
    /**
     * 下个月的偏移量
     */
    private int mNextDiff;

    private Calendar mCurrentDay;

    public WMonthView(Context context) {
        this(context, null);
    }

    public WMonthView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WMonthView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void initMonthAndDate(int year, int month) {
        this.mYear = year;
        this.mMonth = month;
        initCanlendar();

    }

    private void initCanlendar() {
        mNextDiff = WCanlendarUtil.getMonthEndDiff(mYear, mMonth, WCanlendarConfig.sWeekStart);
        int monthDayCount = WCanlendarUtil.getMonthDaysCount(mYear, mMonth);
        int preDiff = WCanlendarUtil.getMonthViewStartDiff(mYear, mMonth, WCanlendarConfig.sWeekStart);

        mLineCount = (preDiff + monthDayCount + mNextDiff) / 7;
//        mItems = WCanlendarUtil.initCalendarForMonthView(mYear, mMonth, , WCanlendarConfig.sWeekStart);
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (mLineCount != 0) {
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(mHeight, MeasureSpec.EXACTLY);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
