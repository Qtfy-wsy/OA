package com.oa.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oa.dao.AffairDao;
import com.oa.dao.DepartmentDao;
import com.oa.dao.RoleDao;
import com.oa.pojo.Affair;
import com.oa.pojo.AffairChain;
import com.oa.pojo.AffairModel;
import com.oa.pojo.Role;
import com.oa.pojo.User;
import com.oa.pojo.vo.AffairLookStateVo;
import com.oa.pojo.vo.AffairLookVo;
import com.oa.pojo.vo.AffairModelVo;
import com.oa.pojo.vo.AffairPendVo;
import com.oa.pojo.vo.ModelItemVo;
import com.oa.pojo.vo.UserVo1;



@Service
public class AffairService {
	@Autowired
	private AffairDao affairDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private DepartmentDao departmentDao;
	
	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public AffairDao getAffairDao() {
		return affairDao;
	}

	public void setAffairDao(AffairDao affairDao) {
		this.affairDao = affairDao;
	}
	@Transactional
	public List<AffairModel> selectAffairModels() {
		
		return affairDao.selectAffairModels();
	}
	
	@Transactional
	public AffairModelVo selectAffairModelVo(Integer affairModelId) {
		AffairModelVo affairModelVo=null;
		//公文模板项集合
		List<ModelItemVo> modelItemVoList=affairDao.selectAffairModelItems(affairModelId);
		if(modelItemVoList!=null&&modelItemVoList.size()>0) {
			//对modelItemOption处理重新存入optionList中
			for(ModelItemVo modelItemVo:modelItemVoList) {
				if(modelItemVo.getModelItemOption()!=null) {
					String[] optionArray=modelItemVo.getModelItemOption().split(",");
					//传到optionList中
					for(int i=0;i<optionArray.length;i++) {
						modelItemVo.getOptionList().add(optionArray[i]);
					}
				}
			}
			//公文模型对象的基本属性
			//模板编号 模板名称 模板创建者 流程链
			  affairModelVo=affairDao.selectAffairModel(affairModelId);
			
			//封装modelitemVo集合
			affairModelVo.setModelItemVoList(modelItemVoList);
			//公文创建时间
			affairModelVo.setCreateDateTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
			//公文模板类型
		
		}
		return affairModelVo;
	}
	
	@Transactional
	public String affairSave(String content, UserVo1 userVo, AffairModelVo affairModelVo) {
		Affair affair=new Affair();
		//接收affairContent
		affair.setAffairContent(content);
		//userId
		affair.setUserId(userVo.getUser().getUserId());
		//affairModelId
		affair.setAffairModelId(affairModelVo.getAffairModelId());
		//affairTime
		affair.setAffairTime(affairModelVo.getCreateDateTime());
		//affairState 公文状态 默认为0 未审核，流程链后修改状态
		Integer affairState=0;
		affair.setAffairState(affairState);
		//存入affair表 ,返回自增主键affairId
		String data ="";
		Integer affairId = 0;
		if(affairDao.saveAffair(affair)>0) {
			//返回自增公文表主键
			affairId=affairDao.selectPrimaryKey();
			//添加第一条流程链
		}
		if(affairId>0) {
			System.out.println("添加公文成功");
			//存入流程表第一条流程链
			AffairChain affairChain=new AffairChain();
			affairChain.setAffairId(affairId);
			affairChain.setUserId(userVo.getUser().getUserId());
			affairChain.setAffairChainOrder(1);
			affairChain.setAffairChainRemark("发起人已提交");
			affairChain.setAffairChainState(2);//自己默认审核状态为2：通过
			affairChain.setAffairChainTime(affairModelVo.getCreateDateTime());
			if(affairDao.saveAffairChain(affairChain)>0) {
					//取出公文链,分割为数组
					String[] chain=affairModelVo.getAffairChain().split(",");
					//取出流程链的第二个审核人id
					Integer id=Integer.parseInt(chain[1]);
					//添加第二条流程链
					AffairChain affairChain2=new AffairChain();
					affairChain2.setAffairId(affairId);
					affairChain2.setUserId(id);
					affairChain2.setAffairChainOrder(2);
					affairChain2.setAffairChainRemark(null);
					affairChain2.setAffairChainState(0);//默认审核状态为0：待审核
					affairChain2.setAffairChainTime(null);
					if(affairDao.saveAffairChain(affairChain2)>0) {
						data="success";
					}
			}
		}
		return  data;
		
	}
	
	@Transactional
	public List<AffairPendVo> selectAffairPendVos(UserVo1 userVo) {
		List<AffairPendVo> affairPendVoList=new ArrayList<AffairPendVo>();
		//查询自己的待办流程
		List<AffairChain> affairChainList =affairDao.selectAffairChains(userVo.getUser().getUserId());
		if(affairChainList!=null&&affairChainList.size()>0) {
			for(AffairChain affairChain: affairChainList) {
				AffairPendVo affairPendVo=new AffairPendVo();
				//流程编号
				affairPendVo.setAffairChainId(affairChain.getAffairChainId());
				//公文编号
				Affair affair=affairDao.selectAffair(affairChain.getAffairId());
				if(affair!=null) {
					//查affair表 获取公文发起人，发起时间，公文内容
				affairPendVo.setUserId(affair.getUserId());
				affairPendVo.setCreateDateTime(affair.getAffairTime());
				affairPendVo.setContent(affair.getAffairContent());
					//公文模板Id查公文模板
				affair.getAffairModelId();
				AffairModelVo affairModel=affairDao.selectAffairModel(affair.getAffairModelId());
				//流程标题
				affairPendVo.setAffairModelName(affairModel.getAffairModelName());
				//流程链
				affairPendVo.setAffairChain(affairModel.getAffairChain());
				}
				affairPendVo.setAffairState("办理中");
				affairPendVoList.add(affairPendVo);
			}
		}
		return affairPendVoList;
	}
	
	@Transactional
	public String affairCheck(String check, String formation, String affairchain, Integer affairChainId) {
		String checkResult = null;
		//修改公文链
		AffairChain affairChain=affairDao.selectAffairChain(affairChainId);
		affairChain.setAffairChainTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
		affairChain.setAffairChainRemark(formation);
		if(check.equals("tongyi")) {
			affairChain.setAffairChainState(2);//2:通过
			if(affairDao.updateAffairChain(affairChain)>0) {
				//创建一条新公文链
				String[] chain=affairchain.split(",");
				int index=0;
				for(int i=0;i<chain.length;i++) {
						index=i;
					if(Integer.parseInt(chain[i])==affairChain.getUserId()&&i<chain.length-1) {
						AffairChain affairChain2=new AffairChain();
						affairChain2.setAffairId(affairChain.getAffairId());
						affairChain2.setUserId(Integer.parseInt(chain[++index]));
						affairChain2.setAffairChainOrder(index+1);
						affairChain2.setAffairChainRemark(null);
						affairChain2.setAffairChainState(0);//默认审核状态为0：待审核
						affairChain2.setAffairChainTime(null);
						affairDao.saveAffairChain(affairChain2);
						break;
					}else if(Integer.parseInt(chain[i])==affairChain.getUserId()&&i==chain.length-1) {
						//修改公文表状态，审核通过
						Integer affairState=2;
						if(affairDao.updateAffair(affairChain.getAffairId(), affairState)>0) {
							checkResult="审核通过";
							break;
						}
					}
				}
			}
		}else if(check.equals("bohui")) {
			affairChain.setAffairChainState(1);//2:未通过
			if(affairDao.updateAffairChain(affairChain)>0) {
				//修改公文表状态，审核未通过
				Integer affairState=1;
				if(affairDao.updateAffair(affairChain.getAffairId(), affairState)>0) {
					checkResult="审核未通过";
				}
			}
		}
		return checkResult;
	}
	
	@Transactional
	public List<Affair> selectAffairAlreads(UserVo1 userVo) {
		//已办流程
		//查询角色判断
		List<Affair> affairList=new ArrayList<Affair>();
		for(Role role:userVo.getRoleList()) {
			if(role.getRoleId()==2) {
				affairList=affairDao.selectAffairs();
				if(affairList!=null&&affairList.size()>0) {
					for(Affair affair:affairList) {
						if(affair.getAffairState()==1) {
							affair.setAffairStateformation("已撤回");
						}
						if(affair.getAffairState()==2) {
							affair.setAffairStateformation("已办理");
						}
					}
				}
			}
		}
		List<AffairChain> affairChainList=affairDao.selectAffairChains2(userVo.getUser().getUserId());
		if(affairChainList!=null&&affairChainList.size()>0) {
			for(AffairChain affairChain:affairChainList) {
				Affair affair=affairDao.selectAffair2(affairChain.getAffairId());
				if(affair!=null) {
					if(affair.getAffairState()==1) {
						affair.setAffairStateformation("已撤回");
					}
					if(affair.getAffairState()==2) {
						affair.setAffairStateformation("已办理");
					}
				affairList.add(affair);
				}
			}
		}
		//去重
		for  ( int  i  =   0 ; i  <  affairList.size()  -   1 ; i ++ )  {       
		      for  ( int  j  =  affairList.size()  -   1 ; j  >  i; j -- )  {       
		           if  (affairList.get(j).getAffairId().equals(affairList.get(i).getAffairId()))  {       
		        	   affairList.remove(j);       
		            }        
		        }        
		      }
		return affairList;  
	}

	@Transactional
	public Affair selectAffair(Integer affairId) {
		Affair affair=affairDao.selectAffair(affairId);
		if(affair!=null) {
			if(affair.getAffairState()==1) {
				affair.setAffairStateformation("已撤回");
			}
			if(affair.getAffairState()==2) {
				affair.setAffairStateformation("已办理");
			}
		}
		return affair;
	}
	
	@Transactional
	public List<AffairLookStateVo> selectAffairLookStateVos(UserVo1 userVo) {
		List<AffairLookStateVo> affairLookStateVoList=new ArrayList<AffairLookStateVo>();
		AffairLookStateVo affairLookStateVo=null;
		User user=null;
		List<AffairChain>affairChainList=affairDao.selectAffairChains3(userVo.getUser().getUserId());
		if(affairChainList!=null&&affairChainList.size()>0) {
			for(AffairChain affairChain:affairChainList) {
				affairLookStateVo=new AffairLookStateVo();
				//affair
				Affair affair=affairDao.selectAffair(affairChain.getAffairId());
				 //affairId
				affairLookStateVo.setAffairId(affair.getAffairId());
				//startRoleName
				user=new User();
				user.setUserId(affair.getUserId());
				if(roleDao.selectRoles(user)!=null&&
						roleDao.selectRoles(user).size()>0) {
					affairLookStateVo.setStartRoleName(roleDao.selectRoles(user).get(0).getRoleName());
				}
				//affairTime
				affairLookStateVo.setAffairTime(affair.getAffairTime());
				//state
				if(affairChain.getAffairChainState()==0) {
					affairLookStateVo.setState("未阅");
				}else {
					affairLookStateVo.setState("已阅");
				}
				//dealState
				if(affair.getAffairState()==0) {
					affairLookStateVo.setDealState("待办");
				}else{
					affairLookStateVo.setDealState("已办理");
				}
				affairLookStateVoList.add(affairLookStateVo);
			}
		}
		//去重
				for  ( int  i  =   0 ; i  <  affairLookStateVoList.size()  -   1 ; i ++ )  {       
				      for  ( int  j  =  affairLookStateVoList.size()  -   1 ; j  >  i; j -- )  {       
				           if  (affairLookStateVoList.get(j).getAffairId().equals(affairLookStateVoList.get(i).getAffairId()))  {       
				        	   affairLookStateVoList.remove(j);       
				            }        
				        }        
				      }
		return affairLookStateVoList; 
	}
	
	@Transactional
	public HashMap<String, Object> selectAffairLookVosAndAffair(Integer affairId, String startRoleName2) {
		HashMap<String, Object> hmap=new HashMap<String, Object>();
		List<AffairLookVo> affairLookVoList=new ArrayList<AffairLookVo>();
		AffairLookVo affairLookVo=null;
		User user=null;
		//取出所有流程链
		List<AffairChain> affairChainList=affairDao.selectAffairChainsByAffairId(affairId);
		if(affairChainList!=null&&affairChainList.size()>0) {
			for(AffairChain affairChain:affairChainList) {
				affairLookVo=new AffairLookVo();
				//StartRoleName
				affairLookVo.setStartRoleName(startRoleName2);
				//CheckRoleName
				user=new User();
				user.setUserId(affairChain.getUserId());
				if(roleDao.selectRoles(user)!=null&&
						roleDao.selectRoles(user).size()>0) {
					affairLookVo.setCheckRoleName(roleDao.selectRoles(user).get(0).getRoleName());
				}
				//departmentName
				if(departmentDao.selectDepartments(user)!=null&&
						departmentDao.selectDepartments(user).size()>0) {
					affairLookVo.setDepartmentName(departmentDao.selectDepartments(user).get(0).getDepartmentName());
				}
				//affairChainRemark
				affairLookVo.setAffairChainRemark(affairChain.getAffairChainRemark());
				//affairLookTime
				affairLookVo.setAffairLookTime(affairChain.getAffairChainTime());
				affairLookVoList.add(affairLookVo);
			}
		}
		hmap.put("affairLookVoList", affairLookVoList);
		//affair
		Affair affair=affairDao.selectAffair(affairId);
		if(affair!=null) {
			if(affair.getAffairState()==0) {
				affair.setAffairStateformation("办理中");
			}else if(affair.getAffairState()==1) {
				affair.setAffairStateformation("已撤回");
			}else if(affair.getAffairState()==2) {
				affair.setAffairStateformation("已办理");
			}
		}
		hmap.put("affair", affair);
		return hmap;
	}


}
