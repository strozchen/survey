package com.stroz.survey.service;

import java.util.List;

import com.stroz.survey.model.Page;
import com.stroz.survey.model.Question;
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
	//添加/更新page
	public void saveOrUpdataPage(Page model);
	/*
	 * 编辑页面
	 */
	public Page getPage(Integer pid);
	/*
	 * 更新问题
	 */
	public void saveOrUpdataQuestion(Question model);
	/*
	 * 删问题
	 */
	public void deleteQusetion(Integer qid);
	/*
	 * 删除页面
	 */
	public void deletePage(Integer pid);
	/*
	 * 删除调查
	 */
	public void deleteSurvey(Integer sid);
	/*
	 * 编辑问题
	 */
	public Question getQuestion(Integer qid);

}
