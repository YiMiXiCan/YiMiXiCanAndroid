package com.nankai.yimixicanandroid.activity;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.nankai.yimixicanandroid.R;
import com.nankai.yimixicanandroid.internet.WebAccessUtils;
import com.nankai.yimixicanandroid.po.UserCard;

import android.widget.CompoundButton;

public class ManageSport extends Activity {
	CheckBox box16,box17,box18,box19,box20,box21,box22,box23,box24,box25;
	final int classID=3;//习惯类ID
	private int userID;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE); //设置全屏
		this.setContentView(R.layout.activity_habitsport);
		box16=(CheckBox)findViewById(R.id.mng16Agree);
		box17=(CheckBox)findViewById(R.id.mng17Agree);
		box18=(CheckBox)findViewById(R.id.mng18Agree);
		box19=(CheckBox)findViewById(R.id.mng19Agree);
		box20=(CheckBox)findViewById(R.id.mng20Agree);
		box21=(CheckBox)findViewById(R.id.mng21Agree);
		box22=(CheckBox)findViewById(R.id.mng22Agree);
		box23=(CheckBox)findViewById(R.id.mng23Agree);
		box24=(CheckBox)findViewById(R.id.mng24Agree);
		box25=(CheckBox)findViewById(R.id.mng25Agree);
		SharedPreferences preferences=getSharedPreferences("publicData", MODE_WORLD_READABLE);
		this.userID=preferences.getInt("UID", 1);
	box16.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){ 
        @Override
        public void onCheckedChanged(CompoundButton buttonView, 
                boolean isChecked) { 
            // TODO Auto-generated method stub 
        	if(isChecked){ 
            	addHabit(userID, 16);
            }else{ 
               cancleHabit(userID, 16);
            } 
        } 
    }); 
	box17.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){ 
        @Override
        public void onCheckedChanged(CompoundButton buttonView, 
                boolean isChecked) { 
            // TODO Auto-generated method stub 
        	if(isChecked){ 
            	addHabit(userID, 17);
            }else{ 
               cancleHabit(userID, 17);
            } 
        } 
    }); 
	box18.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){ 
        @Override
        public void onCheckedChanged(CompoundButton buttonView, 
                boolean isChecked) { 
            // TODO Auto-generated method stub 
        	if(isChecked){ 
            	addHabit(userID, 18);
            }else{ 
               cancleHabit(userID, 18);
            } 
        } 
    }); 
	box19.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){ 
        @Override
        public void onCheckedChanged(CompoundButton buttonView, 
                boolean isChecked) { 
            // TODO Auto-generated method stub 
        	if(isChecked){ 
            	addHabit(userID, 19);
            }else{ 
               cancleHabit(userID, 19);
            } 
        } 
    }); 
	box20.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){ 
        @Override
        public void onCheckedChanged(CompoundButton buttonView, 
                boolean isChecked) { 
        	if(isChecked){ 
            	addHabit(userID, 20);
            }else{ 
               cancleHabit(userID, 20);
            } 
        } 
    }); 
	box21.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){ 
        @Override
        public void onCheckedChanged(CompoundButton buttonView, 
                boolean isChecked) { 
            // TODO Auto-generated method stub 
        	if(isChecked){ 
            	addHabit(userID, 21);
            }else{ 
               cancleHabit(userID, 21);
            } 
        } 
    }); 
	box22.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){ 
        @Override
        public void onCheckedChanged(CompoundButton buttonView, 
                boolean isChecked) { 
        	if(isChecked){ 
            	addHabit(userID, 22);
            }else{ 
               cancleHabit(userID, 22);
            } 
        } 
    }); 
	box23.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){ 
        @Override
        public void onCheckedChanged(CompoundButton buttonView, 
                boolean isChecked) { 
            // TODO Auto-generated method stub 
        	if(isChecked){ 
            	addHabit(userID, 23);
            }else{ 
               cancleHabit(userID, 23);
            } 
        } 
    }); 
	box24.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){ 
        @Override
        public void onCheckedChanged(CompoundButton buttonView, 
                boolean isChecked) { 
            // TODO Auto-generated method stub 
        	if(isChecked){ 
            	addHabit(userID, 24);
            }else{ 
               cancleHabit(userID, 24);
            } 
        } 
    }); 
	box25.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){ 
        @Override
        public void onCheckedChanged(CompoundButton buttonView, 
                boolean isChecked) { 
            // TODO Auto-generated method stub 
        	if(isChecked){ 
            	addHabit(userID, 25);
            }else{ 
               cancleHabit(userID, 25);
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
}

