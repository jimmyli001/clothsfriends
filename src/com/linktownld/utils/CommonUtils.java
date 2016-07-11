/**
 * Copyright : 中国银联商务有限公司, 2014-2015 
 * Project : UisCommon  
 * vision 1.0
 * Last Changed by Zeroat 2014年5月26日 
 * JDK version used: JDK1.6 
 * Change Log                                  
 * Author      Change Date    Comments         
 *---------------------------------------------
 * Zero        2014年5月26日        Initailized
 */
package com.linktownld.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * CommonUtils
 * 
 * @author Zero
 * @since 1.0
 */
public class CommonUtils {

	public static final SimpleDateFormat format14 = new SimpleDateFormat("yyyyMMddHHmmss");
	public static final SimpleDateFormat format8 = new SimpleDateFormat("yyyyMMdd");
	public static final SimpleDateFormat format18 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 判断是否为空.
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(Map map) {
		return map == null || map.size() < 1;
	}

	/**
	 * 判断是否为空.
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return null == str || "".equals(str.trim());
	}

	/**
	 * 去除空格.
	 * 
	 * @param str
	 */
	// public static void trim(String str) {
	// str = isEmpty(str) ? "" : str.trim();
	// }

	/**
	 * 返回值的trim
	 * 
	 * @param str
	 * @return
	 */
	public static String trimRt(String str) {
		return isEmpty(str) ? "" : str.trim();
	}

	public static String trimEmptyStr(String str) {
		return isEmpty(str) ? null : str.trim();
	}

	/**
	 * 判断对象是否为空.
	 * 
	 * @param o
	 * @return
	 */
	public static boolean isNull(Object o) {
		return null == o;
	}

	/**
	 * 判断list 是否为空.
	 * 
	 * @param list
	 * @return
	 */
	public static boolean isEmpty(List<?> list) {
		return null == list || 0 == list.size();
	}

	/**
	 * 获取6位随机数.
	 * 
	 * @return
	 */
	public static String getRanDom6() {
		int[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Random rand = new Random();
		for (int i = 10; i > 1; i--) {
			int index = rand.nextInt(i);
			int tmp = array[index];
			array[index] = array[i - 1];
			array[i - 1] = tmp;
		}
		int result = 0;
		for (int i = 0; i < 6; i++)
			result = result * 10 + array[i];
		String res = String.valueOf(result);
		if (6 > res.length()) {
			int ss = 6 - res.length();
			for (int i = 0; i < ss; i++) {
				res += "0";
			}
		}
		return res;
	}

	/**
	 * 获取14位的时间.
	 * 
	 * @return
	 */
	public static String getDate14() {
		return format14.format(new Date());
	}

	public static String getDate8() {
		return format8.format(new Date());
	}

	public static String getDate18() {
		return format18.format(new Date());
	}

	/**
	 * 创建FORM表单.
	 * 
	 * @param action
	 * @param hiddens
	 * @param encoding
	 * @return
	 */
	public static String createFormHtml(String action, Map<String, String> hiddens, String encoding) {
		StringBuffer sf = new StringBuffer();
		sf.append(
				"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
		sf.append("<html>\r\n");
		sf.append("<head>\r\n");
		sf.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=" + encoding + "\">\r\n");
		sf.append("<title></title>\r\n");
		sf.append("</head>\r\n");
		sf.append("<body>\r\n");
		sf.append("<form id = \"sform\" action=\"" + action + "\" method=\"post\">\r\n");
		if (null != hiddens && 0 != hiddens.size()) {
			Set<java.util.Map.Entry<String, String>> set = hiddens.entrySet();
			java.util.Iterator<java.util.Map.Entry<String, String>> it = set.iterator();
			while (it.hasNext()) {
				java.util.Map.Entry<String, String> ey = it.next();
				String key = ey.getKey();
				String value = ey.getValue();
				sf.append(
						"<input type=\"hidden\" name=\"" + key + "\" id=\"" + key + "\" value=\"" + value + "\"/>\r\n");
			}
		}
		sf.append("</form>\r\n");
		sf.append("</body>\r\n");
		sf.append("<script type=\"text/javascript\">\r\n");
		sf.append("document.getElementById('sform').submit();\r\n");
		sf.append("</script>\r\n");
		sf.append("</html>\r\n");
		return sf.toString();
	}

	public static String formatDateyyyyMMdd(Date date) {
		if (null == date) {
			return "";
		}
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyyMMdd");
		return sFormat.format(date);
	}

	/**
	 * 两个字符串是否相等
	 * 
	 * @param one
	 * @param two
	 * @return
	 */
	public static boolean isEq(String one, String two) {
		String s1 = trimRt(one);
		String s2 = trimRt(two);
		return s1.equals(s2);
	}

	/**
	 * 字符串转为定长字符，位数不足左边填充特定字符
	 * 
	 * @param str
	 *            源字符串
	 * @param fixedLength
	 *            固定长度
	 * @param fillingChar
	 *            填充字符
	 * @return
	 */
	public static String padLeft(String str, int fixedLength, char fillingChar) {
		if (str == null) {
			str = "";
			int space = fixedLength;
			while (space-- != 0) {
				str = fillingChar + str;
			}
			return str;
		}
		if (str.length() < fixedLength) {
			int space = fixedLength - str.length();
			while (space-- != 0) {
				str = fillingChar + str;
			}
		}
		return str;
	}

	/**
	 * 生成验证码
	 * 
	 * @param num
	 * @return
	 */
	public static int randomNum(int num) {
		int[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Random rand = new Random();
		for (int i = 10; i > 1; i--) {
			int index = rand.nextInt(i);
			int tmp = array[index];
			array[index] = array[i - 1];
			array[i - 1] = tmp;
		}
		int result = 0;
		for (int i = 0; i < num; i++)
			result = result * 10 + array[i];
		return result;
	}

	/**
	 * 检查邮件格式是否正确
	 * 
	 * @param email
	 * @return
	 */
	public static boolean isEmail(String email) {
		boolean tag = true;
		final String pattern1 = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
		final Pattern pattern = Pattern.compile(pattern1);
		final Matcher mat = pattern.matcher(email);
		if (!mat.matches()) {
			tag = false;
		}
		return tag;
	}

	public static Integer changeRoleName(String roleName) {
		if ("AB".equals(roleName)) {
			return 4;
		} else if ("AC".equals(roleName)) {
			return 5;
		} else if ("AD".equals(roleName)) {
			return 6;
		} else if ("ABC".equals(roleName)) {
			return 7;
		} else if ("ABD".equals(roleName)) {
			return 8;
		} else if ("ACD".equals(roleName)) {
			return 9;
		} else if ("ABCD".equals(roleName)) {
			return 10;
		}
		return 3;
	}

	public static Integer roleIdIoc(String[] functions) {
		Integer roleId = 3;
		if (null != functions) {
			StringBuffer functionStr = new StringBuffer();
			for (String function : functions) {
				functionStr.append(function);
			}
			String function = functionStr.toString();
			if ("12".equals(function)) {
				roleId = 4;
			} else if ("13".equals(function)) {
				roleId = 5;
			} else if ("14".equals(function)) {
				roleId = 6;
			} else if ("123".equals(function)) {
				roleId = 7;
			} else if ("124".equals(function)) {
				roleId = 8;
			} else if ("134".equals(function)) {
				roleId = 9;
			} else if ("1234".equals(function)) {
				roleId = 10;
			}
		}
		return roleId;
	}

	/**
	 * 根据用户角色ID返回用户权限列表
	 * 
	 * @param role
	 * @return
	 */
	public static String[] userRolesIOC(Integer role) {
		String[] userRoles = new String[] { "1", "", "", "" };
		if (4 == role || 7 == role || 8 == role || 10 == role) {
			userRoles[1] = "2";
		}
		if (5 == role || 7 == role || 9 == role || 10 == role) {
			userRoles[2] = "3";
		}
		if (6 == role || 8 == role || 9 == role || 10 == role) {
			userRoles[3] = "4";
		}
		return userRoles;
	}

	/**
	 * 根据用户角色ID返回用户权限列表
	 * 
	 * @param role
	 * @return
	 */
	public static List<String> userRolesIOC2(Integer role) {
		List<String> list = new ArrayList<String>();
		list.add("1");
		if (4 == role || 7 == role || 8 == role || 10 == role) {
			list.add("2");
		}
		if (5 == role || 7 == role || 9 == role || 10 == role) {
			list.add("3");
		}
		if (6 == role || 8 == role || 9 == role || 10 == role) {
			list.add("4");
		}
		return list;
	}

	/**
	 * 验证手机号码
	 *
	 * @param mobiles
	 * @return
	 */
	public static boolean isMobileNO(String mobiles) {
		boolean flag = false;
		try {
			Pattern p = Pattern.compile("^[1][3-9][0-9]{9}$");
			Matcher m = p.matcher(mobiles);
			flag = m.matches();
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

}
