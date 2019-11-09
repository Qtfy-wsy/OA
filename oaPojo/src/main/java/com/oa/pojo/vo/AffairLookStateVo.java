package com.oa.pojo.vo;

public class AffairLookStateVo {
	private Integer affairId;//流程编号
	private String startRoleName;//发起人
	private String affairTime;//发起时间
	private String state;//状态
	private String dealState;//处理状态
	public Integer getAffairId() {
		return affairId;
	}
	public void setAffairId(Integer affairId) {
		this.affairId = affairId;
	}
	public String getStartRoleName() {
		return startRoleName;
	}
	public void setStartRoleName(String startRoleName) {
		this.startRoleName = startRoleName;
	}
	public String getAffairTime() {
		return affairTime;
	}
	public void setAffairTime(String affairTime) {
		this.affairTime = affairTime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDealState() {
		return dealState;
	}
	public void setDealState(String dealState) {
		this.dealState = dealState;
	}
	
}
