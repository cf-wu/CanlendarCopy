package com.cfwu.playerdemo.widget;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class WCanlendarViewPager extends ViewPager {
    /**
     * 总共显示的月个数
     */
    private int mMonthCount;


    public WCanlendarViewPager(Context context) {
        this(context, null);
    }

    public WCanlendarViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public void setup() {
        mMonthCount = 12 * (WCanlendarConfig.sMaxYear - WCanlendarConfig.sMinYear)
                - WCanlendarConfig.sMinYearMonth + 1 +
                WCanlendarConfig.sMaxYearMonth;
        setAdapter(new CanlendarAdapter());

    }


    class CanlendarAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mMonthCount;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view.equals(object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            int year = (position + WCanlendarConfig.sMinYearMonth - 1) / 12 + WCanlendarConfig.sMinYear;
            int month = (position + WCanlendarConfig.sMinYearMonth - 1) % 12 + 1;
            WMonthView wMonthView = new WMonthView(getContext());
            wMonthView.initMonthAndDate(year, month);
            container.addView(wMonthView);
            return wMonthView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            WMonthView view = (WMonthView) object;
            if (view == null) {
                return;
            }
            container.removeView(view);
        }
    }
}
