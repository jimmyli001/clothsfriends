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
import com.linktownld.view.RoundImageView;

public class HomeFoundListAdapter extends BaseItemAdapter<Object> {

	public HomeFoundListAdapter(Context context) {
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
					R.layout.item_home_follow, null);
			mViewHolder.ll_home_backpic = (LinearLayout) convertView
					.findViewById(R.id.ll_home_backpic);
			mViewHolder.tv_nickname = (TextView) convertView
					.findViewById(R.id.tv_nickname);
			mViewHolder.tv_content = (TextView) convertView
					.findViewById(R.id.tv_content);
			mViewHolder.tv_time = (TextView) convertView
					.findViewById(R.id.tv_time);
			mViewHolder.tv_pic_nums = (TextView) convertView
					.findViewById(R.id.tv_pic_nums);
			mViewHolder.tv_num1 = (TextView) convertView
					.findViewById(R.id.tv_num1);
			mViewHolder.tv_num2 = (TextView) convertView
					.findViewById(R.id.tv_num2);
			mViewHolder.tv_num3 = (TextView) convertView
					.findViewById(R.id.tv_num3);
			mViewHolder.img1 = (ImageView) convertView.findViewById(R.id.img1);
			mViewHolder.img2 = (ImageView) convertView.findViewById(R.id.img2);
			mViewHolder.img3 = (ImageView) convertView.findViewById(R.id.img3);
			mViewHolder.rimg_home_avatar = (RoundImageView) convertView.findViewById(R.id.rimg_home_avatar);
			convertView.setTag(mViewHolder);
		} else {
			mViewHolder = (ViewHolder) convertView.getTag();
		}
		// 这里赋值
		mViewHolder.tv_time.setText("1234粉丝");
		return convertView;
	}

	class ViewHolder {
		LinearLayout ll_home_backpic;
		TextView tv_nickname;
		TextView tv_content;
		TextView tv_time;
		TextView tv_pic_nums;
		com.linktownld.view.RoundImageView rimg_home_avatar;
		ImageView img1;
		ImageView img2;
		ImageView img3;
		TextView tv_num1;
		TextView tv_num2;
		TextView tv_num3;
	}

}
