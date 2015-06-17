package com.nankai.yimixicanandroid.activity;
/**
 * 每日需水量测试
**/
import java.text.DecimalFormat;

import com.nankai.yimixicanandroid.R;
import com.nankai.yimixicanandroid.po.WaterNeed;
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

public class HealthTest4 extends Activity {
	private EditText weight;
	private Button start_test;
	private double userWeight;
	private ImageView home,back;
	protected void onCreate(Bundle savedInstanceState) {

		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE); //设置全屏
		this.setContentView(R.layout.activity_atest4);
		this.weight=(EditText)this.findViewById(R.id.weight);
		this.start_test=(Button)this.findViewById(R.id.start_test);
		this.home = (ImageView) this.findViewById(R.id.home);
		this.back=(ImageView)this.findViewById(R.id.back);
		//监听事件
		this.start_test.setOnClickListener(new ViewOcl());	
		this.home.setOnClickListener(new ViewOcl());	
		this.back.setOnClickListener(new ViewOcl());	
	}
	private class ViewOcl implements View.OnClickListener{
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent=new Intent();
			switch (v.getId()) {
			case R.id.start_test:
				if(check_null())
				{
					userWeight=(Double.parseDouble(weight.getText().toString().trim()));
					CalculateHealth calculateHealth=new CalculateHealth();
					WaterNeed waterNeed=new WaterNeed();
					waterNeed=calculateHealth.dailywater(userWeight);
					DecimalFormat df = new DecimalFormat("#.00");//设置结果保存两位小数
					//结果以对话框形式显示
					AlertDialog dialog = new  AlertDialog.Builder(HealthTest4.this)
					.setTitle("测试结果")
					.setIcon(R.drawable.icon1)
					.setMessage("每日需水总量："+df.format(waterNeed.getTotal())+"毫升\n早晨6: 30——"+df.format(waterNeed.getTime1())+"毫升\n上午8: 30——"+df.format(waterNeed.getTime2())+"毫升\n中午11 : 00——"+df.format(waterNeed.getTime3())+"毫升\n下午12: 50——"+df.format(waterNeed.getTime4())+"毫升\n下午15: 00——"+df.format(waterNeed.getTime5())+"毫升\n晚上17: 30——"+df.format(waterNeed.getTime6())+"毫升\n夜里22: 00——"+df.format(waterNeed.getTime7())+"毫升")
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
						})
						.create();
						dialog.show();
					}
				break;
			case R.id.home:				
           	    intent.setClass(HealthTest4.this,Main.class );
           	    startActivity(intent); 
				break;
			case R.id.back:	
				intent.setClass(HealthTest4.this, HealthTestMain.class);
				startActivity(intent);
				break;
				}			
			}
			}
	//检查
	public boolean check_null(){
		if(weight.getText().toString().trim().equals(null)||weight.getText().toString().trim().length()==0){
			Toast.makeText(getApplicationContext(), "亲，猜你忘填体重了",Toast.LENGTH_LONG).show();
			return false;
		}
		return true;
		
	}
}