package com.zhangqie.listvieweditvalue;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by zhangqie on 2017/8/16.
 */

public class ListAdapter extends BaseAdapter {


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

}
