package com.nankai.yimixicanandroid.activity;
/**
 * 名字：MyCard.java
 * 功能：用户每日打卡与分享
 * 作者：谭米玲
 * 时间：6月20日
 * */
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MyCard extends Activity {
	private ImageView home,back,share;
	private Button daka;
	private int userID;
	private List<Map<String, ?>> lstData;
	private ListView lstMessage;
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏	
		this.setContentView(R.layout.activity_card);
		Intent intent=super.getIntent();
		userID=intent.getIntExtra("UID", 1);//获取用户ID
		
		this.home = (ImageView) this.findViewById(R.id.home);
		this.back = (ImageView) this.findViewById(R.id.back);
		this.share = (ImageView) this.findViewById(R.id.share);
		this.daka = (Button) this.findViewById(R.id.btnDaka);
		this.lstMessage = (ListView) this.findViewById(R.id.mycard_list);			
		this.lstData = fetchData();
		SimpleAdapter adapter = new SimpleAdapter(this, this.lstData,
				R.layout.mycard_item, new String[] {
						"habitName","imgPhoto"}, new int[] {
						R.id.habit_name, R.id.image});
		this.lstMessage.setAdapter(adapter);		
		this.home.setOnClickListener(new ViewOcl());
		this.back.setOnClickListener(new ViewOcl());
		this.share.setOnClickListener(new ViewOcl());
		this.daka.setOnClickListener(new ViewOcl());
		this.lstMessage.setOnItemLongClickListener(new ItemLongOcl());
	}
	//显示ListView
	private List<Map<String, ?>> fetchData() {
		// TODO Auto-generated method stub
		String user_id=String.valueOf(userID);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-ddHH:mm:ss").create();
		List<NameValuePair> lstNameValuePairs = new ArrayList<NameValuePair>();
		lstNameValuePairs.add(new BasicNameValuePair("user_id", user_id));			
		String response = WebAccessUtils.httpRequest("MyCardServlet", lstNameValuePairs);//显示用户的目标习惯	
		List<Map<String, ?>> lst = new ArrayList<Map<String, ?>>();
		Type ListMessages = new TypeToken<ArrayList<UserCard>>() {
		}.getType();	
		List<UserCard> lstMycard = gson.fromJson(response, ListMessages);
		for (UserCard card : lstMycard) {
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("habitId",card.getHabitID());
			item.put("habitName", card.getHabitName());
			item.put("imgPhoto", R.drawable.tutu);
			item.put("tick", null);
			lst.add(item);			
		}
		return lst;
	}
	//控件事件监听
	private class ViewOcl implements View.OnClickListener{
		@Override
		public void onClick(View v) 
		{
			Intent intent=new Intent();
			// TODO Auto-generated method stub
			switch (v.getId()) 
			{
			case R.id.home:				
           	    intent.setClass(MyCard.this,Main.class );
           	    startActivity(intent); 
				break;
			case R.id.back:
           	    intent.setClass(MyCard.this,Main.class );
           	    startActivity(intent); 
				break;
			case R.id.btnDaka:
				Toast.makeText(getApplicationContext(), "太赞了，打卡成功！", Toast.LENGTH_LONG).show();
				break;
			case R.id.share://打卡分享
				String user_id=String.valueOf(userID);
				Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-ddHH:mm:ss").create();
				List<NameValuePair> lstNameValuePairs = new ArrayList<NameValuePair>();
				lstNameValuePairs.add(new BasicNameValuePair("user_id", user_id));			
				String response = WebAccessUtils.httpRequest("MyShareServlet", lstNameValuePairs);		
				Type ListMessages = new TypeToken<ArrayList<String>>() {
				}.getType();	
				List<String> lstMycard = gson.fromJson(response, ListMessages);
				String share="我完成了：";
				for (String card : lstMycard) {
					share+=card;
					share+="！";
				}
				//--------------分享与收藏功能-----------------------------------------------
				Intent intent1=new Intent(Intent.ACTION_SEND);   
				intent1.setType("image/*");  
				File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
				File file = new File(dir, "icon2.png");//获取图片文件
				intent1.putExtra(Intent.EXTRA_SUBJECT, "健人来打卡分享");   
				intent1.putExtra(Intent.EXTRA_TEXT, "健健，快来打卡吧！\n"+share+"\n求赞！");   
				intent1.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));//添加图片
				intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);   
				startActivity(Intent.createChooser(intent1, getTitle()));   
				break;
			}
		}
	}	
	//设置ListView长按删除习惯
	private class ItemLongOcl implements AdapterView.OnItemLongClickListener{
		@Override
		public boolean onItemLongClick(AdapterView<?> adapter, View view,
				int position, long arg3) {
			// TODO Auto-generated method stub
			Map<String, ?> selectedItem = lstData.get(position);
			int habitID=(Integer) selectedItem.get("habitID");
			cancleHabit(userID, habitID);
			return true;
		}
		
	}
	//删除习惯
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