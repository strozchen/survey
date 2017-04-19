package com.stroz.survey.util;

import java.util.Collection;

public class ValidateUtil {
	/*
	 * 判断字符有效性,是空不通过返回0，通过返回1
	 */
	public static boolean isValid(String src){
		return !(src==null||"".equals(src.trim()));
	}
	/*
	 * 判断集合有效性
	 */
	public static boolean isValid(Collection col){
		return !(col==null||col.isEmpty());
	}
}
