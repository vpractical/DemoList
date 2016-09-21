package demo.collapsingtoolbarlayout;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
	AppBarLayout abl;
	Toolbar toolbar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		StatusBarUtil.setStatusBarTrans(this);
		setContentView(R.layout.activity_main);


		abl = (AppBarLayout) findViewById(R.id.appbarlayout);
		toolbar = (Toolbar) findViewById(R.id.toolbar);


			logg("getTotalScrollRange = " + abl.getTotalScrollRange());


			abl.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
				@Override
				public void onGlobalLayout() {
					View view = toolbar.getChildAt(0);

					ViewGroup.LayoutParams params = toolbar.getLayoutParams();
					params.height = view.getHeight();
					toolbar.setLayoutParams(params);


					int height = abl.getHeight();
					int totalScrollRange = abl.getTotalScrollRange();

					logg("height = " + height);
					logg("totalScrollRange = " + totalScrollRange);
					logg("toolbarHeight = " + toolbar.getHeight());


					abl.getViewTreeObserver().removeGlobalOnLayoutListener(this);
				}
			});

			abl.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
				@Override
				public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
					logg("toolbarHeight = " + toolbar.getHeight());
					logg("verticalOffset = " + verticalOffset);
					logg("totalScrollRange = " + abl.getTotalScrollRange());
				}
			});






























		RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
		recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

		recyclerView.setAdapter(new RecyclerView.Adapter() {
			@Override
			public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
				View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item, parent, false);
				return new ItemHolder(view);
			}

			@Override
			public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
				if (holder instanceof ItemHolder) {
					ItemHolder itemHolder = (ItemHolder) holder;
					itemHolder.bind(position);
				}
			}

			@Override
			public int getItemCount() {
				return 30;
			}

			class ItemHolder extends RecyclerView.ViewHolder {
				TextView tv;

				public ItemHolder(View itemView) {
					super(itemView);
					tv = (TextView) itemView;
				}

				private void bind(int p) {
					tv.setText(p + "---");
				}
			}
		});
	}


	public void logg(String s){
		Log.i("^^^^^^^^",s);
	}
}
