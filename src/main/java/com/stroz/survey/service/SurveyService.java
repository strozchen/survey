package com.stroz.survey.service;

import java.util.List;

import com.stroz.survey.model.Survey;
import com.stroz.survey.model.User;
/*
 * SurveySrvice
 */
public interface SurveyService {
	/*
	 * ��ѯ�����б�
	 */
	public List<Survey> findmySurveys(User user);
	/*
	 * �½������б�
	 */
	public Survey newSurvey(User user);

}
