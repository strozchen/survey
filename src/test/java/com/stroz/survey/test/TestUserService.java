package com.stroz.survey.test;

import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.stroz.survey.model.User;
import com.stroz.survey.service.SurveyService;
import com.stroz.survey.service.UserService;

public class TestUserService {

	private static UserService us;

	@BeforeClass
	public static void initUs(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:spring_bean.xml");
		us=(UserService) ctx.getBean("userService");	
	}
	
	@Test
	public void insertUser() {
		User u=new User();
		u.setName("����");
		u.setPassword("222222");
		u.setEmail("lisi@xxx.com");
		u.setNickName("ls");
		
		us.saveEntity(u);

	}

}
