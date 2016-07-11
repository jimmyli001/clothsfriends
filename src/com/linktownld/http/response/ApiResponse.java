package com.linktownld.http.response;

import java.io.Serializable;

/**
 * 接收 网络请求的 Response 返回 类
 * 
 * @author LBS778
 *
 */
public class ApiResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 表示 最外层的判断（例如：无网络，服务器请求失败等）
	 */
	private boolean success;
	/**
	 * 表示 错误的原因
	 */
	private String msg;
	/**
	 * 表示 具体的 业务返回（返回的具体实体）
	 */
	private String data;
	/**
	 * 表示 具体业务的状态码（0为 成功）
	 */
	private String status;

	public ApiResponse() {
	}

	public ApiResponse(boolean success, String data, String msg) {
		this.success = success;
		this.msg = msg;
		this.data = data;

	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	/**
	 * 判断是否网络请求成功
	 * 
	 * @return
	 * 
	 */

	public boolean is_success() {
		if (status != null) {
			return success && status.equals("0");
		} else {
			return false;
		}

	}
}
