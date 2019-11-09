package com.oa.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oa.mapper.MenuMapper;
import com.oa.pojo.Param;
import com.oa.pojo.vo.Menu_operate;

@Component
public class MenuDao {
	@Autowired
	private SqlSessionFactory sessionFactory;
	//获取可操作选项
	public Menu_operate getOpreate(Param p){
		SqlSession sqlSession=sessionFactory.openSession();
		return sqlSession.getMapper(MenuMapper.class).selectOpreate(p);
	}

	public SqlSessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SqlSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
