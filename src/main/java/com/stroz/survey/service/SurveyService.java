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
	/*
	 * 根据id查询单个调查
	 */
	public Survey getSruvey(Integer sid);
	
	/*
	 * 根据ID查询单个调查，并同时遍历所有子参数，避免渲染视图出现懒加载异常
	 */
	public Survey getSurveyWithChild(Integer sid);
	/*
	 * 更新survey
	 */
	public void updataSurvey(Survey model);

}
