package com.stroz.survey.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * ����action��ר�����ڼ̳�
 */
public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T>, Preparable {

	private static final long serialVersionUID = 6774619839140900323L;

	@Override
	public void prepare() throws Exception {

	}

	@Override
	public abstract T getModel();

}
