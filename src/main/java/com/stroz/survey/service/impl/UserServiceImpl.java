package com.stroz.survey.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.stroz.survey.dao.BaseDAO;
import com.stroz.survey.model.User;
import com.stroz.survey.service.UserService;
import com.stroz.survey.util.ValidateUtil;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	@Resource(name="userDAO")
	public void setDao(BaseDAO<User> dao) {
		super.setDao(dao);
	}

	@Override
	public boolean isRegisted(String email) {
		String hql="from User u where u.email=?";
		List<User> list=this.findEntitybyHQL(hql, email);
		return ValidateUtil.isValid(list);
	}

	@Override
	public User validateLoginInfo(String email, String md5) {
		String hql="from User u where u.email=? and u.password=?";
		List<User> list=this.findEntitybyHQL(hql, email,md5);
		return ValidateUtil.isValid(list)?list.get(0):null;
	}	

}
