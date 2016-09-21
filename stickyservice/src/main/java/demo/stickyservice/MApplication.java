package demo.stickyservice;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by Johnny on 2016/9/12.
 */
public class MApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		startService(getApplicationContext());
		JPushInterface.init(getApplicationContext());
	}



	public static void startService(Context context){
		Intent intent = new Intent();
		intent.setClass(context,StickyService.class);
		context.startService(intent);
	}

	public static void stopService(Context context){
		Intent intent = new Intent();
		intent.setClass(context,StickyService.class);
		context.stopService(intent);
	}



}
