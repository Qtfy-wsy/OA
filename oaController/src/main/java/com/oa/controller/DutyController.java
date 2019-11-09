package com.oa.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.oa.pojo.Attendance;
import com.oa.pojo.AttendanceInfo;
import com.oa.pojo.DateParam;
import com.oa.pojo.Department;
import com.oa.pojo.Duty;
import com.oa.pojo.DutyName;
import com.oa.pojo.Param;
import com.oa.pojo.User;
import com.oa.pojo.UserAttendList;
import com.oa.pojo.UserDutyInfo;
import com.oa.pojo.vo.Menu_operate;
import com.oa.pojo.vo.UserDuty;
import com.oa.service.DepartmentService;
import com.oa.service.DutyService;
import com.oa.service.MenuService;

@Controller
@RequestMapping("/Duty")
public class DutyController {
	@Autowired
	private DutyService dutyService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private DepartmentService ds;
	//获取班次信息
	@RequestMapping("/getDuty")
	public String getDuty(Param p,Model model){
		List<Duty> dutyList=dutyService.getDuty();
		model.addAttribute("dutyList", dutyList);
		Menu_operate operate=menuService.getOpreate(p);
		model.addAttribute("operate", operate);
		return "attend";
	}
	//检查添加班次权限，转发添加班次页面信息
	@RequestMapping("/addDuty")
	public String addDuty(Param p,Model model) {
			model.addAttribute("permissionId",p.getPermissionId());
			return "addDuty";
	}
	//执行添加班次
	@RequestMapping(value="/addDutyEnd",produces="application/html;charset=utf-8")
	@ResponseBody
	public String addDutyEnd(Duty duty,Param p) throws Throwable{
		
		int result=dutyService.addDuty(duty);
		String message=null;
		if(result==0) {
			message="添加失败";
		}else {message="已添加"+result+"条记录";}
		return message;
	}
	//删除班次
	@RequestMapping("/deleteDuty")
	public String deleteDuty(Param p,Model model) {
		String message=null;
		int result=dutyService.deleteDuty(p);
		if(result==1) {
			message="删除成功";
		}else if(result==-1) {message="请先删除该班次的排班信息!";
		}else if(result==0) {message="删除失败!";}
		model.addAttribute("message", message);
		return "result";
	}
	//检查更新班次权限，转发更新班次页面
	@RequestMapping("/updateDuty")
	public String updateDuty(Param p,HttpServletRequest request,Model model) {
			Duty duty=dutyService.getDutyById(p);
			if(duty!=null) {
				//返回结果
				model.addAttribute("permissionId", p.getPermissionId());
				model.addAttribute("duty",duty);
				return "updateDuty";
			}else {
				//记录不存在
				String message="记录不存在!";
				model.addAttribute("message", message);
				return "result";
			}
	}
	//执行更新班次
	@RequestMapping(value="/updateDutyEnd",produces="application/html;charset=utf-8")
	@ResponseBody
	public String updateDutyEnd(Duty duty,Param param) {
		int result=dutyService.updateDuty(duty);
		String message=null;
		if(result==0) {
			message="更新失败！";
		}else {message="已更新"+result+"条记录";}
		return message;
	}
	//获取用户当天要登记的考勤信息（个人权限）
	@RequestMapping("/userAttend")
	public String userAttend(HttpServletRequest request,Model model) {
		User loginUser=(User)request.getSession().getAttribute("loginUser");
		if(loginUser!=null) {
			Param param=new Param();
			param.setId(loginUser.getUserId());
			List<Attendance> userAttend=dutyService.getUserAttend(param);
			if(userAttend!=null&&!userAttend.isEmpty()) {
				model.addAttribute("userAttend", userAttend);
				return "userAttend";
			}else {
				String message="无考勤记录!";
				model.addAttribute("message",message);
				return "result";
			}
		}else {
			String message="未登录!";
			model.addAttribute("message",message);
			return "result";
		}
	}
	//获取指定用户的指定时间段考勤信息（考勤管理员权限）
	@RequestMapping("/attendList")
	public String getAttendanceList(DateParam dateParam,Model model) {
		AttendanceInfo ai=dutyService.getAttendanceList(dateParam);
		if(ai!=null) {
			model.addAttribute("userId", dateParam.getUserId());
			model.addAttribute("userAttends", ai.getUserAttendList());
			model.addAttribute("attendCount", ai.getAttendCount());
		}
		return "AttendanceList";
	}
	//用户打卡(更新考勤记录)
	@RequestMapping(value="/userAddAttend",produces="application/html;charset=utf-8")
	@ResponseBody
	public String userAddAttend(Model model,Attendance attendance) {
		int result=dutyService.UpdateAttend(attendance);
		String message=null;
		if(result==0) {
			message="打卡失败！";
		}else {message="打卡成功!";}
		return message;
	}
	//获取个人的所有考勤记录
	@RequestMapping("/getUserAttendance")
	public String getUserAttendance(HttpServletRequest request,Model model) {
		User loginUser=(User)request.getSession().getAttribute("loginUser");
		if(loginUser!=null) {
			Param pa=new Param();
			pa.setId(loginUser.getUserId());
			List<UserAttendList> userAttendances=dutyService.getUserAttends(pa);
			model.addAttribute("userAttends", userAttendances);
			return "userAttendances";
		}else{
			String message="未登录!";
			model.addAttribute("message", message);
			return "result";
		}
	}
	//显示所有排班信息
	@RequestMapping("/UserDutyInfo")
	public String getUserDutyInfo(Model model,Param p){
		Menu_operate operate=menuService.getOpreate(p);
		model.addAttribute("operate", operate);
		List<UserDutyInfo> userDutyList=dutyService.getUserDutyInfo();
		model.addAttribute("userDutyList", userDutyList);
		return "userDutyList";
	}
	//添加排班信息
	@RequestMapping("/addUserDuty")
	public String addUserDuty(Model model,Param p) {
		List<Department> departmentList=ds.getDepartment();
		List<Duty> duties=dutyService.getDuty();
		model.addAttribute("duties",duties);
		model.addAttribute("departmentList", departmentList);
		model.addAttribute("permissionId", p.getPermissionId());
		return "addUserDuty";
	}
	//执行添加排班
	@RequestMapping(value="/addUserDutyEnd",produces="application/html;charset=utf-8")
	@ResponseBody
	public String addUserDutyEnd(Model model,UserDutyInfo udi,Param p) {
		int result=dutyService.addUserDuty(udi);
		String message;
		if(result==-1) {
			message="用户已有排班";
		}else if(result==0) {
			message="排班失败!";
		}else {message="排班成功!";}
		model.addAttribute("message", message);
		return message;
	}
	//删除排班
	@RequestMapping("/deleteUserDuty")
	public String deleteUserDuty(Integer userId,Model model,Param param) {
		int result=dutyService.deleteUserDuty(userId);
		String message=null;
		if(result==0) {
			message="删除失败!";
		}else {message="删除成功!";}
		model.addAttribute("message", message);
		return "result";
	}
	//更新排班
	@RequestMapping("/updateUserDuty")
	public String updateUserDuty(Integer userId,Model model,Param param) {
		Param p=new Param();
		p.setId(userId);
		UserDuty userDuty=dutyService.getUserDuty(p);
		if(userDuty!=null) {
			List<Duty> duties=dutyService.getDuty();
			model.addAttribute("duties",duties);
			model.addAttribute("userDuty", userDuty);
			model.addAttribute("permissionId", param.getPermissionId());
			return "updateUserDuty";
		}else {
			String message="无排班信息";
			model.addAttribute("message", message);
			return "result";
		}
	}
	//执行更新排班
	@RequestMapping(value="/updateUserDutyEnd",produces="application/html;charset=utf-8")
	@ResponseBody
	public String updateUserDutyEnd(UserDutyInfo udi,Param param) {
		int result=dutyService.updateUserDuty(udi);
		if(result==0) {
			return "更新排班失败";
		}else {return "更新"+result+"条记录";}
	}
	//班次名称查重
	@RequestMapping(value="/checkDutyName",produces="application/html;charset=utf-8")
	@ResponseBody
	public String isDutyNameExit(DutyName dn) {
		DutyName dutyName=dutyService.isDutyNameExit(dn);
		if(dutyName!=null) {
			return "此名称已存在，请另起名称";
		}else {
			return "ok";
		}
	} 

	public DutyService getDutyService() {
		return dutyService;
	}
	public void setDutyService(DutyService dutyService) {
		this.dutyService = dutyService;
	}
	public MenuService getMenuService() {
		return menuService;
	}
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
}
