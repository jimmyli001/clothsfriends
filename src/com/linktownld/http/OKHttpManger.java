package com.linktownld.http;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import com.alibaba.fastjson.JSONObject;
import com.linktownld.R;
import com.linktownld.bean.BaiduLocationBean;
import com.linktownld.bean.UserBean;
import com.linktownld.constant.Constants;
import com.linktownld.utils.AndroidUtil;
import com.linktownld.utils.CommonUtils;
import com.linktownld.utils.ContentUtils;
import com.linktownld.utils.DES3Util;
import com.linktownld.utils.NetworkUtils;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

/**
 * OKHTTP网络请求工具类
 * 
 * @author LBS778
 *
 */
public class OKHttpManger {
	private static Boolean isLog = com.linktownld.constant.Constants.HAVE_LOG;
	private static OkHttpClient client;
	public static final MediaType MediaTypeJSON = MediaType.parse("application/json; charset=utf-8");
	public static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("multipart/form-data; charset=utf-8");

	private static OkHttpClient getOKhttpClient(Context context) {
		if (client == null) {
			return getClient(context);
		} else {
			return client;
		}
	}

	/**
	 * OKHttp post 请求 (参数为 Map<String,String>,文件List)
	 * 
	 * @param context
	 * @param url
	 * @param paramsMap
	 * @return
	 */
	public static String doFilePost(Context context, String url, Map<String, String> paramsMap,
			ArrayList<File> fileList, String FileName) {
		JSONObject retObj = new JSONObject();
		// 检查网络
		if (!NetworkUtils.isNetworkAvailable(context)) {
			retObj.put("success", false);
			retObj.put("msg", context.getString(R.string.bad_network));
		} else {
			try {
				MultipartBuilder mMultipartBuilder = getFilePostPram(paramsMap, fileList, FileName);
				Request request = setHeadBuilder(context).url(url).post(mMultipartBuilder.build()).build();
				Response response = getOKhttpClient(context).newCall(request).execute();
				if (response.isSuccessful()) {
					/* 读返回数据 */
					String strResponse = response.body().string();
					// strResponse = DES3Util.decode(strResponse);
					if (isLog) {
						Log.d("plaform response解密前", strResponse);
					}
					strResponse = DES3Util.decode(strResponse);
					if (isLog) {
						Log.d("plaform response解密后", strResponse);
					}
					JSONObject json = JSONObject.parseObject(strResponse);
						retObj.put("success", true);
						retObj.put("status", json.getString("status"));
						retObj.put("data", json.getString("result"));
						retObj.put("msg", json.getString("message"));
					
				} else {
					retObj.put("success", false);
					retObj.put("msg", context.getString(R.string.service_exception));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return retObj.toJSONString();
	}

	/**
	 * OKHttp post 请求 (参数为 Map<String,String>)
	 * 
	 * @param context
	 * @param url
	 * @param paramsMap
	 * @return
	 */
	public static String doMapPost(Context context, String url, Map<String, String> paramsMap) {
		JSONObject retObj = new JSONObject();
		// 检查网络
		if (!NetworkUtils.isNetworkAvailable(context)) {
			retObj.put("success", false);
			retObj.put("msg", context.getString(R.string.bad_network));
		} else {
			try {
				FormEncodingBuilder builder = getMapPostParm(paramsMap);
				Request request = setHeadBuilder(context).url(url).post(builder.build()).build();
				Response response = getOKhttpClient(context).newCall(request).execute();
				if (response.isSuccessful()) {
					/* 读返回数据 */
					String strResponse = response.body().string();
					// strResponse = DES3Util.decode(strResponse);

					if (isLog) {
						Log.d("plaform response解密前", strResponse);
					}
					strResponse = DES3Util.decode(strResponse);
					if (isLog) {
						Log.d("plaform response解密后", strResponse);
					}
					JSONObject json = JSONObject.parseObject(strResponse);
					retObj.put("success", true);
					retObj.put("status", json.getString("status"));
					retObj.put("data", json.getString("result"));
					retObj.put("msg", json.getString("message"));
				} else {
					retObj.put("success", false);
					retObj.put("msg", context.getString(R.string.service_exception));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return retObj.toJSONString();
	}

	/**
	 * OKHttp post 请求 (参数为 json)
	 * 
	 * @param context
	 * @param url
	 * @param paramsMap
	 * @return
	 */
	public static String doJSONPost(Context context, String url, String JSONString) {
		JSONObject retObj = new JSONObject();
		// 检查网络
		if (!NetworkUtils.isNetworkAvailable(context)) {
			retObj.put("success", false);
			retObj.put("msg", context.getString(R.string.bad_network));
		} else {
			RequestBody body = RequestBody.create(MediaTypeJSON, JSONString);
			Request request = setHeadBuilder(context).url(url).post(body).build();
			try {
				Response response = getOKhttpClient(context).newCall(request).execute();
				if (response.isSuccessful()) {
					/* 读返回数据 */
					String strResponse = response.body().string();
					strResponse = DES3Util.decode(strResponse);
					if (isLog) {
						Log.d("plaform response解密前", strResponse);
					}
					// strResponse = DES3Util.decode(strResponse);
					if (isLog) {
						Log.d("plaform response解密后", strResponse);
					}
					JSONObject json = JSONObject.parseObject(strResponse);
					retObj.put("success", true);
					retObj.put("status", json.getString("status"));
					retObj.put("data", json.getString("result"));
					retObj.put("msg", json.getString("message"));
				} else {
					retObj.put("success", false);
					retObj.put("msg", context.getString(R.string.service_exception));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return retObj.toJSONString();
	}

	/**
	 * OKHttp get 请求
	 * 
	 * @param context
	 * @param url
	 * @param paramsMap
	 * @return
	 */
	public static String doMapGet(Context context, String url, Map<String, String> paramsMap) {
		JSONObject retObj = new JSONObject();
		// 检查网络
		if (!NetworkUtils.isNetworkAvailable(context)) {
			retObj.put("success", false);
			retObj.put("msg", context.getString(R.string.bad_network));
		} else {
			if (!url.contains("http://mezone.router/auth.cmd")) {
				url = setGetPram(url, paramsMap);
			}
			Request request = setHeadBuilder(context).url(url).build();
			try {
				Response response = getOKhttpClient(context).newCall(request).execute();
				if (response.isSuccessful()) {
					/* 读返回数据 */
					String strResponse = response.body().string();
					if (isLog) {
						Log.d("plaform response解密前", strResponse);
					}
					if (!url.contains("http://mezone.router/auth.cmd")) {
						strResponse = DES3Util.decode(strResponse);
					}
					if (isLog) {
						Log.d("plaform response解密后", strResponse);
					}
					if (strResponse.startsWith("callback('0")) {
						retObj.put("success", true);
					} else {
						JSONObject json = JSONObject.parseObject(strResponse);
						retObj.put("success", true);
						retObj.put("status", json.getString("status"));
						retObj.put("data", json.getString("result"));
						retObj.put("msg", json.getString("message"));
					}
				} else {
					retObj.put("success", false);
					retObj.put("msg", context.getString(R.string.service_exception));
				}

			} catch (Exception e) {
				e.printStackTrace();
				retObj.put("success", false);
				retObj.put("msg", context.getString(R.string.service_exception));
			}

		}
		return retObj.toJSONString();
	}

	/**
	 * 获得 OkHttpClient 实例
	 * 
	 * @param context
	 * @return
	 */
	private static OkHttpClient getClient(Context context) {
		OkHttpClient client = new OkHttpClient();
		client.setConnectTimeout(15, TimeUnit.SECONDS); // connect timeout
		client.setReadTimeout(15, TimeUnit.SECONDS); // socket timeout
		try {
			if (Constants.HOST_JAVA.contains("https://c-uat.lincombdev.com:8443")) {
				setCertificates(client, context.getAssets().open("lincomb.cer"));
			} else if (Constants.HOST_JAVA.contains("https://api-c.cdxzhi.com:58443")) {
				setCertificates(client, context.getAssets().open("lincomb_prod.cer"));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return client;

	}

	/**
	 * 设置 HTTPS 的 证书
	 * 
	 * @param client
	 * @param certificates
	 */
	@SuppressLint("TrulyRandom")
	public static void setCertificates(OkHttpClient client, InputStream... certificates) {
		try {
			CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
			KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
			keyStore.load(null);
			int index = 0;
			for (InputStream certificate : certificates) {
				String certificateAlias = Integer.toString(index++);
				keyStore.setCertificateEntry(certificateAlias, certificateFactory.generateCertificate(certificate));

				try {
					if (certificate != null)
						certificate.close();
				} catch (IOException e) {
				}
			}

			SSLContext sslContext = SSLContext.getInstance("TLS");

			TrustManagerFactory trustManagerFactory = TrustManagerFactory
					.getInstance(TrustManagerFactory.getDefaultAlgorithm());

			trustManagerFactory.init(keyStore);
			sslContext.init(null, trustManagerFactory.getTrustManagers(), new SecureRandom());
			client.setSslSocketFactory(sslContext.getSocketFactory());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 获得加密的参数 URL
	 * 
	 * @return
	 */
	public static String getPromURL(String url) {
		if (url.contains("?")) {
			String[] str = url.split("\\?");
			for (int i = 0; i < str.length; i++) {
			}
			try {
				String encode = URLEncoder.encode(DES3Util.encode(str[1]), "utf-8");
				return str[0] + "?" + encode;
			} catch (Exception e) {
				e.printStackTrace();
				return url;
			}
		} else {
			return url;
		}

	}

	/**
	 * 给 OKhttp Request 设置 请求头
	 * 
	 * @param mBaseContext
	 * @return
	 */
	public static Request.Builder setHeadBuilder(Context mBaseContext) {
		Request.Builder builder = new Builder();
		builder.addHeader("client", Constants.ANDROID);
		builder.addHeader("version", AndroidUtil.getAppVersionName(mBaseContext));
		UserBean user = ContentUtils.getUserInfo(mBaseContext);
		if (null != user) {
			builder.addHeader("token", ContentUtils.getUserInfo(mBaseContext).getToken());
		} else {
			builder.addHeader("token", "");
		}
		BaiduLocationBean location = ContentUtils.getLocationInfo(mBaseContext);
		if (null != location) {
			builder.addHeader("lon", ContentUtils.getLocationInfo(mBaseContext).getLng());
			builder.addHeader("lat", ContentUtils.getLocationInfo(mBaseContext).getLat());
		} else {
			builder.addHeader("lon", "102.813414");
			builder.addHeader("lat", "25.044822");
		}
		builder.addHeader("channelId", Constants.CHANNEL_ID);
		builder.addHeader("device", ContentUtils.getPhoneName(mBaseContext));
		return builder;

	}

	/**
	 * 设置 Map型参数post请求的 request请求
	 * 
	 * @param paramsMap
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private static FormEncodingBuilder getMapPostParm(Map<String, String> paramsMap)
			throws UnsupportedEncodingException {
		FormEncodingBuilder builder = new FormEncodingBuilder();
		if (null != paramsMap && paramsMap.size() > 0) {
			Set<String> key = paramsMap.keySet();
			for (Iterator<String> it = key.iterator(); it.hasNext();) {
				String s = it.next();
				builder.add(s,
						(CommonUtils.isEmpty(paramsMap.get(s)) ? "" : URLEncoder.encode(paramsMap.get(s), "UTF-8")));
			}
		}
		return builder;
	}

	/**
	 * 设置 FilePost请求的 请求参数
	 * 
	 * @param paramsMap
	 * @param fileList
	 * @param FileName
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private static MultipartBuilder getFilePostPram(Map<String, String> paramsMap, ArrayList<File> fileList,
			String FileName) throws UnsupportedEncodingException {
		MultipartBuilder mMultipartBuilder = new MultipartBuilder().type(MultipartBuilder.FORM);
		for (int i = 0; i < fileList.size(); i++) {
			mMultipartBuilder.addPart(
					Headers.of("Content-Disposition",
							"form-data; name=\"" + FileName + "\";" + "filename=\"" + fileList.get(i).getName() + "\""),
					RequestBody.create(MEDIA_TYPE_MARKDOWN, fileList.get(i)));
		}
		if (null != paramsMap && paramsMap.size() > 0) {
			Set<String> key = paramsMap.keySet();
			for (Iterator<String> it = key.iterator(); it.hasNext();) {
				String s = it.next();
				mMultipartBuilder.addPart(Headers.of("Content-Disposition", "form-data; name=\"" + s + "\""),
						RequestBody.create(null, (CommonUtils.isEmpty(paramsMap.get(s)) ? ""
								: URLEncoder.encode(paramsMap.get(s), "UTF-8"))));
			}
		}
		return mMultipartBuilder;
	}

	/**
	 * 
	 * @param url
	 * @param paramsMap
	 * @return 返回加密的整个 get请求 URL
	 */
	private static String setGetPram(String url, Map<String, String> paramsMap) {
		if (paramsMap != null && paramsMap.size() > 0) {
			url += "?";
			Set<String> key = paramsMap.keySet();
			for (Iterator<String> it = key.iterator(); it.hasNext();) {
				String s = it.next();
				if (isLog) {
					Log.i("http get param", s + "=" + paramsMap.get(s));
				}
				try {
					url += s + "=" + (CommonUtils.isEmpty(paramsMap.get(s)) ? ""
							: URLEncoder.encode(paramsMap.get(s), "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				if (it.hasNext()) {
					url += "&";
				}
			}
		}
		Log.e("url", url);
		// 给url参数加密
		url = getPromURL(url);
		return url;
	}
}
