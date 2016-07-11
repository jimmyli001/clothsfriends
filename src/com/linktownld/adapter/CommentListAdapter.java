package com.linktownld.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.linktownld.R;
import com.linktownld.view.RoundImageView;

public class CommentListAdapter extends BaseItemAdapter<Object> {

	int i = 0;
	boolean isChoice=false;

	public CommentListAdapter(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder mViewHolder;
		if (null == convertView) {
			mViewHolder = new ViewHolder();
			convertView = LayoutInflater.from(getContext()).inflate(
					R.layout.item_comment_list, null);
			mViewHolder.riv_scene_comment_avatar = (RoundImageView) convertView
					.findViewById(R.id.riv_scene_comment_avatar);
			mViewHolder.img_comment_like = (ImageView) convertView
					.findViewById(R.id.img_comment_like);
			mViewHolder.tv_comment_nickname = (TextView) convertView
					.findViewById(R.id.tv_comment_nickname);
			mViewHolder.tv_comment_time = (TextView) convertView
					.findViewById(R.id.tv_comment_time);
			mViewHolder.tv_comment_like_num = (TextView) convertView
					.findViewById(R.id.tv_comment_like_num);
			mViewHolder.tv_comment_content = (TextView) convertView
					.findViewById(R.id.tv_comment_content);
			convertView.setTag(mViewHolder);
		} else {
			mViewHolder = (ViewHolder) convertView.getTag();
		}

		mViewHolder.img_comment_like.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if(isChoice){
					mViewHolder.img_comment_like.setImageResource(R.drawable.heart1);
					isChoice=false;
				}else{
					mViewHolder.img_comment_like.setImageResource(R.drawable.heart);
					isChoice=true;
				}
			}
		});
		// 这里赋值
//		imageLoader.displayImage(R.drawable.avatar1, mViewHolder.riv_scene_comment_avatar,
//				AvarOptions);
		return convertView;
	}

	class ViewHolder {
		RoundImageView riv_scene_comment_avatar;
		TextView tv_comment_nickname;
		TextView tv_comment_time;
		TextView tv_comment_like_num;
		TextView tv_comment_content;
		ImageView img_comment_like;
	}

}
