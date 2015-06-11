package com.nankai.yimixicanandroid.activity;

import com.nankai.yimixicanandroid.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class MoreSet extends Activity {
	private TextView userifo;
	private ImageView back;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE); //设置全屏
		this.setContentView(R.layout.activity_more);
		this.userifo = (TextView) this.findViewById(R.id.userinf);
		this.userifo.setOnClickListener(new ViewOcl());	
		this.back=(ImageView)this.findViewById(R.id.back);
		this.back.setOnClickListener(new ViewOcl());
	}
	private class ViewOcl implements View.OnClickListener{
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.userinf:
				Intent intent1=new Intent();
           	    intent1.setClass(MoreSet.this,PerInfo.class );
           	    startActivity(intent1); 
				break;
			case R.id.back:
				Intent intent6=new Intent();		
				intent6.setClass(MoreSet.this, Main.class);
				startActivity(intent6);
				break;
			}
			}
		}
	}
