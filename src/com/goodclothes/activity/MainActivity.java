package com.goodclothes.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.linktownld.R;
import com.linktownld.bean.UserBean;
import com.linktownld.fragment.CircleFragment;
import com.linktownld.fragment.HomePageFragment;
import com.linktownld.fragment.MessageFragment;
import com.linktownld.fragment.MineFragment;
import com.linktownld.http.callback.ActionCallbackListener;
import com.linktownld.utils.AndroidUtil;

//@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity implements OnClickListener {

	// 定义四个fragment
	private HomePageFragment homePageFragment;
	private CircleFragment circleFragment;
	private MessageFragment messageFragment;
	private MineFragment mineFragment;
	// 帧布局对象,就是用来存放Fragment的容器
	// private FrameLayout framelayout;
	// 底部导航栏
	private LinearLayout homePageTab;
	private LinearLayout circleTab;
	private LinearLayout messageTab;
	private LinearLayout mineTab;
	// 定义FragmentManager对象
	android.support.v4.app.FragmentManager fManager;
	private ImageView img_homepage;
	private ImageView img_found;
	private ImageView img_mine;
	private ImageView img_message;
	private TextView tv_homepage;
	private TextView tv_circle;
	private TextView tv_mine;
	private TextView tv_message;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		// fManager = getFragmentManager();
		fManager = getSupportFragmentManager();
		initView();
		setChioceItem(0);
		changeColor(0);
//		getData();
	}

	private void initView() {
		homePageTab = (LinearLayout) findViewById(R.id.ll_homepage);
		circleTab = (LinearLayout) findViewById(R.id.ll_circle);
		messageTab = (LinearLayout) findViewById(R.id.ll_message);
		mineTab = (LinearLayout) findViewById(R.id.ll_mine);
		img_homepage = (ImageView) findViewById(R.id.img_homepage);
		img_found = (ImageView) findViewById(R.id.img_circle);
		img_message = (ImageView) findViewById(R.id.img_message);
		img_mine = (ImageView) findViewById(R.id.img_mine);
		tv_homepage = (TextView) findViewById(R.id.tv_homepage);
		tv_circle = (TextView) findViewById(R.id.tv_circle);
		tv_message = (TextView) findViewById(R.id.tv_message);
		tv_mine = (TextView) findViewById(R.id.tv_mine);
		homePageTab.setOnClickListener(this);
		circleTab.setOnClickListener(this);
		messageTab.setOnClickListener(this);
		mineTab.setOnClickListener(this);
	}

	private void getData() {
		this.appAction.login("13817670943", "123333",
				new ActionCallbackListener<UserBean>() {

					@Override
					public void onSuccess(UserBean data) {
						AndroidUtil.TostMsg(mContext, data.getToken());
					}

					@Override
					public void onFailure(String errorEvent, String message) {
						AndroidUtil.TostMsg(mContext, message);
					}
				});
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.ll_homepage:
			setChioceItem(0);
			changeColor(0);
			break;
		case R.id.ll_circle:
			setChioceItem(1);
			changeColor(1);
			break;
		case R.id.ll_message:
			setChioceItem(2);
			changeColor(2);
			break;
		case R.id.ll_mine:
			setChioceItem(3);
			changeColor(3);
			break;
		default:
			break;
		}
	}

	// 定义一个选中一个item后的处理
	public void setChioceItem(int index) {
		// 重置选项+隐藏所有Fragment
		android.support.v4.app.FragmentTransaction transaction = fManager
				.beginTransaction();
		hideFragments(transaction);
		switch (index) {
		case 0:
			if (homePageFragment == null) {
				// 如果linkTownFragment为空，则创建一个并添加到界面上
				homePageFragment = new HomePageFragment();
				transaction.add(R.id.frameLayout_context, homePageFragment);
			} else {
				// 如果linkTownFragment不为空，则直接将它显示出来
				transaction.show(homePageFragment);
			}
			break;

		case 1:
			if (circleFragment == null) {
				// 如果serviceFragment为空，则创建一个并添加到界面上
				circleFragment = new CircleFragment();
				transaction.add(R.id.frameLayout_context, circleFragment);
			} else {
				// 如果serviceFragment不为空，则直接将它显示出来
				transaction.show(circleFragment);
			}
			break;

		case 2:
			if (messageFragment == null) {
				// 如果mineFragment为空，则创建一个并添加到界面上
				messageFragment = new MessageFragment();
				transaction.add(R.id.frameLayout_context, messageFragment);
			} else {
				// 如果mineFragment不为空，则直接将它显示出来
				transaction.show(mineFragment);
			}
			break;
		case 3:
			if (mineFragment == null) {
				// 如果mineFragment为空，则创建一个并添加到界面上
				mineFragment = new MineFragment();
				transaction.add(R.id.frameLayout_context, mineFragment);
			} else {
				// 如果mineFragment不为空，则直接将它显示出来
				transaction.show(mineFragment);
			}
			break;
		}
		transaction.commit();
	}

	private void changeColor(int i) {
		switch (i) {
		case 0:
			img_homepage.setImageResource(R.drawable.homepage_choose);
			img_found.setImageResource(R.drawable.globe);
			img_mine.setImageResource(R.drawable.mine);
			tv_homepage.setTextColor(getResources().getColor(
					R.color.bg_base_title));
			tv_circle.setTextColor(getResources()
					.getColor(R.color.color_999999));
			tv_message.setTextColor(getResources().getColor(
					R.color.color_999999));
			tv_mine.setTextColor(getResources().getColor(R.color.color_999999));
			break;
		case 1:
			img_homepage.setImageResource(R.drawable.homepage);
			img_found.setImageResource(R.drawable.globe_choose);
			img_mine.setImageResource(R.drawable.mine);
			tv_homepage.setTextColor(getResources().getColor(
					R.color.color_999999));
			tv_circle.setTextColor(getResources().getColor(
					R.color.bg_base_title));
			tv_message.setTextColor(getResources().getColor(
					R.color.color_999999));
			tv_mine.setTextColor(getResources().getColor(R.color.color_999999));
			break;
		case 2:
			img_homepage.setImageResource(R.drawable.homepage);
			img_found.setImageResource(R.drawable.globe);
			img_mine.setImageResource(R.drawable.mine_choose);
			tv_homepage.setTextColor(getResources().getColor(
					R.color.color_999999));
			tv_circle.setTextColor(getResources()
					.getColor(R.color.color_999999));
			tv_message.setTextColor(getResources().getColor(
					R.color.bg_base_title));
			tv_mine.setTextColor(getResources().getColor(R.color.color_999999));
			break;
		case 3:
			img_homepage.setImageResource(R.drawable.homepage);
			img_found.setImageResource(R.drawable.globe);
			img_mine.setImageResource(R.drawable.mine_choose);
			tv_homepage.setTextColor(getResources().getColor(
					R.color.color_999999));
			tv_circle.setTextColor(getResources()
					.getColor(R.color.color_999999));
			tv_message.setTextColor(getResources().getColor(
					R.color.color_999999));
			tv_mine.setTextColor(getResources().getColor(R.color.bg_base_title));
			break;

		default:
			break;
		}

	}

	// 隐藏所有的Fragment,避免fragment混乱
	private void hideFragments(
			android.support.v4.app.FragmentTransaction transaction) {
		if (homePageFragment != null) {
			transaction.hide(homePageFragment);
		}
		if (circleFragment != null) {
			transaction.hide(circleFragment);
		}
		if (messageFragment != null) {
			transaction.hide(messageFragment);
		}
		if (mineFragment != null) {
			transaction.hide(mineFragment);
		}
	}

}
