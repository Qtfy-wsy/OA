package com.oa.mapper;

import java.util.List;

import com.oa.pojo.Affair;
import com.oa.pojo.AffairChain;
import com.oa.pojo.AffairModel;
import com.oa.pojo.vo.AffairModelVo;
import com.oa.pojo.vo.ModelItemVo;



public interface AffairMapper {

	List<AffairModel> selectAffairModels();

	List<ModelItemVo> selectAffairModelItems(Integer affairModelId);

	AffairModelVo selectAffairModel(Integer affairModelId);

	int saveAffair(Affair affair);

	Integer selectPrimaryKey();

	Integer saveAffairChain(AffairChain saveAffairChain);

	List<AffairChain> selectAffairChains(Integer userId);

	Affair selectAffair(Integer affairId);

	AffairChain selectAffairChain(Integer affairChainId);

	Integer updateAffairChain(AffairChain affairChain);

	Integer updateAffair(Integer affairId, Integer affairState);

	List<Affair> selectAffairs();

	List<AffairChain> selectAffairChains2(Integer userId);

	Affair selectAffair2(Integer affairId);

	List<AffairChain> selectAffairChainsByAffairId(Integer affairId);

	List<AffairChain> selectAffairChains3(Integer userId);


}
