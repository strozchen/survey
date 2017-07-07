package com.stroz.survey.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Page implements Serializable{
	private static final long serialVersionUID = -7019313777180194146L;
	private Integer id;
	private String title="δ����";
	private String description;
	//ҳ�浽����Ķ��һ��ϵ,transient�����ڽ��д��л�ʱ����survey
	private transient Survey survey;
	//ҳ�浽�����һ�Զ��ϵ
	private Set<Question> questions=new HashSet<>();
	//ҳ��
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
			ordernum=id;// Ĭ��ҳ����idһ��
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
