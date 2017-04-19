package com.stroz.survey.struts2.action;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.stroz.survey.model.User;
import com.stroz.survey.service.UserService;
import com.stroz.survey.util.DataUtil;
import com.stroz.survey.util.ValidateUtil;
@Controller
@Scope("prototype")
public class RegAction extends BaseAction<User> {

	private static final long serialVersionUID = 7575009447880442041L;
	
	private String confirmPassword; 
	
	//注入用户service
	@Resource
	private UserService userService;

	
	
	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


	/*
	 * 到达注册页面,@SkipValidation跳过校验
	 */
	@SkipValidation
	public String toRegPage(){
		return "regPage";
	}
	
	public String doReg(){
		model.setPassword(DataUtil.md5(model.getPassword()));
		userService.saveEntity(model);
		return SUCCESS;
	}
	
	/*
	 * 校验
	 */
	@Override
	public void validate() {
		//1.邮箱非空
		if(!ValidateUtil.isValid(model.getEmail())){
			addFieldError("email", "email是必须填项");
		}
		if(!ValidateUtil.isValid(model.getPassword())){
			addFieldError("password", "password是必须填项");
			System.out.println("password是必须填项");
		}
		if(!ValidateUtil.isValid(model.getNickName())){
			addFieldError("nickName", "nickName是必须填项");
		}
		if(hasErrors()){
			return;
		}
		//2.密码一致
		if(!confirmPassword.equals(model.getPassword())){
			addFieldError("password", "password不一致");
			return;
		}		
		//3.email占用
		if(userService.isRegisted(model.getEmail())){
			addFieldError("email", "email已被占用");
			return;
		}
		
	}
	
	
}
