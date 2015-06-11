package com.nankai.yimixicanandroid.activity;

import com.nankai.yimixicanandroid.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class ManageMain extends Activity {
	private Button bntdiet,bntsport,bntschedule;
	private ImageView home,back;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE); //设置全屏
		this.setContentView(R.layout.activity_manage);
		
		//实例化操作类组件
		this.bntdiet = (Button) this.findViewById(R.id.bntdiet);
		this.bntsport = (Button) this.findViewById(R.id.bntsport);
		this.bntschedule = (Button) this.findViewById(R.id.bntschedule);
		this.home = (ImageView) this.findViewById(R.id.home);
		this.back = (ImageView) this.findViewById(R.id.back);
		//绑定监听器
		this.bntdiet.setOnClickListener(new ViewOcl());	
		this.bntsport.setOnClickListener(new ViewOcl());		
		this.bntschedule.setOnClickListener(new ViewOcl());		
		this.home.setOnClickListener(new ViewOcl());
		this.back.setOnClickListener(new ViewOcl());
	}
	private class ViewOcl implements View.OnClickListener{
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.bntdiet:
				Intent intent1=new Intent();
           	    intent1.setClass(ManageMain.this,ManageDiet.class );
           	    startActivity(intent1); 
				break;
			case R.id.bntsport:
				Intent intent2=new Intent();
           	    intent2.setClass(ManageMain.this,ManageSport.class );
           	    startActivity(intent2); 
				break;
			case R.id.bntschedule:
				Intent intent3=new Intent();
           	    intent3.setClass(ManageMain.this,ManageSchedule.class );
           	    startActivity(intent3); 
				break;
			case R.id.home:
				Intent intent4=new Intent();
           	    intent4.setClass(ManageMain.this,Main.class );
           	    startActivity(intent4); 
				break;
			case R.id.back:
				Intent intent5=new Intent();
           	    intent5.setClass(ManageMain.this,Main.class );
           	    startActivity(intent5); 
				break;
		}
	}
		  
	
}
}
