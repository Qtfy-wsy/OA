package com.oa.pojo;
/**
 * 参数类
 * */
public class Param {
	//参数
	private Integer id;
	//权限Id
	private Integer permissionId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	@Override
	public String toString() {
		return ""+id;
	}

}
