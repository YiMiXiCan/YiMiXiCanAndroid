package com.nankai.yimixicanandroid.activity;


import com.nankai.yimixicanandroid.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class Register extends Activity {

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE); //设置全屏
		this.setContentView(R.layout.activity_register);
	}
	
	

}
