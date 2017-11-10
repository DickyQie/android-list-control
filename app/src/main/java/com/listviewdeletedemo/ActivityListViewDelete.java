package com.listviewdeletedemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.util.ZQListView;
import com.util.ZQView;


/*****
 * 
 * ListView侧滑删除
 * 
 * @author zhangqie
 * 
 */
public class ActivityListViewDelete extends Activity implements
		OnItemClickListener, OnClickListener {


	private ZQListView mListView;

	private List<MessageItem> mMessageItems = new ArrayList<MessageItem>();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listview);
		initView();
	}


	private void initView() {
		mListView = (ZQListView) findViewById(R.id.list);
		for (int i = 0; i < 12; i++) {
			MessageItem item = new MessageItem();
			item.title = "标题" + (i + 1);
			item.msg = "消息" + (i + 1);
			item.time = "2016-6-1" + i;
			mMessageItems.add(item);
		}
		mListView.setAdapter(new SlideAdapter());
		mListView.setOnItemClickListener(this);
	}

	private class SlideAdapter extends BaseAdapter {

		private LayoutInflater mInflater;

		SlideAdapter() {
			super();
			mInflater = getLayoutInflater();
		}

		@Override
		public int getCount() {
			return mMessageItems.size();
		}

		@Override
		public Object getItem(int position) {
			return mMessageItems.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder;

			ZQView slideView = (ZQView) convertView;
			if (slideView == null) {
				View itemView = mInflater.inflate(R.layout.list_item, null);

				slideView = new ZQView(ActivityListViewDelete.this);
				slideView.setContentView(itemView);
				holder = new ViewHolder(slideView);
				slideView.setTag(holder);
			} else {
				holder = (ViewHolder) slideView.getTag();
			}
			MessageItem item = mMessageItems.get(position);
			slideView.shrink();
			holder.title.setText(item.title);
			holder.time.setText(item.time);
			holder.deleteHolder.setOnClickListener(ActivityListViewDelete.this);

			return slideView;
		}

	}

	public class MessageItem {
		public String title;
		public String msg;
		public String time;
	}

	private static class ViewHolder {
		public ImageView icon;
		public TextView title;
		public TextView time;
		public ViewGroup deleteHolder;

		ViewHolder(View view) {
			icon = (ImageView) view.findViewById(R.id.icon);
			title = (TextView) view.findViewById(R.id.title);
			time = (TextView) view.findViewById(R.id.time);
			deleteHolder = (ViewGroup) view.findViewById(R.id.holder);
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Toast.makeText(this, "onItemClick position=" + position, Toast.LENGTH_LONG).show();

	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.holder) {
			Toast.makeText(this, "删除操作", Toast.LENGTH_LONG).show();

		}
	}

}
