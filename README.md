# Android自定义控件之ListView的下拉刷新与上拉加载
 <p>&nbsp; &nbsp; &nbsp; &nbsp;开发项目过程中基本都会用到listView的下拉刷新和上滑加载更多，为了方便重写的ListView来实现下拉刷新，同时添加了上拉自动加载更多的功能。</p> 
<p>Android下拉刷新可以分为两种情况：</p> 
<blockquote>
  1.获取更多的数据，按服务器数据库时间顺序存储入情况，此刻我们是获取是显示在我们应用中的数据更早前的数据，这也是最常见的情况。比如（微博获取更多信息，就是获取更多更早前的信息，然后动态的添加到已有的数据的下方）； 
 <p>2.获取更多的最新的数据，其实还是一种获取更多的操作方式。但是这里主要考虑到用户的操作习惯了。一般，用户的操作习惯分这么两种。</p> 
</blockquote> 
<p>示例代码</p> 
<pre><code class="language-java">
public class MainActivity extends Activity implements IXListViewListener {

	private XListView listView;
	private int in = 6;
	private Adapter adapter;
	private Handler mHandler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();

	}

	private void initView() {
		// TODO Auto-generated method stub
		listView = (XListView) findViewById(R.id.list);
		listView.setPullLoadEnable(true);
		adapter = new Adapter(MainActivity.this);
		listView.setAdapter(adapter);
		listView.setXListViewListener(this);
		mHandler = new Handler();

	}

	private void onLoad() {
		listView.stopRefresh();
		listView.stopLoadMore();
		listView.setRefreshTime("刚刚");
	}

	@Override
	public void onRefresh() {
		mHandler.postDelayed(new Runnable() {
			@Override
			public void run() {
				onLoad();
			}
		}, 2000);
	}

	@Override
	public void onLoadMore() {
		mHandler.postDelayed(new Runnable() {
			@Override
			public void run() {
				in += 4;
				onLoad();
			}
		}, 2000);
	}

	private static String[] string = new String[] { "民政局于，请带好相关证件文书 ",
			"财政部发布公告，由于资金调整信息未完善，下周在发放工资，请各位见谅",
			"信息部门于2016-11-11日在某某地方开会，特此通知，请带好相关证件",
			"党政办发放通知，有关贫困地区扶贫政策，希望每个部门做出相应的方案，于2016-11-11开会讨论" };

	public class Adapter extends BaseAdapter {

		private Context context;
		private LayoutInflater inflater;

		public Adapter(Context context) {
			// TODO Auto-generated constructor stub
			this.context = context;
			inflater = LayoutInflater.from(context);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return in;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ViewHolder holder = null;
			final int index = position;
			if (convertView == null) {
				convertView = inflater.inflate(R.layout.item_news_mass, null);
				holder = new ViewHolder(convertView);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			holder.mName.setText(string[(position % 4)]);

			return convertView;
		}

		class ViewHolder {
			private ImageView mImageView;
			private TextView mName;

			public ViewHolder(View view) {
				mName = (TextView) view.findViewById(R.id.item_news_msg);

			}
		}

	}
}
</code></pre> 
<pre><code class="language-xml"> &lt;com.example.pullablerefresh.XListView
        android:id="@+id/list"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="5dp"
        android:background="#FFFFFF"
        android:cacheColorHint="#00000000"
        android:divider="#FFFFFF"
        android:dividerHeight="5dp"
        android:drawSelectorOnTop="false"
        android:listSelector="#00000000"
        android:scrollbars="none"
        android:scrollingCache="false" /&gt;
</code></pre> 
