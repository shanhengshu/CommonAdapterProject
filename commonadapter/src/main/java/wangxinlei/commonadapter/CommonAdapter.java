package main.java.wangxinlei.commonadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by wangxl on 2015/5/4.
 */
public abstract class CommonAdapter<T> extends BaseAdapter {
    // 上下文
    protected Context context;
    // 数据集合
    protected List<T> datas;
    // 布局文件id
    private int layoutId;

    /**
     * 构造方法
     * @param context 上下文
     * @param datas 数据集合
     * @param layoutId 布局文件
     */
    public CommonAdapter(Context context, List<T> datas, int layoutId) {
        this.context = context;
        this.datas = datas;
        this.layoutId = layoutId;
    }

    @Override
    public int getCount() {
        if (datas != null) return datas.size();
        return 0;
    }

    @Override
    public T getItem(int position) {
        if (datas != null) return datas.get(position);
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.getViewHolder(
                context, layoutId, position, convertView, parent);
        initView(holder, getItem(position));
        return holder.getConvertView();
    }

    public abstract void initView(ViewHolder holder, T t);
}
