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
	
	//ע���û�service
	@Resource
	private UserService userService;

	
	
	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


	/*
	 * ����ע��ҳ��,@SkipValidation����У��
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
	 * У��
	 */
	@Override
	public void validate() {
		//1.����ǿ�
		if(!ValidateUtil.isValid(model.getEmail())){
			addFieldError("email", "email�Ǳ�������");
		}
		if(!ValidateUtil.isValid(model.getPassword())){
			addFieldError("password", "password�Ǳ�������");
			System.out.println("password�Ǳ�������");
		}
		if(!ValidateUtil.isValid(model.getNickName())){
			addFieldError("nickName", "nickName�Ǳ�������");
		}
		if(hasErrors()){
			return;
		}
		//2.����һ��
		if(!confirmPassword.equals(model.getPassword())){
			addFieldError("password", "password��һ��");
			return;
		}		
		//3.emailռ��
		if(userService.isRegisted(model.getEmail())){
			addFieldError("email", "email�ѱ�ռ��");
			return;
		}
		
	}
	
	
}
