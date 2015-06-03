package com.nankai.yimixicanandroid.tools;

import java.io.File;

import com.nankai.yimixicanandroid.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

public class ShareAndCollect extends Activity {
	private Button btnShare;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		//this.btnShare=(Button)this.findViewById(R.id.bntShare);
		this.btnShare.setOnClickListener(new ViewOcl());
	    }  
	private class ViewOcl implements View.OnClickListener{
	public void onClick(View view) 
	{  
//		switch (view.getId())
//		{
		//case R.id.bntShare:
		
//--------------分享与收藏功能-----------------------------------------------
		Intent intent=new Intent(Intent.ACTION_SEND);   
		intent.setType("image/*");  
		File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
		File file = new File(dir, "icon2.png");//获取图片文件
		intent.putExtra(Intent.EXTRA_SUBJECT, "分享");   
		intent.putExtra(Intent.EXTRA_TEXT, "终于可以了!!!");   
		 intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));//添加图片
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);   
		startActivity(Intent.createChooser(intent, getTitle()));   
//--------------------------------------------------------------------------
//		}
		}
	}
}
