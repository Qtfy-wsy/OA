package com.oa.pojo.vo;

import java.util.ArrayList;
import java.util.List;

public class ModelItemVo {
	private Integer modelItemId;
	private String modelItemName;
	private String modelItemType;
	private String modelItemOption;
	private Integer affairModelId;
	
	private List<String> optionList=new ArrayList<String>();

	public Integer getModelItemId() {
		return modelItemId;
	}

	public void setModelItemId(Integer modelItemId) {
		this.modelItemId = modelItemId;
	}

	public String getModelItemName() {
		return modelItemName;
	}

	public void setModelItemName(String modelItemName) {
		this.modelItemName = modelItemName;
	}

	public String getModelItemType() {
		return modelItemType;
	}

	public void setModelItemType(String modelItemType) {
		this.modelItemType = modelItemType;
	}

	public String getModelItemOption() {
		return modelItemOption;
	}

	public void setModelItemOption(String modelItemOption) {
		this.modelItemOption = modelItemOption;
	}

	public Integer getAffairModelId() {
		return affairModelId;
	}

	public void setAffairModelId(Integer affairModelId) {
		this.affairModelId = affairModelId;
	}

	public List<String> getOptionList() {
		return optionList;
	}

	public void setOptionList(List<String> optionList) {
		this.optionList = optionList;
	}

}
