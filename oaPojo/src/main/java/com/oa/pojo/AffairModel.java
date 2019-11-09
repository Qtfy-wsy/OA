package com.oa.pojo;

public class AffairModel {
	private Integer affairModelId;
	private String affairModelName;
	private  Integer userId;
	private String affairChain;
	private Integer affairTypeId;
	
	public Integer getAffairTypeId() {
		return affairTypeId;
	}
	public void setAffairTypeId(Integer affairTypeId) {
		this.affairTypeId = affairTypeId;
	}
	public Integer getAffairModelId() {
		return affairModelId;
	}
	public void setAffairModelId(Integer affairModelId) {
		this.affairModelId = affairModelId;
	}
	public String getAffairModelName() {
		return affairModelName;
	}
	public void setAffairModelName(String affairModelName) {
		this.affairModelName = affairModelName;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getAffairChain() {
		return affairChain;
	}
	public void setAffairChain(String affairChain) {
		this.affairChain = affairChain;
	}
	
	
}
