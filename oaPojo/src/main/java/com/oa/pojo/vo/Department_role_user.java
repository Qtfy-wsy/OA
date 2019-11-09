package com.oa.pojo.vo;

import java.util.List;



public class Department_role_user {

	//部门ID
	private Integer departmentId;
	
	private String departmentName;
	
	//上级部门
	private Integer pid;
	//部门负责人ID
	private Integer userId;
	//部门负责人名字
	private String nickName;
	
    // 上级领导ID
	private Integer leaderId;
	//职位ID
	private Integer roleId;
	
	//职位名
	private String roleName;
	//子级部门
	private List<Department_role_user> departmentMenu;
	

	public List<Department_role_user> getDepartmentMenu() {
		return departmentMenu;
	}

	public void setDepartmentMenu(List<Department_role_user> departmentMenu) {
		this.departmentMenu = departmentMenu;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getLeaderId() {
		return leaderId;
	}

	public void setLeaderId(Integer leaderId) {
		this.leaderId = leaderId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}
