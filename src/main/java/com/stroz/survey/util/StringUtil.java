package com.stroz.survey.util;
/*
 * ×Ö·û´®¹¤¾ßÀà
 */
public class StringUtil {

	/*
	 * ²ð·Ö×Ö·û´®
	 */
	public static String[] str2Arr(String src,String tag){
		if(ValidateUtil.isValid(src)){
			return src.split(tag);
		}
		return null;
	}
}
