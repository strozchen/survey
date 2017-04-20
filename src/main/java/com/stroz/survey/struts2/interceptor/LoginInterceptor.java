package com.stroz.survey.struts2.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.storz.survey.struts2.UserAware;
import com.stroz.survey.model.User;
import com.stroz.survey.struts2.action.BaseAction;
import com.stroz.survey.struts2.action.LoginAction;
import com.stroz.survey.struts2.action.RegAction;
/*
 * 登陆拦截器，从session中确认是否已经登陆
 */
public class LoginInterceptor implements Interceptor {

	private static final long serialVersionUID = 8196320868284085925L;

	@Override
	public void destroy() {

	}

	@Override
	public void init() {

	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		BaseAction action=(BaseAction) arg0.getAction();
		if(action instanceof LoginAction || action instanceof RegAction){
			// 登陆或注册action直接放行
			arg0.invoke();
		} else {
			User user = (User) arg0.getInvocationContext().getSession().get("user");
			if (user == null) {
				// 未登陆，返回登陆界面
				return "login";
			} else {
				if (action instanceof UserAware) {
					//对实现UserAware接口的实际进行用户注入
					((UserAware) action).setUser(user);
				}
				// 已登陆放行
				arg0.invoke();
			}
		}
		return null;
	}

}
