package com.stroz.survey.dao.impl;


import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Query;

import org.hibernate.SessionFactory;


import com.stroz.survey.dao.BaseDAO;
@SuppressWarnings("unchecked")
public abstract class BaseDAOImpl<T> implements BaseDAO<T> {
	
	@Resource
	private SessionFactory sf;
	
	
	private Class<T> clazz;
	
	public BaseDAOImpl() {
		// TODO Auto-generated constructor stub
		ParameterizedType type= (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz=(Class<T>) type.getActualTypeArguments()[0];

	}

	@Override
	public void saveEntity(T t) {
		sf.getCurrentSession().save(t);
	
		
	}

	@Override
	public void updateEntity(T t) {
		sf.getCurrentSession().update(t);
		
	}

	@Override
	public void saveOrUpdateEntity(T t) {
		sf.getCurrentSession().saveOrUpdate(t);
		
	}

	@Override
	public void deleteEntity(T t) {
		sf.getCurrentSession().delete(t);
		
	}

	@Override
	public void batchEntityByHQL(String hql, Object... objects) {
		Query query=sf.getCurrentSession().createQuery(hql);
		for (int i=0;i<objects.length;i++){
			query.setParameter(i, objects[i]);			
		}
		query.executeUpdate();
		
	}

	@Override
	public T readEntity(Integer id) {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().load(clazz, id);

	}

	@Override
	public T getEntity(Integer id) {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().get(clazz, id);
	}

	
	@Override
	public List<T> findEntitybyHQL(String hql, Object... objects) {
		Query query=sf.getCurrentSession().createQuery(hql);
		for (int i=0;i<objects.length;i++){
			query.setParameter(i, objects[i]);			
		}
		return query.getResultList();
	}

}
