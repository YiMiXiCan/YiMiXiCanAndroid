package com.nankai.yimixicanandroid.activity;
/**
 * 女性最佳体型测试
**/
import java.text.DecimalFormat;

import com.nankai.yimixicanandroid.R;
import com.nankai.yimixicanandroid.po.FemaleBody;
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

public class HealthTest2 extends Activity {
	private EditText height;
	private Button start_test;
	private double userheight;
	private ImageView home,back;
	protected void onCreate(Bundle savedInstanceState) {

		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE); //设置全屏
		this.setContentView(R.layout.activity_atest2);
		this.height=(EditText)this.findViewById(R.id.height);
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
					userheight=(Double.parseDouble(height.getText().toString().trim()));
					CalculateHealth calculateHealth=new CalculateHealth();
					FemaleBody body=new FemaleBody();
					body=calculateHealth.bestfemale(userheight);
					DecimalFormat df = new DecimalFormat("#.00");//设置结果保存两位小数
					//结果以对话框形式显示
					AlertDialog dialog = new  AlertDialog.Builder(HealthTest2.this)
					.setTitle("测试结果")
					.setIcon(R.drawable.icon1)
					.setMessage("上臂围："+df.format(body.getArm())+"英寸\n胸围:"+df.format(body.getBust())+"英寸\n腰围下限:"+df.format(body.getWaistmin())+"英寸\n腰围上限"+df.format(body.getWaistmax())+"英寸\n臀围"+df.format(body.getHips())+"英寸\n大腿围"+df.format(body.getThigh())+"英寸\n小腿围"+df.format(body.getLowerLeg())+"英寸")
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
           	    intent.setClass(HealthTest2.this,Main.class );
           	    startActivity(intent); 
				break;
			case R.id.back:	
				intent.setClass(HealthTest2.this, HealthTestMain.class);
				startActivity(intent);
				break;
				}			
			}
			}
	//检查
	public boolean check_null(){
		if(height.getText().toString().trim().equals(null)||height.getText().toString().trim().length()==0){
			Toast.makeText(getApplicationContext(), "亲，猜你忘填身高了",Toast.LENGTH_LONG).show();
			return false;
		}
		return true;
		
	}
}