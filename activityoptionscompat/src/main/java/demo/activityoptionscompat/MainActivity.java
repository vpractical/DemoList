package demo.activityoptionscompat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

	@InjectView(R.id.tv1)
	TextView tv1;
	@InjectView(R.id.tv2)
	TextView tv2;
	@InjectView(R.id.tv3)
	TextView tv3;
	@InjectView(R.id.tv4)
	TextView tv4;
	@InjectView(R.id.tv5)
	TextView tv5;

	private ActivityOptionsCompat activityOptionsCompat;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.inject(this);


	}

	@OnClick({R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5})
	public void onClick(View view) {


		switch (view.getId()) {
			case R.id.tv1:
//				activityOptionsCompat = ActivityOptionsCompat.makeCustomAnimation()
				
				break;
			case R.id.tv2:

				activityOptionsCompat = ActivityOptionsCompat.makeScaleUpAnimation(view,(int)view.getX(),(int)view.getY(),view.getWidth(),view.getHeight());

				break;
			case R.id.tv3:
				break;
			case R.id.tv4:
				break;
			case R.id.tv5:
				break;
		}

		ActivityCompat.startActivity(this,new Intent(MainActivity.this,MainActivity.class),activityOptionsCompat.toBundle());
	}
}
