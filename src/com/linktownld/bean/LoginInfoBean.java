package com.linktownld.bean;

/**
 * 用戶保存的用戶名以及密码
 * 
 * @author LBS778
 *
 */
public class LoginInfoBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userPhone;
	private String verCode;

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getVerCode() {
		return verCode;
	}

	public void setVerCode(String verCode) {
		this.verCode = verCode;
	}

}
