package com.oa.pojo.vo;

import java.util.ArrayList;
import java.util.List;

import com.oa.pojo.Department;
import com.oa.pojo.Menu;
import com.oa.pojo.Operate;
import com.oa.pojo.Permission;
import com.oa.pojo.Role;
import com.oa.pojo.User;

public class UserVo1 {
	
		//用户的基本属性对象
		private User user;
		//用户对应的角色集合
		private List<Role> roleList = new ArrayList<Role>();
		//部门对象集合
		private List<Department>departmentList=new ArrayList<Department>();
		//权限集合
		List<Permission> permissionList = new ArrayList<Permission>();
		//菜单集合
		List<Menu> menuList = new ArrayList<Menu>();
		//操作集合
		List<Operate> operateList = new ArrayList<Operate>();
		
		
		public List<Department> getDepartmentList() {
			return departmentList;
		}
		public void setDepartmentList(List<Department> departmentList) {
			this.departmentList = departmentList;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		public List<Role> getRoleList() {
			return roleList;
		}
		public void setRoleList(List<Role> roleList) {
			this.roleList = roleList;
		}
		public List<Permission> getPermissionList() {
			return permissionList;
		}
		public void setPermissionList(List<Permission> permissionList) {
			this.permissionList = permissionList;
		}
		public List<Menu> getMenuList() {
			return menuList;
		}
		public void setMenuList(List<Menu> menuList) {
			this.menuList = menuList;
		}
		public List<Operate> getOperateList() {
			return operateList;
		}
		public void setOperateList(List<Operate> operateList) {
			this.operateList = operateList;
		}
		
		
		
}
