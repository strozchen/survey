package com.stroz.survey.util;
/*
 * �ַ���������
 */
public class StringUtil {

	/*
	 * ����ַ���
	 */
	public static String[] str2Arr(String src,String tag){
		if(ValidateUtil.isValid(src)){
			return src.split(tag);
		}
		return null;
	}
}
