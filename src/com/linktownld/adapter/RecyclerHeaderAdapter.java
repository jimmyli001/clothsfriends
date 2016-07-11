package com.linktownld.adapter;

import java.util.ArrayList;
import java.util.List;

import com.linktownld.R;
import com.linktownld.bean.RecyclerBean;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
public class RecyclerHeaderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
	private List<RecyclerBean> list;

public void RecycleAdapter(List<RecyclerBean> list) {
	this.list = list;

}

@Override
public int getItemCount() {
	return list.isEmpty() ? 0 : list.size();
}

@SuppressLint("InflateParams")
@Override
public ViewHolder onCreateViewHolder(ViewGroup parent, int arg1) {
	View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_main, null);
	ViewHolder vh = new ViewHolder(view);

	vh.recycler_item_image = (ImageView) view.findViewById(R.id.item_img);
	vh.recycler_item_name = (TextView) view.findViewById(R.id.item_title);

	return vh;
}

/** 
* 设置值 
*/
public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
	final RecyclerBean rc = list.get(i);
	viewHolder.recycler_item_image.setImageResource(rc.getImageId());
	viewHolder.recycler_item_name.setText(rc.getTitle());
}

static class ViewHolder extends RecyclerView.ViewHolder {

	private ImageView recycler_item_image;
	private TextView recycler_item_name;

	public ViewHolder(View itemView) {
		super(itemView);
	}
}

@Override
public void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder arg0, int arg1) {
	// TODO Auto-generated method stub
	
}


}
 
