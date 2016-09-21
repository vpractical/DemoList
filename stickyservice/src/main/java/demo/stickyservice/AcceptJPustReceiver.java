package demo.stickyservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import cn.jpush.android.api.JPushInterface;

/**
 * 自定义接收器
 * <p/>
 * 如果不定义这个 Receiver，则： 1) 默认用户会打开主界面 2) 接收不到自定义消息
 */
public class AcceptJPustReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		Bundle bundle = intent.getExtras();
		String extras = bundle.getString(JPushInterface.EXTRA_EXTRA);
		if (JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction())) {
//			String regId = bundle
//					.getString(JPushInterface.EXTRA_REGISTRATION_ID);

		} else if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent
				.getAction())) {
			Log.i("log","接收到消息 ---\n" + extras);
			acceptMsg(context, extras);

		} else if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(intent
				.getAction())) {
			// int notifactionId =
			// bundle.getInt(JPushInterface.EXTRA_NOTIFICATION_ID);
			Log.i("log","接收到通知 ---\n" + extras);
			acceptNotify(context, extras);

		} else if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent
				.getAction())) {

		} else if (JPushInterface.ACTION_RICHPUSH_CALLBACK.equals(intent
				.getAction())) {
			// 在这里根据 JPushInterface.EXTRA_EXTRA 的内容处理代码，比如打开新的Activity，
			// 打开一个网页等..

		} else if (JPushInterface.ACTION_CONNECTION_CHANGE.equals(intent
				.getAction())) {
		} else {

		}
	}

	// 消息
	private void acceptMsg(Context context, String nty) {
		acceptJpush(context, nty);
	}

	// 通知
	private void acceptNotify(Context context, String nty) {
		// acceptJpush(context, nty);
	}

	private void acceptJpush(Context context, String nty) {
			// 启动服务创建通知
			Intent intent2 = new Intent(context, JPushReceiverService.class);
			intent2.putExtra("extra", nty);
			context.startService(intent2);

	}
}
