package com.stroz.survey.struts2.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.storz.survey.struts2.UserAware;
import com.stroz.survey.model.User;
import com.stroz.survey.struts2.action.BaseAction;
import com.stroz.survey.struts2.action.LoginAction;
import com.stroz.survey.struts2.action.RegAction;
/*
 * ��½����������session��ȷ���Ƿ��Ѿ���½
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
			// ��½��ע��actionֱ�ӷ���
			arg0.invoke();
		} else {
			User user = (User) arg0.getInvocationContext().getSession().get("user");
			if (user == null) {
				// δ��½�����ص�½����
				return "login";
			} else {
				if (action instanceof UserAware) {
					//��ʵ��UserAware�ӿڵ�ʵ�ʽ����û�ע��
					((UserAware) action).setUser(user);
				}
				// �ѵ�½����
				arg0.invoke();
			}
		}
		return null;
	}

}
