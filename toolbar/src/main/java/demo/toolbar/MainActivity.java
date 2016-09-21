package demo.toolbar;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		LayoutInflaterCompat.setFactory(LayoutInflater.from(this), new LayoutInflaterFactory() {
			@Override
			public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {

				AppCompatDelegate delegate = getDelegate();
				View view = delegate.createView(parent,name,context,attrs);

				if(view != null && name.equals("Button")){
					TextView bt = new TextView(MainActivity.this);
					bt.setText("delegate");
					return bt;
				}

				return view;
			}
		});
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		SubMenu subMenu = menu.addSubMenu("字体大小");
		subMenu.add(0,1,1,"yi");
		subMenu.add(0,2,2,"er");

		return super.onCreateOptionsMenu(menu);
	}
}
