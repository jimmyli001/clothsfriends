package com.linktownld.fragment;

import com.linktownld.R;
import com.linktownld.adapter.MyServiceListAdapter;
import com.linktownld.view.MyListView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MineFragment extends BaseFragment {
	
	private com.linktownld.view.MyListView   mlv_my_publish;
	
	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.frag_mine, container,false);
        return view;
	}
	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		mlv_my_publish = (MyListView) view.findViewById(R.id.mlv_my_publish);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		MyServiceListAdapter myServiceListAdapter = new MyServiceListAdapter(mContext);
		mlv_my_publish.setAdapter(myServiceListAdapter);
	}
}
