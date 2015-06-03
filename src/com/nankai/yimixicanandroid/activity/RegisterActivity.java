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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//步骤1：继承父类Android.app.Activity
public class RegisterActivity extends Activity {
	// 步骤4：声明该页面中的交互类组件
	private EditText txtregAccount, txtregPassword,txtregPassword2;
	private Button btnReg;

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	// 步骤2：重写父类中的一个方法OnCreate()  Ctrl+Shift+S,V
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_register);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE); //设置全屏
		
		this.txtregAccount = (EditText) this.findViewById(R.id.txtregAccount);
		this.txtregPassword = (EditText) this.findViewById(R.id.txtregPassword);
		this.txtregPassword2 = (EditText) this.findViewById(R.id.txtregPassword2);
		
		this.btnReg = (Button) this.findViewById(R.id.btnReg);
		
	}
	
	private class ViewOcl implements View.OnClickListener{
		public void onClick(View v) {
			if(R.id.btnReg==v.getId())
			{
				String account=txtregAccount.getText().toString().trim();
				String password=txtregPassword.getText().toString().trim();
				String repassword=txtregPassword2.getText().toString().trim();
				Users users=new Users();
				users.setUsername(account);	
				users.setPassword(password);			
				users.setRepassword(repassword);
				Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-ddhh:mm:ss").create();
				String user_data = gson.toJson(users);
				System.out.println(user_data);
				
				List<NameValuePair> lstNameValuePairs = new ArrayList<NameValuePair>();
				lstNameValuePairs.add(new BasicNameValuePair("user_data", user_data));
		
				String response = WebAccessUtils.httpRequest("ARegisterServlet", lstNameValuePairs);	
				System.out.println(response);
				if(response!="101"&&response!="102")
				{
					Toast.makeText(getApplicationContext(), "注册成功！", Toast.LENGTH_LONG).show();
					Intent intent1 = new Intent();
					intent1.setClass(RegisterActivity.this, Main.class);
					startActivity(intent1);
				}
				
				
			}
		}
	}
}