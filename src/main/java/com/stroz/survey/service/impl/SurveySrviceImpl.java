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
	 * ���ҵ����б�
	 */
	@Override
	public List<Survey> findmySurveys(User user) {
		String hql="from Survey s where s.user.id=?";
		return surveyDAO.findEntitybyHQL(hql, user.getId());
	}
	/*
	 * �½������б�
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
	/*
	 * ��ѯ��������
	 */
	@Override
	public Survey getSruvey(Integer sid) {		
		return surveyDAO.getEntity(sid);
	}
	/*
	 * ����ID��ѯ�������飬��ͬʱ���������Ӳ�����������Ⱦ��ͼ�����������쳣
	 */	
	@Override
	public Survey getSurveyWithChild(Integer sid) {
		Survey s=this.getSruvey(sid);
		for(Page p:s.getPages()){
			p.getQuestions().size();
		}
		return s;
	}
	@Override
	public void updataSurvey(Survey model) {
		this.surveyDAO.updateEntity(model);
	}
}
