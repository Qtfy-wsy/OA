package com.oa.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oa.pojo.Affair;
import com.oa.pojo.AffairModel;
import com.oa.pojo.vo.AffairLookStateVo;
import com.oa.pojo.vo.AffairLookVo;
import com.oa.pojo.vo.AffairModelVo;
import com.oa.pojo.vo.AffairPendVo;
import com.oa.pojo.vo.UserVo1;
import com.oa.service.AffairService;
import com.oa.service.UserService;

@Controller
@RequestMapping("/affair")
public class AffairController {
	@Autowired
	private AffairService affairService;
	@Autowired
	private UserService userService;
	
	private AffairModelVo affairModelVo;
	private List<AffairPendVo> affairPendVoList;
	
	public AffairService getAffairService() {
		return affairService;
	}

	public void setAffairService(AffairService affairService) {
		this.affairService = affairService;
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 选择流程模板创建流程
	 * @param model
	 * @return
	 */
	@RequestMapping("/AffairCreate")
	public String AffairAdd(Model model) {
		//查出所有的模板信息
		List<AffairModel> affairModelList=affairService.selectAffairModels();
		model.addAttribute("affairModelList", affairModelList);
		//转发到页面
		return "affairCreate";
	}
	
	/**
	 * 自定义公文详情
	 * @param affairModelId
	 * @param model
	 * @return
	 */
	@RequestMapping("/info")
	public String info(Integer affairModelId,Model model) {
		affairModelVo=affairService.selectAffairModelVo(affairModelId);
		model.addAttribute("affairModelVo",affairModelVo);
		return "affairInfo";
	}
	
	/**
	 * ajax提交公文信息到公文表并跳转主页
	 * @param content
	 * @param session
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public String AffairSave(String content,HttpSession session) {
		UserVo1 userVo=(UserVo1) session.getAttribute("userSession");
		String data=affairService.affairSave(content,userVo,affairModelVo);
		return data;
	}
	
	/**
	 * 待办流程列表
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/AffairPend")
	public String AffairPend(HttpSession session,Model model) {
		UserVo1 userVo=(UserVo1) session.getAttribute("userSession");
		affairPendVoList=affairService.selectAffairPendVos(userVo);
		model.addAttribute("affairPendVoList", affairPendVoList);
		return "affairPend";
	}
	
	/**
	 * 查看
	 * @param affairChainId
	 * @param model
	 * @return
	 */
	@RequestMapping("/affairCoent")
	public String AffairCoent(Integer affairChainId,Model model) {
		for(AffairPendVo affairPendVo:affairPendVoList) {
				if(affairPendVo.getAffairChainId().equals(affairChainId)) {
					model.addAttribute("affairPendVo", affairPendVo);
				}
			}
		return "affairContent";
	}
	/**
	 * 办理
	 * @param affairChainId
	 * @param model
	 * @return
	 */
	@RequestMapping("/affairPendDo")
	public String AffairPendDo(Integer affairChainId,Model model) {
		for(AffairPendVo affairPendVo:affairPendVoList) {
			if(affairPendVo.getAffairChainId().equals(affairChainId)) {
				model.addAttribute("affairPendVo", affairPendVo);
			}
		}
		return "affairPend_do";
	}
	
	/**
	 * 审核
	 * @param check
	 * @param checkformation
	 * @param affairchain
	 * @param affairChainId
	 * @param model
	 * @return
	 */
	@RequestMapping("/affairCheck")
	public String AffairPendDo(String check,String checkformation,String affairchain ,Integer affairChainId,Model model) {
		//解决中文乱码问题
		String formation = null;
		try {
			 formation=URLDecoder.decode(checkformation,"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} 
		String checkResult=affairService.affairCheck(check,formation,affairchain,affairChainId);
		model.addAttribute("message", checkResult);
		return "result";
	}
	
	/**
	 * 已办流程列表
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/AffairAlread")
	public String AffairAlread(HttpSession session,Model model) {
		UserVo1 userVo=(UserVo1) session.getAttribute("userSession");
		List<Affair> affairList=affairService.selectAffairAlreads(userVo);
		model.addAttribute("affairList", affairList);
		return "affairAlread";
	}
	
	/**
	 * 查看已办流程
	 * @param affairId
	 * @param model
	 * @return
	 */
	@RequestMapping("/affairAlreadDo")
	public String AffairAlreadDo(Integer affairId,Model model) {
		Affair affair=affairService.selectAffair(affairId);
		model.addAttribute("affair", affair);
		return "affairAlread_do";
	}
	
	/**
	 * 流程查阅列表
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/AffairLook")
	public String AffairLook(HttpSession session,Model model) {
		UserVo1 userVo=(UserVo1) session.getAttribute("userSession");
		List<AffairLookStateVo> affairLookStateVoList=affairService.selectAffairLookStateVos(userVo);
		model.addAttribute("affairLookStateVoList", affairLookStateVoList);
		return "affairLook";
	}
	
	/**
	 * 查阅
	 * @param affairId
	 * @param startRoleName
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/affairLookDo",produces="application/html;charset=utf-8")
	public String AffairLookDo(Integer affairId,String startRoleName,HttpSession session,Model model) {
		String startRoleName2 = null;
		try {
			startRoleName2 = new String(startRoleName.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		HashMap<String, Object> hmap=affairService.selectAffairLookVosAndAffair(affairId,startRoleName2);
		Affair affair=(Affair) hmap.get("affair");
		List<AffairLookVo> affairLookVoList=(List<AffairLookVo>) hmap.get("affairLookVoList");
		model.addAttribute("startRoleName", startRoleName2);
		model.addAttribute("affair", affair);
		model.addAttribute("affairLookVoList", affairLookVoList);
		return "affairLook_do";
	}
	
	/**
	 * ajax跳转
	 * @return
	 */
	@RequestMapping("/forword")
	public String Affairforword() {
		return "welcome";
	}
	
}
