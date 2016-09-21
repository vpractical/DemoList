package demo.collapsingtoolbarlayout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 *
 *
 */
public class StatusBarUtil {
	/**
	 * 设置状态栏颜色
	 *
	 * @param activity
	 * @param color
	 */
	public static void setStatusBarColor(Activity activity, int color) {
		if (VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			// 1
			setTranslucentStatus(activity, true);
			// 创建状态栏的管理实例
			SystemBarTintManager tintManager = new SystemBarTintManager(
					activity);
			// 激活状态栏设置
			tintManager.setStatusBarTintEnabled(true);
			// 激活导航栏设置
			tintManager.setNavigationBarTintEnabled(true);
			tintManager.setStatusBarTintColor(color);// 通知栏所需颜色
		}
	}

	/**
	 * 设置状态栏图片
	 *
	 * @param activity
	 * @param img
	 */
	public static void setStatusBarBackground(Activity activity, int img) {
		if (VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			// 1
			setTranslucentStatus(activity, true);
			// 创建状态栏的管理实例
			SystemBarTintManager tintManager = new SystemBarTintManager(
					activity);
			// 激活状态栏设置
			tintManager.setStatusBarTintEnabled(true);
			// 激活导航栏设置
			tintManager.setNavigationBarTintEnabled(true);
			// 设置一个样式背景给导航栏
			// tintManager.setNavigationBarTintResource(img);
			// 设置一个状态栏资源
			tintManager.setStatusBarTintDrawable(activity.getResources()
					.getDrawable(img));
		}
	}

	/**
	 * 设置状态栏透明
	 *
	 * @param activity
	 */
	@SuppressLint("NewApi")
	public static void setStatusBarTrans(Activity activity) {

		Window window = activity.getWindow();

		if (VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
					| WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
			window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
					| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
					| View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
			window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			window.setStatusBarColor(Color.TRANSPARENT);
			window.setNavigationBarColor(Color.TRANSPARENT);
		} else if (VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
					WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
					WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
		}


//		if(setStatusBarStyle(window)){
//			if (VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//				window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
//						| WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//				window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//						| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//						| View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//				window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//				window.setStatusBarColor(Color.TRANSPARENT);
//				window.setNavigationBarColor(Color.TRANSPARENT);
//			} else if (VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//				window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
//						WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//				window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
//						WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//			}
//		}else{
//			// 状态栏设置为颜色，不需要透明了
//			setStatusBarColor(activity,
//					activity.getResources().getColor(R.color.systemBarColor));
//			}
	}

	/**
	 * 去掉状态栏
	 *
	 * @param activity
	 */
	public static void setStatusBarMoved(Activity activity) {
		activity.getWindow().setFlags(
				WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
	}

	/**
	 * 设置状态栏深色模式
	 */
	private static boolean setStatusBarStyle(Window window) {
//		if(MIUIUtils.isMIUI()){
//			return MIUIUtils.mMIUISetStatusBarLightMode(window,true);
//		}else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//			window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//			return true;
//		} else if(FlymeUtils.isFlyme()){
//			return FlymeUtils.mFlymeSetStatusBarLightMode(window,true);
//		}else{
//			return false;
//		}

		return false;
	}

	private static void setTranslucentStatus(Activity activity, boolean on) {
		Window win = activity.getWindow();
		WindowManager.LayoutParams winParams = win.getAttributes();
		final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
		if (on) {
			winParams.flags |= bits;
		} else {
			winParams.flags &= ~bits;
		}
		win.setAttributes(winParams);
	}

}
