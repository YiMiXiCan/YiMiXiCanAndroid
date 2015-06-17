package com.nankai.yimixicanandroid.activity;
/**
 * 每日所需能量测试
**/
import java.text.DecimalFormat;

import com.nankai.yimixicanandroid.R;
import com.nankai.yimixicanandroid.po.CaloryNeed;
import com.nankai.yimixicanandroid.tools.CalculateHealth;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class HealthTest3 extends Activity {
	private EditText age,height,weight;
	private Button start_test;
	private double userHeight,userWeight;
	private int userAge;
	private ImageView home,back;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE); //设置全屏
		this.setContentView(R.layout.activity_atest3);		
		this.age=(EditText)this.findViewById(R.id.age);
		this.height=(EditText)this.findViewById(R.id.height);
		this.weight=(EditText)this.findViewById(R.id.weight);
		this.start_test=(Button)this.findViewById(R.id.start_test);
		this.home = (ImageView) this.findViewById(R.id.home);
		this.back=(ImageView)this.findViewById(R.id.back);
		this.start_test.setOnClickListener(new ViewOcl());	
		this.home.setOnClickListener(new ViewOcl());	
		this.back.setOnClickListener(new ViewOcl());
			
	}
	private class ViewOcl implements View.OnClickListener{
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.start_test:
				if(check_null())
				{
					userAge=Integer.parseInt(age.getText().toString().trim());
					userHeight=Double.parseDouble(height.getText().toString().trim());
					userWeight=Double.parseDouble(weight.getText().toString().trim());
					CalculateHealth calculateHealth=new CalculateHealth();
					CaloryNeed caloryNeed=new CaloryNeed();
					caloryNeed=calculateHealth.dailycalory(userAge, userWeight, userHeight);
					DecimalFormat df = new DecimalFormat("#.00");//设置结果保存两位小数
					//结果以对话框形式显示
					AlertDialog dialog = new  AlertDialog.Builder(HealthTest3.this)
					.setTitle("测试结果")
					.setIcon(R.drawable.icon1)
					.setMessage("女:"+"\n几乎不动： "+df.format(caloryNeed.getFemale1())+"\n稍微运动:"+df.format(caloryNeed.getFemale2())+"\n中度运动:"+df.format(caloryNeed.getFemale3())+"\n积极运动:"+df.format(caloryNeed.getFemale4())+"\n专业运动:"+df.format(caloryNeed.getFemale5())+"\n\n"+"男:"+"\n几乎不动： "+df.format(caloryNeed.getMale1())+"\n稍微运动:"+df.format(caloryNeed.getMale2())+"\n中度运动:"+df.format(caloryNeed.getMale3())+"\n积极运动:"+df.format(caloryNeed.getMale4())+"\n专业运动:"+df.format(caloryNeed.getMale5()))
					//相当于点击确认按钮
					.setPositiveButton("分享", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub							
						}
						})
					.setNegativeButton("返回", new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub	
							
						}
						}).create();
						dialog.show();
					}
				break;
			case R.id.home:
				Intent intent5=new Intent();
           	    intent5.setClass(HealthTest3.this,Main.class );
           	    startActivity(intent5); 
				break;
			case R.id.back:
				Intent intent6=new Intent();		
				intent6.setClass(HealthTest3.this, HealthTestMain.class);
				startActivity(intent6);
				break;
				}			
			}
			}
	//检查
	public boolean check_null(){
		if(age.getText().toString().trim().equals(null)||age.getText().toString().trim().length()==0){
			Toast.makeText(getApplicationContext(), "亲，猜你忘填身高了",Toast.LENGTH_LONG).show();
			return false;
		}
		if(height.getText().toString().trim().equals(null)||height.getText().toString().trim().length()==0){
			Toast.makeText(getApplicationContext(), "亲，猜你忘填身高了",Toast.LENGTH_LONG).show();
			return false;
		}
		if(weight.getText().toString().trim().equals(null)||weight.getText().toString().trim().length()==0){
			Toast.makeText(getApplicationContext(), "亲，猜你忘填体重了",Toast.LENGTH_LONG).show();
			return false;
		}
		return true;
		
	}
}
