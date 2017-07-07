package com.stroz.survey.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Page implements Serializable{
	private static final long serialVersionUID = -7019313777180194146L;
	private Integer id;
	private String title="未命名";
	private String description;
	//页面到调查的多对一关系,transient用于在进行串行化时忽略survey
	private transient Survey survey;
	//页面到问题的一对多关系
	private Set<Question> questions=new HashSet<>();
	//页序
	private float ordernum;

	public float getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(float ordernum) {
		this.ordernum = ordernum;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		if(id!=null){
			ordernum=id;// 默认页序与id一致
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
