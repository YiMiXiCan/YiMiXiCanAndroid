package com.nankai.yimixicanandroid.activity;

import com.nankai.yimixicanandroid.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
public class PerInfo extends Activity{
	private ImageView back;
protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE); 
		this.setContentView(R.layout.activity_detail);
		this.back=(ImageView)this.findViewById(R.id.back);
		this.back.setOnClickListener(new ViewOcl());
}
@SuppressWarnings("unused")
private class ViewOcl implements View.OnClickListener{
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.back:
			Intent intent6=new Intent();		
			intent6.setClass(PerInfo.this, MoreSet.class);
			startActivity(intent6);
			break;
		}
		}
	}
}
