package com.nankai.yimixicanandroid.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.nankai.yimixicanandroid.activity.R;
public class ChooseTips extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setContentView(R.layout.activity_tips);
		this.tipback=(ImageView)this.findViewById(R.id.tipback);
		this.tiptohome=(ImageView)this.findViewById(R.id.tiptohome);
		this.imgdiet=(ImageView)this.findViewById(R.id.imgdiet);
		this.imgsport=(ImageView)this.findViewById(R.id.imgsport);
		this.imgschedule=(ImageView)this.findViewById(R.id.imgschedule);
		this.imgcommon=(ImageView)this.findViewById(R.id.imgcommon);
		this.tipback.setOnClickListener(new viewocl());
		this.tiptohome.setOnClickListener(new viewocl());
		this.imgdiet.setOnClickListener(new viewocl());
		this.imgsport.setOnClickListener(new viewocl());
		this.imgschedule.setOnClickListener(new viewocl());
		this.imgcommon.setOnClickListener(new viewocl());
	}
	private ImageView tipback,tiptohome,imgdiet,imgsport,imgschedule,imgcommon;
	private class viewocl implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			Intent intent=new Intent();
			
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.tipback:
				Toast.makeText(getApplicationContext(), "返回",Toast.LENGTH_LONG ).show();
				
				intent.setClass(ChooseTips.this, Main.class);
				startActivity(intent);
				break;

			case R.id.tiptohome:
				Toast.makeText(getApplicationContext(), "返回主页", Toast.LENGTH_LONG).show();
				
				intent.setClass(ChooseTips.this, Main.class);
				startActivity(intent);
				break;
			case R.id.imgdiet:
                Toast.makeText(getApplicationContext(), "饮食", Toast.LENGTH_LONG).show();
				intent.putExtra("type", 1);
				intent.setClass(ChooseTips.this, ShowTips.class);
				startActivity(intent);
				break;
			case R.id.imgsport:
                Toast.makeText(getApplicationContext(), "瘦身", Toast.LENGTH_LONG).show();
				intent.putExtra("type", 3);
				intent.setClass(ChooseTips.this, ShowTips.class);
				startActivity(intent);
				break;
			case R.id.imgschedule:
                Toast.makeText(getApplicationContext(), "养生", Toast.LENGTH_LONG).show();
				intent.putExtra("type", 2);
				intent.setClass(ChooseTips.this, ShowTips.class);
				startActivity(intent);
				break;
			case R.id.imgcommon:
                Toast.makeText(getApplicationContext(), "小常识", Toast.LENGTH_LONG).show();
				intent.putExtra("type", 4);
				intent.setClass(ChooseTips.this, ShowTips.class);
				startActivity(intent);
				break;
			}
		}
		
	}
}
