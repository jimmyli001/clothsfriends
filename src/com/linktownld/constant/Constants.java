package com.linktownld.constant;

/**
 * 保存 常量
 * 
 * @author LBS778
 *
 */

public class Constants {

	public static final String HOST_JAVA = "http://172.16.102.191:8080/1.0/";
	public static final String REGSMSURL = "http://172.16.102.191:8080/access/public/register/regsms.do";
	public static final String XIEYEURL = "http://172.16.102.191:8080/access/html/agreement.html";

	public static boolean HAVE_LOG = false;
	public static String ANDROID = "A";
	public static final int OKHTTP_GET = 0;
	public static final int OKHTTP_JSONPOST = 1;
	public static final int OKHTTP_MAPPOST = 2;
	public static final int OKHTTP_FILEPOST = 3;
	public static final String PHONENUMBER = "4006999211";
	public static final String CHANNEL_ID = "UAT_feixun830";

	public static final String SHARED_PREFERENCE_NAME = "TRAVEL_SHARED_PREFERENCE";
	public static final String USERINFO = "userinfo";
	public static final String LOGININFO = "logininfo";
	public static final String MYRELEASEINFO = "myreleaseinfo";
	public static final String BAIDULOCATIONINFO = "baiDuLocationInfo";
	public static final String TOKEN = "csrftoken";
	public static final String HOMEINFO_HEIGHT = "homeinfo_height";
	public static final String HOMEINFO_WIDTH = "homeinfo_width";

	public static final String DRAWABLE = "drawable://";

	public static final String CITY_BEAN = "city_bean";
	/**
	 * 缓存城市列表
	 */
	public static final String BUSINESSLOCATEACTIVITY_CITYDATA = "businesslocateactivity_citydata";
	/**
	 * 消息未读数目
	 */
	public static final String PUSH_UNREAD_NUM = "push_unread_num";

	/**
	 * 首页一键上网是否被关闭
	 */
	public static final String HOME_ONKEY_CLONE = "home_onkey_clone";
	/**
	 * 付款时订单id
	 */
	public static final String NOPAYORDERID = "no_pay_order_id";
	/**
	 * 付款时服务id
	 */
	public static final String NOPAYIDLEID = "no_pay_idle_id";
	/**
	 * 历史记录
	 */

	public static final String BUSINESSLOCATEACTIVITY_HCITYDATA = "businesslocateactivity_hcitydata";

	public static final String SESSION_ID = "sessionid";
	/**
	 * 当前城市
	 */
	public static final String CURRENT_CITY = "city";
	/**
	 * SharedPreference 中的字段 保存是否已经登录
	 */
	public static final String LOGINED_IN = "logined_in";

	/**
	 * SharedPreference 中的字段 保存登录的用户名
	 */
	public static final String USER_NAME = "username";
	public static final String USER_NAMES = "usernames";
	public static final String USER_NAME_NIKE = "nikename";

	/**
	 * SharedPreference 中的字段 保存登录的密码
	 */
	public static final String PASS_WORD = "password";

	/**
	 * SharedPreference 中的字段 保存登录的TOKEN
	 */
	public static final String USER_TOKEN = "token";
	/**
	 * 定位是否成功标识
	 */
	public static final String LOCATE_STATUS = "locate_status";

	/**
	 * SharedPreference 中的字段 保存景区名字
	 */
	public static final String SCENE_NAME = "scene_name";

	/**
	 * SharedPreference 中的字段 保存景区id
	 */
	public static final String SCENE_ID = "scene_id";

	/**
	 * 当前位置经度
	 */
	public static final String LNG_CURRENT_LOCATION = "lng_current_location";
	/**
	 * 是否周边0否1是
	 */
	public static final String IS_CIRCUM = "is_circum";
	public static final String CURAREAID = "curareaid";
	public static final String ISINTERNETCONNECT = "isinternetconnect";
	public static final String CITYID = "cityid";
	public static final String NICKNAME = "name";

	/**
	 * 当前位置纬度
	 */
	public static final String LAT_CURRENT_LOCATION = "lat_current_location";

	/**
	 * 当前位置纬度
	 */
	public static final String AUDIO_INTRODUCTION = "audio_introduction_auto_play";

	/**
	 * 是否需要登录
	 */
	public static final String NEED_LOGIN = "need_login";
	/**
	 * 是否需要登录
	 */
	public static final String MINE = "mine";

	/**
	 * 是否开启附近的人
	 */
	public static final String NEAR_BY = "near_by";

	/**
	 * 是否接收系统消息
	 */
	public static final String SYSTEM_MESSAGE = "system_message";

	/**
	 * 是否接收用户消息
	 */
	public static final String USER_MESSAGE = "user_message";

	/**
	 * 个推CID
	 */
	public static final String PUSH_CID = "push_CID";

	/**
	 * 设备信息
	 */
	public static final String PHONE_NAME = "phone_name";
	/**
	 * Home数据里面 Location 数据
	 */
	public static final String HOME_LOCATION = "home_location";
	/**
	 * 是否点单txm
	 */
	public static final String HAS_ORDER = "has_order";
	/**
	 * 订单idtxm
	 */
	public static final String ORDER_ID = "order_id";
	/**
	 * 版本信息
	 */
	public static final String UPGRADE_VERSION = "upgrade_version";
	/**
	 * 是否更新
	 */
	public static final String VERSION = "version";
	/**
	 * 定位成功与否
	 */
	public static final String LOCAL = "local";
}
