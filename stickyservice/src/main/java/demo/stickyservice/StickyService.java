package demo.stickyservice;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Johnny on 2016/9/9.
 */
public class StickyService extends Service{

	private Handler workHandler;
	private int logCount;


	@Nullable
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		log("create");
		HandlerThread workThread = new HandlerThread("test");
		workThread.start();
		workHandler = new Handler(workThread.getLooper(), new Handler.Callback() {
			@Override
			public boolean handleMessage(Message msg) {
				log("logCount = " + logCount++);

				workHandler.sendEmptyMessageDelayed(0x11,2000);
				return false;
			}
		});
		workHandler.sendEmptyMessage(0x11);
	}


	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		log("startCommand");

//		JPushInterface.init(getApplicationContext());

		return START_STICKY;
	}


	@Override
	public void onDestroy() {
		log("destroy");
		super.onDestroy();
	}

	private void log(String s){
		Log.i("service",s);
	}
}
