# ExpandableListView的使用多级列表

   <p>多级列表ExpandableListView&nbsp;</p> 
<p>扩展列表能够显示一个指示在每项显示项的当前状态（状态通常是一个扩展的组，组的孩子，或倒塌，最后一个孩子）。使用或<code><a href="https://developer.android.com/reference/android/widget/ExpandableListView.html#setGroupIndicator(android.graphics.drawable.Drawable)" target="_blank" rel="nofollow">setgroupindicator（drawable）</a></code>（或相应的XML属性）来设置这些指标,一个默认的风格提供多级列表指标，将示给意见多级列表。布局android.r.layout.simple_expandable_list_item_1和android.r.layout.simple_expandable_list_item_2（应用<code><a href="https://developer.android.com/reference/android/widget/SimpleCursorTreeAdapter.html" target="_blank" rel="nofollow">simplecursortreeadapter</a></code>）包含位置信息的首选指标。</p> 
<p>效果图：</p> 
<p>&nbsp;&nbsp;&nbsp;&nbsp;<img alt="" height="443" src="https://static.oschina.net/uploads/space/2016/1205/112447_6XK2_2945455.png" width="380"></p> 
<pre><code class="language-html">activity_main.xml
&lt;LinearLayoutxmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#ffffff"
    android:orientation="vertical"&gt;
    &lt;ExpandableListView
        android:id="@+id/expandableListView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:divider="#E4E4E4"
        android:dividerHeight="5dp"&gt;
    &lt;/ExpandableListView&gt;
&lt;/LinearLayout&gt;
child_item.xml
&lt;?xmlversion="1.0"encoding="utf-8"?&gt;
&lt;LinearLayoutxmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"&gt;
    &lt;TextView
        android:id="@+id/textViews"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/&gt;
    &lt;View
        android:layout_width="match_parent"
        android:layout_height="0.5dp"
        android:background="#ff0000"/&gt;
&lt;/LinearLayout&gt;
groud_item.xml
&lt;LinearLayoutxmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
   android:gravity="center_vertical"
    android:orientation="horizontal"&gt;
    &lt;ImageView
        android:id="@+id/imageView1"
        android:layout_width="65dp"
        android:layout_height="55dp"
        android:layout_marginLeft="10dp"
        android:scaleType="fitXY"
        android:src="@drawable/l1"/&gt;
    &lt;TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginLeft="10dp"
        android:text="斯蒂芬"/&gt;
&lt;/LinearLayout&gt;</code></pre> 
<pre><code class="language-java">public class MainActivity extends Activity {
	private ExpandableListView listView;
	private List&lt;String&gt; group;
	private List&lt;List&lt;String&gt;&gt; child;
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
		adapter = new MyAdapter(this,group,child);
		listView.setAdapter(adapter);
	
	}
	
	
	

	private void initData() {
		group = new ArrayList&lt;String&gt;();
		child = new ArrayList&lt;List&lt;String&gt;&gt;();
		addInfo("笑傲江湖",new String[]{"东方不败","风清扬","令狐冲","岳不群"});
		addInfo("天龙八部", new String[]{"乔峰","虚竹","段誉"});
		addInfo("九阴真经", new String[]{"中神通","东邪","西毒","南帝","北丐"});
	}
	
	/**
	 * 添加数据信息
	 * @param g
	 * @param c
	 */
	private void addInfo(String g,String[] c) {
		group.add(g);
		List&lt;String&gt; list = new ArrayList&lt;String&gt;();
		for (int i = 0; i &lt; c.length; i++) {
			list.add(c[i]);
		}
		child.add(list);
	}

}</code></pre> 
<pre><code class="language-java">/**
 * expandableListView的用法同ListView
 *
 */
public class MyAdapter extends BaseExpandableListAdapter {
	private Context context;
	private List&lt;String&gt; group;
	private List&lt;List&lt;String&gt;&gt; child;
	private int[] img={R.drawable.l2,R.drawable.l3,R.drawable.l1};
	public MyAdapter(Context context, List&lt;String&gt; group,
			List&lt;List&lt;String&gt;&gt; child) {
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
    * @param groupPosition 组位置
    * @param isExpanded 该组是展开状态还是伸缩状态
    * @param convertView 重用已有的视图对象
    * @param parent 返回的视图对象始终依附于的视图组
    * @return
    * @see android.widget.ExpandableListAdapter#getGroupView(int, boolean, android.view.View,
    *      android.view.ViewGroup)
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
			holder.mImageView=(ImageView) convertView.findViewById(R.id.imageView1);
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
    * @param groupPosition 组位置
    * @param childPosition 子元素位置
    * @param isLastChild 子元素是否处于组中的最后一个
    * @param convertView 重用已有的视图(View)对象
    * @param parent 返回的视图(View)对象始终依附于的视图组
    * @return
    * @see android.widget.ExpandableListAdapter#getChildView(int, int, boolean, android.view.View,
    *      android.view.ViewGroup)
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
}</code></pre> 
<span id="OSC_h3_1"></span>
<h3><span style="color:#B22222">源码下载：</span></h3> 
<p>&nbsp;</p> 
<p>Eclipse下载：<a href="http://download.csdn.net/detail/dickyqie/9630549" target="_blank" rel="nofollow">http://download.csdn.net/detail/dickyqie/9630549</a></p> 
