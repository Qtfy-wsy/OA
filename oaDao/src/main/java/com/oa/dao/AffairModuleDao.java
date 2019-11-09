package com.oa.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oa.mapper.AffairModuleMapper;
import com.oa.pojo.AffairModel;
import com.oa.pojo.AffairModelItem;
import com.oa.pojo.AffairType;

@Component
public class AffairModuleDao {
	@Autowired
	private SqlSessionFactory sessionFactory;

	public SqlSessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SqlSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<AffairType> selectAffairTypes() {
		
		return sessionFactory.openSession().getMapper(AffairModuleMapper.class).selectAffairTypes();
	}

	public Integer saveAffairModel(AffairModel affairModel) {
		
		return sessionFactory.openSession().getMapper(AffairModuleMapper.class).saveAffairModel(affairModel);
	}

	public Integer selectPrimaryKey() {
		
		return sessionFactory.openSession().getMapper(AffairModuleMapper.class).selectPrimaryKey();
	}

	public int saveAffairModelItem(AffairModelItem affairModelItem) {
		
		return sessionFactory.openSession().getMapper(AffairModuleMapper.class).saveAffairModelItem(affairModelItem);
	}

	public List<AffairModel> selectAffairmodules() {
		
		return sessionFactory.openSession().getMapper(AffairModuleMapper.class).selectAffairmodules();
	}

	public int deleteAffairModel(Integer id) {
		
		return sessionFactory.openSession().getMapper(AffairModuleMapper.class).deleteAffairModel(id);
	}

	
}
