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
	//ע��SurveySrvice
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
	 * ��ѯ�ҵĵ���
	 */
	public String mySurveys(){
		this.mySurveys=surveyService.findmySurveys(user);
		return "mySurveyListPage";
	}

	/*
	 * �½�����
	 */
	public String newSurvey(){
		this.model=surveyService.newSurvey(user);
		return "designSurveyPage";
	}

	/*
	 * ������ϸ
	 */
	public String designSurvey(){
		this.model=surveyService.getSurveyWithChild(sid);
		return "designSurveyPage";
	}
	/*
	 * ����editSurveyPage
	 */
	public String editSurveyPage(){
		this.model=surveyService.getSruvey(sid);
		return "editSurveyPage";
	}
	/*
	 * ��designSurvey֮ǰ���ã���Ϊmodel��ֵ�������modelDriven������
	 * ʹ��modelDriven.refreshModelBeforeResult����Բ����������
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
