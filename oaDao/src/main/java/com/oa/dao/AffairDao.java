package com.oa.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oa.mapper.AffairMapper;
import com.oa.pojo.Affair;
import com.oa.pojo.AffairChain;
import com.oa.pojo.AffairModel;
import com.oa.pojo.vo.AffairModelVo;
import com.oa.pojo.vo.ModelItemVo;

@Component
public class AffairDao {
	@Autowired
	private SqlSessionFactory sessionFactory;

	public SqlSessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SqlSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<AffairModel> selectAffairModels() {
		return sessionFactory.openSession().getMapper(AffairMapper.class).selectAffairModels();
	}

	public List<ModelItemVo> selectAffairModelItems(Integer affairModelId) {
		return sessionFactory.openSession().getMapper(AffairMapper.class).selectAffairModelItems(affairModelId);
	}

	public AffairModelVo selectAffairModel(Integer affairModelId) {
		
		return sessionFactory.openSession().getMapper(AffairMapper.class).selectAffairModel(affairModelId);
	}

	public int saveAffair(Affair affair) {
		
		return sessionFactory.openSession().getMapper(AffairMapper.class).saveAffair(affair);
	}

	public Integer selectPrimaryKey() {
		
		return sessionFactory.openSession().getMapper(AffairMapper.class).selectPrimaryKey();
	}

	public Integer saveAffairChain(AffairChain saveAffairChain) {
		
		return sessionFactory.openSession().getMapper(AffairMapper.class).saveAffairChain(saveAffairChain);
	}

	public List<AffairChain> selectAffairChains(Integer userId) {
		
		return sessionFactory.openSession().getMapper(AffairMapper.class).selectAffairChains(userId);
	}

	public Affair selectAffair(Integer affairId) {
		
		return sessionFactory.openSession().getMapper(AffairMapper.class).selectAffair(affairId);
	}

	public AffairChain selectAffairChain(Integer affairChainId) {
		
		return sessionFactory.openSession().getMapper(AffairMapper.class).selectAffairChain(affairChainId);
	}

	public Integer updateAffairChain(AffairChain affairChain) {
		
		return sessionFactory.openSession().getMapper(AffairMapper.class).updateAffairChain(affairChain);
	}


	public Integer updateAffair(Integer affairId, Integer affairState) {
		
		return sessionFactory.openSession().getMapper(AffairMapper.class).updateAffair(affairId,affairState);
	}

	public List<Affair> selectAffairs() {
		
		return sessionFactory.openSession().getMapper(AffairMapper.class).selectAffairs();
	}

	public List<AffairChain> selectAffairChains2(Integer userId) {
		
		return sessionFactory.openSession().getMapper(AffairMapper.class).selectAffairChains2(userId);
	}

	public Affair selectAffair2(Integer affairId) {
	
		return sessionFactory.openSession().getMapper(AffairMapper.class).selectAffair2(affairId);
	}

	public List<AffairChain> selectAffairChainsByAffairId(Integer affairId) {
		// T
		return sessionFactory.openSession().getMapper(AffairMapper.class).selectAffairChainsByAffairId(affairId);

	}

	public List<AffairChain> selectAffairChains3(Integer userId) {
		
		return sessionFactory.openSession().getMapper(AffairMapper.class).selectAffairChains3(userId);
	}
	

}
