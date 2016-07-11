package com.linktownld.utils;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

//import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * 3DES加密工具类
 */
public class DES3Util {
	// 加解密统一使用的编码方式
	private final static String encoding = "utf-8";
	// 密钥
	private static String secretKey = "Pvz7gMvdwz&HQIEvu3o45@mHAvgCJ";
	// 向量
	private static String iv = "01749620";

	static {
		// Properties properties = PropertiesLoaderUtils
		// .loadAllProperties("DES3Key.properties");
		// secretKey = properties.getProperty("SECRET_KEY");
		// iv = properties.getProperty("IV");
//		secretKey = "SHHBJR$mobile%0519[!SECRET@]&";
		secretKey = "Pvz7gMvdwz&HQIEvu3o45@mHAvgCJ";
//		iv = "20150519";
		iv = "01749620";
	}

	/**
	 * 3DES加密
	 * 
	 * @param plainText
	 *            普通文本
	 * @return
	 * @throws Exception
	 */
	public static String encode(String plainText) throws Exception {
		Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		deskey = keyfactory.generateSecret(spec);

		Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
		IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
		cipher.init(Cipher.ENCRYPT_MODE, deskey, ips);
		byte[] encryptData = cipher.doFinal(plainText.getBytes(encoding));
		return Base64Util.encode(encryptData);
	}

	/**
	 * 3DES解密
	 * 
	 * @param encryptText
	 *            加密文本
	 * @return
	 * @throws Exception
	 */
	public static String decode(String encryptText) throws Exception {
		Key deskey = null;
		DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("desede");
		deskey = keyfactory.generateSecret(spec);
		Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
		IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
		cipher.init(Cipher.DECRYPT_MODE, deskey, ips);
		byte[] decryptData = Base64Util.decode(encryptText);
		decryptData = cipher.doFinal(decryptData);
		return new String(decryptData, encoding);

		// byte[] keyBytes = encryptText.getBytes("UTF-8");
		// byte[] ivBytes = encryptText.getBytes("UTF-8");
		// AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivBytes);
		// SecretKeySpec newKey = new SecretKeySpec(keyBytes, "desede");
		// Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
		// cipher.init(Cipher.DECRYPT_MODE, newKey, ivSpec);
		// byte[] decodedVal = Base64.decode(value.getBytes("UTF-8"),
		// Base64.DEFAULT);
		// byte[] cipherData = cipher.doFinal(decodedVal);
		// String decryptedData = new String(cipherData, "UTF-8");
		// return decryptedData.trim();
	}

	public static void main(String[] args) {
		try {
			String enStr = "mobileNumber=15618385005&kCode=KCODETEST0001&channel=LINGDANG";
			System.out.println(">>>>>>>>加密前：" + enStr);

			String result = encode(enStr);
			System.out.println(">>>>>>>>加密后：" + result);

			String src = result;
			System.out.println(">>>>>>>>解密前：" + src);

			System.out.println(">>>>>>>>解密后："
					+ java.net.URLDecoder.decode(decode(src), "UTF-8"));

			// String src1 =
			// "MtTlHDHVkyLDnelUnF6MPiz5Uq89Kl74wboE9ulusCaDm12cHhgEWokGHLR5qefs7wu0O6aAOMdaC2Q0oziW7FpePmhXHSrZTxzr9+MONG3ig4pz+zyaP38SMg+qXKWjrpX34Yazc2vVQsVKrTZBMzPSNAciuztzFfzaRB1xlBGp9axY/3+MNh5thMNI1gv8Z5OT7antz/1VbL2ou5x5LZN2YWLv+CgoIl0Wbs4NC4EVLsqlMukUF02Tpe2Pa3sNWzyVayHH+a2WPpctVmSmcVpq6RKIJGsiZdfViMW0docoo+p/j6pmRJQM/covlruGVsGmi9HxCtG5lNkhM3jhy9QfMj48Lb0QTQ3lsREqPRRh/KrottXmYk/vkuiQW/jyd/EQ2+kmW4WJipdJY/f4sKrj29Rjga7yH0JILMGL05oQlRpV1aY42BDjbTvPOb/FKrkxHx4MV55aTZYJaFIBFPoLI3RnC8gfJvDz+DFeNdv8lOhWpCQuEceXyMCkj5SL2E5r5nlobfc2wEsuk0dNzPueMEWS5r//UMRU4y/pbZc0qgMU8wkInsGwWFEv/S0lMgzhxBE4AEQg+o9VW2KL3p1fcT+UeAgEev2RQlDYqA1y+IPc/hd3L4TlTCuk2fuCt2JGPkc9/11g5T6ILyGrc1HB1x7q3kQoxoOHeXkYXJiDIHUiMIyecWvL69zQ1GNeNCCk7FweFMb3TKBQAoVgfjXu4LRN8GNypr10Q/MRJYjQmOVqXDzPlOTEdGx9IMWxmNPe65Q+oPiQYYZYxpz9nhX1LL59F+L60Biuo9HHzwK6V+kmfrujSSQdSZslSn6uX7LZiya6rwo=";
			// System.out.println(">>>>>>>>解密前：" + src1);

			// System.out.println(">>>>>>>>解密后：" +
			// java.net.URLDecoder.decode(decode(src1),"UTF-8"));

			// System.out.println(">>>>>>>>解密后：" +
			// decode("NWROvkiGvh4tHUH6XVXL5N=="));
		} catch (Exception e) {
		}
	}

}