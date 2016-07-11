package com.linktownld.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.linktownld.http.OKHttpManger;
import com.linktownld.http.response.ApiResponse;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.provider.Settings;
import android.util.Log;

/**
 * 网络层 工具类
 * 
 * @author LBS778
 *
 */
public class NetworkUtils {

	private final static String TIME_OUT_EVENT = "CONNECT_TIME_OUT";
	private final static String TIME_OUT_EVENT_MSG = "连接服务器失败";

	/**
	 * 是否有可用的网络连接.
	 *
	 * @param context
	 * @return
	 */
	public static boolean isNetworkAvailable(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		String action = ConnectivityManager.CONNECTIVITY_ACTION;
		if (cm.getActiveNetworkInfo() != null) {
			return cm.getActiveNetworkInfo().isAvailable();
		}
		return false;
	}

	/**
	 * 获取wifi状态
	 *
	 * @param context
	 */
	public static State getWifiState(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		// wifi
		State wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();
		return wifi;
	}

	/**
	 * 获取移动网络状态
	 *
	 * @param context
	 * @return
	 */
	public static State getMobileState(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		// mobile 3G Data Network
		State mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState();
		return mobile;
	}

	/**
	 * 打开系统的网络设置页面
	 *
	 * @param activity
	 */
	public static void openNetworkSettings(Activity activity) {
		activity.startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS));
	}

	/**
	 * 判断当前的网络是否连接
	 *
	 * @param activity
	 * @return
	 */
	public static boolean isNetworkAvailable_(Activity activity) {
		ConnectivityManager cm = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = cm.getActiveNetworkInfo();
		// if no network is available networkInfo will be null
		// otherwise check if we are connected
		if (networkInfo != null && networkInfo.isConnected()) {
			return true;
		}
		return false;
	}

	/**
	 * 通用返回 map get 请求
	 * 
	 * @param url
	 * @param paramMap
	 * @return
	 */

	public static ApiResponse BaseHttpForGet(Context mContext, String url, Map<String, String> paramMap) {
		try {
			String reslut = OKHttpManger.doMapGet(mContext, url, paramMap);
			return JSONObject.parseObject(reslut, ApiResponse.class);
		} catch (Exception e) {
			e.printStackTrace();
			return new ApiResponse(false, TIME_OUT_EVENT, TIME_OUT_EVENT_MSG);
		}

	}

	/**
	 * 通用返回 file Post请求
	 * 
	 * @param url
	 * @param paramMap
	 * @param fileList
	 * @param FileName
	 * @return
	 */
	public static ApiResponse BaseHttpForFilePost(Context mContext, String url, Map<String, String> paramMap,
			ArrayList<File> fileList, String FileName) {
		try {
			return JSONObject.parseObject(OKHttpManger.doFilePost(mContext, url, paramMap, fileList, FileName),
					ApiResponse.class);
		} catch (Exception e) {
			return new ApiResponse(false, TIME_OUT_EVENT, TIME_OUT_EVENT_MSG);
		}

	}

	/**
	 * 通用返回 JSON Post请求
	 * 
	 * @param url
	 * @param paramMap
	 * @param JSONString
	 * @return
	 */
	public static ApiResponse BaseHttpForJSONPost(Context mContext, String url, Map<String, String> paramMap,
			String JSONString) {
		try {
			return JSONObject.parseObject(OKHttpManger.doJSONPost(mContext, url, JSONString), ApiResponse.class);
		} catch (Exception e) {
			return new ApiResponse(false, TIME_OUT_EVENT, TIME_OUT_EVENT_MSG);
		}

	}

	/**
	 * 通用返回 Map Post请求
	 * 
	 * @param url
	 * @param paramMap
	 * @return
	 */
	public static ApiResponse BaseHttpForMapPost(Context mContext, String url, Map<String, String> paramMap) {
		try {
			return JSONObject.parseObject(OKHttpManger.doMapPost(mContext, url, paramMap), ApiResponse.class);
		} catch (Exception e) {
			return new ApiResponse(false, TIME_OUT_EVENT, TIME_OUT_EVENT_MSG);
		}

	}
}
