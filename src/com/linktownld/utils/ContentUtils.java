package com.linktownld.utils;

import com.alibaba.fastjson.JSONObject;
import com.linktownld.bean.BaiduLocationBean;
import com.linktownld.bean.LoginInfoBean;
import com.linktownld.bean.UserBean;
import com.linktownld.constant.Constants;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 操作文件/uri/sharedpreference的工具类
 * 
 * @author fenfei.she
 * @date 2014年7月30日
 */
public final class ContentUtils {

	/**
	 * @param mContext
	 *            上下文，来区别哪一个activity调用的
	 * @param whichSp
	 *            使用的SharedPreferences的名字
	 * @param field
	 *            SharedPreferences的哪一个字段
	 * @return
	 */
	// 取出whichSp中field字段对应的string类型的值
	public static String getSharePreStr(Context mContext, String whichSp, String field) {
		SharedPreferences sp = (SharedPreferences) mContext.getSharedPreferences(whichSp, 0);
		String s = sp.getString(field, "0");// 如果该字段没对应值，则取出字符串0
		return s;
	}

	// 取出whichSp中field字段对应的int类型的值
	public static int getSharePreInt(Context mContext, String whichSp, String field) {
		SharedPreferences sp = (SharedPreferences) mContext.getSharedPreferences(whichSp, 0);
		int i = sp.getInt(field, 0);// 如果该字段没对应值，则取出0
		return i;
	}

	// 取出whichSp中field字段对应的boolean类型的值
	public static boolean getSharePreBoolean(Context mContext, String whichSp, String field) {
		SharedPreferences sp = (SharedPreferences) mContext.getSharedPreferences(whichSp, 0);
		boolean i = sp.getBoolean(field, false);
		return i;
	}

	// 保存string类型的value到whichSp中的field字段
	public static void putSharePre(Context mContext, String whichSp, String field, String value) {
		SharedPreferences sp = (SharedPreferences) mContext.getSharedPreferences(whichSp, 0);
		sp.edit().putString(field, value).commit();
	}

	// 保存int类型的value到whichSp中的field字段
	public static void putSharePre(Context mContext, String whichSp, String field, int value) {
		SharedPreferences sp = (SharedPreferences) mContext.getSharedPreferences(whichSp, 0);
		sp.edit().putInt(field, value).commit();
	}

	public static String getStringFromSharedPreference(Context mContext, String whichSp, String field) {
		SharedPreferences sp = (SharedPreferences) mContext.getSharedPreferences(whichSp, 0);
		String s = sp.getString(field, "");// 如果该字段没对应值，则取出空字符串
		return s;
	}

	// 保存boolen类型的value到whichSp中的field字段(主要做登陆状态)
	public static void putSharePre(Context mContext, String whichSp, String field, boolean value) {
		SharedPreferences sp = (SharedPreferences) mContext.getSharedPreferences(whichSp, 0);
		sp.edit().putBoolean(field, value).commit();
	}

	// 删除某个表
	public static void deleteField(Context mContext, String whichSp) {
		SharedPreferences sp = (SharedPreferences) mContext.getSharedPreferences(whichSp, 0);
		sp.edit().clear();
	}

	public static void putNearByFlag(Context context, boolean flag) {
		SharedPreferences sp = (SharedPreferences) context.getSharedPreferences(Constants.SHARED_PREFERENCE_NAME, 0);
		sp.edit().putBoolean(Constants.NEAR_BY, flag).commit();
	}

	public static boolean getNearBy(Context context) {
		SharedPreferences sp = (SharedPreferences) context.getSharedPreferences(Constants.SHARED_PREFERENCE_NAME, 0);
		return sp.getBoolean(Constants.NEAR_BY, true);
	}

	// 保持是否接收系统消息flag
	public static void putSysMessageFlag(Context context, boolean flag) {
		SharedPreferences sp = (SharedPreferences) context.getSharedPreferences(Constants.SHARED_PREFERENCE_NAME, 0);
		sp.edit().putBoolean(Constants.SYSTEM_MESSAGE, flag).commit();
	}

	public static boolean getSysMessage(Context context) {
		SharedPreferences sp = (SharedPreferences) context.getSharedPreferences(Constants.SHARED_PREFERENCE_NAME, 0);
		return sp.getBoolean(Constants.SYSTEM_MESSAGE, true);
	}

	// 保持是否接收用户消息flag
	public static void putUserMessageFlag(Context context, boolean flag) {
		SharedPreferences sp = (SharedPreferences) context.getSharedPreferences(Constants.SHARED_PREFERENCE_NAME, 0);
		sp.edit().putBoolean(Constants.USER_MESSAGE, flag).commit();
	}

	public static boolean getUserMessage(Context context) {
		SharedPreferences sp = (SharedPreferences) context.getSharedPreferences(Constants.SHARED_PREFERENCE_NAME, 0);
		return sp.getBoolean(Constants.USER_MESSAGE, true);
	}

	// 存储 个推 CID 数据
	public static void putPushCId(Context context, String cid) {
		SharedPreferences sp = (SharedPreferences) context.getSharedPreferences(Constants.SHARED_PREFERENCE_NAME, 0);
		sp.edit().putString(Constants.PUSH_CID, cid).commit();
	}

	public static String getPushCId(Context context) {
		SharedPreferences sp = (SharedPreferences) context.getSharedPreferences(Constants.SHARED_PREFERENCE_NAME, 0);
		return sp.getString(Constants.PUSH_CID, "");
	}

	// 存储 设备信息
	public static void putPhoneName(Context context, String phone) {
		SharedPreferences sp = (SharedPreferences) context.getSharedPreferences(Constants.SHARED_PREFERENCE_NAME, 0);
		sp.edit().putString(Constants.PHONE_NAME, phone).commit();
	}

	public static String getPhoneName(Context context) {
		SharedPreferences sp = (SharedPreferences) context.getSharedPreferences(Constants.SHARED_PREFERENCE_NAME, 0);
		return sp.getString(Constants.PHONE_NAME, "");
	}

	// 设置城市缓存 数据
	public static void putBusinesslocateactivity_citydata(Context context, String citydata) {
		SharedPreferences sp = (SharedPreferences) context.getSharedPreferences(Constants.SHARED_PREFERENCE_NAME, 0);
		sp.edit().putString(Constants.BUSINESSLOCATEACTIVITY_CITYDATA, citydata).commit();
	}

	// 获得城市缓存 数据
	public static String getBusinesslocateactivity_citydata(Context context) {
		SharedPreferences sp = (SharedPreferences) context.getSharedPreferences(Constants.SHARED_PREFERENCE_NAME, 0);
		return sp.getString(Constants.BUSINESSLOCATEACTIVITY_CITYDATA, "");
	}

	// 设置未读数目
	public static void putUnRead(Context context, int unread) {
		SharedPreferences sp = (SharedPreferences) context.getSharedPreferences(Constants.SHARED_PREFERENCE_NAME, 0);
		sp.edit().putInt(Constants.PUSH_UNREAD_NUM, unread).commit();
	}

	// 获得未读数目
	public static int getUnRead(Context context) {
		SharedPreferences sp = (SharedPreferences) context.getSharedPreferences(Constants.SHARED_PREFERENCE_NAME, 0);
		return sp.getInt(Constants.PUSH_UNREAD_NUM, -1);
	}

	// 设置首頁一件上网 是否被关闭 (true 为 应该显示出来 ，false 为 不该 显示出来)
	public static void putHomeOneKeyClose(Context context, boolean isClose) {
		SharedPreferences sp = (SharedPreferences) context.getSharedPreferences(Constants.SHARED_PREFERENCE_NAME, 0);
		sp.edit().putBoolean(Constants.HOME_ONKEY_CLONE, isClose).commit();
	}

	// 获得首頁一件上网 是否被关闭
	public static boolean getHomeOneKeyClose(Context context) {
		SharedPreferences sp = (SharedPreferences) context.getSharedPreferences(Constants.SHARED_PREFERENCE_NAME, 0);
		return sp.getBoolean(Constants.HOME_ONKEY_CLONE, false);
	}

	// 设置微信支付前的orderid（MyBuyDetail_noPayActivity 付款时 传入，SureSuccessActivity接收时
	// 使用）
	public static void putNoPayOrderId(Context context, int orderId) {
		SharedPreferences sp = (SharedPreferences) context.getSharedPreferences(Constants.SHARED_PREFERENCE_NAME, 0);
		sp.edit().putInt(Constants.NOPAYORDERID, orderId).commit();
	}

	// 获得微信支付前的orderid（MyBuyDetail_noPayActivity 付款时 传入，SureSuccessActivity接收时
	// 使用）
	public static int getNoPayOrderId(Context context) {
		SharedPreferences sp = (SharedPreferences) context.getSharedPreferences(Constants.SHARED_PREFERENCE_NAME, 0);
		return sp.getInt(Constants.NOPAYORDERID, 0);
	}

	// 设置微信支付前的idleId（MyBuyDetail_noPayActivity 付款时 传入，SureSuccessActivity接收时
	// 使用）
	public static void putNoPayIdleId(Context context, int idleId) {
		SharedPreferences sp = (SharedPreferences) context.getSharedPreferences(Constants.SHARED_PREFERENCE_NAME, 0);
		sp.edit().putInt(Constants.NOPAYIDLEID, idleId).commit();
	}

	// 获得微信支付前的idleId（MyBuyDetail_noPayActivity 付款时 传入，SureSuccessActivity接收时
	// 使用）
	public static int getNoPayIdleId(Context context) {
		SharedPreferences sp = (SharedPreferences) context.getSharedPreferences(Constants.SHARED_PREFERENCE_NAME, 0);
		return sp.getInt(Constants.NOPAYIDLEID, 0);
	}

	public static boolean getLoginStatus(Context context) {
		return ContentUtils.getSharePreBoolean(context, Constants.SHARED_PREFERENCE_NAME, Constants.LOGINED_IN);
	}

	public static void setLoginStatus(Context context, boolean loginStatus) {
		ContentUtils.putSharePre(context, Constants.SHARED_PREFERENCE_NAME, Constants.LOGINED_IN, loginStatus);
	}

	public static void setLocateStatus(Context context, boolean locateStatus) {
		ContentUtils.putSharePre(context, Constants.SHARED_PREFERENCE_NAME, Constants.LOCATE_STATUS, locateStatus);
	}

	public static boolean getLocateStatus(Context context) {
		return ContentUtils.getSharePreBoolean(context, Constants.SHARED_PREFERENCE_NAME, Constants.LOCATE_STATUS);
	}

	// public static void saveToken(Context context, String token) {
	// ContentUtils.putSharePre(context, Constants.SHARED_PREFERENCE_NAME,
	// Constants.TOKEN, token);
	// }
	/**
	 * 设置用户信息
	 * 
	 * @param context
	 * @param user
	 */
	public static void setUserInfo(Context context, UserBean user) {
		String userjson = JSONObject.toJSONString(user);
		ContentUtils.putSharePre(context, Constants.SHARED_PREFERENCE_NAME, Constants.USERINFO, userjson);
	}

	/**
	 * 获得用户信息
	 * 
	 * @param context
	 * @return
	 */
	public static UserBean getUserInfo(Context context) {
		String user = getStringFromSharedPreference(context, Constants.SHARED_PREFERENCE_NAME, Constants.USERINFO);
		if (!user.equals("")) {
			UserBean userInfo = JSONObject.parseObject(user, UserBean.class);
			return userInfo;
		} else {
			return null;
		}
	}

	/**
	 * 设置用户的登录信息（传null为清空数据）
	 * 
	 * @param context
	 * @param loginJSON
	 */
	public static void setLoginInfo(Context context, LoginInfoBean loginJSON) {
		if (null != loginJSON) {
			String login = JSONObject.toJSONString(loginJSON);
			ContentUtils.putSharePre(context, Constants.SHARED_PREFERENCE_NAME, Constants.LOGININFO, login);
		} else {
			ContentUtils.putSharePre(context, Constants.SHARED_PREFERENCE_NAME, Constants.LOGININFO, "");
		}

	}

	/**
	 * 获得号码和验证码
	 * 
	 * @param context
	 * @return
	 */
	public static LoginInfoBean getLoginInfo(Context context) {
		String login = getStringFromSharedPreference(context, Constants.SHARED_PREFERENCE_NAME, Constants.LOGININFO);
		if (!login.equals("")) {
			LoginInfoBean loginInfo = JSONObject.parseObject(login, LoginInfoBean.class);
			return loginInfo;
		} else {
			return null;
		}
	}

	/**
	 * 设置 百度定位的信息
	 * 
	 * @param context
	 * @param JSON
	 */
	public static void setLocationInfo(Context context, BaiduLocationBean JSON) {
		String JSONs = JSONObject.toJSONString(JSON);
		ContentUtils.putSharePre(context, Constants.SHARED_PREFERENCE_NAME, Constants.BAIDULOCATIONINFO, JSONs);
	}

	/**
	 * 返回 百度定位的信息
	 * 
	 * @param context
	 * @return
	 */
	public static BaiduLocationBean getLocationInfo(Context context) {
		String str = getStringFromSharedPreference(context, Constants.SHARED_PREFERENCE_NAME,
				Constants.BAIDULOCATIONINFO);
		if (!str.equals("")) {
			BaiduLocationBean mBaiduLocationInfo = JSONObject.parseObject(str, BaiduLocationBean.class);
			return mBaiduLocationInfo;
		} else {
			return null;
		}
	}

	/**
	 * 建立更新flag
	 */
	public static void setUpgradeStatus(Context context, boolean upgradeStatus) {
		ContentUtils.putSharePre(context, Constants.SHARED_PREFERENCE_NAME, Constants.VERSION, upgradeStatus);
	}

	/**
	 * 获取更新flag
	 */
	public static boolean getUpgradeStatus(Context context) {
		return ContentUtils.getSharePreBoolean(context, Constants.SHARED_PREFERENCE_NAME, Constants.VERSION);
	}

	/**
	 * 设置定位失败出现与否
	 */
	public static void setLocalStatus(Context context, boolean LocalStatus) {
		ContentUtils.putSharePre(context, Constants.SHARED_PREFERENCE_NAME, Constants.LOCAL, LocalStatus);
	}

	/**
	 * 获取定位失败成功出现与否
	 */
	public static boolean getLocalStatus(Context context) {
		return ContentUtils.getSharePreBoolean(context, Constants.SHARED_PREFERENCE_NAME, Constants.LOCAL);
	}

}
