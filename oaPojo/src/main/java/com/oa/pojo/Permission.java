package com.oa.pojo;



/**
 * @see 权限
 * */
public class Permission {
	//权限编号
	private Integer permissionId;
	//权限名称
	private String permissionName;
	//权限类型
	private String permissionType;
	//父级权限
	private Integer ppid;
	//子权限列表
//	private List<Permission> subPermission;
	//可操作列表
//	private List<Operate> operateList;
	//菜单
	private Menu menu;
	
	public Integer getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	public String getPermissionType() {
		return permissionType;
	}
	public void setPermissionType(String permissionType) {
		this.permissionType = permissionType;
	}
	public Integer getPpid() {
		return ppid;
	}
	public void setPpid(Integer ppid) {
		this.ppid = ppid;
	}
//	public List<Permission> getSubPermission() {
//		return subPermission;
//	}
//	public void setSubPermission(List<Permission> subPermission) {
//		this.subPermission = subPermission;
//	}
//	public List<Operate> getOperateList() {
//		return operateList;
//	}
//	public void setOperateList(List<Operate> operateList) {
//		this.operateList = operateList;
//	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	@Override
	public boolean equals(Object obj) {
		Permission permission=(Permission)obj;
		if(this.getPermissionId().equals(permission.getPermissionId())) {
			return true;
		}else {return false;}
	}
	@Override
	public int hashCode() {
		
		return this.getPermissionId();
	}
	
}
