package com.nankai.yimixicanandroid.tools;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

public class ImgaePagerAdapter extends PagerAdapter {

	ImageView[] mImageViews;

	public ImgaePagerAdapter(ImageView[] mImageViews) {
		this.mImageViews = mImageViews;
	}
	
	//获取要滑动的控件的数�?
	@Override
	public int getCount() {
		return Integer.MAX_VALUE;
	}
	//来判断显示的是否是同�?��图片，这里我们将两个参数相比较返回即�? 
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}
	//PagerAdapter如果滑动的图片超出了缓存的范围，就会调用这个方法，将图片�?��  
	@Override
	public void destroyItem(View container, int position, Object object) {
		
		((ViewPager) container).removeView(mImageViews[position
				% mImageViews.length]);

	}

	
	@Override
	public Object instantiateItem(View container, int position) {
		((ViewPager) container).addView(mImageViews[position
				% mImageViews.length], 0);
		return mImageViews[position % mImageViews.length];
	}

}
