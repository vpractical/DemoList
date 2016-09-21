package demo.stickyservice;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	private FloatingActionButton fab;
	private Activity activity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		activity = this;

		fab = (FloatingActionButton) findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Snackbar snackbar = Snackbar.make(fab,"Service",Snackbar.LENGTH_SHORT);
				snackbar.setAction("启动", new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						Toast.makeText(activity,"Service已销毁",Toast.LENGTH_SHORT).show();
						MApplication.stopService(activity);
					}
				});
				snackbar.show();
			}
		});
	}


}
