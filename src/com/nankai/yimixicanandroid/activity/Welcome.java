package com.nankai.yimixicanandroid.activity;

import com.nankai.yimixicanandroid.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

public class Welcome extends Activity {

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//************************************		
		// 由于访问互联网，因此将网络访问放入到子线程中进行
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		//************************************		
		super.onCreate(savedInstanceState);
		 //设置全屏
		 this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		 //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		 setContentView(R.layout.welcome);
		 ImageView view =(ImageView) findViewById(R.id.imageView1);
         AlphaAnimation aa = new AlphaAnimation(0.01f,1.0f);//透明度变
         aa.setDuration(1500);//设置渐变时间
         view.startAnimation(aa);//设置渐变的view
		aa.setAnimationListener(new AnimationListener(){
      	 //动画结束后自动执行
        public void onAnimationEnd(Animation arg0) {
            redirectTo();
        }
        public void onAnimationRepeat(Animation animation) {
        	
        }
        public void onAnimationStart(Animation animation) {
        	
        }
                                                                      
     });
}

	/**
     * 跳转到登录界面
     */
    private void redirectTo(){       
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
        finish();
    }

}
