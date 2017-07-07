package com.stroz.survey.model;

import java.io.Serializable;
import java.util.Date;

public class Answer implements Serializable{
	private static final long serialVersionUID = -3368370337809139688L;
	private Integer id;
	private String answerIds;//选项索引
	private String otherAnswer;
	private String uuid;//批次
	private Date answerTime;
	private Integer questionId;//关联字段
	private Integer surveyId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAnswerIds() {
		return answerIds;
	}
	public void setAnswerIds(String answerIds) {
		this.answerIds = answerIds;
	}
	public String getOtherAnswer() {
		return otherAnswer;
	}
	public void setOtherAnswer(String otherAnswer) {
		this.otherAnswer = otherAnswer;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public Date getAnswerTime() {
		return answerTime;
	}
	public void setAnswerTime(Date answerTime) {
		this.answerTime = answerTime;
	}
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	public Integer getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(Integer surveyId) {
		this.surveyId = surveyId;
	}
	
	
}
