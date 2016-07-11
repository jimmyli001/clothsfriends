package com.linktownld.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.linktownld.R;

public class MyServiceListAdapter extends BaseItemAdapter<Object> {

	public MyServiceListAdapter(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder mViewHolder;
		if (null == convertView) {
			mViewHolder = new ViewHolder();
			convertView = LayoutInflater.from(getContext()).inflate(
					R.layout.item_my_listview, null);
			mViewHolder.ll_my_backpic = (LinearLayout) convertView
					.findViewById(R.id.ll_my_backpic);
			mViewHolder.tv_date = (TextView) convertView
					.findViewById(R.id.tv_date);
			mViewHolder.tv_pic_nums = (TextView) convertView
					.findViewById(R.id.tv_pic_nums);
			convertView.setTag(mViewHolder);
		} else {
			mViewHolder = (ViewHolder) convertView.getTag();
		}
		// 这里赋值
		return convertView;
	}

	class ViewHolder {
		LinearLayout ll_my_backpic;
		TextView tv_date;
		TextView tv_pic_nums;
	}

}
