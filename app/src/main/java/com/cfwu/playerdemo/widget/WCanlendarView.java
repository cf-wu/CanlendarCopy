package com.cfwu.playerdemo.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.cfwu.playerdemo.R;


public class WCanlendarView extends FrameLayout {
    private Context mContext;
    private View mRootView;
    private LinearLayout mWeekBar;
    private WCanlendarViewPager mCanlendarViewPager;

    public WCanlendarView(@NonNull Context context) {
        this(context, null);
    }

    public WCanlendarView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WCanlendarView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    private void init() {
        mRootView = View.inflate(mContext, R.layout.layout_canlendar_weekbar, null);
        mWeekBar = mRootView.findViewById(R.id.canlendar_bar);
        mCanlendarViewPager = mRootView.findViewById(R.id.canlendar_month);
        mCanlendarViewPager.setup();
        this.addView(mRootView);
    }


}
