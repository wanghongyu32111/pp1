package com.example.media2.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.media2.R;
import com.example.media2.bean.ProductEs;

import java.util.List;

public class DetileProductAdpter extends RecyclerView.Adapter<DetileProductAdpter.ViewHodel>{

    Context context ;
    List<ProductEs.ResultEs> resultEs;
    public DetileProductAdpter(List<ProductEs.ResultEs> resultEs){
        this.resultEs = resultEs;
    }
    @NonNull
    @Override
    public ViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.detile_product_adpter_item ,null);
        return new ViewHodel(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodel holder, int position) {
        holder.text.setText(resultEs.get(position).title);
        String imagUrl = resultEs.get(position).imageUrl;
        Glide.with(context).load(imagUrl).placeholder(R.drawable.product_icon).error(R.drawable.product_icon).into(holder.image);
    }

    @Override
    public int getItemCount() {
        if(resultEs == null){
            return 0;
        }
        return resultEs.size();
    }

    public class ViewHodel extends RecyclerView.ViewHolder{

        TextView text;
        ImageView image;

        public ViewHodel(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.detitle_product_textview_id);
            image = itemView.findViewById(R.id.detitle_product_iamgview_id);
        }
    }
}
