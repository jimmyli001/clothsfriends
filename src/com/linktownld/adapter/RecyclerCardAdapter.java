package com.linktownld.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.linktownld.R;
public class RecyclerCardAdapter  extends RecyclerView.Adapter<SimpleCardViewHolder>{
 
    private Context mCtx;
    private LayoutInflater mInflater;
    private final List<String> mDataSource = new ArrayList<String>(); 
     
    public RecyclerCardAdapter(Context mCtx, List<String> dataList) {
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
    public void onBindViewHolder(SimpleCardViewHolder viewHolder, int i) {
        viewHolder.itemTv.setText(mDataSource.get(i));
//        int resId = mCtx.getResources().getIdentifier("img_"+i, 
//        		"drawable", 
//        		mCtx.getPackageName());
//        System.out.println(mCtx.getPackageName());
//        if(resId!=0)
//        {
            viewHolder.itemIv.setBackgroundResource(R.drawable.img_1);
//        }
    }
    @Override
    public SimpleCardViewHolder onCreateViewHolder(ViewGroup viewgroup, int i) {
         
        View v =  mInflater.inflate(R.layout.item_recyclerview_main, viewgroup,false);
        SimpleCardViewHolder simpleViewHolder = new SimpleCardViewHolder(v);
        simpleViewHolder.setIsRecyclable(true);
         
        return simpleViewHolder;
    }
}
 
class SimpleCardViewHolder extends ViewHolder
{
    public TextView itemTv;
    public ImageView itemIv;
 
    public SimpleCardViewHolder(View layout) {
        super(layout);
        itemTv = (TextView) layout.findViewById(R.id.item_title);
        itemIv = (ImageView) layout.findViewById(R.id.item_img);
    }
}