package com.rfchina.internet.mytestapp;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by luoyican on 2017/7/10.
 */

public class MainActivityAdapter extends BaseAdapter {
    List<Class> activities;

    public MainActivityAdapter(List<Class> activities) {
        this.activities = activities;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return activities.size();
    }

    @Override
    public Class getItem(int position) {
        return activities.get(position);
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(parent.getContext(), R.layout.item_main_adapter, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txtActivityName.setText("click to " + getItem(position).toString());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parent.getContext(), getItem(position));
                parent.getContext().startActivity(intent);
            }
        });
        return convertView;
    }

    class ViewHolder {
        TextView txtActivityName;

        public ViewHolder(View view) {
            txtActivityName = (TextView) view.findViewById(R.id.txtActivityName);
        }
    }

}
