package com.stroz.survey.service;

import com.stroz.survey.model.User;

public interface UserService extends BaseService<User> {
	/*
	 * �鿴�Ƿ�ע��
	 */
	public boolean isRegisted(String email);
	/*
	 * ��֤��½��Ϣ
	 */
	public User validateLoginInfo(String email, String md5);

}
