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

@Service("surveyService")
public class SurveySrviceImpl implements SurveyService {
	@Resource(name="surveyDAO")
	private BaseDAO<Survey> surveyDAO;
	@Resource(name="pageDAO")
	private BaseDAO<Page> pageDAO;
	@Resource(name="questionDAO")
	private BaseDAO<Question> questionDAO;
	@Resource(name="answerDAO")
	private BaseDAO<Answer> answerDAO;
	/*
	 * ���ҵ����б�
	 */
	@Override
	public List<Survey> findmySurveys(User user) {
		String hql="from Survey s where s.user.id=?";
		return surveyDAO.findEntitybyHQL(hql, user.getId());
	}
	/*
	 * �½������б�
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
	 * ��ѯ��������
	 */
	@Override
	public Survey getSruvey(Integer sid) {		
		return surveyDAO.getEntity(sid);
	}
	/*
	 * ����ID��ѯ�������飬��ͬʱ���������Ӳ�����������Ⱦ��ͼ�����������쳣
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
	 * ����/����ҳ��
	 */
	public void saveOrUpdataPage(Page model){
		pageDAO.saveOrUpdateEntity(model);
	}
	/*
	 * ����id��ѯҳ��
	 */
	public Page getPage(Integer pid){
		return pageDAO.getEntity(pid);
	}
	/*
	 * ����/��������
	 */
	public void saveOrUpdataQuestion(Question model){
		questionDAO.saveOrUpdateEntity(model);
	}
	/*
	 * ɾ�����⣬ͬʱɾ����
	 */
	@Override
	public void deleteQusetion(Integer qid) {
		String hql="delete from Answer a where a.questionId=?";
		answerDAO.batchEntityByHQL(hql, qid);
		hql="delete from Question q where q.id=?";
		questionDAO.batchEntityByHQL(hql, qid);
		
		
	}
	/*
	 * ɾ��ҳ�棬ͬʱɾ������ʹ�
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
	 * ɾ������,ͬʱɾ��ҳ�棬���⣬��
	 */
	@Override
	public void deleteSurvey(Integer sid) {
		// TODO Auto-generated method stub
		String hql="delete from Answer a where a.surveyId=?";
		answerDAO.batchEntityByHQL(hql, sid);
		//hibernate �У��������������ϵ�����
		hql="delete from Question q where q.page.id in (select p.id from Page p where p.survey.id=?)";
		questionDAO.batchEntityByHQL(hql, sid);
		hql="delete from Page p where p.survey.id=?";
		pageDAO.batchEntityByHQL(hql, sid);
		hql="delete from Survey s where s.id=?";
		surveyDAO.batchEntityByHQL(hql, sid);
		
	}
	/*
	 * �༭����
	 */
	@Override
	public Question getQuestion(Integer qid) {
		// TODO Auto-generated method stub
		return questionDAO.getEntity(qid);
	}
}
