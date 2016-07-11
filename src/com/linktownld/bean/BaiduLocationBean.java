package com.linktownld.bean;


public class BaiduLocationBean extends BaseBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String lng;
	private String lat;
	private String city;
	private String addrStr;

	public String getAddrStr() {
		return addrStr;
	}

	public void setAddrStr(String addrStr) {
		this.addrStr = addrStr;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "BaiduLocationInfo [lng=" + lng + ", lat=" + lat + ", city=" + city + "]";
	}

}
