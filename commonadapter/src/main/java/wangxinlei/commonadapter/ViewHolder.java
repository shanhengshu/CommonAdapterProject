package main.java.wangxinlei.commonadapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by wangxl on 2015/5/4.
 */
public class ViewHolder {
    // 上下文路径
    private Context context;
    // 位置
    private int position;
    // 单元View
    private View convertView;
    // 控件集合
    private SparseArray<View> views;

    /**
     * 构造方法
     * @param context 上下文
     * @param layoutId 布局id
     * @param position Index
     * @param parent 父布局
     */
    private ViewHolder(Context context, int layoutId,
                       int position, ViewGroup parent) {
        this.context = context;
        this.position = position;
        views = new SparseArray<View>();
        this.convertView = LayoutInflater.from(this.context).inflate(layoutId, null);
        convertView.setTag(this);
    }

    /**
     * 获取ViewHolder
     * @param context 上下文
     * @param layoutId 布局文件id
     * @param position Index
     * @param convertView 单元View
     * @param parent 父布局
     * @return ViewHolder
     */
    public static ViewHolder getViewHolder(Context context, int layoutId,
                                    int position, View convertView,
                                    ViewGroup parent){
        ViewHolder holder = null;
        if (convertView == null){
            holder = new ViewHolder(context, layoutId, position, parent);
        } else {
            holder = (ViewHolder) convertView.getTag();
            holder.position = position;
        }
        return holder;
    }

    /**
     * 获取单元View
     * @return
     */
    public View getConvertView() {
        return convertView;
    }

    /**
     * 根据id获取控件
     * @param id 控件id
     * @param <T> 控件类型
     * @return 控件
     */
    public <T extends View> T getViewById(int id) {
        View view = views.get(id);
        if (view == null) {
            view = convertView.findViewById(id);
            views.put(id, view);
        }
        return (T) view;
    }

    /**
     * 根据id设置TextView的文字
     * @param viewId TextView的id
     * @param text 文字列
     * @return
     */
    public ViewHolder setText(int viewId, String text){
        ((TextView)getViewById(viewId)).setText(text);
        return this;
    }
}