# ExpandableListView的使用多级列表

<div id="article_content" class="article_content">

<p><span style="font-size:18px">多级列表</span><span style="font-size:18px">ExpandableListView&nbsp;</span></p>
<p><span style="font-family:Roboto,sans-serif; line-height:24px"><span style="font-size:14px">扩展列表能够显示一个指示在每项显示项的当前状态（状态通常是一个扩展的组，组的孩子，或倒塌，最后一个孩子）。</span></span><span style="font-size:14px">使用<code style=""><a target="_blank" target="_blank" href="https://developer.android.com/reference/android/widget/ExpandableListView.html#setChildIndicator(android.graphics.drawable.Drawable)" style="text-decoration:none">setchildindicator（drawable）</a></code>或<code style=""><a target="_blank" target="_blank" href="https://developer.android.com/reference/android/widget/ExpandableListView.html#setGroupIndicator(android.graphics.drawable.Drawable)" style="text-decoration:none">setgroupindicator（drawable）</a></code>（或相应的XML属性）来设置这些指标,一个默认的风&#26684;<code style=""><a target="_blank" target="_blank" href="https://developer.android.com/reference/android/widget/ExpandableListView.html" style="text-decoration:none">多级列表</a></code>提供指标，将示给意见<code style=""><a target="_blank" target="_blank" href="https://developer.android.com/reference/android/widget/ExpandableListView.html" style="text-decoration:none">多级列表</a></code>。布局android.r.layout.simple_expandable_list_item_1和android.r.layout.simple_expandable_list_item_2（应</span>用<code style=""><a target="_blank" target="_blank" href="https://developer.android.com/reference/android/widget/SimpleCursorTreeAdapter.html" style="text-decoration:none">simplecursortreeadapter</a></code>）包含位置信息的首选指标。</p>
<p>效果图：</p>
<p><img src="http://img.blog.csdn.net/20160914153130272?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQv/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center" alt=""><br>
</p>
<p><strong><span style="font-size:14px; color:#3366ff">activity_main.xml</span></strong></p>
<p></p>
<p style="font-size:14px"><span style="color:teal">&lt;</span><span style="color:#3F7F7F">LinearLayout</span><span style="color:#7F007F">xmlns:android</span>=<em><span style="color:#2A00FF">&quot;http://schemas.android.com/apk/res/android&quot;</span></em></p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_width</span>=<em><span style="color:#2A00FF">&quot;match_parent&quot;</span></em></p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_height</span>=<em><span style="color:#2A00FF">&quot;match_parent&quot;</span></em></p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:background</span>=<em><span style="color:#2A00FF">&quot;#ffffff&quot;</span></em></p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:orientation</span>=<em><span style="color:#2A00FF">&quot;vertical&quot;</span></em><span style="color:teal">&gt;</span></p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp; <span style="color:teal">&lt;</span><span style="color:#3F7F7F">ExpandableListView</span></p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:id</span>=<em><span style="color:#2A00FF">&quot;@&#43;id/expandableListView&quot;</span></em></p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_width</span>=<em><span style="color:#2A00FF">&quot;match_parent&quot;</span></em></p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_height</span>=<em><span style="color:#2A00FF">&quot;match_parent&quot;</span></em></p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:divider</span>=<em><span style="color:#2A00FF">&quot;#E4E4E4&quot;</span></em></p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:dividerHeight</span>=<em><span style="color:#2A00FF">&quot;5dp&quot;</span></em><span style="color:teal">&gt;</span></p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp; <span style="color:teal">&lt;/</span><span style="color:#3F7F7F">ExpandableListView</span><span style="color:teal">&gt;</span></p>
<p style="font-size:14px"><span style="color:teal">&lt;/</span><span style="color:#3F7F7F">LinearLayout</span><span style="color:teal">&gt;</span></p>
<strong><span style="font-size:14px; color:#3333ff">child_item.xml</span></strong>
<p></p>
<p></p>
<p style="font-size:14px"><span style="color:teal">&lt;?</span><span style="color:#3F7F7F">xml</span><span style="color:#7F007F">version</span>=<em><span style="color:#2A00FF">&quot;1.0&quot;</span></em><span style="color:#7F007F">encoding</span>=<em><span style="color:#2A00FF">&quot;utf-8&quot;</span></em><span style="color:teal">?&gt;</span></p>
<p style="font-size:14px"><span style="color:teal">&lt;</span><span style="color:#3F7F7F">LinearLayout</span><span style="color:#7F007F">xmlns:android</span>=<em><span style="color:#2A00FF">&quot;http://schemas.android.com/apk/res/android&quot;</span></em></p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_width</span>=<em><span style="color:#2A00FF">&quot;match_parent&quot;</span></em></p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_height</span>=<em><span style="color:#2A00FF">&quot;match_parent&quot;</span></em></p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:orientation</span>=<em><span style="color:#2A00FF">&quot;vertical&quot;</span></em><span style="color:teal">&gt;</span></p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp; <span style="color:teal">&lt;</span><span style="color:#3F7F7F">TextView</span></p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:id</span>=<em><span style="color:#2A00FF">&quot;@&#43;id/textViews&quot;</span></em></p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_width</span>=<em><span style="color:#2A00FF">&quot;wrap_content&quot;</span></em></p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_height</span>=<em><span style="color:#2A00FF">&quot;wrap_content&quot;</span></em><span style="color:teal">/&gt;</span></p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp; <span style="color:teal">&lt;</span><span style="color:#3F7F7F">View</span></p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_width</span>=<em><span style="color:#2A00FF">&quot;match_parent&quot;</span></em></p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_height</span>=<em><span style="color:#2A00FF">&quot;0.5dp&quot;</span></em></p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:background</span>=<em><span style="color:#2A00FF">&quot;#ff0000&quot;</span></em><span style="color:teal">/&gt;</span></p>
<p style="font-size:14px"><span style="color:teal">&lt;/</span><span style="color:#3F7F7F">LinearLayout</span><span style="color:teal">&gt;</span></p>
<span style="font-size:14px; color:#3333ff"><strong>groud_item.xml</strong></span>
<p></p>
<p></p>
<p><span style="color:teal">&lt;</span><span style="color:#3F7F7F">LinearLayout</span><span style="color:#7F007F">xmlns:android</span>=<em><span style="color:#2A00FF">&quot;http://schemas.android.com/apk/res/android&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">xmlns:tools</span>=<em><span style="color:#2A00FF">&quot;http://schemas.android.com/tools&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_width</span>=<em><span style="color:#2A00FF">&quot;match_parent&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_height</span>=<em><span style="color:#2A00FF">&quot;match_parent&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;<span style="color:#7F007F">android:gravity</span>=<em><span style="color:#2A00FF">&quot;center_vertical&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:orientation</span>=<em><span style="color:#2A00FF">&quot;horizontal&quot;</span></em><span style="color:teal">&gt;</span></p>
<p>&nbsp;&nbsp;&nbsp; <span style="color:teal">&lt;</span><span style="color:#3F7F7F">ImageView</span></p>
<p><span style="color:#3F7F7F">&nbsp;&nbsp;&nbsp;&nbsp; </span>&nbsp;&nbsp;&nbsp;<span style="color:#7F007F">android:id</span>=<em><span style="color:#2A00FF">&quot;@&#43;id/imageView1&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_width</span>=<em><span style="color:#2A00FF">&quot;65dp&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_height</span>=<em><span style="color:#2A00FF">&quot;55dp&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_marginLeft</span>=<em><span style="color:#2A00FF">&quot;10dp&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:scaleType</span>=<em><span style="color:#2A00FF">&quot;fitXY&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:src</span>=<em><span style="color:#2A00FF">&quot;@drawable/l1&quot;</span></em><span style="color:teal">/&gt;</span></p>
<p>&nbsp;&nbsp;&nbsp; <span style="color:teal">&lt;</span><span style="color:#3F7F7F">TextView</span></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:id</span>=<em><span style="color:#2A00FF">&quot;@&#43;id/textView&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_width</span>=<em><span style="color:#2A00FF">&quot;wrap_content&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_height</span>=<em><span style="color:#2A00FF">&quot;wrap_content&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:layout_marginLeft</span>=<em><span style="color:#2A00FF">&quot;10dp&quot;</span></em></p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#7F007F">android:text</span>=<em><span style="color:#2A00FF">&quot;</span><span style="color:#2A00FF">斯蒂芬</span><span style="color:#2A00FF">&quot;</span></em><span style="color:teal">/&gt;</span></p>
<p><span style="color:teal">&lt;/</span><span style="color:#3F7F7F">LinearLayout</span><span style="color:teal">&gt;</span></p>
<br>
<p></p>
<p><strong><span style="font-size:14px; color:#3366ff">MainActivity.java</span></strong></p>
<p></p>
<p style="font-size:14px"><span style="color:#3F5FBF">/*****</span></p>
<p style="font-size:14px"><span style="color:#3F5FBF">&nbsp;* ExpandableListView</span></p>
<p style="font-size:14px"><span style="color:#3F5FBF">&nbsp;* </span></p>
<p style="font-size:14px"><span style="color:#3F5FBF">&nbsp;*/</span></p>
<p style="font-size:14px"><strong><span style="color:#7F0055">public</span> <span style="color:#7F0055">
class&nbsp;</span></strong>MainActivity <strong><span style="color:#7F0055">exends</span></strong> Activity {</p>
<p style="font-size:14px">&nbsp;&nbsp; <strong><span style="color:#7F0055">private</span></strong> ExpandableListView<span style="color:#0000C0">listView</span>;</p>
<p style="font-size:14px">&nbsp;&nbsp; <strong><span style="color:#7F0055">private</span></strong> List&lt;String&gt;<span style="color:#0000C0">group</span>;</p>
<p style="font-size:14px">&nbsp;&nbsp; <strong><span style="color:#7F0055">private</span></strong>List&lt;List&lt;String&gt;&gt;<span style="color:#0000C0">child</span>;</p>
<p style="font-size:14px">&nbsp;&nbsp; <strong><span style="color:#7F0055">private</span></strong> MyAdapter<span style="color:#0000C0">adapter</span>;</p>
<p style="font-size:14px">&nbsp;&nbsp; <span style="color:#646464">@Override</span></p>
<p style="font-size:14px">&nbsp;&nbsp; <strong><span style="color:#7F0055">protected</span><span style="color:#7F0055">void&nbsp;</span></strong>onCreate(Bundle savedInstanceState) {</p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">super</span></strong>.onCreate(savedInstanceState);</p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; setContentView(R.layout.<em><span style="color:#0000C0">activity_main</span></em>);</p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#0000C0">listView</span> =(ExpandableListView) findViewById(R.id.<em><span style="color:#0000C0">expandableListView</span></em>);</p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#3F5FBF">/**</span></p>
<p style="font-size:14px"><span style="color:#3F5FBF">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;* </span><span style="color:#3F5FBF">初始化数据</span></p>
<p style="font-size:14px"><span style="color:#3F5FBF">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;*/</span></p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; initData();</p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#0000C0">adapter</span> = <strong>
<span style="color:#7F0055">new</span></strong>MyAdapter(<strong><span style="color:#7F0055">this</span></strong>,<span style="color:#0000C0">group</span>,
<span style="color:#0000C0">child</span>);</p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#0000C0">listView</span>.setAdapter(<span style="color:#0000C0">adapter</span>);</p>
<p style="font-size:14px">&nbsp;&nbsp; }</p>
<p style="font-size:14px">&nbsp;&nbsp; <strong><span style="color:#7F0055">private</span> <span style="color:#7F0055">
void&nbsp;</span></strong>initData() {</p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#0000C0">group</span> = <strong>
<span style="color:#7F0055">new</span></strong>ArrayList&lt;String&gt;();</p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#0000C0">child</span> = <strong>
<span style="color:#7F0055">new</span></strong>ArrayList&lt;List&lt;String&gt;&gt;();</p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; addInfo(<span style="color:#2A00FF">&quot;</span><span style="color:#2A00FF">笑傲江湖</span><span style="color:#2A00FF">&quot;</span>,<strong><span style="color:#7F0055">new</span></strong> String[]{
<span style="color:#2A00FF">&quot;</span><span style="color:#2A00FF">东方不败</span><span style="color:#2A00FF">&quot;</span>,<span style="color:#2A00FF">&quot;</span><span style="color:#2A00FF">风清扬</span><span style="color:#2A00FF">&quot;</span>,<span style="color:#2A00FF">&quot;</span><span style="color:#2A00FF">令狐冲</span><span style="color:#2A00FF">&quot;</span>,<span style="color:#2A00FF">&quot;</span><span style="color:#2A00FF">岳不群</span><span style="color:#2A00FF">&quot;</span>
 });</p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; addInfo(<span style="color:#2A00FF">&quot;</span><span style="color:#2A00FF">天龙八部</span><span style="color:#2A00FF">&quot;</span>,<strong><span style="color:#7F0055">new</span></strong> String[]{
<span style="color:#2A00FF">&quot;</span><span style="color:#2A00FF">乔峰</span><span style="color:#2A00FF">&quot;</span>,<span style="color:#2A00FF">&quot;</span><span style="color:#2A00FF">虚竹</span><span style="color:#2A00FF">&quot;</span>,<span style="color:#2A00FF">&quot;</span><span style="color:#2A00FF">段誉</span><span style="color:#2A00FF">&quot;</span>
 });</p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; addInfo(<span style="color:#2A00FF">&quot;</span><span style="color:#2A00FF">九阴真经</span><span style="color:#2A00FF">&quot;</span>,<strong><span style="color:#7F0055">new</span></strong> String[]{
<span style="color:#2A00FF">&quot;</span><span style="color:#2A00FF">中神通</span><span style="color:#2A00FF">&quot;</span>,<span style="color:#2A00FF">&quot;</span><span style="color:#2A00FF">东邪</span><span style="color:#2A00FF">&quot;</span>,<span style="color:#2A00FF">&quot;</span><span style="color:#2A00FF">西毒</span><span style="color:#2A00FF">&quot;</span>,<span style="color:#2A00FF">&quot;</span><span style="color:#2A00FF">南帝</span><span style="color:#2A00FF">&quot;</span>,<span style="color:#2A00FF">&quot;</span><span style="color:#2A00FF">北丐</span><span style="color:#2A00FF">&quot;</span>
 });</p>
<p style="font-size:14px">&nbsp;&nbsp; }</p>
<p style="font-size:14px">&nbsp;&nbsp; <span style="color:#3F5FBF">/**</span></p>
<p style="font-size:14px"><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;* </span><span style="color:#3F5FBF">添加数据信息</span></p>
<p style="font-size:14px"><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;* </span></p>
<p style="font-size:14px"><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;* </span><strong><span style="color:#7F9FBF">@param</span></strong><span style="color:#3F5FBF"> g</span></p>
<p style="font-size:14px"><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;* </span><strong><span style="color:#7F9FBF">@param</span></strong><span style="color:#3F5FBF"> c</span></p>
<p style="font-size:14px"><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;*/</span></p>
<p style="font-size:14px">&nbsp;&nbsp; <strong><span style="color:#7F0055">private</span> <span style="color:#7F0055">
void&nbsp;</span></strong>addInfo(String g, String[] c) {</p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#0000C0">group</span>.add(g);</p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; List&lt;String&gt; list = <strong><span style="color:#7F0055">new</span></strong>ArrayList&lt;String&gt;();</p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">for</span></strong> (<strong><span style="color:#7F0055">int</span></strong> i = 0; i&lt; c.<span style="color:#0000C0">length</span>; i&#43;&#43;) {</p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; list.add(c[i]);</p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }</p>
<p style="font-size:14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span style="color:#0000C0">child</span>.add(list);</p>
<p style="font-size:14px">&nbsp;&nbsp; }</p>
<p style="font-size:14px">}</p>
<span style="font-size:14px; color:#3366ff"><strong>Adapter.java</strong></span>
<p></p>
<p></p>
<p><span style="color:#3F5FBF">/**</span></p>
<p><span style="color:#3F5FBF">&nbsp;* expandableListView</span><span style="color:#3F5FBF">的用法同</span><span style="color:#3F5FBF">ListView</span></p>
<p><span style="color:#3F5FBF">&nbsp;* </span></p>
<p><span style="color:#3F5FBF">&nbsp;*/</span></p>
<p><strong><span style="color:#7F0055">public</span> <span style="color:#7F0055">
class</span></strong> MyAdapter&nbsp;<strong><span style="color:#7F0055">extends</span></strong> BaseExpandableListAdapter {</p>
<p>&nbsp;&nbsp; <strong><span style="color:rgb(127,0,85)">private</span> </strong>Context <span style="color:#0000C0">
context</span>;</p>
<p>&nbsp;&nbsp; <strong><span style="color:#7F0055">private</span></strong> List&lt;String&gt; <span style="color:#0000C0">
group</span>;</p>
<p>&nbsp;&nbsp; <strong><span style="color:#7F0055">private</span></strong>List&lt;List&lt;String&gt;&gt;<span style="color:#0000C0">child</span>;</p>
<p>&nbsp;&nbsp; <strong><span style="color:#7F0055">private</span> <span style="color:#7F0055">
int</span></strong>[] <span style="color:#0000C0">img</span> = {R.drawable.<em><span style="color:#0000C0">l2</span></em>, R.drawable.<em><span style="color:#0000C0">l3</span></em>,R.drawable.<em><span style="color:#0000C0">l1</span></em> };</p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp; <strong><span style="color:#7F0055">public</span></strong> MyAdapter(Context context, List&lt;String&gt; group,</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; List&lt;List&lt;String&gt;&gt; child) {</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">this</span></strong>.<span style="color:#0000C0">context</span> =context;</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">this</span></strong>.<span style="color:#0000C0">group</span> = group;</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">this</span></strong>.<span style="color:#0000C0">child</span> = child;</p>
<p>&nbsp;&nbsp; }</p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp; <span style="color:#646464">@Override</span></p>
<p>&nbsp;&nbsp; <strong><span style="color:#7F0055">public</span> <span style="color:#7F0055">
int&nbsp;</span></strong>getGroupCount() {</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">return</span></strong> <span style="color:#0000C0">
group</span>.size();</p>
<p>&nbsp;&nbsp; }</p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp; <span style="color:#646464">@Override</span></p>
<p>&nbsp;&nbsp; <strong><span style="color:#7F0055">public</span> <span style="color:#7F0055">
int</span></strong>getChildrenCount(<strong><span style="color:#7F0055">int</span></strong> groupPosition) {</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">return</span></strong> <span style="color:#0000C0">
child</span>.get(groupPosition).size();</p>
<p>&nbsp;&nbsp; }</p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp; <span style="color:#646464">@Override</span></p>
<p>&nbsp;&nbsp; <strong><span style="color:#7F0055">public</span></strong> Object &nbsp;getGroup(<strong><span style="color:#7F0055">int&nbsp;</span></strong>groupPosition) {</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">return</span></strong> <span style="color:#0000C0">
group</span>.get(groupPosition);</p>
<p>&nbsp;&nbsp; }</p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp; <span style="color:#646464">@Override</span></p>
<p>&nbsp;&nbsp; <strong><span style="color:#7F0055">public</span></strong> Object &nbsp;getChild(<strong><span style="color:#7F0055">int&nbsp;</span></strong>groupPosition,<strong><span style="color:#7F0055">int</span></strong> childPosition) {</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">return</span></strong> <span style="color:#0000C0">
child</span>.get(childPosition).get(childPosition);</p>
<p>&nbsp;&nbsp; }</p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp; <span style="color:#646464">@Override</span></p>
<p>&nbsp;&nbsp; <strong><span style="color:#7F0055">public</span> <span style="color:#7F0055">
long&nbsp;</span></strong>getGroupId(<strong><span style="color:#7F0055">int</span></strong> groupPosition) {</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">return&nbsp;</span></strong>groupPosition;</p>
<p>&nbsp;&nbsp; }</p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp; <span style="color:#646464">@Override</span></p>
<p>&nbsp;&nbsp; <strong><span style="color:#7F0055">public</span> <span style="color:#7F0055">
long&nbsp;</span></strong>getChildId(<strong><span style="color:#7F0055">int</span></strong> groupPosition,<strong><span style="color:#7F0055">int&nbsp;</span></strong>childPosition) {</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">return&nbsp;</span></strong>childPosition;</p>
<p>&nbsp;&nbsp; }</p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp; <span style="color:#646464">@Override</span></p>
<p>&nbsp;&nbsp; <strong><span style="color:#7F0055">public</span> <span style="color:#7F0055">
boolean&nbsp;</span></strong>hasStableIds() {</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">return</span> <span style="color:#7F0055">
false</span></strong>;</p>
<p>&nbsp;&nbsp; }</p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp; <span style="color:#3F5FBF">/**</span></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;* </span></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;* </span><span style="color:#3F5FBF">获取显示指定组的视图对象</span></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;* </span></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;* </span><strong><span style="color:#7F9FBF">@param</span></strong><span style="color:#3F5FBF">groupPosition</span></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span><span style="color:#3F5FBF">组位置</span></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;* </span><strong><span style="color:#7F9FBF">@param</span></strong><span style="color:#3F5FBF">isExpanded</span></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span><span style="color:#3F5FBF">该组是展开状态还是伸缩状态</span></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;* </span><strong><span style="color:#7F9FBF">@param</span></strong><span style="color:#3F5FBF">convertView</span></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span><span style="color:#3F5FBF">重用已有的视图对象</span></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;* </span><strong><span style="color:#7F9FBF">@param</span></strong><span style="color:#3F5FBF"> parent</span></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span style="color:#3F5FBF">返回的视图对象始终依附于的视图组</span></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;* </span><strong><span style="color:#7F9FBF">@return</span></strong></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;* </span><strong><span style="color:#7F9FBF">@see</span></strong><span style="color:#3F5FBF">android.widget.ExpandableListAdapter#getGroupView(int, boolean,</span></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; android.view.View,android.view.ViewGroup)</span></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;*/</span></p>
<p>&nbsp;&nbsp; <span style="color:#646464">@Override</span></p>
<p>&nbsp;&nbsp; <strong><span style="color:#7F0055">public</span></strong> View &nbsp;getGroupView(<strong><span style="color:#7F0055">int&nbsp;</span></strong>groupPosition,<strong><span style="color:#7F0055">boolean</span></strong> isExpanded,</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; View convertView, ViewGroup parent) {</p>
<p>&nbsp; &nbsp; &nbsp; &nbsp; ViewHolder holder;</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">if</span></strong>(convertView == <strong>
<span style="color:#7F0055">null</span></strong>) {</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; convertView = LayoutInflater.<em>from</em>(<span style="color:#0000C0">context</span>).inflate(</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; R.layout.<em><span style="color:#0000C0">groud_item</span></em>,<strong><u><span style="color:#7F0055">null</span></u></strong>);</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; holder = <strong><span style="color:#7F0055">new</span></strong>ViewHolder();</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; holder.<span style="color:#0000C0">textView</span> =(TextView) convertView</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; .findViewById(R.id.<em><span style="color:#0000C0">textView</span></em>);</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; holder.<span style="color:#0000C0">mImageView</span> =(ImageView) convertView</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; .findViewById(R.id.<em><span style="color:#0000C0">imageView1</span></em>);</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; convertView.setTag(holder);</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; } <strong><span style="color:#7F0055">else</span></strong> {</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; holder = (ViewHolder)convertView.getTag();</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; holder.<span style="color:#0000C0">textView</span>.setText(<span style="color:#0000C0">group</span>.get(groupPosition));</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; holder.<span style="color:#0000C0">textView</span>.setTextSize(25);</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; holder.<span style="color:#0000C0">textView</span>.setPadding(36,10, 0, 10);</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; holder.<span style="color:#0000C0">mImageView</span>.setImageResource(<span style="color:#0000C0">img</span>[groupPosition]);</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">return&nbsp;</span></strong>convertView;</p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp; }</p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp; <span style="color:#3F5FBF">/**</span></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;* </span></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;* </span><span style="color:#3F5FBF">获取一个视图对象，显示指定组中的指定子元素数据。</span></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;* </span></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;* </span><strong><span style="color:#7F9FBF">@param</span></strong><span style="color:#3F5FBF">groupPosition</span></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span><span style="color:#3F5FBF">组位置</span></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;* </span><strong><span style="color:#7F9FBF">@param</span></strong><span style="color:#3F5FBF">childPosition</span></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span><span style="color:#3F5FBF">子元素位置</span></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;* </span><strong><span style="color:#7F9FBF">@param</span></strong><span style="color:#3F5FBF">isLastChild</span></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span><span style="color:#3F5FBF">子元素是否处于组中的最后一个</span></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;* </span><strong><span style="color:#7F9FBF">@param</span></strong><span style="color:#3F5FBF">convertView</span></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span><span style="color:#3F5FBF">重用已有的视图</span><span style="color:#3F5FBF">(View)</span><span style="color:#3F5FBF">对象</span></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;* </span><strong><span style="color:#7F9FBF">@param</span></strong><span style="color:#3F5FBF"> parent</span></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span><span style="color:#3F5FBF">返回的视图</span><span style="color:#3F5FBF">(View)</span><span style="color:#3F5FBF">对象始终依附于的视图组</span></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;* </span><strong><span style="color:#7F9FBF">@return</span></strong></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;* </span><strong><span style="color:#7F9FBF">@see</span></strong><span style="color:#3F5FBF">android.widget.ExpandableListAdapter#getChildView(int, int, boolean,</span></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; android.view.View,android.view.ViewGroup)</span></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;*/</span></p>
<p>&nbsp;&nbsp; <span style="color:#646464">@Override</span></p>
<p>&nbsp;&nbsp; <strong><span style="color:#7F0055">public</span></strong> View getChildView(<strong><span style="color:#7F0055">int&nbsp;</span></strong>groupPosition,<strong><span style="color:#7F0055">int</span></strong> childPosition,</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">boolean&nbsp;</span></strong>isLastChild, View convertView, ViewGroup parent) {</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ViewHolder holder;</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">if</span></strong>(convertView == <strong>
<span style="color:#7F0055">null</span></strong>) {</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; convertView = LayoutInflater.<em>from</em>(<span style="color:#0000C0">context</span>).inflate(</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; R.layout.<em><span style="color:#0000C0">child_item</span></em>,<strong><u><span style="color:#7F0055">null</span></u></strong>);</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; holder = <strong><span style="color:#7F0055">new</span></strong>ViewHolder();</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; holder.<span style="color:#0000C0">textView</span> =(TextView) convertView</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; .findViewById(R.id.<em><span style="color:#0000C0">textViews</span></em>);</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; convertView.setTag(holder);</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; } <strong><span style="color:#7F0055">else</span></strong> {</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; holder = (ViewHolder)convertView.getTag();</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; }</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; holder.<span style="color:#0000C0">textView</span>.setText(<span style="color:#0000C0">child</span>.get(groupPosition).get(childPosition));</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; holder.<span style="color:#0000C0">textView</span>.setTextSize(20);</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; holder.<span style="color:#0000C0">textView</span>.setPadding(72,10, 0, 10);</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">return&nbsp;</span></strong>convertView;</p>
<p>&nbsp;&nbsp; }</p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp; <span style="color:#3F5FBF">/**</span></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;* </span></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;* </span><span style="color:#3F5FBF">是否选中指定位置上的子元素。</span></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;* </span></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;* </span><strong><span style="color:#7F9FBF">@param</span></strong><span style="color:#3F5FBF">groupPosition</span></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;* </span><strong><span style="color:#7F9FBF">@param</span></strong><span style="color:#3F5FBF">childPosition</span></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;* </span><strong><span style="color:#7F9FBF">@return</span></strong></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;* </span><strong><span style="color:#7F9FBF">@see</span></strong><span style="color:#3F5FBF">android.widget.ExpandableListAdapter#isChildSelectable(int, int)</span></p>
<p><span style="color:#3F5FBF">&nbsp;&nbsp; &nbsp;*/</span></p>
<p>&nbsp;&nbsp; <span style="color:#646464">@Override</span></p>
<p>&nbsp;&nbsp; <strong><span style="color:#7F0055">public</span> <span style="color:#7F0055">
boolean&nbsp;</span></strong>isChildSelectable(<strong><span style="color:#7F0055">int</span></strong> groupPosition,<strong><span style="color:#7F0055">int&nbsp;</span></strong>childPosition) {</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <strong><span style="color:#7F0055">return</span> <span style="color:#7F0055">
false</span></strong>;</p>
<p>&nbsp;&nbsp; }</p>
<p>&nbsp;</p>
<p>&nbsp;&nbsp; <strong><span style="color:#7F0055">class</span></strong> ViewHolder {</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ImageView <span style="color:#0000C0">mImageView</span>;</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; TextView <span style="color:#0000C0">textView</span>;</p>
<p>&nbsp;&nbsp; }</p>
<p>}</p>
<br>
<p></p>
<p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; font-family:Arial; font-size:14px; line-height:26px">
<span style="font-family:Verdana,Arial,Helvetica,sans-serif; line-height:21px"><span style="font-family:Arial; line-height:35px"><span style="color:rgb(204,0,0); font-family:&quot;Microsoft Yahei&quot;; font-size:18px; line-height:28px; text-indent:32px">源码下载：</span><br>
</span></span></p>
<p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; font-family:Arial; font-size:14px; line-height:26px">
<span style="line-height:35px; background-color:transparent"><br>
</span></p>
<p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; font-family:Arial; font-size:14px; line-height:26px">
<span style="line-height:35px; background-color:transparent">Eclipse下载：</span><a target="_blank" target="_blank" href="http://download.csdn.net/detail/dickyqie/9630549" style="line-height:35px; color:rgb(255,153,0); text-decoration:none; background-color:transparent">http://download.csdn.net/detail/dickyqie/9630549</a></p>
<p style="margin-top:0px; margin-bottom:0px; padding-top:0px; padding-bottom:0px; font-family:Arial; font-size:14px; line-height:26px">
<span style="font-family:Verdana,Arial,Helvetica,sans-serif; line-height:21px"><span style="font-family:Arial; line-height:35px">AndroidStudio下载：<a target="_blank" href="https://github.com/DickyQie/ListViewExpandableListViewDelete/tree/expandablelistview" style="font-family:Arial; font-size:14px; line-height:35px; color:rgb(255,153,0); text-decoration:none; background-color:transparent">https://github.com/DickyQie/ListViewExpandableListViewDelete/tree/expandablelistview</a></span></span></p>
<br>
<p></p>
<p><br>
</p>
<p><br>
</p>
<p><br>
</p>
<p><br>
</p>
   
</div>
