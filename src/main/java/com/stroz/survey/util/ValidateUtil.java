package com.stroz.survey.util;

import java.util.Collection;

public class ValidateUtil {
	/*
	 * �ж��ַ���Ч��,�ǿղ�ͨ������0��ͨ������1
	 */
	public static boolean isValid(String src){
		return !(src==null||"".equals(src.trim()));
	}
	/*
	 * �жϼ�����Ч��
	 */
	public static boolean isValid(Collection col){
		return !(col==null||col.isEmpty());
	}
}
