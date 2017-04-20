package com.stroz.survey.test;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.stroz.survey.model.User;
import com.stroz.survey.service.SurveyService;

public class TestSurveyService {
	
	private static SurveyService surveyService;
	
	@BeforeClass
	public static void initUs(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:spring_bean.xml");
		surveyService=(SurveyService) ctx.getBean("surveyService");	
	}
	@Test
	public void TestnewSurvey() {
		User u=new User();
		u.setId(7);
		surveyService.newSurvey(u);
	}

}
