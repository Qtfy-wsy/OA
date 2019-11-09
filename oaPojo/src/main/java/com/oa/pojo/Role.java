package com.oa.pojo;

import java.util.List;

import com.oa.pojo.vo.role_permission;

/**
 * @see 角色
 * */
public class Role {
	//角色编号
	private Integer roleId;
	//角色名称
	private String roleName;
	//部门编号
	private Integer departmentId;
	//一级权限列表
	private List<Permission> permissionList;
	//角色所拥有的所有权限（封装了权限Id）
	private List<role_permission> role_pid;
	
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
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public List<Permission> getPermissionList() {
		return permissionList;
	}
	public void setPermissionList(List<Permission> permissionList) {
		this.permissionList = permissionList;
	}
	public List<role_permission> getRole_pid() {
		return role_pid;
	}
	public void setRole_pid(List<role_permission> role_pid) {
		this.role_pid = role_pid;
	}
}
