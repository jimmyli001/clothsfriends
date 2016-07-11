package com.linktownld.http.interfaces;

import com.linktownld.http.response.ApiResponse;

/**
 * 网络请求的接口
 * 
 * @author LBS778
 *
 */
public interface Api {

	/**
	 * 登录
	 *
	 * @param loginName
	 *            登录名（手机号）
	 * @param password
	 *            密码
	 */
	public ApiResponse loginByApp(String loginName, String password);

}
