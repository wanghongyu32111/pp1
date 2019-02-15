package com.example.media2.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.media2.R;

import java.util.List;

public class ProductAdpter extends RecyclerView.Adapter<ProductAdpter.ViewHold> {
    List<String> pList;
    Context context;
    public ProductAdpter(List<String> list , Context context){
        this.pList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.p_recy_item , null);
        return new ViewHold(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHold holder, final int position) {
        holder.textView.setText(pList.get(position));
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context , "我是第 " + position , Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        if(pList == null){
            return 0;
        }
        return pList.size();
    }


    class ViewHold extends RecyclerView.ViewHolder {
        TextView textView ;
        public ViewHold(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_recy_item_id);
        }
    }
}
