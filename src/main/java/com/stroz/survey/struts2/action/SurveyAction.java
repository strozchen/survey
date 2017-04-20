package com.stroz.survey.struts2.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Service;

import com.storz.survey.struts2.UserAware;
import com.stroz.survey.model.Survey;
import com.stroz.survey.model.User;
import com.stroz.survey.service.SurveyService;

@Service
public class SurveyAction extends BaseAction<Survey> implements UserAware {

	private static final long serialVersionUID = -8233625056708367886L;
	//注入SurveySrvice
	@Resource
	private SurveyService surveyService;
	private List<Survey> mySurveys;
	private User user;
	
	public List<Survey> getMySurveys() {
		return mySurveys;
	}


	public void setMySurveys(List<Survey> mySurveys) {
		this.mySurveys = mySurveys;
	}


	/*
	 * 查询我的调查
	 */
	public String mySurveys(){
		this.mySurveys=surveyService.findmySurveys(user);
		return "mySurveyListPage";
	}

	public String newSurvey(){
		this.model=surveyService.newSurvey(user);
		return "designSurveyPage";
	}


	@Override
	public void setUser(User user) {
		// TODO Auto-generated method stub
		this.user=user;
	}

}
