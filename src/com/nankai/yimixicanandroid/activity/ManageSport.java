package com.nankai.yimixicanandroid.activity;

import com.nankai.yimixicanandroid.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class ManageSport extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_manage);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE); //设置全屏
	}
}