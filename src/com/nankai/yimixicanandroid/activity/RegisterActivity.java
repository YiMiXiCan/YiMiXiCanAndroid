package com.nankai.yimixicanandroid.activity;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.nankai.yimixicanandroid.R;
import com.nankai.yimixicanandroid.internet.WebAccessUtils;
import com.nankai.yimixicanandroid.po.Users;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
//步骤1：继承父类Android.app.Activity
public class RegisterActivity extends Activity {
	// 步骤4：声明该页面中的交互类组件
	private EditText txtregAccount, txtregPassword,txtregPassword2;
	private Button btnReg;
	private CheckBox cbregAgree;
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	// 步骤2：重写父类中的一个方法OnCreate()  Ctrl+Shift+S,V
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE); //设置全屏
		this.setContentView(R.layout.activity_register);
		
		this.txtregAccount = (EditText) this.findViewById(R.id.txtregAccount);
		this.txtregPassword = (EditText) this.findViewById(R.id.txtregPassword);
		this.txtregPassword2 = (EditText) this.findViewById(R.id.txtregPassword2);
		this.cbregAgree = (CheckBox) this.findViewById(R.id.cbregAgree);
		this.btnReg = (Button) this.findViewById(R.id.btnReg);
		this.btnReg.setOnClickListener(new ViewOcl());
	}
	
	private class ViewOcl implements View.OnClickListener{
		@SuppressLint("SimpleDateFormat")
		public void onClick(View v) {
			if(R.id.btnReg==v.getId())
			{
				  boolean flag=checkForm();
	                 if(flag){
	                	 Users user=new Users();
	                	 String iden,repassword,password,regtime;
	                	 iden=txtregAccount.getText().toString().trim();
	                	 repassword=txtregPassword2.getText().toString().trim();
	                	 password=txtregPassword.getText().toString().trim();	       
	                	 user.setUsername(iden);
	                	 user.setRepassword(repassword);
	                	 user.setPassword(password);
	                	 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	             		Date nowtime = new Date();
	             		regtime = sdf.format(nowtime);
	             		user.setRegtime(regtime);
	 	 				Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-ddhh:mm:ss").create();
	 	 				String user_data = gson.toJson(user);
	 	 				List<NameValuePair> lstNameValuePairs = new ArrayList<NameValuePair>();
	 	 				lstNameValuePairs.add(new BasicNameValuePair("user_data", user_data));
	 	 				String response = WebAccessUtils.httpRequest("RegisterServlet", lstNameValuePairs);				
	 	 				Type ListMessages = new TypeToken<String>() {
	             		}.getType();
	             		String  string = gson.fromJson(response, ListMessages);
	 	 				 if(string.equals("true")){
	                	 Toast.makeText(getApplicationContext(), "恭喜您，注册成功！", Toast.LENGTH_LONG).show();
	                	 SharedPreferences.Editor editor=getSharedPreferences("publicData",MODE_WORLD_WRITEABLE).edit();
	                	 editor.putString("account", iden);
	                	 editor.commit();
	                	 Intent intent=new Intent();
		            	 intent.setClass(RegisterActivity.this,Login.class );
		            	 startActivity(intent); 
	                 }else{
	 					Toast.makeText(getApplicationContext(), "账号已存在，请更改账号", Toast.LENGTH_LONG).show();
	 				}
	                 }				
			}
		}
	}
	    private boolean checkForm(){
	    	if(this.txtregAccount.getText().toString()==null||this.txtregAccount.getText().toString().length()==0){
	    		Toast.makeText(getApplicationContext(), "手机号/账号不可为空！", Toast.LENGTH_LONG).show();
	    		return false;
	    	}
	    	if(this.txtregPassword.getText().toString()==null||this.txtregPassword.getText().toString().length()==0){
	    		Toast.makeText(getApplicationContext(), "密码不可为可！", Toast.LENGTH_LONG).show();
	    		return false;
	    	}
	      	if(!(this.txtregPassword2.getText().toString()).equals(this.txtregPassword2.getText().toString())){
	    		Toast.makeText(getApplicationContext(), "两次密码不一致！", Toast.LENGTH_LONG).show();
	    		return false;
	    	}
	      	if(!this.cbregAgree.isChecked()){
	      		Toast.makeText(getApplicationContext(), "必须阅读并同意我们的条款", Toast.LENGTH_LONG).show();
	      		return false;
	      	}
	    	return true;
	    }
	    
}
