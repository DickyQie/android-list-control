package viewoflistdemo.com.viewoflistdemo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/****
 *
 * ListView+GridView+Gallery
 *
 * Created by zhangqie on 2016/6/2
 *
 */
public class MainActivity extends Activity implements View.OnClickListener{
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView()
    {
        findViewById(R.id.btnList).setOnClickListener(this);
        findViewById(R.id.btnGrid).setOnClickListener(this);
        findViewById(R.id.btnGrlley).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btnList:
                intent=new Intent(MainActivity.this,ActivityListView.class);
                break;
            case R.id.btnGrid:
                intent=new Intent(MainActivity.this,ActivityGridView.class);
                break;
            case R.id.btnGrlley:
                intent=new Intent(MainActivity.this,ActivityGrelly.class);
                break;

            default:
                break;
        }
        startActivity(intent);
    }

}
