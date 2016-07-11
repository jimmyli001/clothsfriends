package com.linktownld.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.linktownld.R;
import com.linktownld.application.BaseApplication;
import com.linktownld.http.impl.AppActionImpl;
import com.linktownld.http.interfaces.AppAction;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

public class BaseFragment extends Fragment {
	// 上下文实例
	public Context mContext;
	// 应用全局的实例
	public BaseApplication application;
	// 核心层的Action实例
	public AppAction appAction;

	protected ImageLoader imageLoader;

	protected DisplayImageOptions ListOptions; // DisplayImageOptions是用于设置列表图片显示的类
	protected DisplayImageOptions AvarOptions; // DisplayImageOptions是用于设置头像图片显示的类

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mContext = getActivity();
		application = (BaseApplication) getActivity().getApplication();
		appAction = AppActionImpl.getAppActionInstance(mContext);
		initImageLoader();
	}

	private void initImageLoader() {
		if (imageLoader == null) {
			imageLoader = ImageLoader.getInstance();
		}
		if (null == ListOptions) {
			// 使用DisplayImageOptions.Builder()创建DisplayImageOptions
			ListOptions = new DisplayImageOptions.Builder().showImageForEmptyUri(R.drawable.ic_default_list) // 设置图片Uri为空或是错误的时候显示的图片
					.showImageOnFail(R.drawable.ic_default_list) // 设置图片加载或解码过程中发生错误显示的图片
					.cacheInMemory(true) // 设置下载的图片是否缓存在内存中
					.cacheOnDisc(true) // 设置下载的图片是否缓存在SD卡中
					// .displayer(new RoundedBitmapDisplayer(10)) // 设置成圆角图片
					.bitmapConfig(Bitmap.Config.RGB_565).build(); // 创建配置过得DisplayImageOption对象
		}
		if (null == AvarOptions) {
			AvarOptions = new DisplayImageOptions.Builder().showImageForEmptyUri(R.drawable.ic_default_avatar) // 设置图片Uri为空或是错误的时候显示的图片
					.showImageOnFail(R.drawable.ic_default_avatar) // 设置图片加载或解码过程中发生错误显示的图片
					.cacheInMemory(true) // 设置下载的图片是否缓存在内存中
					.cacheOnDisc(true) // 设置下载的图片是否缓存在SD卡中
					// .displayer(new RoundedBitmapDisplayer(10)) // 设置成圆角图片
					.bitmapConfig(Bitmap.Config.RGB_565).build(); // 创建配置过得DisplayImageOption对象
		}
	}
}
