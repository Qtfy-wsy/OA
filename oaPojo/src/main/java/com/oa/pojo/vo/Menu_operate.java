package com.oa.pojo.vo;

import java.util.List;

public class Menu_operate {
	private Integer menuId;
	private List<Operate_pid> operateList;
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public List<Operate_pid> getOperateList() {
		return operateList;
	}
	public void setOperateList(List<Operate_pid> operateList) {
		this.operateList = operateList;
	}
}
