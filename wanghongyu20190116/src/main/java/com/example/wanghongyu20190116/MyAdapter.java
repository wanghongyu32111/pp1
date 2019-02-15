package com.example.wanghongyu20190116;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    private ArrayList<Json.ResultBean> list=new ArrayList<Json.ResultBean>();
    private Context context;

    public MyAdapter(ArrayList<Json.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @Override
    public int getViewTypeCount() {
        return 2;
    }
    @Override
    public int getItemViewType(int position) {
        return position % 2;
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
        int itemViewType = getItemViewType(position);
        switch (itemViewType){
            case 0:
            Holder Holder=new Holder();
            if (convertView==null){
                convertView= View.inflate(context,R.layout.item,null);
                Holder.text1= convertView.findViewById(R.id.text1);
                Holder.image1= convertView.findViewById(R.id.image1);

                convertView.setTag(Holder);
            }else{
                Holder=(Holder) convertView.getTag();
            }
            Holder.text1.setText(list.get(position).getSummary());
              ImageLoader.getInstance().displayImage(list.get(position).getImageUrl(),Holder.image1);
            break;

            case 1:
                Holder1 Holder1=new Holder1();
                if (convertView==null){
                    convertView= View.inflate(context,R.layout.item1,null);
                    Holder1.text2 = convertView.findViewById(R.id.text2);
                    convertView.setTag(Holder1);
                }else{
                    Holder1=(Holder1) convertView.getTag();
                }
                Holder1.text2.setText(list.get(position).getSummary());
                break;

        }



        return convertView;
    }
    class Holder{
        TextView text1;
        ImageView image1;
    }
    class Holder1{
        TextView text2;
    }
}
