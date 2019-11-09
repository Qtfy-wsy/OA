package com.oa.pojo.vo;

import java.util.ArrayList;
import java.util.List;

public class AffairModelVo {
	private Integer affairModelId;//模板编号
	private String affairModelName;//模板名称
	private String affairChain;//流程链
	private Integer userId;//公文模板创建者
	
	private Integer affairModelType;//模板类型
	private String createDateTime;//公文创建时间

	
	List<ModelItemVo> modelItemVoList = new ArrayList<ModelItemVo>();

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

	public Integer getAffairModelType() {
		return affairModelType;
	}

	public void setAffairModelType(Integer affairModelType) {
		this.affairModelType = affairModelType;
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

	public List<ModelItemVo> getModelItemVoList() {
		return modelItemVoList;
	}

	public void setModelItemVoList(List<ModelItemVo> modelItemVoList) {
		this.modelItemVoList = modelItemVoList;
	}


	

}
