package com.linktownld.bean;

public class Profilebean extends BaseBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	private Long createTime;
	private int id;
	private boolean isActive;
	private boolean isDeleted;
	private String nickname;
	private String sex;
	private int userId;
	private String avatar;
	private String birthday;
	private double height;
	private int city_id;
	private String signature;
	private String reserve1;
	private String reserve2;
	private String reserve3;
	private String reserve4;
	private String reserve5;
	private String zodiac;

	public String getZodiac() {
		return zodiac;
	}

	public void setZodiac(String zodiac) {
		this.zodiac = zodiac;
	}

	public String getReserve1() {
		return reserve1;
	}

	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1;
	}

	public String getReserve2() {
		return reserve2;
	}

	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2;
	}

	public String getReserve3() {
		return reserve3;
	}

	public void setReserve3(String reserve3) {
		this.reserve3 = reserve3;
	}

	public String getReserve4() {
		return reserve4;
	}

	public void setReserve4(String reserve4) {
		this.reserve4 = reserve4;
	}

	public String getReserve5() {
		return reserve5;
	}

	public void setReserve5(String reserve5) {
		this.reserve5 = reserve5;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getCity_id() {
		return city_id;
	}

	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Profilebean [code=" + code + ", createTime=" + createTime + ", id=" + id + ", isActive=" + isActive
				+ ", isDeleted=" + isDeleted + ", nickname=" + nickname + ", sex=" + sex + ", userId=" + userId
				+ ", avatar=" + avatar + ", birthday=" + birthday + ", height=" + height + ", city_id=" + city_id
				+ ", signature=" + signature + ", reserve1=" + reserve1 + ", reserve2=" + reserve2 + ", reserve3="
				+ reserve3 + ", reserve4=" + reserve4 + ", reserve5=" + reserve5 + ", zodiac=" + zodiac + "]";
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

}
// "reserve4": "0",
// "reserve5": "{bankname=\"上海银行\"，name=\"李林\",cardid=\"111111\"}",
