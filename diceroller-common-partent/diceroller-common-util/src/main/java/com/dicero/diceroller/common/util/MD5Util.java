package com.dicero.diceroller.common.util;

import org.springframework.util.DigestUtils;

/**
 * 
* <p></p>
* @author ningzhong.zeng
 */
public class MD5Util {
	/**
     * 签名字符串
     * @param text 需要签名的字符串
     * @param key 密钥
     * @param input_charset 编码格式
     * @return 签名结果
     */
    public static String sign(String text, String key) {
    	text = text + key;
    	return DigestUtils.md5DigestAsHex(text.getBytes()).toUpperCase();
    }

    /**
     * 签名字符串
     * @param text 需要签名的字符串
     * @param sign 签名结果
     * @param key 密钥
     * @param input_charset 编码格式
     * @return 签名结果
     */
    public static boolean verify(String text, String sign, String key) {
    	text = text + key;
    	String mysign = DigestUtils.md5DigestAsHex(text.getBytes()).toUpperCase();
    	if(mysign.equals(sign)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public static void main(String[] args) {
    	String pd = MD5Util.sign("123456", "");
    	System.out.println("pd:"+pd);
    	System.err.println(MD5Util.verify("123456", pd, ""));
    	// pd:e10adc3949ba59abbe56e057f20f883e
	}

}