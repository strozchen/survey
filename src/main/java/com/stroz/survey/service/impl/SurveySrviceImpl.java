package com.stroz.survey.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.stroz.survey.dao.BaseDAO;
import com.stroz.survey.model.Page;
import com.stroz.survey.model.Survey;
import com.stroz.survey.model.User;
import com.stroz.survey.service.SurveyService;

@Service("surveyService")
public class SurveySrviceImpl implements SurveyService {
	@Resource(name="surveyDAO")
	private BaseDAO<Survey> surveyDAO;
	@Resource(name="pageDAO")
	private BaseDAO<Page> pageDAO;
	/*
	 * 查找调查列表
	 */
	@Override
	public List<Survey> findmySurveys(User user) {
		String hql="from Survey s where s.user.id=?";
		return surveyDAO.findEntitybyHQL(hql, user.getId());
	}
	/*
	 * 新建调查列表
	 */
	@Override
	public Survey newSurvey(User user) {
		Survey s=new Survey();
		Page p=new Page();
		p.setSurvey(s);
		s.getPages().add(p);
		s.setUser(user);
		surveyDAO.saveEntity(s);
		pageDAO.saveEntity(p);
		return s;
	}
}
