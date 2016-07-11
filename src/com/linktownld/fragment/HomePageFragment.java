package com.linktownld.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.linktownld.R;

public class HomePageFragment extends BaseFragment implements OnClickListener{
	public Context mContext;
	private TextView tv_home_notice;
	private TextView tv_home_found;
	private TextView tv_home_friend;
	private LinearLayout ll_home_title;
	private TextView tv_home_title1;
	private TextView tv_home_title2;
	
	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.frag_homepage, container, false);
		return view;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		tv_home_notice = (TextView) view.findViewById(R.id.tv_home_notice);
		tv_home_found = (TextView) view.findViewById(R.id.tv_home_found);
		tv_home_friend = (TextView) view.findViewById(R.id.tv_home_friend);
		tv_home_title1 = (TextView) view.findViewById(R.id.tv_home_title1);
		tv_home_title2 = (TextView) view.findViewById(R.id.tv_home_title2);
		ll_home_title = (LinearLayout) view.findViewById(R.id.ll_home_title);
		initEvent();
	}

	private void initEvent() {
		tv_home_notice.setTextColor(getResources().getColor(R.color.bg_base_title));
		tv_home_notice.setTextSize(16);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		tv_home_notice.setOnClickListener(this);
		tv_home_found.setOnClickListener(this);
		tv_home_friend.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.tv_home_notice:
			tv_home_notice.setTextColor(getResources().getColor(R.color.bg_base_title));
			tv_home_notice.setTextSize(16);
			tv_home_found.setTextColor(getResources().getColor(R.color.black));
			tv_home_found.setTextSize(14);
			tv_home_friend.setTextColor(getResources().getColor(R.color.black));
			tv_home_friend.setTextSize(14);
			ll_home_title.setVisibility(View.GONE);
			break;
		case R.id.tv_home_found:
			tv_home_notice.setTextColor(getResources().getColor(R.color.black));
			tv_home_notice.setTextSize(14);
			tv_home_found.setTextColor(getResources().getColor(R.color.bg_base_title));
			tv_home_found.setTextSize(16);
			tv_home_friend.setTextColor(getResources().getColor(R.color.black));
			tv_home_friend.setTextSize(14);
			ll_home_title.setVisibility(View.VISIBLE);
			tv_home_title1.setText("精选/");
			tv_home_title2.setText("RECOMMENDED");
			break;
		case R.id.tv_home_friend:
			tv_home_notice.setTextColor(getResources().getColor(R.color.black));
			tv_home_notice.setTextSize(14);
			tv_home_found.setTextColor(getResources().getColor(R.color.black));
			tv_home_found.setTextSize(14);
			tv_home_friend.setTextColor(getResources().getColor(R.color.bg_base_title));
			tv_home_friend.setTextSize(16);
			ll_home_title.setVisibility(View.VISIBLE);
			tv_home_title1.setText("推荐关注/");
			tv_home_title2.setText("FOLLOW");
			break;

		default:
			break;
		}
	}

}
