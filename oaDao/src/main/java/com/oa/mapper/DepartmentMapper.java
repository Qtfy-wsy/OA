package com.oa.mapper;

import java.util.List;

import com.oa.pojo.Department;
import com.oa.pojo.Param;
import com.oa.pojo.Role_user_leader;
import com.oa.pojo.User;
import com.oa.pojo.vo.Department_role_user;


public interface DepartmentMapper {

	
	//查询子部门
	List<Department> selectsondepartment();
	//查询部门负责人
	String nickName();
	//查询上级部门
	Department parentdepartment();
	//查询部门职位
	List<Department_role_user>selectdepartmentrole();
	
	List<Department> selectDepartments(User user);

	Department selectdp1();

	List<Department> selectdp2();
}
