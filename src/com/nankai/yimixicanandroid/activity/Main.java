package com.nankai.yimixicanandroid.activity;

import com.nankai.yimixicanandroid.R;
import com.nankai.yimixicanandroid.tools.ChildViewPager;
import com.nankai.yimixicanandroid.tools.ImgaePagerAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Main extends Activity {

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	private ChildViewPager viewPager;

	/**
	 * 轮播图片
	 */
	private ImageView[] mImageViews;

	/**
	 * 图片资源id
	 */
	private int[] imgResouceIdArray;
	/**
	 * 第一个 grid的适配器
	 */
	ViewGroup group;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.main_layout);
		setViewPageImage();
	}
	

	/**
	 * 设置轮转播放图片
	*/
	@SuppressWarnings("unused")
	private void setViewPageImage() {
		group = (ViewGroup)this.findViewById(R.id.viewGroup);
		viewPager = (ChildViewPager) this.findViewById(R.id.viewPager);
		imgResouceIdArray = new int[] { R.drawable.schedule_home, R.drawable.diet_home,
				R.drawable.sport_home };
		mImageViews = new ImageView[imgResouceIdArray.length];
		for (int i = 0; i < mImageViews.length; i++) {
			ImageView imageView = new ImageView(this);
			mImageViews[i] = imageView;
			imageView.setBackgroundResource(imgResouceIdArray[i]);
		}
		viewPager.setAdapter(new ImgaePagerAdapter(mImageViews));
		//viewPager.setOnPageChangeListener((OnPageChangeListener) this);
	} 
}