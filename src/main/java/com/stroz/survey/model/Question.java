package com.stroz.survey.model;

public class Question {
	//题型0-8
	private int questionType;
	private String title;
	//选项
	private String options;
	//private String[] optionArr;
	//其他项
	private boolean other;
	//其他项样式，0-无，1-文本框，2-下拉列表
	private int otherStyle;
	//其他项下拉选项
	private String otherSelectOptions;
	//private String[] otherSelectOptionArr;
	//矩阵式行标题集
	private String matrixRowTitle;
	//private String[] matrixRowTitleArr;
	//矩阵式列标题集
	private String matrixColTitle;
	//private String[] matrixColTitleArr;
	//矩阵式下拉选项
	private String matrixSelectTitle;
	//private String[] matrixSelectTitleArr;
	
	//问题到页面的多对一关系
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
