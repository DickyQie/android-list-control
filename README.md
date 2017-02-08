# Android 列表使用(ListView GridView Gallery图片计时滚动)
  <p>ListView</p> 
<p>&nbsp;作用：&nbsp;1.将数据填充到布局。&nbsp;2.处理用户的选择点击等操作。</p> 
<p>&nbsp; &nbsp; 根据列表的适配器类型，列表分为三种，ArrayAdapter，SimpleAdapter和SimpleCursorAdapter</p> 
<p>&nbsp;实例：</p> 
<pre><code class="language-html">listview.xml
&lt;LinearLayoutxmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:descendantFocusability="afterDescendants"&gt;
    &lt;!--  android:cacheColorHint="#00000000"  背景透明 --&gt;
     &lt;!--    android:dividerHeight="1dp" item界限宽度 --&gt;
      &lt;!--  android:cacheColorHint="#00000000"  item界线颜色 --&gt;
    &lt;ListView
        android:id="@+id/listview"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:cacheColorHint="#00000000"
        android:dividerHeight="1dp"
        android:divider="#FF0000"
     /&gt;
&lt;/LinearLayout&gt;

item.xml

&lt;LinearLayoutxmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center_vertical"
    android:orientation="horizontal"&gt;
    &lt;!-- 列表item布局 --&gt;
    &lt;ImageView
        android:id="@+id/img"
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:layout_marginLeft="15dp"
        android:src="@drawable/a2"/&gt;
    &lt;TextView
        android:id="@+id/txtname"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginLeft="25dp"/&gt;
&lt;/LinearLayout&gt;</code></pre> 
<pre><code class="language-java">public class ActivityListView extends Activity {
   private ListView mListView;
   protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载listview控件所在的布局文件
        setContentView(R.layout.listview_layout);
        //获取listview控件的对象
        mListView = (ListView)findViewById(R.id.listview);
        /**
         *定义SimpleAdapter（并加载对应item布局文件，获得对应的keY,获得对应item布局文件中的组件的id
         *第二个参数data：数据源第三个参数resource：listView每个item对应的布局文件第四个参数 from：
         *第五个参数to： new String[]{对应的key}v
         */
        SimpleAdapter simpleAdapter =new SimpleAdapter(this, get_data(),
              R.layout.item_listview,new String[]{"name","img" },
              newint[] { R.id.txtname, R.id.img });
             //通过setAdapter将适配器绑定到listView控件
              mListView.setAdapter(simpleAdapter);
      };
        /**
          *数据源
          */
        String[] name = { "张三","李四","小星星","静静","明明","小翠" };
         private ArrayList&lt;Map&lt;String, Object&gt;&gt; get_data() {
         //定义一个ArrayList的集合（集合中又封装一个map类型的集合）
               ArrayList&lt;Map&lt;String, Object&gt;&gt; data_list =new ArrayList&lt;Map&lt;String,Object&gt;&gt;();
               for (int i = 0; i&lt;name.length; i++) {
                 // key,valueintstring map不能new map
                 Map&lt;String, Object&gt; data_map =new HashMap&lt;String, Object&gt;();
                 data_map.put("name",name[i]);
                 data_map.put("img",R.drawable.a1);
                  //将map集合添加（封装）到ArrayList集合中
                 data_list.add(data_map);
         }
             //返回ArrayList集合
             return data_list;
        }
}</code></pre> 
<p>Gallery</p> 
<p>作用：实现图片计时滚动显示</p> 
<pre><code class="language-html">gallery.xml
&lt;LinearLayoutxmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center_vertical"
    android:orientation="vertical"&gt;
    &lt;Gallery
        android:id="@+id/gallery"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:spacing="0dip"/&gt;
&lt;/LinearLayout&gt;</code></pre> 
<pre><code>public class ActivityGrelly extends Activity {
   /** Called when the activity isfirst created. */
   private int index;
   private Gallery g;
   private Handler handler;
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.gallery_layout);
      initView();
   }
 
   private void initView() {
      // TODOAuto-generated method stub
      // 获得Gallery对象
      g = (Gallery)findViewById(R.id.gallery);
 
      // 添加ImageAdapter给Gallery对象
      g.setAdapter(newImageAdapter(this));
 
      // 设置Gallery的背景
      g.setBackgroundResource(R.drawable.bg);
 
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
      handler = new Handler(){
 
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
      g.setOnItemClickListener(new OnItemClickListener() {
         public void onItemClick(AdapterView&lt;?&gt; parent, View v,
                int position,long id) {
            Toast.makeText(ActivityGrelly.this,
                   "你选择了" + (position + 1) +"号图片", Toast.LENGTH_SHORT)
                   .show();
         }
      });
   }
}</code></pre> 
<p>效果：</p> 
<p>&nbsp;&nbsp;<img alt="" src="https://static.oschina.net/uploads/img/201702/08164857_nPGW.jpg"><img alt="" src="https://static.oschina.net/uploads/img/201702/08164857_O2Fa.jpg"><img alt="" src="https://static.oschina.net/uploads/img/201702/08164857_j302.jpg"></p> 
<p>&nbsp;</p> 
