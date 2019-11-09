package com.oa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.sql.visitor.functions.If;
import com.oa.dao.AffairModuleDao;
import com.oa.dao.DepartmentDao;
import com.oa.dao.UserDao;
import com.oa.pojo.AffairModel;
import com.oa.pojo.AffairModelItem;
import com.oa.pojo.AffairType;
import com.oa.pojo.Department;
import com.oa.pojo.User;


@Service
public class AffairModuleService {
	@Autowired
	private AffairModuleDao affairModuleDao;
	@Autowired
	private DepartmentDao departmentDao;
	@Autowired
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	public AffairModuleDao getAffairModuleDao() {
		return affairModuleDao;
	}

	public void setAffairModuleDao(AffairModuleDao affairModuleDao) {
		this.affairModuleDao = affairModuleDao;
	}
	
	@Transactional
	public List<AffairType> selectAffairTypes() {
		
		return affairModuleDao.selectAffairTypes();
	}
	
	@Transactional
	public String affairModuleSave(AffairModel affairModel, List<AffairModelItem> affairModelItemList) {
		String createResult = null;
		Integer affairModelId = 0;
		if(affairModuleDao.saveAffairModel(affairModel)>0) {
			affairModelId=affairModuleDao.selectPrimaryKey();
			boolean flag=true;
			for(AffairModelItem affairModelItem:affairModelItemList) {
				affairModelItem.setAffairModelId(affairModelId);
				int n=affairModuleDao.saveAffairModelItem(affairModelItem);
				if(n<=0) {
					flag=false;
					createResult="公文模板创建失败！";
				}
			}
			if(flag) {
				createResult="公文模板创建成功！";
			}
		}
		return createResult;
	}
	
	@Transactional
	public User selectdp1() {
		Department department=departmentDao.selectdp1();
		User user = null;
		if(department!=null) {
			user= userDao.selectUserByuserId(department.getUserId());
		}
		
		return user;
	}
	
	@Transactional
	public List<Department> selectdp2() {
		List<Department> departmentList=departmentDao.selectdp2();
		if(departmentList!=null&&departmentList.size()>0) {
			return departmentList;
		}
		return null;
	}
	
	@Transactional
	public List<User> selectdp3(Integer leaderId) {
		 List<User> userList=userDao.selectUsers(leaderId);
		 User user=userDao.selectUserByuserId(leaderId);
		 if(userList!=null&&userList.size()>0) {
			 userList.add(user);
				return userList;
			}
		return null;
	}
	
	@Transactional
	public List<AffairModel> selectAffairmodules() {
		List<AffairModel> affairModelList=affairModuleDao.selectAffairmodules();
		if(affairModelList!=null&&affairModelList.size()>0) {
			return affairModelList;
		}
		return null;
	}

	public String deleteAffairModel(Integer id) {
		String deleteResult = null;
		if(affairModuleDao.deleteAffairModel(id)>0) {
			deleteResult="删除模板成功！";
		}
		return deleteResult;
	}
	
}
