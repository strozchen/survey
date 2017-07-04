package com.stroz.survey.struts2.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.stroz.survey.model.Page;
import com.stroz.survey.model.Survey;
import com.stroz.survey.service.SurveyService;
@Controller
@Scope("prototype")
public class PageAction extends BaseAction<Page> {

	private static final long serialVersionUID = 5288408465130207325L;

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
	 * 到达添加页面的页面
	 */
	public String toAddPage(){
		return "addPagePage";
	}
	/*
	 * 保存/更新页面
	 */
	public String saveOrUpdatePage(){
		Survey s=new Survey();
		s.setId(sid);
		model.setSurvey(s);
		surveyService.saveOrUpdataPage(model);
		return "designSurveyAction";
	}
	/*
	 * 编辑页面
	 */
	public String editPage(){
		model=surveyService.getPage(pid);
		return "editPagePage";
	}
	/*
	 * 删除页面
	 */
	public String deletePage(){
		surveyService.deletePage(pid);
		return "designSurveyAction";
	}
}
