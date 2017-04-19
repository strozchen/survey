package com.stroz.survey.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.stroz.survey.util.DataUtil;

public class TestDataUtil {

	@Test
	public void test() {
		DataUtil du=new DataUtil();
		System.out.println(du.md5("sssss"));
	}

}
