package com.listviewdeletedemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/*****
 * ExpandableListView侧滑删除
 *
 * @author zhangqie
 */

public class ActivityExpandableListViewDelete extends AppCompatActivity{

    private List<UserInfo> list =new ArrayList<>();
    private Context context;
    private ExpandableListView myElv;
    private MyElvAdapter myAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandablelistview);
        context = this;
        initData();
        initView();
    }

    public void initView() {
        myElv = (ExpandableListView) findViewById(R.id.expandablelist);
        myAdapter = new MyElvAdapter(context, myElv,list);
        myElv.setAdapter(myAdapter);
        myElv.setGroupIndicator(null);
        int  intgroupCount = myElv.getCount();
        //全部展开
        for (int i=0; i<intgroupCount; i++)
        {
            myElv.expandGroup(i);
        }
        myAdapter.setOnClickDeleteListenter(new OnClickDeleteListenter() {
            @Override
            public void onItemClick(View view, int onePosition, int position) {
                 Toast.makeText(ActivityExpandableListViewDelete.this,"删除操作",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initData(){
        UserInfo user1=new UserInfo();
        user1.setId(0);
        user1.setCheckBox(false);
        user1.setDatas(show1());
        list.add(user1);
        UserInfo user2=new UserInfo();
        user2.setId(1);
        user2.setCheckBox(false);
        user2.setDatas(show2());
        list.add(user2);
    }

    private  List<UserInfo.Data> show1(){
        List<UserInfo.Data> list =new ArrayList<>();
        UserInfo.Data data=new UserInfo().new Data();
        data.setName("歆语博客");
        data.setAge("18");
        data.setCheckBox(false);
        list.add(data);
        return list;
    }

    private  List<UserInfo.Data> show2(){
        List<UserInfo.Data> list =new ArrayList<>();
        UserInfo.Data data=new UserInfo().new Data();
        data.setName("切切歆语");
        data.setAge("19");
        data.setCheckBox(false);
        list.add(data);
        UserInfo.Data data1=new UserInfo().new Data();
        data1.setName("胡歌");
        data1.setAge("36");
        data1.setCheckBox(false);
        list.add(data1);
        return list;
    }



}
