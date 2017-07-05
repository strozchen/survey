package com.stroz.survey.struts2.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.stroz.survey.model.User;
import com.stroz.survey.service.UserService;
import com.stroz.survey.struts2.UserAware;
import com.stroz.survey.util.DataUtil;
@Controller
@Scope("prototype")
public class LoginAction extends BaseAction<User> implements SessionAware{

	private static final long serialVersionUID = -6515745119430153787L;
	@Resource
	private UserService userService;
	private Map<String,Object> sessionMap;
	private User user;
	/*
	 * 到达登陆页面
	 */
	public String toLoginPage(){
		return "loginPage";
	}
	/*
	 * 进行登陆处理
	 */
	public String doLogin(){
		return SUCCESS;
	}
	/*
	 * 校验登陆信息
	 */
	public void validateDoLogin() {
		User user=userService.validateLoginInfo(model.getEmail(),DataUtil.md5(model.getPassword()));
		if(user==null){
			addActionError("emial/password error");
		}
		else{
			sessionMap.put("user",user);
		}
	}
	//注入session
	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionMap=arg0;
	}
}
