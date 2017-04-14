package com.stroz.survey.struts2.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.stroz.survey.model.User;
@Controller
@Scope("prototype")
public class RegAction extends BaseAction<User> {

	private static final long serialVersionUID = 7575009447880442041L;
	
	private User model;
	@Override
	public User getModel() {
		return model;
	}
	/*
	 * µ½´ï×¢²áÒ³Ãæ
	 */
	public String toRegPage(){
		return "regPage";
	}

}
