package com.oa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oa.dao.DepartmentDao;
import com.oa.mapper.DepartmentMapper;
import com.oa.pojo.Department;
import com.oa.pojo.Param;

@Service
public class DepartmentService {
@Autowired
private DepartmentDao departmentDao;

public DepartmentDao getDepartmentDao() {
	return departmentDao;
}

public void setDepartmentDao(DepartmentDao departmentDao) {
	this.departmentDao = departmentDao;
}

//获取所有部门信息
@Transactional
public List<Department> getDepartment(){
	return departmentDao.getDepartment();
}
	
}
