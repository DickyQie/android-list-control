#ListView和ExpandableListView的侧滑删除操作
<p>本案例主要实现了ListView和<strong>ExpandableListView</strong>的侧滑删除操作功能</p> 
<p>效果图：</p> 
<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<img alt="" height="570" src="https://static.oschina.net/uploads/space/2016/1129/092847_omH7_2945455.gif" width="408"></p> 
<p>代码：</p> 
<pre><code class="language-java">自定义ListView
public class ZQListView extends ListView {
 
   private static final String TAG ="ZQListView ";
 
   private ZQView mFocusedItemView;
 
   float mX = 0;
   float mY = 0;
   private int mPosition = -1;
   boolean isSlider = false;
 
   public ZQListView(Contextcontext) {
      super(context);
   }
 
   public ZQListView(Contextcontext, AttributeSet attrs) {
      super(context,attrs);
   }
 
   public ZQListView(Contextcontext, AttributeSet attrs,int defStyle) {
      super(context,attrs, defStyle);
   }
 
   @Override
   public boolean onTouchEvent(MotionEvent event) {
      float x =event.getX();
      float y =event.getY();
      switch(event.getAction()) {
      case MotionEvent.ACTION_DOWN:
         isSlider = false;
         mX = x;
         mY = y;
         int position= pointToPosition((int) x, (int) y);
         if (mPosition !=position) {
            mPosition =position;
            if (mFocusedItemView !=null) {
                mFocusedItemView.reset();
            }
         }
         break;
      case MotionEvent.ACTION_MOVE:
         if (mPosition != -1) {
            if (Math.abs(mY - y) &lt;30 &amp;&amp; Math.abs(mX - x) &gt; 20) {
                int first =this.getFirstVisiblePosition();
                int index =mPosition - first;
                mFocusedItemView =(ZQView) getChildAt(index);
                mFocusedItemView.onTouchEvent(event);
                isSlider = true;
                return true;
            }
         }
         break;
      case MotionEvent.ACTION_UP:
         if (isSlider) {
            isSlider = false;
            if (mFocusedItemView !=null) {
                mFocusedItemView.adjust(mX - x &gt;0);
                return true;
            }
         }
         break;
      }
      return super.onTouchEvent(event);
   }
}</code></pre> 
<pre><code class="language-java">侧滑布局类
public class ZQView extends LinearLayout {
   private static final String TAG ="SlideView";
   private static final int TAN = 2;
   private int mHolderWidth = 120;
   private float mLastX = 0;
   private float mLastY = 0;
   private Context mContext;
   private LinearLayout mViewContent;
   private Scroller mScroller;
 
   public ZQView(Contextcontext, Resources resources) {
      super(context);
      initView();
   }
 
   public ZQView(Contextcontext) {
      super(context);
      initView();
   }
 
   public ZQView(Contextcontext, AttributeSet attrs) {
      super(context,attrs);
      initView();
   }
 
   private void initView() {
      setOrientation(LinearLayout.HORIZONTAL);
      mContext = getContext();
      mScroller = new Scroller(mContext);
      View.inflate(mContext,R.layout.delete_view,this);
      mViewContent = (LinearLayout)findViewById(R.id.view_content);
      mHolderWidth = Math.round(TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,mHolderWidth,getResources()
                   .getDisplayMetrics()));
   }
 
   public void setContentView(View view) {
      mViewContent.addView(view);
   }
 
   public void shrink(){
      int offset =getScrollX();
      if (offset== 0) {
         return;
      }
      scrollTo(0, 0);
   }
 
   public void reset() {
      int offset =getScrollX();
      if (offset== 0) {
         return;
      }
      smoothScrollTo(0, 0);
   }
 
   public void adjust(boolean left) {
      int offset =getScrollX();
      if (offset== 0) {
         return;
      }
      if (offset&lt; 20) {
         this.smoothScrollTo(0,0);
      } else if (offset&lt; mHolderWidth - 20) {
         if (left) {
            this.smoothScrollTo(mHolderWidth, 0);
         } else {
            this.smoothScrollTo(0,0);
         }
      } else {
         this.smoothScrollTo(mHolderWidth, 0);
      }
   }
 
   @Override
   public boolean onTouchEvent(MotionEvent event) {
      switch(event.getAction()) {
      case MotionEvent.ACTION_MOVE:
         float x =event.getX();
         float y =event.getY();
         float deltaX =x -mLastX;
         float delatY =y -mLastY;
         mLastX = x;
         mLastY = y;
         if (Math.abs(deltaX)&lt; Math.abs(delatY) *TAN) {
            break;
         }
         if (deltaX!= 0) {
            float newScrollX = getScrollX() - deltaX;
            if(newScrollX &lt; 0) {
                newScrollX = 0;
            } else if(newScrollX &gt; mHolderWidth) {
                newScrollX = mHolderWidth;
            }
            this.scrollTo((int)newScrollX, 0);
         }
         break;
      }
      return super.onTouchEvent(event);
   }
 
   private void smoothScrollTo(int destX,int destY) {
      int scrollX =getScrollX();
      int delta =destX - scrollX;
      mScroller.startScroll(scrollX,0, delta, 0, Math.abs(delta) * 3);
      invalidate();
   }
 
   @Override
   public void computeScroll() {
      if (mScroller.computeScrollOffset()){
         scrollTo(mScroller.getCurrX(),mScroller.getCurrY());
         postInvalidate();
      }
   }</code></pre> 
<pre><code class="language-html">delete.xml
&lt;?xml version="1.0" encoding="utf-8"?&gt;
&lt;merge xmlns:Android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"&gt;
 
    &lt;LinearLayout
        android:id="@+id/view_content"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="horizontal"&gt;
    &lt;/LinearLayout&gt;
 
    &lt;RelativeLayout
        android:id="@+id/holder"
        android:layout_width="120dp"
        android:layout_height="match_parent"
        android:background="@drawable/holder_bg"
        android:clickable="true"&gt;
 
        &lt;TextView
            android:id="@+id/delete"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_centerInParent="true"
            android:drawableLeft="@drawable/del_icon_normal"
            android:gravity="center"
            android:text="删除"
            android:textColor="@color/floralwhite"/&gt;
    &lt;/RelativeLayout&gt;
 
&lt;/merge&gt;


listview.xml
&lt;LinearLayoutxmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"&gt;
 
    &lt;com.example.util.ZQListView
        android:id="@+id/list"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="#fff4f7f9"
        android:cacheColorHint="#00000000"
        android:divider="#6c6c6c"
        android:dividerHeight="1dp"
        android:drawSelectorOnTop="false"
        android:listSelector="#00000000"
        android:scrollbars="none"
        android:scrollingCache="false"/&gt;
 
&lt;/LinearLayout&gt;</code></pre> 
<pre><code class="language-java">Activity和适配器类
public class ActivityListViewDelete extends Activity implements
      OnItemClickListener, OnClickListener {
 
   private ZQListView mListView;
 
   private List&lt;MessageItem&gt; mMessageItems = new ArrayList&lt;ActivityListViewDelete.MessageItem&gt;();
 
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      initView();
   }
 
   public static int[] Img = {R.drawable.ssdk_oks_classic_qq,
         R.drawable.ssdk_oks_classic_qzone,
         R.drawable.ssdk_oks_classic_shortmessage,
         R.drawable.ssdk_oks_classic_sinaweibo,
         R.drawable.ssdk_oks_classic_tencentweibo,
         R.drawable.ssdk_oks_classic_vkontakte,
         R.drawable.ssdk_oks_classic_wechat,
         R.drawable.ssdk_oks_classic_wechatfavorite,
         R.drawable.ssdk_oks_classic_wechatmoments,
         R.drawable.ssdk_oks_classic_yixinmoments };
 
   private void initView() {
      mListView = (ZQListView)findViewById(R.id.list);
      int length = Img.length;
      for (int i = 0; i&lt; length; i++) {
         MessageItem item = new MessageItem();
         item.iconRes = Img[i];
         item.title = "标题" + (i + 1);
         item.msg = "消息" + (i + 1);
         item.time = "2016-6-1" + i;
         mMessageItems.add(item);
      }
      mListView.setAdapter(newSlideAdapter());
      mListView.setOnItemClickListener(this);
   }
 
   private class SlideAdapter extends BaseAdapter {
 
      private LayoutInflater mInflater;
 
      SlideAdapter() {
         super();
         mInflater =getLayoutInflater();
      }
 
      @Override
      public int getCount() {
         return mMessageItems.size();
      }
 
      @Override
      public Object getItem(int position) {
         return mMessageItems.get(position);
      }
 
      @Override
      public long getItemId(int position) {
         return position;
      }
 
      @Override
      public View getView(int position, View convertView, ViewGroupparent) {
         ViewHolder holder;
         ZQView slideView = (ZQView)convertView;
         if(slideView == null) {
            View itemView = mInflater.inflate(R.layout.list_item,null);
 
            slideView = newZQView(ActivityListViewDelete.this);
            slideView.setContentView(itemView);
            holder = newViewHolder(slideView);
            slideView.setTag(holder);
         } else {
            holder = (ViewHolder) slideView.getTag();
         }
         MessageItem item = mMessageItems.get(position);
         slideView.shrink();
         holder.icon.setImageResource(item.iconRes);
         holder.title.setText(item.title);
         holder.time.setText(item.time);
         holder.deleteHolder.setOnClickListener(ActivityListViewDelete.this);
 
         return slideView;
      }
 
   }
 
   public class MessageItem {
      public int iconRes;
      public String title;
      public String msg;
      public String time;
   }
 
   private static class ViewHolder {
      public ImageViewicon;
      public TextView title;
      public TextView time;
      public ViewGroup deleteHolder;
 
      ViewHolder(View view) {
         icon =(ImageView) view.findViewById(R.id.icon);
         title =(TextView) view.findViewById(R.id.title);
         time =(TextView) view.findViewById(R.id.time);
         deleteHolder =(ViewGroup) view.findViewById(R.id.holder);
      }
   }
 
   @Override
   public void onItemClick(AdapterView&lt;?&gt; parent, View view, int position,
         long id) {
      Toast.makeText(this,"onItemClickposition=" + position, 1).show();
 
   }
 
   @Override
   public void onClick(View v) {
      if(v.getId() == R.id.holder) {
         Toast.makeText(this,"删除操作",1).show();

      }
   }
 
}</code></pre> 
<p>此代码是ListView的侧滑删除操作，ExpandableListView未贴出来，下载代码即可，两个都有。</p> 
<span id="OSC_h2_1"></span>
<h2><strong><span style="color:#B22222">源码下载：</span></strong></h2> 
<p>&nbsp;</p> 
<p>Eclipse下载：<a href="http://download.csdn.net/detail/dickyqie/9627652" target="_blank" rel="nofollow">http://download.csdn.net/detail/dickyqie/9627652</a></p> 
