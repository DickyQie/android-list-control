# ExpandableListView的使用多级列表

   <p>多级列表ExpandableListView&nbsp;</p> 
<p>扩展列表能够显示一个指示在每项显示项的当前状态（状态通常是一个扩展的组，组的孩子，或倒塌，最后一个孩子）。使用或<code><a href="https://developer.android.com/reference/android/widget/ExpandableListView.html#setGroupIndicator(android.graphics.drawable.Drawable)" target="_blank" rel="nofollow">setgroupindicator（drawable）</a></code>（或相应的XML属性）来设置这些指标,一个默认的风格提供多级列表指标，将示给意见多级列表。布局android.r.layout.simple_expandable_list_item_1和android.r.layout.simple_expandable_list_item_2（应用<code><a href="https://developer.android.com/reference/android/widget/SimpleCursorTreeAdapter.html" target="_blank" rel="nofollow">simplecursortreeadapter</a></code>）包含位置信息的首选指标。</p> 
<p>效果图：</p> 
<p>&nbsp;&nbsp;&nbsp;&nbsp;<img alt="" height="443" src="https://static.oschina.net/uploads/space/2016/1205/112447_6XK2_2945455.png" width="380"></p> 

