package com.nankai.yimixicanandroid.tools;

import com.nankai.yimixicanandroid.R;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

public class RemindMe extends Activity {
	 NotificationManager objNotificationManager;
	 Notification        objNotification;
	 PendingIntent       objPendingIntent;
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		objNotificationManager = (NotificationManager) getSystemService( NOTIFICATION_SERVICE );	       
        int icon = R.drawable.icon2;
        CharSequence tickerText = "小图标旁的文字";
        objNotification = new Notification( icon,
                                            tickerText,
                                            System.currentTimeMillis() );
        
        // 如果有振动或者全部提示方式，必须在 AndroidManifest.xml 加入振动权限
        objPendingIntent = PendingIntent.getActivity( this,
                                                      0,
                                                      new Intent( this, RemindMe.class ),
                                                      0 );
        objNotification.setLatestEventInfo( this,
                                            "通知栏的标题",
                                            "通知栏的内容",
                                            objPendingIntent );           
        // 添加入通知管理器中
        objNotificationManager.notify( 0,
                                       objNotification ); 
    }
}
