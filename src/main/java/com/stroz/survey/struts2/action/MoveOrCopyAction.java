package com.stroz.survey.struts2.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.stroz.survey.model.Page;
import com.stroz.survey.model.Survey;
import com.stroz.survey.model.User;
import com.stroz.survey.service.SurveyService;
import com.stroz.survey.struts2.UserAware;
/*
 * 移动/复制页面action
 */
@Service
@Scope("prototype")
public class MoveOrCopyAction extends BaseAction<Page> implements UserAware {
	
	private static final long serialVersionUID = 2708502982807203813L;
	@Resource
	private SurveyService surveyService;
	private User user;
	
	private List<Survey> mySurveys;
	private Integer srcPid;
	private Integer targPid;
	private int pos;
	private int sid;
	
	public Integer getSrcPid() {
		return srcPid;
	}

	public void setSrcPid(Integer srcPid) {
		this.srcPid = srcPid;
	}

	public Integer getTargPid() {
		return targPid;
	}

	public void setTargPid(Integer targPid) {
		this.targPid = targPid;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	public List<Survey> getMySurveys() {
		return mySurveys;
	}

	public void setMySurveys(List<Survey> mySurveys) {
		this.mySurveys = mySurveys;
	}

	/*
	 * 到达移动/复制列表页面
	 */
	public String toSelectTargetPage(){
		this.mySurveys=surveyService.getSurveyWithPage(user);
		return "moveOrCopyListPage";
	}
	/*
	 * 执行移动/复制操作
	 */
	public String doMoveOrCopyPage(){
		surveyService.moveOrCopyPage(srcPid,targPid,pos);
		return "designSurveyAction";
	}
}
