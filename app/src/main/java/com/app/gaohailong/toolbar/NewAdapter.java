package com.app.gaohailong.toolbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by donglinghao on 2015-10-30.
 */
public class NewAdapter extends BaseAdapter{
    private Context context;
    private List<New> mList;

    public NewAdapter(Context context, List<New> mList) {
        this.context = context;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        New news = (New) getItem(position);
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.new_item,parent,false);
        }
        TextView mTitle = (TextView) convertView.findViewById(R.id.new_title);
        TextView mTime = (TextView) convertView.findViewById(R.id.new_time);
        ImageView mImage = (ImageView) convertView.findViewById(R.id.new_image);

        mTitle.setText(news.getTitle());
        mTime.setText(news.getTime());
        mImage.setImageResource(news.getImageUrl());
        return convertView;
    }
}
