package com.nankai.yimixicanandroid.activity;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nankai.yimixicanandroid.R;
import com.nankai.yimixicanandroid.internet.WebAccessUtils;
import com.nankai.yimixicanandroid.po.Users;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
public class PerInfo extends Activity{
	private ImageView back,home;
	private EditText account,height,weight,oldpassword,newpassword,renewpassword;
	private Spinner sex;
	private int userID;
protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE); 
		this.setContentView(R.layout.activity_detail);

		Intent intent=super.getIntent();
		userID=intent.getIntExtra("UID", 1);//获取用户ID
		
		this.account=(EditText)this.findViewById(R.id.txtAccount);
		this.height=(EditText)this.findViewById(R.id.txtregheight);
		this.weight=(EditText)this.findViewById(R.id.txtregweight);
		this.oldpassword=(EditText)this.findViewById(R.id.txtregPassword);
		this.newpassword=(EditText)this.findViewById(R.id.txtregPassword1);
		this.renewpassword=(EditText)this.findViewById(R.id.txtregPassword2);
		this.sex=(Spinner)this.findViewById(R.id.spSex);
		this.back=(ImageView)this.findViewById(R.id.back);
		this.home=(ImageView)this.findViewById(R.id.home);
		
		this.back.setOnClickListener(new ViewOcl());
		this.home.setOnClickListener(new ViewOcl());
		show(userID);
}
/**
 * 显示用户信息
 **/
public void show(int userID)
{
	String user_id=String.valueOf(userID);
	Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-ddHH:mm:ss").create();
	List<NameValuePair> lstNameValuePairs = new ArrayList<NameValuePair>();
	lstNameValuePairs.add(new BasicNameValuePair("user_id", user_id));			
	String response = WebAccessUtils.httpRequest("UserInformationServlet", lstNameValuePairs);
	Users user=new Users();
	user= gson.fromJson(response,Users.class);
	//organizer Detail
	//account.setText(user.getUsername());
	height.setText(String.valueOf(user.getHeight()));
	weight.setText(String.valueOf(user.getWeight()));
	oldpassword.setText(user.getPassword());
	
}
private class ViewOcl implements View.OnClickListener{
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent=new Intent();
		switch (v.getId()) {
		case R.id.back://返回					
			intent.setClass(PerInfo.this, MoreSet.class);
			startActivity(intent);
			break;
		case R.id.home:	//跳到主页			
       	    intent.setClass(PerInfo.this,Main.class );
       	    startActivity(intent); 
			break;
		}
		}
	}
}
