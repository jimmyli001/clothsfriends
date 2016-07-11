package com.linktownld.http.impl;

import java.util.HashMap;
import java.util.Map;

import com.linktownld.http.interfaces.Api;
import com.linktownld.http.response.ApiResponse;
import com.linktownld.utils.AndroidUtil;
import com.linktownld.utils.ContentUtils;
import com.linktownld.utils.NetworkUtils;

import android.content.Context;

/**
 * 网络请求相关接口的实现类
 * 
 * @author LBS778
 *
 */
public class ApiImpl implements Api {

	private Context mContext;

	public ApiImpl(Context context) {
		mContext = context;
	}

	@Override
	public ApiResponse loginByApp(String loginName, String password) {
		String LoginURL = AndroidUtil.getNoKeyUrl("login/userlogin.do", mContext);
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("username", loginName);
		paramMap.put("password", password);
		String cid = ContentUtils.getPushCId(mContext);
		paramMap.put("getui", cid);
		return NetworkUtils.BaseHttpForGet(mContext, LoginURL, paramMap);
	}

}
