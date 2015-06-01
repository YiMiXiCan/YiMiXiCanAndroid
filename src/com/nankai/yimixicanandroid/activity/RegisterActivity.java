package com.nankai.yimixicanandroid.activity;


import android.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
//步骤1：继承父类Android.app.Activity
public class RegisterActivity extends Activity {
	// 步骤4：声明该页面中的交互类组件
	private EditText txtName, txtPassword,txtRPassword;
	private Button btnRegister, btnCancel;

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
	}
	
	

}
