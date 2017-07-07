package com.stroz.survey.dao;

import java.util.List;
/**
 * baseDAO接口
 * @author chenwei-pc
 *
 * @param <T>
 */
public interface BaseDAO<T> {
	public void saveEntity(T t);
	public void updateEntity(T t);
	public void saveOrUpdateEntity(T t);
	public void deleteEntity(T t);
	public void batchEntityByHQL(String hql,Object...objects);
	
	public T readEntity(Integer id);
	public T getEntity(Integer id);
	public List<T> findEntitybyHQL(String hql,Object...objects);
	//单值查询
	public Object uniqueResult(String hql,Object...objects);
	
}
