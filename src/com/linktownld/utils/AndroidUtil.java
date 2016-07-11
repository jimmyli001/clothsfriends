package com.linktownld.utils;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

import com.linktownld.bean.BaiduLocationBean;
import com.linktownld.bean.UserBean;
import com.linktownld.constant.Constants;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * 安卓相关的util
 * 
 * @author LBS778
 *
 */
public class AndroidUtil {

	private static String isPublic = ":isPublic";

	/**
	 * 返回当前程序版本名
	 */
	public static String getAppVersionName(Context context) {
		String versionName = "";
		try {
			// ---get the package info---
			PackageManager pm = context.getPackageManager();
			PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
			versionName = pi.versionName;
			// versioncode = pi.versionCode;
			if (versionName == null || versionName.length() <= 0) {
				return "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return versionName;
	}

	/**
	 * Tost 的 简单方法
	 * 
	 * @param context
	 * @param msg
	 */
	public static void TostMsg(Context context, String msg) {
		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
	}

	/**
	 * 判断应用是否在前台
	 * 
	 * @param context
	 * @return
	 */
	public static boolean isAppRunOnForeground(Context context) {
		String packageName = context.getPackageName();
		ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
		List<RunningTaskInfo> tasksInfo = activityManager.getRunningTasks(1);
		if (tasksInfo.size() > 0) {
			if (packageName.equals(tasksInfo.get(0).topActivity.getPackageName())) {
				return true;
			}
		}
		return false;
	}

	public static String getKeyUrl(String url, String key, String value, Context context) {
		url = isPublic + "/" + url;
		url = url.replaceFirst(isPublic, ContentUtils.getLoginStatus(context) ? "private" : "public").replaceFirst(key,
				value);
		return Constants.HOST_JAVA + url;
	}

	public static String getNoKeyUrl(String url, Context context) {
		url = isPublic + "/" + url;
		url = url.replaceFirst(isPublic, ContentUtils.getLoginStatus(context) ? "private" : "public");
		return Constants.HOST_JAVA + url;
	}

	public static int totalHeight = 0;

	public static void setListViewHeight(ListView listView) {

		/* 得到适配器 */

		Adapter adapter = listView.getAdapter();

		/* 遍历控件 */

		for (int i = 0; i < adapter.getCount(); i++) {

			View view = adapter.getView(i, null, listView);

			/* 测量一下子控件的高度 */

			view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);

			totalHeight += view.getMeasuredHeight();

		}

		/* 控件之间的间隙 */

		totalHeight += listView.getDividerHeight() * (listView.getCount() - 1);

		/* 2、赋值给ListView的LayoutParams对象 */

		ViewGroup.LayoutParams params = listView.getLayoutParams();

		params.height = totalHeight;

		listView.setLayoutParams(params);

	}

	public static HashMap<String, String> setHeader(Context mBaseContext) {
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("client", Constants.ANDROID);
		headers.put("version", getAppVersionName(mBaseContext));
		UserBean user = ContentUtils.getUserInfo(mBaseContext);
		if (null != user) {
			headers.put("token", ContentUtils.getUserInfo(mBaseContext).getToken());
		} else {
			headers.put("token", "");
		}
		BaiduLocationBean location = ContentUtils.getLocationInfo(mBaseContext);
		if (null != location) {
			headers.put("lon", ContentUtils.getLocationInfo(mBaseContext).getLng());
			headers.put("lat", ContentUtils.getLocationInfo(mBaseContext).getLat());
		} else {
			headers.put("lon", "102.813414");
			headers.put("lat", "25.044822");
		}
		headers.put("channelId", Constants.CHANNEL_ID);
		headers.put("device", ContentUtils.getPhoneName(mBaseContext));
		Log.i("device", ContentUtils.getPhoneName(mBaseContext) + "");
		return headers;

	}

	public static OutputStream setHeaderUpImg(OutputStream outStream, Context context) {

		try {
			String client = "client: " + Constants.ANDROID + "\r\n";
			outStream.write(client.getBytes());
			String version = "version: " + getAppVersionName(context) + "\r\n";
			outStream.write(version.getBytes());
			BaiduLocationBean location = ContentUtils.getLocationInfo(context);
			if (null != location) {
				String lon = "lon: " + ContentUtils.getLocationInfo(context).getLng() + "\r\n";
				outStream.write(lon.getBytes());
				String lat = "lat: " + ContentUtils.getLocationInfo(context).getLat() + "\r\n";
				outStream.write(lat.getBytes());
			} else {
				String lon = "lon: " + "102.813414" + "\r\n";
				outStream.write(lon.getBytes());
				String lat = "lat: " + "25.044822" + "\r\n";
				outStream.write(lat.getBytes());
			}

			UserBean user = ContentUtils.getUserInfo(context);
			if (null != user) {

				String token = "token: " + ContentUtils.getUserInfo(context).getToken() + "\r\n";
				outStream.write(token.getBytes());
			} else {
				String token = "token: " + "" + "\r\n";
				outStream.write(token.getBytes());
			}
			String channelId = "channelId: " + Constants.CHANNEL_ID + "\r\n";
			outStream.write(channelId.getBytes());

			String phoneName = "device: " + ContentUtils.getPhoneName(context) + "\r\n";
			outStream.write(phoneName.getBytes());

			return outStream;
		} catch (Exception e) {
			e.printStackTrace();
			return outStream;
		}
	}

	public static boolean isUAT8443() {
		if (Constants.HOST_JAVA.contains("https://c-uat.lincombdev.com:8443")) {
			return true;
		} else {
			return false;
		}

	}
}
