package com.linktownld.activity;

import com.linktownld.R;
import com.linktownld.adapter.CommentListAdapter;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

/**
 * 评论列表(查看和发表评论)界面
 * @author yang.zhou
 *
 */

public class CommentListActivity extends BaseActivity{

	private TextView tv_title_name;
	private TextView tv_title_right;
	private ListView lv_comment_listview;
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_comment_list);
		initView();
		initAdapter();
	}

	private void initAdapter() {
		CommentListAdapter commentListAdapter = new CommentListAdapter(mContext);
		lv_comment_listview.setAdapter(commentListAdapter);
	}

	private void initView() {
		tv_title_name = (TextView) findViewById(R.id.tv_title_name);
		tv_title_right = (TextView) findViewById(R.id.tv_title_right);
		lv_comment_listview = (ListView) findViewById(R.id.lv_comment_listview);
		tv_title_name.setText("评论列表");
		tv_title_right.setVisibility(View.GONE);
	}
}
