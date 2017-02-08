package com.example.pullablerefresh;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pullablerefresh.XListView.IXListViewListener;

/****
 * 
 * ListView 上拉刷新，下拉加载
 * 
 * @author zq
 * 
 */
public class MainActivity extends Activity implements IXListViewListener {

	private XListView listView;
	private int in = 6;
	private Adapter adapter;
	private Handler mHandler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();

	}

	private void initView() {
		// TODO Auto-generated method stub
		listView = (XListView) findViewById(R.id.list);
		listView.setPullLoadEnable(true);
		adapter = new Adapter(MainActivity.this);
		listView.setAdapter(adapter);
		listView.setXListViewListener(this);
		mHandler = new Handler();

	}

	private void onLoad() {
		listView.stopRefresh();
		listView.stopLoadMore();
		listView.setRefreshTime("刚刚");
	}

	@Override
	public void onRefresh() {
		mHandler.postDelayed(new Runnable() {
			@Override
			public void run() {
				onLoad();
			}
		}, 2000);
	}

	@Override
	public void onLoadMore() {
		mHandler.postDelayed(new Runnable() {
			@Override
			public void run() {
				in += 4;
				onLoad();
			}
		}, 2000);
	}

	private static String[] string = new String[] { "民政局于，请带好相关证件文书 ",
			"财政部发布公告，由于资金调整信息未完善，下周在发放工资，请各位见谅",
			"信息部门于2016-11-11日在某某地方开会，特此通知，请带好相关证件",
			"党政办发放通知，有关贫困地区扶贫政策，希望每个部门做出相应的方案，于2016-11-11开会讨论" };

	public class Adapter extends BaseAdapter {

		private Context context;
		private LayoutInflater inflater;

		public Adapter(Context context) {
			// TODO Auto-generated constructor stub
			this.context = context;
			inflater = LayoutInflater.from(context);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return in;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ViewHolder holder = null;
			final int index = position;
			if (convertView == null) {
				convertView = inflater.inflate(R.layout.item_news_mass, null);
				holder = new ViewHolder(convertView);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			holder.mName.setText(string[(position % 4)]);

			return convertView;
		}

		class ViewHolder {
			private ImageView mImageView;
			private TextView mName;

			public ViewHolder(View view) {
				mName = (TextView) view.findViewById(R.id.item_news_msg);

			}
		}

	}
}
