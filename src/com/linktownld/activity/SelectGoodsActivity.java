package com.linktownld.activity;


import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.linktownld.R;
import com.linktownld.adapter.SelectGoodsListAdapter;
/**
 * 选择商品界面
 * @author yang.zhou
 *
 */
public class SelectGoodsActivity extends BaseActivity{

	private TextView tv_title_name;
	private TextView tv_title_right;
	private TextView tv_buy_goods_price;
	private TextView tv_buy_goods_next;
	private TextView tv_select_num;
	private ListView lv_select_goods_list;
	private LinearLayout ll_select_goods_nocontent;
	private boolean isNull=false;
	private SelectGoodsListAdapter selectGoodsListAdapter;
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_select_goods);
		initView();
		initEvent();
		initAdapter();
	}

	private void initAdapter() {
		selectGoodsListAdapter = new SelectGoodsListAdapter(mContext);
		lv_select_goods_list.setAdapter(selectGoodsListAdapter);
	}

	private void initView() {
		tv_title_name = (TextView) findViewById(R.id.tv_title_name);
		tv_title_right = (TextView) findViewById(R.id.tv_title_right);
		tv_buy_goods_price = (TextView) findViewById(R.id.tv_buy_goods_price);
		tv_buy_goods_next = (TextView) findViewById(R.id.tv_buy_goods_next);
		lv_select_goods_list = (ListView) findViewById(R.id.lv_select_goods_list);
		tv_select_num = (TextView) findViewById(R.id.tv_select_num);
		ll_select_goods_nocontent = (LinearLayout) findViewById(R.id.ll_select_goods_nocontent);
		tv_title_name.setText("选择商品");
		tv_title_right.setVisibility(View.GONE);
	}
	
	private void initEvent() {
		if(isNull){
			lv_select_goods_list.setVisibility(View.GONE);
			ll_select_goods_nocontent.setVisibility(View.VISIBLE);
			tv_buy_goods_price.setText("购物车是空的");
			tv_buy_goods_price.setTextColor(Color.parseColor("#BABABA"));
			tv_buy_goods_next.setBackgroundColor(Color.parseColor("#B2B2B2"));
		}else{
			lv_select_goods_list.setVisibility(View.VISIBLE);
			ll_select_goods_nocontent.setVisibility(View.GONE);
			tv_buy_goods_price.setText("￥ 1500.00");
			tv_buy_goods_price.setTextColor(Color.parseColor("#FE9653"));
			tv_buy_goods_next.setBackgroundColor(Color.parseColor("#EC584E"));
		}
	}

	
}
