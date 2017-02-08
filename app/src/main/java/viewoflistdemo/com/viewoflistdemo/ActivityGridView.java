package viewoflistdemo.com.viewoflistdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/***
 *
 * GridView
 *
 * Created by zhangqie on 2016/6/2
 *
 */
public class ActivityGridView extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        // 加载gridview控件所在的布局文件
        setContentView(R.layout.gridview_layout);
        // 获取GridView 的对象实例
        GridView show_gridview = (GridView) findViewById(R.id.show_gridView);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, get_data(),
                R.layout.item_gridview, new String[] { "img", "name" },
                new int[] { R.id.img, R.id.name });
        show_gridview.setAdapter(simpleAdapter);
    }

    /**
     * 数据源
     *
     */
    private ArrayList<Map<String, Object>> get_data() {
        // 定义一个ArrayList的集合 （集合中又封装一个map类型的集合）
        ArrayList<Map<String, Object>> data_list = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 10; i++) {
            // key,value int string map不能new map
            Map<String, Object> data_map = new HashMap<String, Object>();
            data_map.put("name", "第" + i + "个");
            data_map.put("img", R.mipmap.a1);
            // 将map集合添加（封装）到ArrayList集合中
            data_list.add(data_map);

        }
        // 返回ArrayList集合
        return data_list;

    }

}
