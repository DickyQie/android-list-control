package com.listviewdeletedemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.util.ZQExpandableListView;
import com.util.ZQView;

import java.util.ArrayList;
import java.util.List;


/*****
 * ExpandableListView侧滑删除
 *
 * @author zhangqie
 */

public class ActivityExpandableListViewDelete extends Activity implements
        OnItemClickListener {

    private static final String TAG = "ActivityExpandableListViewDelete";

    private ZQExpandableListView mListView;

    private List<String> ml1, ml2;

    private List<String> group;
    private List<List<String>> child;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandablelistview);
        initData();
        initView();
    }

    private void initView() {
        mListView = (ZQExpandableListView) findViewById(R.id.expandablelist);
        mListView.setAdapter(new SlideAdapter());
        mListView.setOnItemClickListener(this);
    }

    private class SlideAdapter extends BaseExpandableListAdapter {

        private LayoutInflater mInflater;

        SlideAdapter() {
            super();
            mInflater = getLayoutInflater();
        }

        @Override
        public int getGroupCount() {
            // TODO Auto-generated method stub
            return group.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            // TODO Auto-generated method stub
            return child.size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            // TODO Auto-generated method stub
            return group.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            // TODO Auto-generated method stub
            return child.get(groupPosition).get(childPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            // TODO Auto-generated method stub
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            // TODO Auto-generated method stub
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded,
                                 View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            TextView t = null;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.group_item, null);

                t = (TextView) convertView.findViewById(R.id.textView1);
                convertView.setTag(t);
            } else {
                t = (TextView) convertView.getTag();
            }
            t.setText(group.get(groupPosition));
            return convertView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition,
                                 boolean isLastChild, View convertView, ViewGroup parent) {
            ViewHolder holder;
            ZQView slideView = (ZQView) convertView;
            if (slideView == null) {
                View itemView = mInflater.inflate(R.layout.list_item, null);

                slideView = new ZQView(ActivityExpandableListViewDelete.this);
                slideView.setContentView(itemView);
                holder = new ViewHolder(slideView);
                slideView.setTag(holder);
            } else {
                holder = (ViewHolder) slideView.getTag();
            }

            slideView.shrink();
            holder.icon
                    .setImageResource(ActivityListViewDelete.Img[childPosition]);
            holder.title.setText(child.get(groupPosition).get(childPosition));
            holder.deleteHolder.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Toast.makeText(ActivityExpandableListViewDelete.this,
                            "删除操作", Toast.LENGTH_LONG).show();
                }
            });

            return slideView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            // TODO Auto-generated method stub
            return false;
        }

    }

    private static class ViewHolder {
        public ImageView icon;
        public TextView title;
        public ViewGroup deleteHolder;

        ViewHolder(View view) {
            icon = (ImageView) view.findViewById(R.id.icon);
            title = (TextView) view.findViewById(R.id.title);
            deleteHolder = (ViewGroup) view.findViewById(R.id.holder);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        Toast.makeText(this, "onItemClick position=" + position, Toast.LENGTH_LONG).show();

    }

    private void initData() {
        group = new ArrayList<String>();
        child = new ArrayList<List<String>>();
        addInfo("北京", new String[]{"朝阳", "海淀", "东城区"});
        addInfo("河北", new String[]{"邯郸", "石家庄", "邢台"});
        addInfo("广东", new String[]{"广州", "深圳", "珠海"});
    }

    /**
     * 添加数据信息
     *
     * @param g
     * @param c
     */
    private void addInfo(String g, String[] c) {
        group.add(g);
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < c.length; i++) {
            list.add(c[i]);
        }
        child.add(list);
    }

}
