package com.linktownld.http.impl;

import com.alibaba.fastjson.JSONObject;
import com.linktownld.bean.UserBean;
import com.linktownld.constant.ErrorEvent;
import com.linktownld.http.callback.ActionCallbackListener;
import com.linktownld.http.interfaces.Api;
import com.linktownld.http.interfaces.AppAction;
import com.linktownld.http.response.ApiResponse;
import com.linktownld.utils.CommonUtils;
import com.linktownld.view.dialog.CustomProgressDialog;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Looper;

/**
 * 业务相关接口实现类
 * 
 * @author LBS778
 *
 */
public class AppActionImpl implements AppAction {

	private final static int PAGE_SIZE = 10; // 默认每页10条

	private Context context;
	private Api api;
	private static AppActionImpl appActionImpl;

	protected CustomProgressDialog progressDialog = null;

	public static AppActionImpl getAppActionInstance(Context context) {
		if (appActionImpl == null) {
			appActionImpl = new AppActionImpl(context);
		}
		return appActionImpl;

	}

	public AppActionImpl(Context context) {
		this.context = context;
		this.api = new ApiImpl(context);
	}

	@Override
	public void login(final String loginName, final String password, final ActionCallbackListener<UserBean> listener) {
		// 参数为空检查
		if (CommonUtils.isEmpty(loginName)) {
			if (listener != null) {
				listener.onFailure(ErrorEvent.PARAM_NULL, "登录名为空");
			}
			return;
		}
		if (CommonUtils.isEmpty(password)) {
			if (listener != null) {
				listener.onFailure(ErrorEvent.PARAM_NULL, "密码为空");
			}
			return;
		}
		// TODO 添加缓存
		showLoadingView();
		// 请求Api
		new AsyncTask<Void, Void, ApiResponse>() {
			@Override
			protected ApiResponse doInBackground(Void... params) {
				return api.loginByApp(loginName, password);
			}

			@Override
			protected void onPostExecute(ApiResponse response) {
				dismissLoadingView();
				if (listener != null && response != null) {
					if (response.is_success()) {
						listener.onSuccess(JSONObject.parseObject(response.getData(), UserBean.class));
					} else {
						listener.onFailure(response.getStatus(), response.getMsg());
					}
				}
			}

		}.execute();
	
	}

	/**
	 * 显示加载框
	 */
	protected void showLoadingView() {
		if (progressDialog == null) {
			progressDialog = CustomProgressDialog.createDialog(context);
		}
		progressDialog.show();

	}

	/**
	 * 显示不关闭的加载框
	 */
	protected void shownodisLoadingView() {
		if (progressDialog == null) {
			progressDialog = CustomProgressDialog.createDialog(context);
		}
		progressDialog.setCancelable(false);
		progressDialog.show();
	}

	/**
	 * 隐藏加载框
	 */
	protected void dismissLoadingView() {
		if (progressDialog != null && progressDialog.isShowing()) {
			progressDialog.dismiss();
		}
		progressDialog = null;
	}

}
