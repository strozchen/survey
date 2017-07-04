package com.stroz.survey.model;

import com.stroz.survey.util.StringUtil;
import com.stroz.survey.util.ValidateUtil;

public class Question {
	private static final String RN="\r\n";
	private Integer id;
	//����0-8
	private int questionType;
	private String title;
	//ѡ��
	private String options;
	private String[] optionArr;
	//������
	private boolean other;
	//��������ʽ��0-�ޣ�1-�ı���2-�����б�
	private int otherStyle;
	//����������ѡ��
	private String otherSelectOptions;
	private String[] otherSelectOptionArr;
	//����ʽ�б��⼯
	private String matrixRowTitle;
	private String[] matrixRowTitleArr;
	//����ʽ�б��⼯
	private String matrixColTitle;
	private String[] matrixColTitleArr;
	//����ʽ����ѡ��
	private String matrixSelectTitle;
	private String[] matrixSelectTitleArr;
	
	//���⵽ҳ��Ķ��һ��ϵ
	private Page page;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getQuestionType() {
		return questionType;
	}

	public void setQuestionType(int questionType) {
		this.questionType = questionType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
		this.optionArr=StringUtil.str2Arr(options, RN);
	}

	public boolean isOther() {
		return other;
	}

	public void setOther(boolean other) {
		this.other = other;
	}

	public int getOtherStyle() {
		return otherStyle;
	}

	public void setOtherStyle(int otherStyle) {
		this.otherStyle = otherStyle;
	}

	public String getOtherSelectOptions() {
		return otherSelectOptions;
	}

	public void setOtherSelectOptions(String otherSelectOptions) {
		this.otherSelectOptions = otherSelectOptions;
		this.otherSelectOptionArr=StringUtil.str2Arr(otherSelectOptions, RN);
	}

	public String getMatrixRowTitle() {
		return matrixRowTitle;
	}

	public void setMatrixRowTitle(String matrixRowTitle) {
		this.matrixRowTitle = matrixRowTitle;
		this.matrixRowTitleArr=StringUtil.str2Arr(matrixRowTitle, RN);
	}

	public String getMatrixColTitle() {
		return matrixColTitle;
	}

	public void setMatrixColTitle(String matrixColTitle) {
		this.matrixColTitle = matrixColTitle;
		this.matrixColTitleArr=StringUtil.str2Arr(matrixColTitle, RN);
	}

	public String getMatrixSelectTitle() {
		return matrixSelectTitle;
	}

	public void setMatrixSelectTitle(String matrixSelectTitle) {
		this.matrixSelectTitle = matrixSelectTitle;
		this.matrixSelectTitleArr=StringUtil.str2Arr(matrixSelectTitle, RN);
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String[] getOptionArr() {
		return optionArr;
	}

	public void setOptionArr(String[] optionArr) {
		this.optionArr = optionArr;
	}

	public String[] getOtherSelectOptionArr() {
		return otherSelectOptionArr;
	}

	public void setOtherSelectOptionArr(String[] otherSelectOptionArr) {
		this.otherSelectOptionArr = otherSelectOptionArr;
	}

	public String[] getMatrixRowTitleArr() {
		return matrixRowTitleArr;
	}

	public void setMatrixRowTitleArr(String[] matrixRowTitleArr) {
		this.matrixRowTitleArr = matrixRowTitleArr;
	}

	public String[] getMatrixColTitleArr() {
		return matrixColTitleArr;
	}

	public void setMatrixColTitleArr(String[] matrixColTitleArr) {
		this.matrixColTitleArr = matrixColTitleArr;
	}

	public String[] getMatrixSelectTitleArr() {
		return matrixSelectTitleArr;
	}

	public void setMatrixSelectTitleArr(String[] matrixSelectTitleArr) {
		this.matrixSelectTitleArr = matrixSelectTitleArr;
	}

	public Question() {
		super();
	}
	
	
}
