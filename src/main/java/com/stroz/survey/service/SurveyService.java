package com.stroz.survey.service;

import java.util.List;

import com.stroz.survey.model.Page;
import com.stroz.survey.model.Question;
import com.stroz.survey.model.Survey;
import com.stroz.survey.model.User;
/*
 * SurveySrvice
 */
public interface SurveyService {
	/*
	 * ��ѯ�����б�
	 */
	public List<Survey> findmySurveys(User user);
	/*
	 * �½������б�
	 */
	public Survey newSurvey(User user);
	/*
	 * ����id��ѯ��������
	 */
	public Survey getSruvey(Integer sid);
	
	/*
	 * ����ID��ѯ�������飬��ͬʱ���������Ӳ�����������Ⱦ��ͼ�����������쳣
	 */
	public Survey getSurveyWithChild(Integer sid);
	/*
	 * ����survey
	 */
	public void updataSurvey(Survey model);
	//���/����page
	public void saveOrUpdataPage(Page model);
	/*
	 * �༭ҳ��
	 */
	public Page getPage(Integer pid);
	/*
	 * ��������
	 */
	public void saveOrUpdataQuestion(Question model);
	/*
	 * ɾ����
	 */
	public void deleteQusetion(Integer qid);
	/*
	 * ɾ��ҳ��
	 */
	public void deletePage(Integer pid);
	/*
	 * ɾ������
	 */
	public void deleteSurvey(Integer sid);
	/*
	 * �༭����
	 */
	public Question getQuestion(Integer qid);
	/*
	 * ɾ����
	 */
	public void clearAnswer(Integer sid);
	/*
	 * ��/�رյ���
	 */
	public void toggleStatus(Integer sid);
	/*
	 * ����logo·��
	 */
	public void updateLogoPhotoPath(Integer sid, String string);
	/*
	 * ��ѯ���鼯�ϣ�Я��ҳ��
	 */
	public List<Survey> getSurveyWithPage(User user);
	/*
	 * ִ���ƶ�/���Ʋ���
	 */
	public void moveOrCopyPage(Integer srcPid,Integer targPid, int pos);


}
