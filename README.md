# Android-------ListView列表中获取EditText输入的值 
<p>最近项目的购物车中用列表中包含了留言功能, 需要获取EditText输入的内容，当购买多件商品时，就有点棘手了。</p> 
<p>经过查资料解决了这个功能，并写了一个案例；</p> 
<p>&nbsp;&nbsp; 效果图：</p> 
<p>&nbsp;&nbsp;&nbsp;&nbsp; <img alt="" src="https://static.oschina.net/uploads/img/201709/20083153_yqah.gif"></p> 
<p>&nbsp;可以在商品数据用一个字段来管理留言数据，这样就可以方便的操作了。</p> 
<p>&nbsp;代码：</p> 
<pre><code class="language-java">public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        listView=(ListView)findViewById(R.id.listview);
        listView.setAdapter(new ListAdapter(this));
    }
    public void saveEditData(int position, String str) {
        Toast.makeText(this,str+"----"+position,Toast.LENGTH_LONG).show();
    }
}</code></pre> 
<p>Adapter</p> 
<pre><code class="language-java">public class ListAdapter extends BaseAdapter {


    Context context;
    LayoutInflater inflater;
    String[] strings=new String[]{"商品1","商品2","商品3"};
    public ListAdapter(Context context) {
        this.inflater=LayoutInflater.from(context);
        this.context=context;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object getItem(int position) {
        return strings[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (null == convertView){
            convertView = inflater.inflate(R.layout.item_multiple_confirm,null);
            holder =new ViewHolder(convertView,position);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv_name.setText(getItem(position).toString());
        return convertView;
    }

    class ViewHolder{
        TextView tv_name;
        EditText editText;
        public ViewHolder(View view,int pisition){
            tv_name = (TextView) view.findViewById(R.id.fill_order_name);
            editText= (EditText) view.findViewById(R.id.fill_order_ltext);
            editText.setTag(pisition);//存tag值
            editText.addTextChangedListener(new TextSwitcher(this));
        }
    }

    class TextSwitcher implements TextWatcher {
        private ViewHolder mHolder;

        public TextSwitcher(ViewHolder mHolder) {
            this.mHolder = mHolder;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            int position = (int) mHolder.editText.getTag();//取tag值
            ((MainActivity)context).saveEditData(position, s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }

}</code></pre> 
<p>代码是写的比较简单</p>
