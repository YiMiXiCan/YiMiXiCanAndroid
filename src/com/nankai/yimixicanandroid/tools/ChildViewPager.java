package com.nankai.yimixicanandroid.tools;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class ChildViewPager extends ViewPager {
	public ChildViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public ChildViewPager(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent arg0) {
		// 当拦截触摸事件到达此位置的时候，返回true�?
		// 说明将onTouch拦截在此控件，进而执行此控件的onTouchEvent
		return true;
	}


	@Override
	public boolean onTouchEvent(MotionEvent arg0) {
		getParent().requestDisallowInterceptTouchEvent(true);
		return super.onTouchEvent(arg0);
	}
}
