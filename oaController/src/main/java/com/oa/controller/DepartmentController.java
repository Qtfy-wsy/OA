package com.oa.controller;

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.oa.pojo.Department;
import com.oa.pojo.Param;
import com.oa.pojo.Permission;
import com.oa.pojo.Role;
import com.oa.pojo.User;
import com.oa.pojo.vo.Department_role_user;
import com.oa.pojo.vo.Menu_operate;
import com.oa.service.DepartmentService;
import com.oa.service.MenuService;

@Controller
@RequestMapping("/Department")
public class DepartmentController {
	@Autowired
	private DepartmentService  departmentService;
	@Autowired
	private MenuService menuService;
	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	/**
	 * 
		//获取用户信息
	@RequestMapping("/getUser")
	public String getUser(Param p,Model model,HttpServletRequest request) {
		User user=userService.getUser(p);
		if(user!=null) {
			//存放菜单
			HashSet<Permission> permissions=new HashSet<Permission>();
			for(Role role:user.getRoleList()) {
				for(Permission permission:role.getPermissionList()) {
					permissions.add(permission);
				}
			}
			model.addAttribute("permissions", permissions);
			model.addAttribute("user", user);
			request.getSession().setAttribute("loginUser",user);
		}
		return "index";
	}
	 */
	
	//获取子部门
//	@RequestMapping("/getDepartment")
//	public String getdepartment(Param p,Model model){
//		Menu_operate operate=menuService.getOpreate(p);
//		model.addAttribute("operate", operate);
//		List<Department> getSonList=departmentService.getSondepartment();
//		if(getSonList!=null)
//		model.addAttribute("getSonList", getSonList);
//		return "department_menu";}
//	@RequestMapping(value="/getDepartment",produces="application/json;charset=utf-8")
//	@ResponseBody
//	public String getDepartment() {
//		Department department=departmentService.getDepartment();
//		String json_str=JSONObject.toJSONString(department);
		
//		if(department!=null) {
//			System.out.println("总部门id:"+department.getDepartmentId());
//			System.out.println("总部门名称:"+department.getDepartmentName());
//			System.out.println("负责人："+department.getLeader().getNickName());
//			for(User user:department.getStaffs()) {
//				System.out.println("部门员工:"+user.getNickName());
//			}
//			for(Department sub1:department.getSubDepartment()) {
//				System.out.println("分部门名称:"+sub1.getDepartmentName());
//				System.out.println("负责人："+sub1.getLeader().getNickName());
//				for(Department sub2:sub1.getSubDepartment()) {
//					System.out.println("分分部门名称:"+sub2.getDepartmentName());
//					System.out.println("负责人："+sub2.getLeader().getNickName());
//				}
//			}
//		}
//		return json_str;
//	}
	
	
	
	public MenuService getMenuService() {
		return menuService;
	}
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
}
