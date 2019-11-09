package com.oa.pojo;

import java.util.List;

/**
 * @see 菜单
 * */
public class Menu {
	//菜单编号
	private Integer menuId;
	//菜单名称
	private String menuName;
	//菜单指向的页面地址
	private String menuUrl;
	//父级菜单编号
	private Integer mpid;
	//子级菜单
	private List<Menu> subMenu;
	
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	
	public Integer getMpid() {
		return mpid;
	}
	public void setMpid(Integer mpid) {
		this.mpid = mpid;
	}
	public List<Menu> getSubMenu() {
		return subMenu;
	}
	public void setSubMenu(List<Menu> subMenu) {
		this.subMenu = subMenu;
	}
	
}
