package com.stroz.survey.struts2.action;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
<<<<<<< HEAD
import org.springframework.context.annotation.Scope;
=======
>>>>>>> c22cfc427e39f3a92336e0243da50fe6278f0c87
import org.springframework.stereotype.Service;

import com.stroz.survey.model.Survey;
import com.stroz.survey.model.User;
import com.stroz.survey.service.SurveyService;
import com.stroz.survey.struts2.UserAware;
import com.stroz.survey.util.ValidateUtil;

@Service
<<<<<<< HEAD
@Scope("prototype")
=======
>>>>>>> c22cfc427e39f3a92336e0243da50fe6278f0c87
public class SurveyAction extends BaseAction<Survey> implements UserAware,ServletContextAware{

	private static final long serialVersionUID = -8233625056708367886L;
	//注入SurveySrvice
	@Resource
	private SurveyService surveyService;
	private List<Survey> mySurveys;
	private User user;
	private Integer sid;
	
	private File logoPhoto;
	private String logoPhotoFileName;
<<<<<<< HEAD
	private String logoPhotoContentType;
	private ServletContext sc;
	
	/*
	 * 动态错误页指定
	 */
	private String inputPage;
	
	
	public String getInputPage() {
		return inputPage;
	}
	public void setInputPage(String inputPage) {
		this.inputPage = inputPage;
	}
	public String getLogoPhotoContentType() {
		return logoPhotoContentType;
	}
	public void setLogoPhotoContentType(String logoPhotoContentType) {
		this.logoPhotoContentType = logoPhotoContentType;
	}
=======
	private ServletContext sc;
	
	
	
>>>>>>> c22cfc427e39f3a92336e0243da50fe6278f0c87
	public File getLogoPhoto() {
		return logoPhoto;
	}
	public void setLogoPhoto(File logoPhoto) {
		this.logoPhoto = logoPhoto;
	}
	public String getLogoPhotoFileName() {
		return logoPhotoFileName;
	}
	public void setLogoPhotoFileName(String logoPhotoFileName) {
		this.logoPhotoFileName = logoPhotoFileName;
	}
	public List<Survey> getMySurveys() {
		return mySurveys;
	}
	public void setMySurveys(List<Survey> mySurveys) {
		this.mySurveys = mySurveys;
	}
	
	public Integer getSid() {
		return sid;
	}


	public void setSid(Integer sid) {
		this.sid = sid;
	}


	@Override
	public void setUser(User user) {
		// TODO Auto-generated method stub
		this.user=user;
	}


	/*
	 * 查询我的调查
	 */
	public String mySurveys(){
		this.mySurveys=surveyService.findmySurveys(user);
		return "mySurveyListPage";
	}

	/*
	 * 新建调查
	 */
	public String newSurvey(){
		this.model=surveyService.newSurvey(user);
		return "designSurveyPage";
	}

	/*
	 * 调查详细
	 */
	public String designSurvey(){
		this.model=surveyService.getSurveyWithChild(sid);
		return "designSurveyPage";
	}
	/*
	 * 返回editSurveyPage
	 */
	public String editSurveyPage(){
		this.model=surveyService.getSruvey(sid);
		return "editSurveyPage";
	}
	/*
	 * 在designSurvey之前调用，先为model赋值，后调用modelDriven拦截器
	 * 使用modelDriven.refreshModelBeforeResult后可以不用这个方法
	 */
//	public void prepareDesignSurvey(){
//		this.model=surveyService.getSurveyWithChild(sid);
//		
//	}
	public void prepareUpdataSurvey(){
		//clearErrorsAndMessages(); 
		inputPage="/editSurvey.jsp";
	}
	public String updataSurvey(){
		this.sid=model.getId();
		model.setUser(user);
		surveyService.updataSurvey(model);
		return "designSurveyAction";
	}
	/*
	 * 删除调查
	 */
	public String deleteSurvey(){
		surveyService.deleteSurvey(sid);
		return "findMySurveyAction";
	}
	/*
	 * 删除答案
	 */
	public String clearAnswer(){
		surveyService.clearAnswer(sid);
		return "findMySurveyAction";
	}
	/*
	 * 打开/关闭调查
	 */
	public String toggleStatus(){
		surveyService.toggleStatus(sid);
		return "findMySurveyAction";
	}
	/*
	 * 到达logo上传页面
	 */
	public String toAddLogoPage(){
		return "addLogoPage";
	}
	//注入servletContext对象
	@Override
	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub
		this.sc=arg0;
	}
<<<<<<< HEAD
	
	public void prepareDoAddLogo(){
		//clearErrorsAndMessages(); 
		inputPage="/addLogo.jsp";
	}
=======
>>>>>>> c22cfc427e39f3a92336e0243da50fe6278f0c87
	/*
	 * 实现logo上传
	 */
	public String doAddLogo(){
		if(ValidateUtil.isValid(logoPhotoFileName)){
			//实现上传
			String dir=sc.getRealPath("/upload");
			String ext=logoPhotoFileName.substring(logoPhotoFileName.lastIndexOf("."));
			long l=System.nanoTime();
			File newFile=new File(dir,l+ext);
			logoPhoto.renameTo(newFile);
			//更新路径
			surveyService.updateLogoPhotoPath(sid,"/upload/"+l+ext);
			
		}
		return "designSurveyAction";
	}
	/*
	 * 确认图片是否存在，jsp中调用
	 */
	public boolean photoExits(){
		String path=model.getLogoPath();
		if(ValidateUtil.isValid(path)){
			String absPath=sc.getRealPath(path);
			File file=new File(absPath);
			return file.exists(); 
		}
		return false;
	}

}
