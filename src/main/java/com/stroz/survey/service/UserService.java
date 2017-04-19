package com.stroz.survey.service;

import com.stroz.survey.model.User;

public interface UserService extends BaseService<User> {
	/*
	 * 查看是否注册
	 */
	public boolean isRegisted(String email);
	/*
	 * 验证登陆信息
	 */
	public User validateLoginInfo(String email, String md5);

}
