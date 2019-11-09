package com.oa.mapper;

import java.util.List;

import com.oa.pojo.AffairModel;
import com.oa.pojo.AffairModelItem;
import com.oa.pojo.AffairType;


public interface AffairModuleMapper {

	List<AffairType> selectAffairTypes();

	Integer saveAffairModel(AffairModel affairModel);

	Integer selectPrimaryKey();

	int saveAffairModelItem(AffairModelItem affairModelItem);

	List<AffairModel> selectAffairmodules();

	int deleteAffairModel(Integer id);


}
