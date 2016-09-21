package demo.tablayout;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

	@InjectView(R.id.tablayout)
	TabLayout tablayout;
	@InjectView(R.id.viewpager)
	ViewPager viewpager;

	private List<Fragment> fmList = new ArrayList<>();

	private String[] titles = {"HandlerThread","IntentService","乎乎"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.inject(this);

		fmList.add(new HandlerThreadFm());
		fmList.add(new IntentServiceFm());
		fmList.add(new MF());

//
// CheckService.getRunningServices(this);

		viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
			@Override
			public Fragment getItem(int position) {
				return fmList.get(position);
			}

			@Override
			public int getCount() {
				return fmList.size();
			}

			@Override
			public CharSequence getPageTitle(int position) {
				return titles[position % titles.length];
			}
		});


		tablayout.setupWithViewPager(viewpager);

		log("onCreate");
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
//		if (hasFocus && Build.VERSION.SDK_INT >= 19) {
//			View decorView = getWindow().getDecorView();
//			decorView.setSystemUiVisibility(
//					View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//							| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//							| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//							| View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//							| View.SYSTEM_UI_FLAG_FULLSCREEN
//							| View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
//		}


		log("onWindowFocusChanged - " + hasFocus);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		log("onConfigurationChanged - " + newConfig.orientation);
	}

	private void log(String s){
		Log.i("横屏",s);
	}


	@Override
	protected void onStart() {
		super.onStart();
		log("onStart");
	}

	@Override
	protected void onResume() {
		super.onResume();
		log("onResume");
	}

	@Override
	protected void onPause() {
		super.onPause();
		log("onPause");
	}

	@Override
	protected void onStop() {
		super.onStop();
		log("onStop");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		log("onDestroy");
	}

}
