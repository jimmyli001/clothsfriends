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

public class HomeFriendListAdapter extends BaseItemAdapter<Object> {

	boolean isNotice;
	
	public HomeFriendListAdapter(Context context) {
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
					R.layout.item_home_friend, null);
			mViewHolder.tv_friend_nickname = (TextView) convertView
					.findViewById(R.id.tv_friend_nickname);
			mViewHolder.tv_friend_message = (TextView) convertView
					.findViewById(R.id.tv_friend_message);
			mViewHolder.tv_friend_describe = (TextView) convertView
					.findViewById(R.id.tv_friend_describe);
			mViewHolder.tv_friend_fans = (TextView) convertView
					.findViewById(R.id.tv_friend_fans);
			mViewHolder.tv_friend_notice = (TextView) convertView
					.findViewById(R.id.tv_friend_notice);
			mViewHolder.rimg_avatar = (RoundImageView) convertView.findViewById(R.id.rimg_avatar);
			convertView.setTag(mViewHolder);
		} else {
			mViewHolder = (ViewHolder) convertView.getTag();
		}
		// 这里赋值
		mViewHolder.tv_friend_notice.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if(isNotice){
					mViewHolder.tv_friend_notice.setBackgroundResource(R.drawable.bg_scene_join);
					mViewHolder.tv_friend_notice.setText("+关注");
					isNotice = false;
				}else{
					mViewHolder.tv_friend_notice.setBackgroundResource(R.drawable.bg_scene_cancle_join);
					mViewHolder.tv_friend_notice.setText("取消关注");
					mViewHolder.tv_friend_notice.setText("+关注");
					isNotice = true;
				}
			}
		});
		return convertView;
	}

	class ViewHolder {
		TextView tv_friend_nickname;
		TextView tv_friend_message;
		TextView tv_friend_describe;
		TextView tv_friend_fans;
		com.linktownld.view.RoundImageView rimg_avatar;
		TextView tv_friend_notice;
	}

}
