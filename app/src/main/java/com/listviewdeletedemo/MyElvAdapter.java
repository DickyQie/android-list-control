package com.listviewdeletedemo;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyElvAdapter extends BaseExpandableListAdapter {


	private Context context;
	private ListView listView;
	List<UserInfo> list;

	public MyElvAdapter(Context context, ListView listView, List<UserInfo> list) {
		super();
		this.context = context;
		this.listView = listView;
		this.list=list;
	}

	@Override
	public Object getChild(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return list.get(arg0).getDatas().get(arg1);
	}

	@Override
	public long getChildId(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getChildView(final int groupPosition, final int position,
			boolean arg2, View convertView, ViewGroup parent) {

		final ViewHolder1 viewHolder1;
		if (convertView == null){
			convertView = LayoutInflater.from(context).inflate(R.layout.item2,
					null);
			viewHolder1=new ViewHolder1(convertView);
			convertView.setTag(viewHolder1);

		}else {
			viewHolder1=(ViewHolder1)convertView.getTag();
		}
		new FrontViewToMove(viewHolder1.frontView, listView,200);
		viewHolder1.button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//删除事件，回调接口传参数
				onClickDeleteListenter.onItemClick(v,groupPosition,position);
				new FrontViewToMove(viewHolder1.frontView, listView,200).generateRevealAnimate(viewHolder1.frontView,0);

			}
		});
		viewHolder1.textView.setTextSize(20);
		viewHolder1.textView.setTextColor(Color.DKGRAY);
		viewHolder1.textView.setText("  " + list.get(groupPosition).getDatas().get(position).getName());
		return convertView;
	}

	class ViewHolder1 {
		private TextView textView;
		private View frontView;
		private Button button;
		public ViewHolder1(View view){
			textView= (TextView) view.findViewById(R.id.text);
			button = (Button) view.findViewById(R.id.btn_delete);
			frontView = view.findViewById(R.id.id_front);
		}
	}


	// 删除接口回调方法
	private OnClickDeleteListenter onClickDeleteListenter = null;
	public void setOnClickDeleteListenter(OnClickDeleteListenter listener) {
		this.onClickDeleteListenter = listener;
	}

	@Override
	public int getChildrenCount(int arg0) {
		// TODO Auto-generated method stub
		return (list!=null && list.size()>0)? list.get(arg0).getDatas().size() : 0;
	}

	@Override
	public Object getGroup(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return (list!=null && list.size()>0) ? list.size() : 0;
	}

	@Override
	public long getGroupId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getGroupView(final int groupPosition, boolean isExpanded,
							 View convertView, ViewGroup parent) {
		final ViewHolder viewHolder;
		if (convertView ==null){
			convertView = LayoutInflater.from(context).inflate(R.layout.item1,null);
			viewHolder =new ViewHolder(convertView);
			convertView.setTag(viewHolder);
		}else {
			viewHolder=(ViewHolder)convertView.getTag();
		}
		viewHolder.textView.setText("条目 " + list.get(groupPosition).getId());
		viewHolder.textView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(context,"第一层点击操作",Toast.LENGTH_LONG).show();
			}
		});
		return convertView;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	class ViewHolder {
		TextView textView;
		public ViewHolder(View view){
			textView= (TextView) view.findViewById(R.id.name);
		}
	}

}
