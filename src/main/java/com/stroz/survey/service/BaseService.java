package com.stroz.survey.service;

import java.util.List;

public interface BaseService<T> {
	public void saveEntity(T t);
	public void updateEntity(T t);
	public void saveOrUpdateEntity(T t);
	public void deleteEntity(T t);
	public void batchEntityByHQL(String hql,Object...objects);
	
	public T readEntity(Integer id);
	public T getEntity(Integer id);
	public List<T> findEntitybyHQL(String hql,Object...objects);
	//µ•÷µ≤È—Ø
	public Object uniqueResult(String hql,Object...objects);
}
