package com.oa.mapper;

import java.util.List;

import com.oa.pojo.Department;

public interface Dmapper {
	//获取子部门信息(所有部门，最大机构只有一个,所以返回单例)
	Department selectSubDepart(Integer integer);
	List<Department> selectDepartment();
}
