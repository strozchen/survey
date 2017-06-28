package com.stroz.survey.struts2.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.stroz.survey.model.Page;
import com.stroz.survey.model.Question;
import com.stroz.survey.service.SurveyService;
@Controller
@Scope("prototype")
public class QuestionAction extends BaseAction<Question> {
	
	private static final long serialVersionUID = 5309173869909225326L;
	private Integer sid;
	private Integer pid;
	@Resource
	private SurveyService surveyService;
	
	
	public Integer getSid() {
		return sid;
	}


	public void setSid(Integer sid) {
		this.sid = sid;
	}


	public Integer getPid() {
		return pid;
	}


	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/*
	 * 到达问题类型选择页面
	 */
	public String toSelectQusetionType(){
		return "SelectQusetionTypePage";
	}
	/*
	 * 到达设计页面
	 */
	public String toDesignQuestionPage(){
		return String.valueOf(model.getQuestionType());
	}
	/*
	 * 保存新的问题页面
	 */
	public String saveOrUpdateQuestion(){
		Page p=new Page();
		p.setId(pid);
		model.setPage(p);
		surveyService.saveOrUpdataQuestion(model);
		return "designSurveyAction";		
	}
}
