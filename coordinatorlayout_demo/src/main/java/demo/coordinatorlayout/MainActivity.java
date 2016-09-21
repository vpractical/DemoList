package demo.coordinatorlayout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

	@InjectView(R.id.toolbar)
	Toolbar toolbar;
	@InjectView(R.id.tabs)
	TabLayout tabs;
	@InjectView(R.id.listview)
	RecyclerView listview;
	@InjectView(R.id.fab)
	FloatingActionButton fab;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.inject(this);

		tabs.addTab(tabs.newTab().setText("啊啊"));
		tabs.addTab(tabs.newTab().setText("啊啊"));
		tabs.addTab(tabs.newTab().setText("啊啊"));
		tabs.addTab(tabs.newTab().setText("啊啊"));

		fab.setBackgroundColor(Color.parseColor("#20ff0000"));
		fab.setImageResource(R.mipmap.ic_launcher);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Snackbar.make(v, "滚", Snackbar.LENGTH_SHORT)
						.setAction("Action", null).show();
			}
		});


		final List<String> data = new ArrayList<>();
		for (int i = 0; i < 40; i++) {
			data.add(i + "------");
		}

		listview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
		listview.setAdapter(new RecyclerView.Adapter() {
			@Override
			public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
				View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item,parent,false);
				return new ItemHolder(view);
			}

			@Override
			public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
				if(holder instanceof ItemHolder){
					ItemHolder h = (ItemHolder) holder;
					h.bind(position);
				}
			}

			@Override
			public int getItemCount() {
				return data.size();
			}
			class ItemHolder extends RecyclerView.ViewHolder{
				TextView tv;
				public ItemHolder(View itemView) {
					super(itemView);
					tv = (TextView) itemView.findViewById(R.id.item_tv);

				}

				public void bind(int position){
					tv.setText(data.get(position));
				}
			}
		});
	}
}
