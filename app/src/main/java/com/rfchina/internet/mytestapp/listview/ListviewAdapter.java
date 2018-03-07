package com.rfchina.internet.mytestapp.listview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;
import com.rfchina.internet.mytestapp.R;

import java.util.List;

/**
 * Created by luoyican on 2018/3/6.
 */

public class ListviewAdapter extends BaseAdapter {
    List<String> datas;

    public ListviewAdapter(List<String> datas) {
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public String getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        String url = datas.get(position);
        if (convertView == null) {
            convertView = View.inflate(parent.getContext(), R.layout.item_listview_activity, null);
            viewHolder = new ViewHolder();
            viewHolder.mImageView = (ImageView) convertView.findViewById(R.id.ivIcon);
            viewHolder.mImageView.setTag(url);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageForEmptyUri(R.drawable.d) // 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.drawable.d) // 设置图片加载或解码过程中发生错误显示的图片
                .cacheInMemory(true) // 设置下载的图片是否缓存在内存中
                .cacheOnDisk(true) // 设置下载的图片是否缓存在SD卡中(设置缓存就可以只加载一次即可)
                .showImageOnLoading(R.drawable.d) // 创建配置过得DisplayImageOption对象
                .build();
        ImageLoader.getInstance().displayImage(url, new ImageViewAware(viewHolder.mImageView, false), options);
        return convertView;
    }

    class ViewHolder {
        ImageView mImageView;
    }
}
