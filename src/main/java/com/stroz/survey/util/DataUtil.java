package com.stroz.survey.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.MessageDigest;

public class DataUtil {

	public static String md5(String src){
		try {
			StringBuffer buffer = new StringBuffer();
			char[] chars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E','F' };
			byte[] bytes = src.getBytes();
			MessageDigest md;
			md = MessageDigest.getInstance("MD5");
			byte[] targ=md.digest(bytes);
			for(byte b:targ){
				buffer.append(chars[(b>>4) & 0x0F]);
				buffer.append(chars[b & 0x0F]);
			}
			return buffer.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static Serializable deeplyCopy(Serializable obj){
		try {
			ByteArrayOutputStream bos=new ByteArrayOutputStream();	
			ObjectOutputStream oos=new ObjectOutputStream(bos);
			oos.writeObject(obj);
			byte[] bytes=bos.toByteArray();
			bos.close();
			oos.close();
			
			ByteArrayInputStream bis=new ByteArrayInputStream(bytes);
			ObjectInputStream ois=new ObjectInputStream(bis);
			bis.close();
			ois.close();
			Serializable copy=(Serializable) ois.readObject();
			return copy;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
