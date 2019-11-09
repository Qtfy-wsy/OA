package com.oa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.oa.pojo.AffairModel;
import com.oa.pojo.AffairModelItem;
import com.oa.pojo.AffairType;
import com.oa.pojo.Department;
import com.oa.pojo.Param;
import com.oa.pojo.User;
import com.oa.pojo.vo.Menu_operate;
import com.oa.pojo.vo.UserVo1;
import com.oa.service.AffairModuleService;
import com.oa.service.MenuService;

@Controller
@RequestMapping("/affairmodule")
public class AffairModuleController {
	@Autowired
	private AffairModuleService affairModuleService;
	@Autowired
	private MenuService menuService;
	
	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public AffairModuleService getAffairModuleService() {
		return affairModuleService;
	}

	public void setAffairModuleService(AffairModuleService affairModuleService) {
		this.affairModuleService = affairModuleService;
	}
	
	//获取所有模板信息
	@RequestMapping("/getAffairmodule")
	public String getDuty(Param p,Model model){
		List<AffairModel> affairModelList=affairModuleService.selectAffairmodules();
		Menu_operate operate=menuService.getOpreate(p);
		model.addAttribute("affairModelList", affairModelList);
		model.addAttribute("operate", operate);
		return "affairModule";
	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/addAffairModule")
	public String addAffairModule(Param p,Model model) {
		List<AffairType> affairTypeList=affairModuleService.selectAffairTypes();
		model.addAttribute("affairTypeList", affairTypeList);
		model.addAttribute("permissionId",p.getPermissionId());
		return "affairModuleCreate";
	}
	
	@RequestMapping("/AffairModuleSave")
	public String AffairModuleSave(String affairModelName,HttpSession session,String chain,Integer affairTypeId,
			Integer cols,HttpServletRequest request,Model model) {
		UserVo1 userVo=(UserVo1) session.getAttribute("userSession");
		AffairModel affairModel=new AffairModel();
		affairModel.setAffairModelName(affairModelName);
		affairModel.setUserId(userVo.getUser().getUserId());
		affairModel.setAffairChain(chain);
		affairModel.setAffairTypeId(affairTypeId);
		List<AffairModelItem> affairModelItemList=new ArrayList<AffairModelItem>();
		AffairModelItem affairModelItem;
		if(cols!=null){
			for(int i=1; i<=cols; i++){
				affairModelItem=new AffairModelItem();
				if(request.getParameter("modelItemName"+i)!=null&&request.getParameter("modelItemName"+i)!="") {
					affairModelItem.setModelItemName(request.getParameter("modelItemName"+i));
					affairModelItem.setModelItemOption(request.getParameter("modelItemOption"+i));
					affairModelItem.setModelItemType(request.getParameter("modelItemType"+i));
					affairModelItemList.add(affairModelItem);
				}
			}
		}

		String createResult=affairModuleService.affairModuleSave(affairModel,affairModelItemList);
		model.addAttribute("message", createResult);
		return "result";
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/selectdp1",produces="application/json;charset=utf-8")
	@ResponseBody
	public String selectdp1() {
		User user=affairModuleService.selectdp1();
		String data=JSON.toJSONString(user);
		return data;
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/selectdp2",produces="application/json;charset=utf-8")
	@ResponseBody
	public String selectdp2() {
		List<Department> departmentList=affairModuleService.selectdp2();
		String data=JSON.toJSONString(departmentList);
		return data;
	}
	
	/**
	 * 删除公文模板
	 * @param leaderId
	 * @return
	 */
	@RequestMapping(value="/selectdp3",produces="application/json;charset=utf-8")
	@ResponseBody
	public String selectdp3(Integer leaderId) {
		List<User> userList=affairModuleService.selectdp3(leaderId);
		String data=JSON.toJSONString(userList);
		return data;
	}
	
	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/deleteAffairModule")
	public String deleteAffairModule(Integer id,Param p,Model model) {
		String deleteResult=affairModuleService.deleteAffairModel(id);
		model.addAttribute("message", deleteResult);
		model.addAttribute("permissionId",p.getPermissionId());
		return "result";
	}
}
