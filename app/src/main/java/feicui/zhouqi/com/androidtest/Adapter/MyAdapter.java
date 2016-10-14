package feicui.zhouqi.com.androidtest.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import feicui.zhouqi.com.androidtest.Data;
import feicui.zhouqi.com.androidtest.R;

/**
 * Created by z on 2016/10/14.
 */
public class MyAdapter extends BaseAdapter {
    List<Data> list;
    Activity activity;
    Context context;

    public MyAdapter(List<Data> list, Activity activity) {
        this.list=list;
        this.activity =activity;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(activity).inflate(R.layout.item_newslist, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.txt_item_title = (TextView) convertView.findViewById(R.id.tv_item_newslist);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txt_item_title.setText(list.get(position).getNew_title());
        return convertView;
    }

    private class ViewHolder {
        TextView txt_item_title;
    }
}
