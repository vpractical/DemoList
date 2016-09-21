package demo.tablayout.utils;

import android.os.Handler;
import android.os.Message;

/**
 * Created by Johnny on 2016/9/8.
 */
public abstract class UI {


	public void handle(Handler mainHandler){
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				want();
			}
		};
		Message message = Message.obtain(mainHandler,runnable);
		mainHandler.sendMessage(message);
	}


	public abstract void want();

}
