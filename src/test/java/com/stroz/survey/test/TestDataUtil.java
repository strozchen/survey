package com.stroz.survey.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.stroz.survey.model.Page;
import com.stroz.survey.model.Question;
import com.stroz.survey.model.Survey;
import com.stroz.survey.util.DataUtil;

public class TestDataUtil {

	@Test
	public void test() {
		DataUtil du=new DataUtil();
		System.out.println(du.md5("sssss"));
	}
	
	@Test
	public void test2(){
		Survey s=new Survey();
		s.setTitle("s1");
		Page p=new Page();
		p.setTitle("p1");
		Question q1=new Question();
		q1.setTitle("q1");
		Question q2=new Question();
		q2.setTitle("q2");
		p.getQuestions().add(q1);
		p.getQuestions().add(q2);
		p.setSurvey(s);
		
		System.out.println(p.hashCode());
		
		Page pp=(Page) DataUtil.deeplyCopy(p);
		System.out.println(pp.hashCode());
		
	}

}
