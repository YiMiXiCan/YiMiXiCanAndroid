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


public class ManageDiet extends Activity{
	CheckBox box1,box2,box3,box4,box5,box6,box7,box8,box26;
	final int classID=1;//习惯类ID
	private ImageView home,back;
	private int userID;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE); //设置全屏
		this.setContentView(R.layout.activity_habitdiet);
		box1=(CheckBox)findViewById(R.id.mng1Agree);
		box2=(CheckBox)findViewById(R.id.mng2Agree);
		box3=(CheckBox)findViewById(R.id.mng3Agree);
		box4=(CheckBox)findViewById(R.id.mng4Agree);
		box5=(CheckBox)findViewById(R.id.mng5Agree);
		box6=(CheckBox)findViewById(R.id.mng6Agree);
		box7=(CheckBox)findViewById(R.id.mng7Agree);
		box8=(CheckBox)findViewById(R.id.mng8Agree);
		box26=(CheckBox)findViewById(R.id.mng26Agree);
		this.home = (ImageView) this.findViewById(R.id.home);
		this.back=(ImageView)this.findViewById(R.id.back);
		SharedPreferences preferences=getSharedPreferences("publicData", MODE_WORLD_READABLE);
		this.userID=preferences.getInt("UID", 1);
		this.home.setOnClickListener(new ViewOcl());	
		this.back.setOnClickListener(new ViewOcl());
		box1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){ 
            @Override
            public void onCheckedChanged(CompoundButton buttonView, 
                    boolean isChecked) { 
                // TODO Auto-generated method stub 
                if(isChecked){ 
                	addHabit(userID, 1);
                }else{ 
                   cancleHabit(userID, 1);
                } 
            } 
        }); 
		box2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){ 
            @Override
            public void onCheckedChanged(CompoundButton buttonView, 
                    boolean isChecked) { 
                // TODO Auto-generated method stub 
            	if(isChecked){ 
                	addHabit(userID, 2);
                }else{ 
                   cancleHabit(userID, 2);
                } 
            } 
        }); 
		box3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){ 
            @Override
            public void onCheckedChanged(CompoundButton buttonView, 
                    boolean isChecked) { 
                // TODO Auto-generated method stub 
            	if(isChecked){ 
                	addHabit(userID, 3);
                }else{ 
                   cancleHabit(userID, 3);
                } 
            } 
        }); 
		box4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){ 
            @Override
            public void onCheckedChanged(CompoundButton buttonView, 
                    boolean isChecked) { 
            	if(isChecked){ 
                	addHabit(userID, 4);
                }else{ 
                   cancleHabit(userID, 4);
                } 
            } 
        }); 
		box5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){ 
            @Override
            public void onCheckedChanged(CompoundButton buttonView, 
                    boolean isChecked) { 
                // TODO Auto-generated method stub 
            	if(isChecked){ 
                	addHabit(userID, 5);
                }else{ 
                   cancleHabit(userID, 5);
                } 
            } 
        }); 
		box6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){ 
            @Override
            public void onCheckedChanged(CompoundButton buttonView, 
                    boolean isChecked) { 
            	if(isChecked){ 
                	addHabit(userID, 6);
                }else{ 
                   cancleHabit(userID, 6);
                } 
            } 
        }); 
		box7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){ 
            @Override
            public void onCheckedChanged(CompoundButton buttonView, 
                    boolean isChecked) { 
                // TODO Auto-generated method stub 
            	if(isChecked){ 
                	addHabit(userID, 7);
                }else{ 
                   cancleHabit(userID, 7);
                } 
            } 
        }); 
		box8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){ 
            @Override
            public void onCheckedChanged(CompoundButton buttonView, 
                    boolean isChecked) { 
            	if(isChecked){ 
                	addHabit(userID, 8);
                }else{ 
                   cancleHabit(userID, 8);
                } 
            } 
        }); 
		box26.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){ 
            @Override
            public void onCheckedChanged(CompoundButton buttonView, 
                    boolean isChecked) { 
                // TODO Auto-generated method stub 
            	if(isChecked){ 
                	addHabit(userID, 26);
                }else{ 
                   cancleHabit(userID, 26);
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
           	    intent5.setClass(ManageDiet.this,Main.class );
           	    startActivity(intent5); 
				break;
			case R.id.back:
				Intent intent6=new Intent();		
				intent6.setClass(ManageDiet.this, ManageMain.class);
				startActivity(intent6);
				break;
			}			
			}
	}
}
