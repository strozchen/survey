package com.stroz.survey.struts2.action;

import java.lang.reflect.ParameterizedType;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * 抽象action，专门用于继承
 */
public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T>, Preparable {

	private static final long serialVersionUID = 6774619839140900323L;

	public T model;
	
	public BaseAction() {
		ParameterizedType type=(ParameterizedType) this.getClass().getGenericSuperclass();
		Class clazz=(Class) type.getActualTypeArguments()[0];
		try {
			model=(T) clazz.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void prepare() throws Exception {

	}

	@Override
	public T getModel(){
		return model;
	};

}
