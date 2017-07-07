package com.stroz.survey.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.stroz.survey.dao.BaseDAO;
import com.stroz.survey.service.BaseService;
/*
 * 抽象的BaseService实现，专门用于被继承
 */
public abstract class BaseServiceImpl <T> implements BaseService<T> {

	private BaseDAO<T> dao;
	
	@Resource
	public void setDao(BaseDAO<T> dao) {
		this.dao = dao;
	}

	@Override
	public void saveEntity(T t) {
		dao.saveEntity(t);
		
	}

	@Override
	public void updateEntity(T t) {
		dao.updateEntity(t);
	}

	@Override
	public void saveOrUpdateEntity(T t) {
		dao.saveOrUpdateEntity(t);
	}

	@Override
	public void deleteEntity(T t) {
		dao.deleteEntity(t);
	}

	@Override
	public void batchEntityByHQL(String hql, Object... objects) {
		dao.batchEntityByHQL(hql, objects);
	}

	@Override
	public T readEntity(Integer id) {
		return dao.readEntity(id);
	}

	@Override
	public T getEntity(Integer id) {
		return dao.getEntity(id);
	}

	@Override
	public List<T> findEntitybyHQL(String hql, Object... objects) {
		return dao.findEntitybyHQL(hql, objects);
	}
	//单值查询
	public Object uniqueResult(String hql,Object...objects){
		return dao.uniqueResult(hql, objects);
	}

}
