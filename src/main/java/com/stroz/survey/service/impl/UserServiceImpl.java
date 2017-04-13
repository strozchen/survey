package com.stroz.survey.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.stroz.survey.dao.BaseDAO;
import com.stroz.survey.model.User;
import com.stroz.survey.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	@Resource(name="userDAO")
	public void setDao(BaseDAO<User> dao) {
		super.setDao(dao);
	}	

}
