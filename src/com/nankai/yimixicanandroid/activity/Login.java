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
import android.content.SharedPreferences;
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
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏		
		this.setContentView(R.layout.activity_login);
		
		this.txtAccount = (EditText) this.findViewById(R.id.txtAccount);
		this.txtPassword = (EditText) this.findViewById(R.id.txtPassword);
		this.btnRegister = (Button) this.findViewById(R.id.btnRegister);
		this.btnLogin = (Button) this.findViewById(R.id.btnLogin);
		this.btnRegister.setOnClickListener(new ViewOcl());
		this.btnLogin.setOnClickListener(new ViewOcl());
		SharedPreferences preferences=getSharedPreferences("publicData", MODE_WORLD_READABLE);
		String account=preferences.getString("account", "");
		this.txtAccount.setText(account); 
	}
	
	
    private class ViewOcl implements View.OnClickListener{
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.btnRegister:
				Toast.makeText(getApplicationContext(), "欢迎来注册", Toast.LENGTH_LONG).show();
				Intent intent1 = new Intent();
				intent1.setClass(Login.this, RegisterActivity.class);
				startActivity(intent1);
				break;
			case R.id.btnLogin:
				if(checkForm()){		
				String account = txtAccount.getText().toString().trim();
				String password = txtPassword.getText().toString().trim();
				
				Users user = new Users();
				user.setUsername(account);
				user.setPassword(password);	
				Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-ddhh:mm:ss").create();
				String user_data = gson.toJson(user);
				System.out.println(user_data);
		
				List<NameValuePair> lstNameValuePairs = new ArrayList<NameValuePair>();
				lstNameValuePairs.add(new BasicNameValuePair("user_data", user_data));
		
				String response = WebAccessUtils.httpRequest("LoginServlet", lstNameValuePairs);	
				System.out.println(response);
				Users u = null;
				u = gson.fromJson(response, Users.class);				
				if(u != null){					
					SharedPreferences.Editor editor=getSharedPreferences("publicData",MODE_WORLD_WRITEABLE).edit();
               	    editor.putInt("UID", u.getUid());
               	    editor.commit();               	    
					Toast.makeText(getApplicationContext(), "欢迎登录逗逗乐", Toast.LENGTH_LONG).show();
					Intent intent2 = new Intent();
					intent2.setClass(Login.this, Main.class);
					startActivity(intent2);
				}else{
					Toast.makeText(getApplicationContext(), "用户名和密码不匹配", Toast.LENGTH_LONG).show();
					}	
				}
				break;
			default:
				break;
			}
		}
		
	}
	//非空验证
	private boolean checkForm(){
    	if(txtAccount.getText().toString()==null||txtAccount.getText().toString().length()==0){
    		Toast.makeText(getApplicationContext(), "账号不可为空", Toast.LENGTH_LONG).show();
    		return false;
    	}
    	if(txtPassword.getText().toString()==null||txtPassword.getText().toString().length()==0){
    		Toast.makeText(getApplicationContext(), "密码不可为空", Toast.LENGTH_LONG).show();
    		return false;
    	}		
    	return true;
}
}