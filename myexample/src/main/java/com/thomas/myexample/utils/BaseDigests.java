package com.thomas.myexample.utils;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springside.modules.security.utils.Digests;
import org.springside.modules.utils.Exceptions;

/**
 * @ClassName: BaseDigests
 * @Description: 加密基础类支持SHA1 MD5 BASE64等
 * @author XuTao
 * @date 2014-4-9 下午02:21:36
 * 
 */
public class BaseDigests extends Digests {
	private static Logger log = LoggerFactory.getLogger(BaseDigests.class);

	public final static String ENCODING = "UTF-8";

	public static byte[] md5(byte[] input) {
		return digest(input, "MD5", null, 1);
	}

	/**
	 * 对字符串进行散列, 支持md5与sha1算法.
	 */
	private static byte[] digest(byte[] input, String algorithm, byte[] salt, int iterations) {
		try {
			MessageDigest digest = MessageDigest.getInstance(algorithm);

			if (salt != null) {
				digest.update(salt);
			}

			byte[] result = digest.digest(input);

			for (int i = 1; i < iterations; i++) {
				digest.reset();
				result = digest.digest(result);
			}
			return result;
		} catch (GeneralSecurityException e) {
			throw Exceptions.unchecked(e);
		}
	}

	// 使用md5将url加密
	public static byte[] md5(String url) {
		if (!StringUtils.isEmpty(url)) {
			try {
				byte[] bs = BaseDigests.md5(url.getBytes());
				log.info("加密过后的字段{}", new String(bs, "gb2312"));
				return bs;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	// 使用base64加密
	public static String base64Encode(String data) throws UnsupportedEncodingException {
		byte[] b = Base64.encodeBase64URLSafe(data.getBytes(ENCODING));
		return new String(b, ENCODING);
	}

	// 使用base64解密
	public static String base64Decoce(String data) throws UnsupportedEncodingException {
		byte[] b = Base64.decodeBase64(data.getBytes(ENCODING));
		return new String(b, ENCODING);
	}
}
