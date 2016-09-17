package com.expandablelistview;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * expandableListView的用法同ListView
 * 
 */
public class MyAdapter extends BaseExpandableListAdapter {
	private Context context;
	private List<String> group;
	private List<List<String>> child;
	private int[] img = { R.mipmap.l2, R.mipmap.l3, R.mipmap.l1 };

	public MyAdapter(Context context, List<String> group,
			List<List<String>> child) {
		this.context = context;
		this.group = group;
		this.child = child;
	}

	@Override
	public int getGroupCount() {
		return group.size();
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return child.get(groupPosition).size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return group.get(groupPosition);
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return child.get(childPosition).get(childPosition);
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	/**
	 * 
	 * 获取显示指定组的视图对象
	 * 
	 * @param groupPosition
	 *            组位置
	 * @param isExpanded
	 *            该组是展开状态还是伸缩状态
	 * @param convertView
	 *            重用已有的视图对象
	 * @param parent
	 *            返回的视图对象始终依附于的视图组
	 * @return
	 * @see android.widget.ExpandableListAdapter#getGroupView(int, boolean,
	 *      View, ViewGroup)
	 */
	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.groud_item, null);
			holder = new ViewHolder();
			holder.textView = (TextView) convertView
					.findViewById(R.id.textView);
			holder.mImageView = (ImageView) convertView
					.findViewById(R.id.imageView1);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.textView.setText(group.get(groupPosition));
		holder.textView.setTextSize(25);
		holder.textView.setPadding(36, 10, 0, 10);
		holder.mImageView.setImageResource(img[groupPosition]);
		return convertView;

	}

	/**
	 * 
	 * 获取一个视图对象，显示指定组中的指定子元素数据。
	 * 
	 * @param groupPosition
	 *            组位置
	 * @param childPosition
	 *            子元素位置
	 * @param isLastChild
	 *            子元素是否处于组中的最后一个
	 * @param convertView
	 *            重用已有的视图(View)对象
	 * @param parent
	 *            返回的视图(View)对象始终依附于的视图组
	 * @return
	 * @see android.widget.ExpandableListAdapter#getChildView(int, int, boolean,
	 *      View, ViewGroup)
	 */
	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(
					R.layout.child_item, null);
			holder = new ViewHolder();
			holder.textView = (TextView) convertView
					.findViewById(R.id.textViews);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.textView.setText(child.get(groupPosition).get(childPosition));
		holder.textView.setTextSize(20);
		holder.textView.setPadding(72, 10, 0, 10);
		return convertView;
	}

	/**
	 * 
	 * 是否选中指定位置上的子元素。
	 * 
	 * @param groupPosition
	 * @param childPosition
	 * @return
	 * @see android.widget.ExpandableListAdapter#isChildSelectable(int, int)
	 */
	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return false;
	}

	class ViewHolder {
		ImageView mImageView;
		TextView textView;
	}
}
