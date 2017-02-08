package viewoflistdemo.com.viewoflistdemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/***
 *
 * Grelly
 *
 * Created by zhangqie on 2016/6/2
 *
 */
public class ActivityGrelly extends Activity{
    private int index;
    private Gallery g;
    private Handler handler;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery_layout);
        initView();
    }

    private void initView() {
        // TODO Auto-generated method stub
        // 获得Gallery对象
        g = (Gallery) findViewById(R.id.gallery);

        // 添加ImageAdapter给Gallery对象
        g.setAdapter(new ImageAdapter(ActivityGrelly.this));

        // 设置Gallery的背景
        g.setBackgroundResource(R.mipmap.bg);

        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                Message message = new Message();
                message.what = 2;
                index = g.getSelectedItemPosition();
                index++;
                handler.sendMessage(message);
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 3000, 3000);
        handler = new Handler() {

            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 2:
                        g.setSelection(index);
                        break;

                    default:
                        break;
                }
            }

        };

        // 设置Gallery的事件监听
        g.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ActivityGrelly.this,
                        "你选择了" + (position + 1) + " 号图片", Toast.LENGTH_SHORT)
                        .show();
            }
        });

    }




}
