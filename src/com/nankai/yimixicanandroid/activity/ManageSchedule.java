package com.nankai.yimixicanandroid.activity;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.nankai.yimixicanandroid.R;
import com.nankai.yimixicanandroid.internet.WebAccessUtils;
import com.nankai.yimixicanandroid.po.UserCard;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;

public class ManageSchedule extends Activity {
	CheckBox box9,box10,box11,box12,box13,box14;
	private ImageView home,back;
	final int classID=2;//习惯类ID
	private int userID;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE); //设置全屏
		this.setContentView(R.layout.activity_habitschedule);
		box9=(CheckBox)findViewById(R.id.mng9Agree);
		box10=(CheckBox)findViewById(R.id.mng10Agree);
		box11=(CheckBox)findViewById(R.id.mng11Agree);
		box12=(CheckBox)findViewById(R.id.mng12Agree);
		box13=(CheckBox)findViewById(R.id.mng13Agree);
		box14=(CheckBox)findViewById(R.id.mng14Agree);
		this.home = (ImageView) this.findViewById(R.id.home);
		this.back=(ImageView)this.findViewById(R.id.back);
		this.home.setOnClickListener(new ViewOcl());	
		this.back.setOnClickListener(new ViewOcl());
		SharedPreferences preferences=getSharedPreferences("publicData", MODE_WORLD_READABLE);
		this.userID=preferences.getInt("UID", 1);
		box9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){ 
	            @Override
	            public void onCheckedChanged(CompoundButton buttonView, 
	                    boolean isChecked) { 
	            	if(isChecked){ 
	                	addHabit(userID, 9);
	                }else{ 
	                   cancleHabit(userID, 9);
	                } 
	            } 
	        }); 
		box10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){ 
            @Override
            public void onCheckedChanged(CompoundButton buttonView, 
                    boolean isChecked) { 
                // TODO Auto-generated method stub 
            	if(isChecked){ 
                	addHabit(userID, 10);
                }else{ 
                   cancleHabit(userID, 10);
                } 
            } 
        }); 
		box11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){ 
            @Override
            public void onCheckedChanged(CompoundButton buttonView, 
                    boolean isChecked) { 
            	if(isChecked){ 
                	addHabit(userID, 11);
                }else{ 
                   cancleHabit(userID, 11);
                } 
            } 
        }); 
		box12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){ 
            @Override
            public void onCheckedChanged(CompoundButton buttonView, 
                    boolean isChecked) { 
                // TODO Auto-generated method stub 
            	if(isChecked){ 
                	addHabit(userID, 12);
                }else{ 
                   cancleHabit(userID, 12);
                } 
            } 
        }); 
		box13.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){ 
            @Override
            public void onCheckedChanged(CompoundButton buttonView, 
                    boolean isChecked) { 
            	if(isChecked){ 
                	addHabit(userID, 13);
                }else{ 
                   cancleHabit(userID, 13);
                } 
            } 
        }); 
		box14.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){ 
            @Override
            public void onCheckedChanged(CompoundButton buttonView, 
                    boolean isChecked) { 
                // TODO Auto-generated method stub 
            	if(isChecked){ 
                	addHabit(userID, 14);
                }else{ 
                   cancleHabit(userID, 14);
                } 
            } 
        }); 

	}
	public void addHabit(int userID,int habitID)
	{
		UserCard card=new UserCard();
		card.setUserID(userID);
		card.setHabitID(habitID);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-ddHH:mm:ss").create();
	    String card_data = gson.toJson(card);
		List<NameValuePair> lstNameValuePairs = new ArrayList<NameValuePair>();
		lstNameValuePairs.add(new BasicNameValuePair("card_data", card_data));			
		String response = WebAccessUtils.httpRequest("InsertHabitServlet", lstNameValuePairs);				
		Type ListMessages = new TypeToken<String>() {
		}.getType();
		 String  string = gson.fromJson(response, ListMessages);
		 if(string.equals("true")){
			 Toast.makeText(getApplicationContext(), "习惯添加成功，赞一个！", Toast.LENGTH_LONG).show();
		 }
		 else{
			 Toast.makeText(getApplicationContext(), "习惯添加出问题了，抱歉~", Toast.LENGTH_LONG).show();
		 }
		
	}
	public void cancleHabit(int userID,int habitID)
	{
		UserCard card=new UserCard();
		card.setUserID(userID);
		card.setHabitID(habitID);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-ddHH:mm:ss").create();
	    String card_data = gson.toJson(card);
		List<NameValuePair> lstNameValuePairs = new ArrayList<NameValuePair>();
		lstNameValuePairs.add(new BasicNameValuePair("card_data", card_data));			
		String response = WebAccessUtils.httpRequest("CancleHabitServlet", lstNameValuePairs);				
		Type ListMessages = new TypeToken<String>() {
		}.getType();
		 String  string = gson.fromJson(response, ListMessages);
		 if(string.equals("true")){
			 Toast.makeText(getApplicationContext(), "习惯成功删除了", Toast.LENGTH_LONG).show();
		 }
		 else{
			 Toast.makeText(getApplicationContext(), "习惯删除出了问题", Toast.LENGTH_LONG).show();
		 }
	}	
	private class ViewOcl implements View.OnClickListener{
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.home:
				Intent intent5=new Intent();
           	    intent5.setClass(ManageSchedule.this,Main.class );
           	    startActivity(intent5); 
				break;
			case R.id.back:
				Intent intent6=new Intent();		
				intent6.setClass(ManageSchedule.this, ManageMain.class);
				startActivity(intent6);
				break;
			}			
			}
	}
}
