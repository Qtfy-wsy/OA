package com.oa.pojo.vo;

public class AffairPendVo {
	private Integer affairChainId ;//流程编号
	private String affairModelName;//流程标题
	private Integer userId;//流程发起人
	private String createDateTime;//流程发起时间
	private String content;//公文内容；
	private String affairChain;//流程链
	private String affairState;//流程状态
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Integer getAffairChainId() {
		return affairChainId;
	}
	public void setAffairChainId(Integer affairChainId) {
		this.affairChainId = affairChainId;
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
	public String getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(String createDateTime) {
		this.createDateTime = createDateTime;
	}
	public String getAffairChain() {
		return affairChain;
	}
	public void setAffairChain(String affairChain) {
		this.affairChain = affairChain;
	}
	public String getAffairState() {
		return affairState;
	}
	public void setAffairState(String affairState) {
		this.affairState = affairState;
	}
	
}
