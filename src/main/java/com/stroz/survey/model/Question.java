package com.stroz.survey.model;

public class Question {
	//����0-8
	private int questionType;
	private String title;
	//ѡ��
	private String options;
	//private String[] optionArr;
	//������
	private boolean other;
	//��������ʽ��0-�ޣ�1-�ı���2-�����б�
	private int otherStyle;
	//����������ѡ��
	private String otherSelectOptions;
	//private String[] otherSelectOptionArr;
	//����ʽ�б��⼯
	private String matrixRowTitle;
	//private String[] matrixRowTitleArr;
	//����ʽ�б��⼯
	private String matrixColTitle;
	//private String[] matrixColTitleArr;
	//����ʽ����ѡ��
	private String matrixSelectTitle;
	//private String[] matrixSelectTitleArr;
	
	//���⵽ҳ��Ķ��һ��ϵ
	private Page page;

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
	}

	public String getMatrixRowTitle() {
		return matrixRowTitle;
	}

	public void setMatrixRowTitle(String matrixRowTitle) {
		this.matrixRowTitle = matrixRowTitle;
	}

	public String getMatrixColTitle() {
		return matrixColTitle;
	}

	public void setMatrixColTitle(String matrixColTitle) {
		this.matrixColTitle = matrixColTitle;
	}

	public String getMatrixSelectTitle() {
		return matrixSelectTitle;
	}

	public void setMatrixSelectTitle(String matrixSelectTitle) {
		this.matrixSelectTitle = matrixSelectTitle;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Question() {
		super();
	}
	
	
}
