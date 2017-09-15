package com.zhangqie.listvieweditvalue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        listView=(ListView)findViewById(R.id.listview);
        listView.setAdapter(new ListAdapter(this));
    }
    public void saveEditData(int position, String str) {
        Toast.makeText(this,str+"----"+position,Toast.LENGTH_LONG).show();
    }
}
