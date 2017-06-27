package com.rfchina.internet.mytestapp.cornerlayout;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rfchina.internet.mytestapp.R;

import java.util.List;

/**
 * Created by luoyican on 2017/6/14.
 */

public class CornerAdapter extends BaseAdapter {
    List<String> datas;

    public CornerAdapter(List<String> datas) {
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public String getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup group) {
        if (view == null) {
            view = View.inflate(group.getContext(), R.layout.item_list_corner, null);
        }
        TextView textView = (TextView) view.findViewById(R.id.text);
        textView.setText(getItem(i));
        return view;
    }
}
