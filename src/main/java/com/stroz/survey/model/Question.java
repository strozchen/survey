package com.stroz.survey.model;

import com.stroz.survey.util.StringUtil;
import com.stroz.survey.util.ValidateUtil;

public class Question {
	private static final String RN="\r\n";
	private Integer id;
	//题型0-8
	private int questionType;
	private String title;
	//选项
	private String options;
	private String[] optionArr;
	//其他项
	private boolean other;
	//其他项样式，0-无，1-文本框，2-下拉列表
	private int otherStyle;
	//其他项下拉选项
	private String otherSelectOptions;
	private String[] otherSelectOptionArr;
	//矩阵式行标题集
	private String matrixRowTitle;
	private String[] matrixRowTitleArr;
	//矩阵式列标题集
	private String matrixColTitle;
	private String[] matrixColTitleArr;
	//矩阵式下拉选项
	private String matrixSelectTitle;
	private String[] matrixSelectTitleArr;
	
	//问题到页面的多对一关系
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
