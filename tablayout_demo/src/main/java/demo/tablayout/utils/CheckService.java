package demo.tablayout.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Created by Johnny on 2016/9/9.
 */
public class CheckService {

	public static void getRunningServices(Context context){
		ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
		List<ActivityManager.RunningServiceInfo> list = manager.getRunningServices(200);
		for (ActivityManager.RunningServiceInfo info:list
			 ) {
			Log.i("-------",info.service.getClassName() + "\n" + info.service.getPackageName() + "\n");
		}
	}
}
