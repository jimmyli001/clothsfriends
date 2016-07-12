package com.goodclothes.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.linktownld.R;
import com.linktownld.adapter.MyServiceListAdapter;

/**
 * 我的服务（加入场景，发布服务）界面
 * @author yang.zhou
 *
 */

public class MyServiceListAvtivity extends BaseActivity {

	private TextView tv_title_name;
	private TextView tv_title_right;
	private ListView lv_myservice_list;
	private LinearLayout ll_myservice_nocontent;
	private boolean isNull =false;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_myservice_list);
		initView();
		initData();
		initAdapter();
	}

	private void initAdapter() {
		MyServiceListAdapter myServiceAdapter = new MyServiceListAdapter(mContext);
		lv_myservice_list.setAdapter(myServiceAdapter);
	}

	private void initView() {
		tv_title_name = (TextView) findViewById(R.id.tv_title_name);
		tv_title_right = (TextView) findViewById(R.id.tv_title_right);
		lv_myservice_list = (ListView) findViewById(R.id.lv_myservice_list);
		ll_myservice_nocontent = (LinearLayout) findViewById(R.id.ll_myservice_nocontent);
		tv_title_name.setText("我的服务");
		tv_title_right.setText("保存");
	}

	private void initData() {
		if (isNull) {
			lv_myservice_list.setVisibility(View.GONE);
			ll_myservice_nocontent.setVisibility(View.VISIBLE);
		} else {
			lv_myservice_list.setVisibility(View.VISIBLE);
			ll_myservice_nocontent.setVisibility(View.GONE);
			
		}
	}

}
