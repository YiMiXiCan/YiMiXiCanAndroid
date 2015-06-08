package com.nankai.yimixicanandroid.activity;

import com.nankai.yimixicanandroid.R;
import com.nankai.yimixicanandroid.tools.ChildViewPager;
import com.nankai.yimixicanandroid.tools.ImgaePagerAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class Main extends Activity {
	private Button bnttest,bntmanage,bnttips;
	private ImageView bnthome,bntset,bntshare;
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
		this.bnttest = (Button) this.findViewById(R.id.imgtests);
		this.bntmanage = (Button) this.findViewById(R.id.imgmanage);
		this.bnttips = (Button) this.findViewById(R.id.imgtips);
		this.bnthome = (ImageView) this.findViewById(R.id.img_weixin);
		this.bntset = (ImageView) this.findViewById(R.id.img_settings);
		this.bntshare = (ImageView) this.findViewById(R.id.img_address);
		
		this.bnttest.setOnClickListener(new ViewOcl());	
		this.bntmanage.setOnClickListener(new ViewOcl());		
		this.bnttips.setOnClickListener(new ViewOcl());		
		this.bnthome.setOnClickListener(new ViewOcl());	
		this.bntset.setOnClickListener(new ViewOcl());		
		this.bntshare.setOnClickListener(new ViewOcl());		
		
	}
	private class ViewOcl implements View.OnClickListener{
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.imgtests:
				Intent intent1=new Intent();
           	    intent1.setClass(Main.this,TestMain.class );
           	    startActivity(intent1); 
				break;
			case R.id.imgmanage:
				Intent intent2=new Intent();
           	    intent2.setClass(Main.this,ManageMain.class );
           	    startActivity(intent2); 
				break;
			case R.id.imgtips:
//				Intent intent3=new Intent();
//           	    intent3.setClass(Main.this,ManageSchedule.class );
//           	    startActivity(intent3); 
				break;
			case R.id.img_weixin:
				Intent intent4=new Intent();
           	    intent4.setClass(Main.this,Main.class );
           	    startActivity(intent4); 
				break;
			case R.id.img_settings:
				Intent intent5=new Intent();
           	    intent5.setClass(Main.this,MoreSet.class );
           	    startActivity(intent5); 
				break;
			case R.id.img_address:
//				Intent intent6=new Intent();
//           	    intent6.setClass(Main.this,ManageSchedule.class );
//           	    startActivity(intent6); 
				break;
				default:
				break;			
		}
	}
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