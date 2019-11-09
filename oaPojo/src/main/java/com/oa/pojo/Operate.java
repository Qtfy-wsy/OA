package com.oa.pojo;

import java.util.List;

/**
 * @see 操作类
 * */
public class Operate {
	//操作编号
	private Integer operateId;
	//操作名称
	private String operateName;
	private String operateAction;
	//操作指向的页面地址
	private String operateUrl;
	//父级操作编号
	private Integer opid;
	//子级操作
	private List<Operate> subOperate;
	
	public Integer getOperateId() {
		return operateId;
	}
	public void setOperateId(Integer operateId) {
		this.operateId = operateId;
	}
	public String getOperateName() {
		return operateName;
	}
	public void setOperateName(String operateName) {
		this.operateName = operateName;
	}
	public String getOperateAction() {
		return operateAction;
	}
	public void setOperateAction(String operateAction) {
		this.operateAction = operateAction;
	}
	public String getOperateUrl() {
		return operateUrl;
	}
	public void setOperateUrl(String operateUrl) {
		this.operateUrl = operateUrl;
	}
	public Integer getOpid() {
		return opid;
	}
	public void setOpid(Integer opid) {
		this.opid = opid;
	}
	public List<Operate> getSubOperate() {
		return subOperate;
	}
	public void setSubOperate(List<Operate> subOperate) {
		this.subOperate = subOperate;
	}
	
}
