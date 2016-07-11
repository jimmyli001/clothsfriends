package com.linktownld.bean;

/**
 * 用户所以信息
 * 
 * @author LBS778
 *
 */
public class UserBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Profilebean profile;
	private String token;
	private boolean isFirstLogin;
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getIsFirstLogin() {
		return isFirstLogin;
	}

	public void setIsFirstLogin(boolean isFirstLogin) {
		this.isFirstLogin = isFirstLogin;
	}

	public Profilebean getProfile() {
		return profile;
	}

	public void setProfile(Profilebean profile) {
		this.profile = profile;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "UserBean [profile=" + profile + ", token=" + token + "]";
	}

}
