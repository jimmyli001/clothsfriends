package com.linktownld.activity.palceorder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.linktownld.R;
import com.linktownld.activity.BaseActivity;
import com.linktownld.activity.SelectGoodsActivity;

/**
 * 下单 （选择地点，时间）界面 
 * @author lin.li
 *
 */
public class PaceOrderByAdressActivity extends BaseActivity implements OnClickListener{
	
	private TextView tv_title_name;
	private TextView tv_title_right;
	
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.activity_place_order_adress);
		initView();
	}

	private void initView() {
		tv_title_name = (TextView) findViewById(R.id.tv_title_name);
		tv_title_right = (TextView) findViewById(R.id.tv_title_right);
		tv_title_name.setText("选择服务地点＆时间");
		tv_title_right.setText("下一步");
		tv_title_right.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.tv_title_right:
			startActivity(new Intent(mContext, SelectGoodsActivity.class));
			break;

		default:
			break;
		}
	}

}
