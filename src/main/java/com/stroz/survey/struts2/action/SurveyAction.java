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
	private Integer sid;
	public List<Survey> getMySurveys() {
		return mySurveys;
	}


	public void setMySurveys(List<Survey> mySurveys) {
		this.mySurveys = mySurveys;
	}
	
	public Integer getSid() {
		return sid;
	}


	public void setSid(Integer sid) {
		this.sid = sid;
	}


	@Override
	public void setUser(User user) {
		// TODO Auto-generated method stub
		this.user=user;
	}


	/*
	 * 查询我的调查
	 */
	public String mySurveys(){
		this.mySurveys=surveyService.findmySurveys(user);
		return "mySurveyListPage";
	}

	/*
	 * 新建调查
	 */
	public String newSurvey(){
		this.model=surveyService.newSurvey(user);
		return "designSurveyPage";
	}

	/*
	 * 调查详细
	 */
	public String designSurvey(){
		this.model=surveyService.getSurveyWithChild(sid);
		return "designSurveyPage";
	}
	/*
	 * 返回editSurveyPage
	 */
	public String editSurveyPage(){
		this.model=surveyService.getSruvey(sid);
		return "editSurveyPage";
	}
	/*
	 * 在designSurvey之前调用，先为model赋值，后调用modelDriven拦截器
	 * 使用modelDriven.refreshModelBeforeResult后可以不用这个方法
	 */
//	public void prepareDesignSurvey(){
//		this.model=surveyService.getSurveyWithChild(sid);
//		
//	}

	public String updataSurvey(){
		this.sid=model.getId();
		model.setUser(user);
		surveyService.updataSurvey(model);
		return "designSurveyAction";
	}
}
