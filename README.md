 <p>本案例主要实现了<strong>ListView</strong>和<strong>ExpandableListView</strong>的侧滑删除操作功能</p> 
<p>效果图：</p> 
<p>&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; <img alt="" src="https://static.oschina.net/uploads/img/201711/10201848_Es4R.gif" width="400"></p> 
<p>代码：</p> 
<pre><code class="language-java">private class SlideAdapter extends BaseAdapter {

        private LayoutInflater mInflater;

        SlideAdapter() {
            super();
            mInflater = getLayoutInflater();
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
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;

            ZQView slideView = (ZQView) convertView;
            if (slideView == null) {
                View itemView = mInflater.inflate(R.layout.list_item, null);

                slideView = new ZQView(ActivityListViewDelete.this);
                slideView.setContentView(itemView);
                holder = new ViewHolder(slideView);
                slideView.setTag(holder);
            } else {
                holder = (ViewHolder) slideView.getTag();
            }
            MessageItem item = mMessageItems.get(position);
            slideView.shrink();
            holder.title.setText(item.title);
            holder.time.setText(item.time);
            holder.deleteHolder.setOnClickListener(ActivityListViewDelete.this);

            return slideView;
        }

    }

    public class MessageItem {
        public String title;
        public String msg;
        public String time;
    }

    private static class ViewHolder {
        public ImageView icon;
        public TextView title;
        public TextView time;
        public ViewGroup deleteHolder;

        ViewHolder(View view) {
            icon = (ImageView) view.findViewById(R.id.icon);
            title = (TextView) view.findViewById(R.id.title);
            time = (TextView) view.findViewById(R.id.time);
            deleteHolder = (ViewGroup) view.findViewById(R.id.holder);
        }
    }

    @Override
    public void onItemClick(AdapterView&lt;?&gt; parent, View view, int position,
            long id) {
        Toast.makeText(this, "onItemClick position=" + position, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.holder) {
            Toast.makeText(this, "删除操作", Toast.LENGTH_LONG).show();

        }
    }</code></pre> 
<p>ExpandableListView的Adapter</p> 
<pre><code class="language-java">private Context context;
    private ListView listView;
    List&lt;UserInfo&gt; list;

    public MyElvAdapter(Context context, ListView listView, List&lt;UserInfo&gt; list) {
        super();
        this.context = context;
        this.listView = listView;
        this.list=list;
    }

    @Override
    public Object getChild(int arg0, int arg1) {
        // TODO Auto-generated method stub
        return list.get(arg0).getDatas().get(arg1);
    }

    @Override
    public long getChildId(int arg0, int arg1) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getChildView(final int groupPosition, final int position,
            boolean arg2, View convertView, ViewGroup parent) {

        final ViewHolder1 viewHolder1;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item2,
                    null);
            viewHolder1=new ViewHolder1(convertView);
            convertView.setTag(viewHolder1);

        }else {
            viewHolder1=(ViewHolder1)convertView.getTag();
        }
        new FrontViewToMove(viewHolder1.frontView, listView,200);
        viewHolder1.button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //删除事件，回调接口传参数
                onClickDeleteListenter.onItemClick(v,groupPosition,position);
                new FrontViewToMove(viewHolder1.frontView, listView,200).
                generateRevealAnimate(viewHolder1.frontView,0);

            }
        });
        viewHolder1.textView.setTextSize(20);
        viewHolder1.textView.setTextColor(Color.DKGRAY);
        viewHolder1.textView.
         setText("  " + list.get(groupPosition).getDatas().get(position).getName());
        return convertView;
    }

    class ViewHolder1 {
        private TextView textView;
        private View frontView;
        private Button button;
        public ViewHolder1(View view){
            textView= (TextView) view.findViewById(R.id.text);
            button = (Button) view.findViewById(R.id.btn_delete);
            frontView = view.findViewById(R.id.id_front);
        }
    }


    // 删除接口回调方法
    private OnClickDeleteListenter onClickDeleteListenter = null;
    public void setOnClickDeleteListenter(OnClickDeleteListenter listener) {
        this.onClickDeleteListenter = listener;
    }

    @Override
    public int getChildrenCount(int arg0) {
        // TODO Auto-generated method stub
        return (list!=null &amp;&amp; list.size()&gt;0)? list.get(arg0).getDatas().size() : 0;
    }

    @Override
    public Object getGroup(int arg0) {
        // TODO Auto-generated method stub
        return list.get(arg0);
    }

    @Override
    public int getGroupCount() {
        // TODO Auto-generated method stub
        return (list!=null &amp;&amp; list.size()&gt;0) ? list.size() : 0;
    }

    @Override
    public long getGroupId(int arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView ==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item1,null);
            viewHolder =new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder)convertView.getTag();
        }
        viewHolder.textView.setText("条目 " + list.get(groupPosition).getId());
        viewHolder.textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"第一层点击操作",Toast.LENGTH_LONG).show();
            }
        });
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isChildSelectable(int arg0, int arg1) {
        // TODO Auto-generated method stub
        return false;
    }

    class ViewHolder {
        TextView textView;
        public ViewHolder(View view){
            textView= (TextView) view.findViewById(R.id.name);
        }
    }</code></pre> 
<p>注：更新修复侧滑删除报错。</p> 
