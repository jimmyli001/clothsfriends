package com.linktownld.adapter;

import java.util.ArrayList;
import java.util.List;

import com.linktownld.R;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
public class RecyclerCardHAdapter  extends RecyclerView.Adapter<SimpleCardViewHHolder>{
 
    private Context mCtx;
    private LayoutInflater mInflater;
    private final List<String> mDataSource = new ArrayList<String>(); 
     
    public RecyclerCardHAdapter(Context mCtx, List<String> dataList) {
        super();
        this.mCtx = mCtx;
        mInflater = LayoutInflater.from(mCtx);
        this.mDataSource.addAll(dataList);
    }
    @Override
    public int getItemCount() {
        return mDataSource.size();
    }
    @Override
    public void onBindViewHolder(SimpleCardViewHHolder viewHolder, int i) {
        viewHolder.itemTv.setText(mDataSource.get(i));
            viewHolder.itemIv.setBackgroundResource(R.drawable.img_1);
    }
    @Override
    public SimpleCardViewHHolder onCreateViewHolder(ViewGroup viewgroup, int i) {
         
        View v =  mInflater.inflate(R.layout.item_recyclerview_h_main, viewgroup,false);
        SimpleCardViewHHolder simpleViewHolder = new SimpleCardViewHHolder(v);
        simpleViewHolder.setIsRecyclable(true);
         
        return simpleViewHolder;
    }
}
 
class SimpleCardViewHHolder extends ViewHolder
{
    public TextView itemTv;
    public ImageView itemIv;
 
    public SimpleCardViewHHolder(View layout) {
        super(layout);
        itemTv = (TextView) layout.findViewById(R.id.item_title_h);
        itemIv = (ImageView) layout.findViewById(R.id.item_img_h);
    }
}