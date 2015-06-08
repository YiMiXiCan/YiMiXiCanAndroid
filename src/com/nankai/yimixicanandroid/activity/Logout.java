package com.nankai.yimixicanandroid.activity;


import com.nankai.yimixicanandroid.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Logout extends Activity {
	
	private Button btnLogout, btnCannel;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_logout);
		this.btnLogout = (Button) this.findViewById(R.id.btnLogout);
		this.btnCannel = (Button) this.findViewById(R.id.btnCan);
		// 设置监听器
		this.btnLogout.setOnClickListener(new ViewOcl());
		this.btnCannel.setOnClickListener(new ViewOcl());
	}
	private class ViewOcl implements  View.OnClickListener{
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.btnLogout:
			
				Toast.makeText(getApplicationContext(), "亲，再留一会吧", Toast.LENGTH_LONG).show();
				//String response = WebAccessUtils.httpRequest("ALogoutServlet");
				finish();
				break;
			case R.id.btnCan:
				Intent intent = new Intent();
				intent.setClass(Logout.this, Main.class);
				startActivity(intent);				
		}
		
	}

}
	

}
