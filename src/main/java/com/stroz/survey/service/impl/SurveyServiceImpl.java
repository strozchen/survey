package com.stroz.survey.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.stroz.survey.dao.BaseDAO;
import com.stroz.survey.model.Answer;
import com.stroz.survey.model.Page;
import com.stroz.survey.model.Question;
import com.stroz.survey.model.Survey;
import com.stroz.survey.model.User;
import com.stroz.survey.service.SurveyService;
import com.stroz.survey.util.DataUtil;

@Service("surveyService")
public class SurveyServiceImpl implements SurveyService {
	@Resource(name="surveyDAO")
	private BaseDAO<Survey> surveyDAO;
	@Resource(name="pageDAO")
	private BaseDAO<Page> pageDAO;
	@Resource(name="questionDAO")
	private BaseDAO<Question> questionDAO;
	@Resource(name="answerDAO")
	private BaseDAO<Answer> answerDAO;
	/*
	 * 查找调查列表
	 */
	@Override
	public List<Survey> findmySurveys(User user) {
		String hql="from Survey s where s.user.id=?";
		return surveyDAO.findEntitybyHQL(hql, user.getId());
	}
	/*
	 * 新建调查列表
	 */
	@Override
	public Survey newSurvey(User user) {
		Survey s=new Survey();
		Page p=new Page();
		p.setSurvey(s);
		s.getPages().add(p);
		s.setUser(user);
		surveyDAO.saveEntity(s);
		pageDAO.saveEntity(p);
		return s;
	}
	/*
	 * 查询单个调查
	 */
	@Override
	public Survey getSruvey(Integer sid) {		
		return surveyDAO.getEntity(sid);
	}
	/*
	 * 根据ID查询单个调查，并同时遍历所有子参数，避免渲染视图出现懒加载异常
	 */	
	@Override
	public Survey getSurveyWithChild(Integer sid) {
		Survey s=this.getSruvey(sid);
		for(Page p:s.getPages()){
			p.getQuestions().size();
		}
		return s;
	}
	@Override
	public void updataSurvey(Survey model) {
		this.surveyDAO.updateEntity(model);
	}
	/*
	 * 保存/更新页面
	 */
	public void saveOrUpdataPage(Page model){
		pageDAO.saveOrUpdateEntity(model);
	}
	/*
	 * 按照id查询页面
	 */
	public Page getPage(Integer pid){
		return pageDAO.getEntity(pid);
	}
	/*
	 * 保存/更新问题
	 */
	public void saveOrUpdataQuestion(Question model){
		questionDAO.saveOrUpdateEntity(model);
	}
	/*
	 * 删除问题，同时删除答案
	 */
	@Override
	public void deleteQusetion(Integer qid) {
		String hql="delete from Answer a where a.questionId=?";
		answerDAO.batchEntityByHQL(hql, qid);
		hql="delete from Question q where q.id=?";
		questionDAO.batchEntityByHQL(hql, qid);
		
		
	}
	/*
	 * 删除页面，同时删除问题和答案
	 */
	@Override
	public void deletePage(Integer pid) {
		String hql="delete from Answer a where a.questionId in (select q.id from Question q where q.page.id=?)";
		answerDAO.batchEntityByHQL(hql, pid);
		hql="delete from Question q where q.page.id=?";
		questionDAO.batchEntityByHQL(hql, pid);
		hql="delete from Page p where p.id=?";
		pageDAO.batchEntityByHQL(hql, pid);
		
	}
	/*
	 * 删除调查,同时删除页面，问题，答案
	 */
	@Override
	public void deleteSurvey(Integer sid) {
		// TODO Auto-generated method stub
		String hql="delete from Answer a where a.surveyId=?";
		answerDAO.batchEntityByHQL(hql, sid);
		//hibernate 中，不允许两级以上的链接
		hql="delete from Question q where q.page.id in (select p.id from Page p where p.survey.id=?)";
		questionDAO.batchEntityByHQL(hql, sid);
		hql="delete from Page p where p.survey.id=?";
		pageDAO.batchEntityByHQL(hql, sid);
		hql="delete from Survey s where s.id=?";
		surveyDAO.batchEntityByHQL(hql, sid);
		
	}
	/*
	 * 编辑问题
	 */
	@Override
	public Question getQuestion(Integer qid) {
		// TODO Auto-generated method stub
		return questionDAO.getEntity(qid);
	}
	/*
	 * 删除答案
	 */
	@Override
	public void clearAnswer(Integer sid) {
		// TODO Auto-generated method stub
		String hql="delete from Answer a where a.surveyId=?";
		answerDAO.batchEntityByHQL(hql, sid);
	}
	/*
	 * 打开/关闭调查
	 */
	@Override
	public void toggleStatus(Integer sid) {
		// TODO Auto-generated method stub
		Survey s=this.getSruvey(sid);
		String hql="update Survey s set s.closed=? where s.id=?";
		surveyDAO.batchEntityByHQL(hql, !s.isClosed(),sid);
	}
	/*
	 * 更新logo路径
	 */
	@Override
	public void updateLogoPhotoPath(Integer sid, String string) {
		// TODO Auto-generated method stub
		String hql="update Survey s set s.logoPath=? where s.id=?";
		surveyDAO.batchEntityByHQL(hql, string, sid);
	}
	/*
	 * 查询调查集合，携带页面
	 */
	public List<Survey> getSurveyWithPage(User user){
		String hql="from Survey s where s.user.id=?";
		List<Survey> list=surveyDAO.findEntitybyHQL(hql, user.getId());
		for(Survey s:list){
			s.getPages().size();//懒加载，查询page
		}
		return list;
	}
	/*
	 * 执行移动/复制操作
	 */
	public void moveOrCopyPage(Integer srcPid,Integer targPid, int pos) {
		// TODO Auto-generated method stub
		Page srcPage=pageDAO.getEntity(srcPid);
		Survey srcSurvey=srcPage.getSurvey();
		Page targPage=pageDAO.getEntity(targPid);
		Survey targSurvey=targPage.getSurvey();
		//同一Survey,只移动
		if(targSurvey.getId().equals(srcSurvey.getId())){
			setOrdernum(srcPage,targPage,pos);
		}
		//不同Survey，复制并移动
		else{
			//强行加载问题，解决懒加载
			srcPage.getQuestions().size();
			//通过串行化深度复制，并不复制survey
			Page newPage=(Page) DataUtil.deeplyCopy(srcPage);
			//重新设置survey
			newPage.setSurvey(targSurvey);
			//持久化
			pageDAO.saveEntity(newPage);
			for(Question q:newPage.getQuestions()){
				questionDAO.saveEntity(q);
			}
			setOrdernum(newPage,targPage,pos);
		}
		
		
	}
	/*
	 * 设置ordernum
	 */
	private void setOrdernum(Page srcPage, Page targPage, int pos) {
		// TODO Auto-generated method stub
		if(pos==0){
			if(isFirstPage(targPage)){
				srcPage.setOrdernum(targPage.getOrdernum()-0.01f);
			}
			else{
				Page prePage=getPrePage(targPage);
				srcPage.setOrdernum((targPage.getOrdernum()+prePage.getOrdernum())/2);
			}
		}
		else{
			if(isLastPage(targPage)){
				srcPage.setOrdernum(targPage.getOrdernum()+0.01f);
			}
			else{
				//深度复制
				Page nextPage=getNextPage(targPage);
				srcPage.setOrdernum((targPage.getOrdernum()+nextPage.getOrdernum())/2);
			}
			
		}
		
	}
	private Page getNextPage(Page targPage) {
		// TODO Auto-generated method stub
		String hql="from Page p where p.survey.id=? and p.ordernum>? order by ordernum asc";
		List<Page> list=pageDAO.findEntitybyHQL(hql, targPage.getSurvey().getId(),targPage.getOrdernum());
		return list.get(0);
	}
	private Page getPrePage(Page targPage) {
		// TODO Auto-generated method stub
		String hql="from Page p where p.survey.id=? and p.ordernum<? order by ordernum desc";
		List<Page> list=pageDAO.findEntitybyHQL(hql, targPage.getSurvey().getId(),targPage.getOrdernum());
		return list.get(0);
	}
	private boolean isLastPage(Page targPage) {
		// TODO Auto-generated method stub
		String hql="Select count(*) from Page p where p.survey.id=? and p.ordernum>?";
		long count=(long) pageDAO.uniqueResult(hql, targPage.getSurvey().getId(),targPage.getOrdernum());
		return count==0;
	}
	private boolean isFirstPage(Page targPage) {
		String hql="Select count(*) from Page p where p.survey.id=? and p.ordernum<?";
		long count=(long) pageDAO.uniqueResult(hql, targPage.getSurvey().getId(),targPage.getOrdernum());
		return count==0;
	}
}
