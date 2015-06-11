package com.nankai.yimixicanandroid.activity;

import com.nankai.yimixicanandroid.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class TestMain extends Activity {
	private Button bnttest1,bnttest2,bnttest3,bnttest4;
	private ImageView home,back;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE); //设置全屏
		this.setContentView(R.layout.activity_test);
		//实例化操作类组件
		this.bnttest1 = (Button) this.findViewById(R.id.bnttest1);
		this.bnttest2 = (Button) this.findViewById(R.id.bnttest2);
		this.bnttest3 = (Button) this.findViewById(R.id.bnttest3);
		this.bnttest4 = (Button) this.findViewById(R.id.bnttest4);
		this.home = (ImageView) this.findViewById(R.id.home);
		this.back=(ImageView)this.findViewById(R.id.back);
		//绑定监听器
		this.bnttest1.setOnClickListener(new ViewOcl());	
		this.bnttest2.setOnClickListener(new ViewOcl());		
		this.bnttest3.setOnClickListener(new ViewOcl());		
		this.bnttest4.setOnClickListener(new ViewOcl());		
		this.home.setOnClickListener(new ViewOcl());	
		this.back.setOnClickListener(new ViewOcl());
	}
	private class ViewOcl implements View.OnClickListener{
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.bnttest1:
				Intent intent1=new Intent();
           	    intent1.setClass(TestMain.this,HealthTest1.class );
           	    startActivity(intent1); 
				break;
			case R.id.bnttest2:
				Intent intent2=new Intent();
           	    intent2.setClass(TestMain.this,HealthTest2.class );
           	    startActivity(intent2); 
				break;
			case R.id.bnttest3:
				Intent intent3=new Intent();
           	    intent3.setClass(TestMain.this,HealthTest3.class );
           	    startActivity(intent3); 
				break;
			case R.id.bnttest4:
				Intent intent4=new Intent();
           	    intent4.setClass(TestMain.this,HealthTest4.class );
           	    startActivity(intent4); 
				break;	
			case R.id.home:
				Intent intent5=new Intent();
           	    intent5.setClass(TestMain.this,Main.class );
           	    startActivity(intent5); 
				break;
			case R.id.back:
				Intent intent6=new Intent();		
				intent6.setClass(TestMain.this, Main.class);
				startActivity(intent6);
				break;
		}
	}
		  
	
}
}
