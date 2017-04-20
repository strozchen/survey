package com.stroz.survey.service;

import java.util.List;

import com.stroz.survey.model.Survey;
import com.stroz.survey.model.User;
/*
 * SurveySrvice
 */
public interface SurveyService {
	/*
	 * 查询调查列表
	 */
	public List<Survey> findmySurveys(User user);
	/*
	 * 新建调查列表
	 */
	public Survey newSurvey(User user);

}
