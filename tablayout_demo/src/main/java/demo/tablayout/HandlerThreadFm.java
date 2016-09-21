package demo.tablayout;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import demo.tablayout.utils.UI;

/**
 * Created by Johnny on 2016/8/31.
 */
public class HandlerThreadFm extends Fragment {
	TextView tv;
	HandlerThread workHandlerThread;
	Handler workHandler;
	Handler mainHandler;

	boolean isCanCheck = true;


	/////////////

	Thread workThread;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		tv = new TextView(getActivity());
		tv.setGravity(Gravity.CENTER);
		tv.setTextSize(100);
		tv.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				isCanCheck = !isCanCheck;
			}
		});


		mainHandler = new Handler();
		new UI() {
			@Override
			public void want() {
				Log.i("dd", "0");
			}
		}.handle(mainHandler);

		init1();
//		init2();
		return tv;
	}

	private void init2() {
		mainHandler = new Handler();
		mainHandler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				super.handleMessage(msg);
				tv.setText(Math.random() + "");
			}
		};

		/**
		 * 作为参数的Callback中的handleMessage，返回值为true时
		 */
		workThread = new Thread(new Runnable() {
			@Override
			public void run() {
				Looper.prepare();
				workHandler = new Handler(new Handler.Callback() {
					@Override
					public boolean handleMessage(Message msg) {
						if (isCanCheck) {
							mainHandler.sendEmptyMessage(0x12);
							workHandler.sendEmptyMessageDelayed(0x11, 1000);
						}

						return false;
					}
				}) {
					@Override
					public void handleMessage(Message msg) {

						super.handleMessage(msg);
						if (isCanCheck) {
							mainHandler.sendEmptyMessage(0x12);
							workHandler.sendEmptyMessageDelayed(0x11, 1000);
						}
					}
				};
				Looper.loop();
			}
		});
		workThread.start();
	}


	private void init1() {
		mainHandler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				super.handleMessage(msg);
				tv.setText(Math.random() + "");
			}
		};
		workHandlerThread = new HandlerThread("test_do");
		workHandlerThread.start();
		workHandler = new Handler(workHandlerThread.getLooper(), new Handler.Callback() {
			@Override
			public boolean handleMessage(Message msg) {
				if (isCanCheck) {
					checkUpdate();
					workHandler.sendEmptyMessageDelayed(0x11, 1000);
				}
				return false;
			}
		}) {
			@Override
			public void handleMessage(Message msg) {
				super.handleMessage(msg);
//				if (isCanCheck) {
//					checkUpdate();
//					workHandler.sendEmptyMessageDelayed(0x11, 1000);
//				}
			}
		};
	}

	private void checkUpdate() {
		mainHandler.sendEmptyMessage(0x12);
	}

	@Override
	public void onResume() {
		super.onResume();
		isCanCheck = true;
		if (workHandler != null) {
			workHandler.sendEmptyMessage(0x11);
		}
	}

	@Override
	public void onPause() {
		super.onPause();
		isCanCheck = false;
		if (workHandler != null) {
			workHandler.removeMessages(0x11);
		}
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		if (workHandlerThread != null) {
			workHandlerThread.quit();
		}
	}

}
