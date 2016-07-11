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

public class SelectGoodsListAdapter extends BaseItemAdapter<Object> {

	int i = 0;

	public SelectGoodsListAdapter(Context context) {
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
					R.layout.item_select_goods, null);
			mViewHolder.img_selectgoods_item = (ImageView) convertView
					.findViewById(R.id.img_selectgoods_item);
			mViewHolder.img_selectgoods_plus = (ImageView) convertView
					.findViewById(R.id.img_selectgoods_plus);
			mViewHolder.img_selectgoods_minus = (ImageView) convertView
					.findViewById(R.id.img_selectgoods_minus);
			mViewHolder.tv_selectgoods_content = (TextView) convertView
					.findViewById(R.id.tv_selectgoods_content);
			mViewHolder.tv_goods_area = (TextView) convertView
					.findViewById(R.id.tv_goods_area);
			mViewHolder.tv_selectgoods_price = (TextView) convertView
					.findViewById(R.id.tv_selectgoods_price);
			mViewHolder.tv_selectgoods_price_decimal = (TextView) convertView
					.findViewById(R.id.tv_selectgoods_price_decimal);
			mViewHolder.tv_selectgoods_num = (TextView) convertView
					.findViewById(R.id.tv_selectgoods_num);
			mViewHolder.tv_shop_area = (TextView) convertView
					.findViewById(R.id.tv_shop_area);
			mViewHolder.ll_selectgoods_tags = (LinearLayout) convertView
					.findViewById(R.id.ll_selectgoods_tags);
			mViewHolder.ll_shop_content = (LinearLayout) convertView
					.findViewById(R.id.ll_shop_content);
			convertView.setTag(mViewHolder);
		} else {
			mViewHolder = (ViewHolder) convertView.getTag();
		}

		// 这里赋值
		// 购买数量增加
		mViewHolder.img_selectgoods_plus
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						if (mViewHolder.tv_selectgoods_num.getVisibility() == View.GONE) {
							mViewHolder.tv_selectgoods_num
									.setVisibility(View.VISIBLE);
							mViewHolder.img_selectgoods_minus
									.setVisibility(View.VISIBLE);
							mViewHolder.tv_selectgoods_num.setText(1 + "");
						} else if (mViewHolder.tv_selectgoods_num
								.getVisibility() == View.VISIBLE) {
							mViewHolder.tv_selectgoods_num.setText((Integer
									.parseInt(mViewHolder.tv_selectgoods_num
											.getText().toString()) + 1)
									+ "");
						}
					}
				});
		// 购买数量减少
		mViewHolder.img_selectgoods_minus
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						if (Integer.parseInt(mViewHolder.tv_selectgoods_num
								.getText().toString()) == View.GONE) {
							mViewHolder.tv_selectgoods_num
									.setVisibility(View.GONE);
							mViewHolder.img_selectgoods_minus
									.setVisibility(View.GONE);
						} else {
							if (Integer.parseInt(mViewHolder.tv_selectgoods_num
									.getText().toString()) > 1) {
								mViewHolder.tv_selectgoods_num.setText((Integer
										.parseInt(mViewHolder.tv_selectgoods_num
												.getText().toString()) - 1)
										+ "");
							} else {
								mViewHolder.img_selectgoods_minus
										.setVisibility(View.GONE);
								mViewHolder.tv_selectgoods_num
										.setVisibility(View.GONE);
							}

						}
					}
				});
		return convertView;
	}

	class ViewHolder {
		ImageView img_selectgoods_item;
		TextView tv_selectgoods_content;
		LinearLayout ll_selectgoods_tags;
		TextView tv_goods_area;
		TextView tv_selectgoods_price;
		TextView tv_selectgoods_price_decimal;
		TextView tv_selectgoods_num;
		ImageView img_selectgoods_plus;
		ImageView img_selectgoods_minus;
		LinearLayout ll_shop_content;
		TextView tv_shop_area;
	}

}
