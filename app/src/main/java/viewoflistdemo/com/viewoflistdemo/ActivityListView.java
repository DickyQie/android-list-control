package viewoflistdemo.com.viewoflistdemo;

/**
 * Created by Administrator on 2016/9/2.
 */

import android.app.Activity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/***
 *
 * ListView
 *
 * Created by zhangqie on 2016/6/2
 *
 */
public class ActivityListView extends Activity {

    private ListView mListView;

    protected void onCreate(android.os.Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        // 加载listview控件所在的布局文件
        setContentView(R.layout.listview_layout);
        // 获取listview控件的对象
        mListView = (ListView) findViewById(R.id.listview);
        /**
         * 定义SimpleAdapter（ 并加载对应item布局文件，获得对应的keY,获得对应item布局文件中的组件的id
         *
         * 第二个参数data：数据源 第三个参数resource ：listView每个item对应的布局文件 第四个参数 from：
         * 第五个参数to ： new String[]{对应的key}v
         */
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, get_data(),
                R.layout.item_listview, new String[] { "name", "img" },
                new int[] { R.id.txtname, R.id.img });
        // 通过setAdapter将适配器绑定到listView控件
        mListView.setAdapter(simpleAdapter);

    };

    /**
     *
     * 数据源
     *
     */
    String[] name = { "张三", "李四", "小星星", "静静", "明明", "小翠" };
    private ArrayList<Map<String, Object>> get_data() {

        // 定义一个ArrayList的集合 （集合中又封装一个map类型的集合）
        ArrayList<Map<String, Object>> data_list = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < name.length; i++) {
            // key,value int string map不能new map
            Map<String, Object> data_map = new HashMap<String, Object>();
            data_map.put("name", name[i]);
            data_map.put("img", R.mipmap.a1);
            // 将map集合添加（封装）到ArrayList集合中
            data_list.add(data_map);
        }
        // 返回ArrayList集合
        return data_list;

    }



}
