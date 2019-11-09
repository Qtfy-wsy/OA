package com.oa.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oa.mapper.RoleMapper;
import com.oa.pojo.Role;
import com.oa.pojo.User;


@Component
public class RoleDao {
	@Autowired
	private SqlSessionFactory sessionFactory;

	public SqlSessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SqlSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public List<Role> selectRoles(User user){
		
		return sessionFactory.openSession().getMapper(RoleMapper.class).selectRoles(user);
	}
	

}
