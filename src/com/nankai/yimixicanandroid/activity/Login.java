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
import android.os.StrictMode;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {
	private EditText txtAccount, txtPassword;
	private Button btnRegister, btnLogin;
    protected void onCreate(Bundle savedInstanceState) {
        
    	StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	    StrictMode.setThreadPolicy(policy);
    	super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_login);
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
		
		this.setContentView(R.layout.activity_login);
		
		this.txtAccount = (EditText) this.findViewById(R.id.txtAccount);
		this.txtPassword = (EditText) this.findViewById(R.id.txtPassword);
		this.btnRegister = (Button) this.findViewById(R.id.btnRegister);
		this.btnLogin = (Button) this.findViewById(R.id.btnLogin);
		
		this.btnRegister.setOnClickListener(new ViewOcl());
		this.btnLogin.setOnClickListener(new ViewOcl());
	}
	
	
	private class ViewOcl implements  View.OnClickListener{
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.btnRegister:
				Toast.makeText(getApplicationContext(), "哈哈", Toast.LENGTH_LONG).show();
				Intent intent1 = new Intent();
				intent1.setClass(Login.this, RegisterActivity.class);
				startActivity(intent1);
				break;
			case R.id.btnLogin:
				
				
				String account = txtAccount.getText().toString().trim();
				String password = txtPassword.getText().toString().trim();
				
				Users user = new Users();
				user.setUid(account);
				user.setPassword(password);
				
				Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-ddhh:mm:ss").create();
				String user_data = gson.toJson(user);
				System.out.println(user_data);
						
				
				
				List<NameValuePair> lstNameValuePairs = new ArrayList<NameValuePair>();
				lstNameValuePairs.add(new BasicNameValuePair("user_data", user_data));
				
				
				String response = WebAccessUtils.httpRequest("ALoginServlet", lstNameValuePairs);	
				System.out.println(response);
				
				
				Users u = null;
				u = gson.fromJson(response, Users.class);
				
				if(u != null){
					
					Intent intent = new Intent();
					intent.putExtra("user", u.getUid());
					intent.setClass(Login.this, Main.class);
					startActivity(intent);
				}else{
					Toast.makeText(getApplicationContext(), "呵呵哒", Toast.LENGTH_LONG).show();
				}
				
				
				break;
			default:
				break;
			}
		}
		
	}

}