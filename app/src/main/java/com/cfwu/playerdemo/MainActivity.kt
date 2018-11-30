package com.cfwu.playerdemo

import android.graphics.SurfaceTexture
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.TextureView
import com.cfwu.playerdemo.canlendar.CalendarView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), TextureView.SurfaceTextureListener, CalendarView.OnMonthChangeListener {
    override fun onMonthChange(year: Int, month: Int) {
        tv_title.text="$year 年$month 月"
    }

    override fun onSurfaceTextureSizeChanged(surface: SurfaceTexture?, width: Int, height: Int) {
    }

    override fun onSurfaceTextureUpdated(surface: SurfaceTexture?) {
    }

    override fun onSurfaceTextureDestroyed(surface: SurfaceTexture?): Boolean {
        return true
    }

    override fun onSurfaceTextureAvailable(surface: SurfaceTexture?, width: Int, height: Int) {


    }

    private var mTextureView:TextureView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cv.setOnMonthChangeListener(this)
    }

}
