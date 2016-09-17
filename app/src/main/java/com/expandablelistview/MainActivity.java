package com.expandablelistview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.List;

       /*****
        *
        * ExpandableListView
        *
        * @author zhangqie
        *
        */
public class MainActivity extends Activity {
    private ExpandableListView listView;
    private List<String> group;
    private List<List<String>> child;
    private MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ExpandableListView) findViewById(R.id.expandableListView);
        /**
         * 初始化数据
         */
        initData();
        adapter = new MyAdapter(this, group, child);
        listView.setAdapter(adapter);

    }

    private void initData() {
        group = new ArrayList<String>();
        child = new ArrayList<List<String>>();
        addInfo("笑傲江湖", new String[] { "东方不败", "风清扬", "令狐冲", "岳不群" });
        addInfo("天龙八部", new String[] { "乔峰", "虚竹", "段誉" });
        addInfo("九阴真经", new String[] { "中神通", "东邪", "西毒", "南帝", "北丐" });
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
