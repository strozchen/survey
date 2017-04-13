package com.storz.survey.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class TestDataSource {

	@Test
	public void test() throws SQLException {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring_bean.xml");
//		DataSource datasource=(DataSource) ctx.getBean("dataSource");
//		System.out.println(datasource.getConnection());
		SessionFactory sessionfactory=(SessionFactory) ctx.getBean("sessionFactory");			
		System.out.println(sessionfactory.getCurrentSession());
	}

}
