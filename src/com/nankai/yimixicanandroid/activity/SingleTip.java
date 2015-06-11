package com.nankai.yimixicanandroid.activity;



import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nankai.yimixicanandroid.R;
import com.nankai.yimixicanandroid.internet.WebAccessUtils;
import com.nankai.yimixicanandroid.po.Tips;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SingleTip extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setContentView(R.layout.activity_atip);
		this.tipback=(ImageView)this.findViewById(R.id.singleback);
		this.tiptohome=(ImageView)this.findViewById(R.id.singletohome);
		this.tip_result=(TextView)this.findViewById(R.id.tip_result);
		findView();
		this.tipback.setOnClickListener(new viewocl());
		this.tiptohome.setOnClickListener(new viewocl());
		
		}
	private ImageView tipback,tiptohome;
	private TextView tip_result;
	private void findView() {
		int tid=this.getIntent().getIntExtra("tid",0);
		Tips tip=new Tips();
		tip.setImage(tid);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-ddhh:mm:ss").create();
		String user_data = gson.toJson(tip);
		List<NameValuePair> lstNameValuePairs = new ArrayList<NameValuePair>();
		lstNameValuePairs.add(new BasicNameValuePair("user_data", user_data));
		
		// 锟斤拷锟斤拷2-2锟斤拷锟斤拷锟矫凤拷式实锟斤拷锟斤拷锟斤拷姆锟斤拷锟�
		String response =WebAccessUtils.httpRequest("FindTipById", lstNameValuePairs);
		System.out.println(response);
		 //  if(!response.equals("null"))
		//	{   Tips tipa=gson.fromJson(response,Tips.class);
		//	this.tip_result.setText(tipa.getTxt());
		//	System.out.println(tipa);
		if(!response.equals("null"))
		{   Tips tip1=gson.fromJson(response, Tips.class);
		     System.out.println(tip1);
		     this.tip_result.setText(tip1.getTxt());
			   Toast.makeText(getApplicationContext(), "成功显示", Toast.LENGTH_LONG).show();
				System.out.println(tip1);
			}
		   else{System.out.println("出错了");}
	}
	
	public class viewocl implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			Intent intent=new Intent();
			
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.singleback:
				//Toast.makeText(getApplicationContext(), "返回",Toast.LENGTH_LONG ).show();
				
				intent.setClass(SingleTip.this, ChooseTips.class);
				startActivity(intent);
				break;

			case R.id.singletohome:
				//Toast.makeText(getApplicationContext(), "返回主页", Toast.LENGTH_LONG).show();
				
				intent.setClass(SingleTip.this, Main.class);
				startActivity(intent);
				break;
			
			}
		}
		
	}
}
