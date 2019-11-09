package com.oa.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oa.mapper.DepartmentMapper;
import com.oa.mapper.Dmapper;
import com.oa.pojo.Department;
import com.oa.pojo.User;
@Component
public class DepartmentDao {
	
	@Autowired
	private SqlSessionFactory sessionFactory;

//查询子部门
	public List<Department> getSondepartment() {
		SqlSession session = sessionFactory.openSession(true);
		return session.getMapper(DepartmentMapper.class).selectsondepartment();
	}

//查询部门信息
	public List<Department> getDepartment() {
		SqlSession session = sessionFactory.openSession();
		return session.getMapper(Dmapper.class).selectDepartment();
	}

	public List<Department> selectDepartments(User user) {

		return sessionFactory.openSession().getMapper(DepartmentMapper.class).selectDepartments(user);
	}

	public Department selectdp1() {

		return sessionFactory.openSession().getMapper(DepartmentMapper.class).selectdp1();
	}

	public List<Department> selectdp2() {

		return sessionFactory.openSession().getMapper(DepartmentMapper.class).selectdp2();
	}

	public SqlSessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SqlSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
