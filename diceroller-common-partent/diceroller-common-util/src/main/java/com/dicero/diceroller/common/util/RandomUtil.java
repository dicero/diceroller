package com.dicero.diceroller.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

/**
* <p></p>
* @author ningzhong.zeng
*
 */
public class RandomUtil {
	
	public static Random random = new Random();
	
	 /**
     * @description 生成唯一的uuid
     * @return 
     * @return 返回类型 
     * @throws
     */
    public static String randomUserUuid(String fix) {
        return fix + "88" + RandomStringUtils.randomNumeric(6);
    }

	 /**
     * @description 生成唯一的uuid
     * @return 
     * @return 返回类型 
     * @throws
     */
    public static String randomUuid(String fix) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");  
        String dateStr = dateFormat.format(date);
        return dateStr + RandomStringUtils.randomAlphabetic(6) + fix;
    }
    
    /**
     * @description 生成唯一的uuid
     * @return 
     * @return 返回类型 
     * @throws
     */
    public static String randomUuid(String fix, int size) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");  
        String dateStr = dateFormat.format(date);
        return dateStr + RandomStringUtils.randomNumeric(size) + fix;
    }
    
    /**
     * @description 生成唯一的uuid
     * @return 
     * @return 返回类型 
     * @throws
     */
    public static String randomUuid(String fix, int size, String pattern) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat(pattern);  
        String dateStr = dateFormat.format(date);
        return dateStr + RandomStringUtils.randomAlphabetic(size) + fix;
    }
    
    /**
	 * <p>根据长度返回随机数</p>
	 * @param length
	 * @return
	 */
	public static String randomStringOrNumber(int size) {
		StringBuilder ret = new StringBuilder();
		for (int i = 0; i < size; i++) {
			boolean isChar = (random.nextInt(2) % 2 == 0);// 输出字母还是数字
			if (isChar) { // 字符串
				int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; // 取得大写字母还是小写字母
				ret.append((char) (choice + random.nextInt(26)));
			} else { // 数字
				ret.append(Integer.toString(random.nextInt(10)));
			}
		}
		return ret.toString();
	}
    
    /**
     * @description 生成随机数
     * @param size
     * @return 
     * @return 返回类型 
     * @throws
     */
    public static String randomString(int size) {
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < size; i++) {
            str.append(new Random().nextInt(9));
        }
        return str.toString();
    }
    
}
