package com.monitor.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 项目工具类
 * @author liushahe
 *
 */
public class Utils {
	/**
	 * 获取用户编号
     * 格式 U+年月日时分秒+6位随机数
	 * @return
	 */
	public static String getUid() {
		Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMddhhmmss");
		String time=format.format(date);
		String random=String.valueOf(new Random().nextInt(1000000));
		return "u"+time+random;
	}

}
