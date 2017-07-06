package com.stroz.survey.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class Survey {
	private Integer id;
	private String title="未命名";
	private String preText="上一步";
	private String nextText="下一步";
	private String endText="退出";
	private String doneText="完成";
	private Date createTime=new Date();
	private User user;
	private Set<Page> pages=new HashSet<>();
	private boolean closed;
	private String logoPath;
	
	
	public String getLogoPath() {
		return logoPath;
	}
	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}
	public boolean isClosed() {
		return closed;
	}
	public void setClosed(boolean closed) {
		this.closed = closed;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPreText() {
		return preText;
	}
	public void setPreText(String preText) {
		this.preText = preText;
	}
	public String getNextText() {
		return nextText;
	}
	public void setNextText(String nextText) {
		this.nextText = nextText;
	}
	public String getEndText() {
		return endText;
	}
	public void setEndText(String endText) {
		this.endText = endText;
	}
	public String getDoneText() {
		return doneText;
	}
	public void setDoneText(String doneText) {
		this.doneText = doneText;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Set<Page> getPages() {
		return pages;
	}
	public void setPages(Set<Page> pages) {
		this.pages = pages;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Survey() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
