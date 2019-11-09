package com.oa.controller;

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.oa.pojo.Param;
import com.oa.pojo.Permission;
import com.oa.pojo.Role;
import com.oa.pojo.User;
import com.oa.pojo.UserLogin;
import com.oa.pojo.vo.Menu_operate;
import com.oa.pojo.vo.Operate_pid;
import com.oa.pojo.vo.UserId_pswd;
import com.oa.pojo.vo.UserVo;
import com.oa.pojo.vo.UserVo1;
import com.oa.pojo.vo.role_permission;
import com.oa.service.MenuService;
import com.oa.service.UserService;

@Controller
@RequestMapping("/User")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private MenuService menuService;
	//获取用户信息
	@RequestMapping(value="/userLogin",produces="application/json;charset=utf-8")
	@ResponseBody
	public String getUser(UserLogin p,Model model,HttpServletRequest request) throws Throwable {
		User user=userService.getUser(p);
		UserVo1 userVo = userService.selectUserVo(user);
		request.getSession().setAttribute("userSession", userVo);
		if(user!=null) {
			//存放菜单
			HashSet<Permission> permissions=new HashSet<Permission>();
			for(Role role:user.getRoleList()) {
				for(Permission permission:role.getPermissionList()) {
					permissions.add(permission);
				}
			}
			request.getSession().setAttribute("permissions", permissions);
			model.addAttribute("user", user);
			request.getSession().setAttribute("loginUser",user);
			//request.getSession().setAttribute(, value);
			return "ok";
		}else {
			return "用户名或密码错误";
		}
	}
	//登录成功页面
	@RequestMapping("/loginDo")
	public String loginDo(HttpServletRequest request) {
		return "index";
	}
	//退出登录
	@RequestMapping("/userExit")
	public String userExit(HttpServletRequest request) {
		request.getSession().removeAttribute("loginUser");
		request.getSession().removeAttribute("permissions");
		return "redirect:login.html";
	}
	//获取所有用户信息
	@RequestMapping("/showUsers")
	public String getUsers(Model model,Param p){
		List<User> userList=userService.getUsers();
		Menu_operate operate=menuService.getOpreate(p);
		model.addAttribute("operate", operate);
		model.addAttribute("userList", userList);
		return "user-list";
	}
	//删除用户
	@RequestMapping("/UserDelete")
	public String deleteUser(Model model,Integer id,Integer permissionId,HttpServletRequest request) {
		//获取登录用户信息
		Param p=new Param();
		p.setId(id);
		p.setPermissionId(permissionId);
		User loginUser=(User) request.getSession().getAttribute("loginUser");
		boolean flag=false;
		//遍历用户的所有权限,检查是否拥有对应权限
		top:for(Role role:loginUser.getRoleList()) {
			for(role_permission rp:role.getRole_pid()) {
				if(rp.getPermissionId().equals(p.getPermissionId())) {
					flag=true;
					break top;
				}
			}
		}
		String message=null;
		if(flag) {
			int result=userService.deleteUser(p);
			
			if(result==1) {
				message="删除成功";
			}else if(result==0) {
				message="删除失败";
			}else if(result==-1) {message="请先将该用户下面的相关信息删除！";}
		}else {message="没有修改权限!";}
		model.addAttribute("message", message);
		return "result";
	}
	//查找指定用户下辖员工
	@RequestMapping(value="getDepartmentUser",produces="application/json;charset=utf-8")
	@ResponseBody
	public String getDepartmentUser(Integer leaderId) {
		List<UserVo> users=userService.getDepartUser(leaderId);
		String json_str=JSONObject.toJSONString(users);
		return json_str;
	}
	
	//验证考勤登记密码
	@RequestMapping(value="/upwdCheck",produces="application/html;charset=utf-8")
	@ResponseBody
	public String checkUpwd(String upwd,HttpServletRequest request) {
		User loginUser=(User) request.getSession().getAttribute("loginUser");
		if(loginUser!=null) {
			Integer userId=loginUser.getUserId();
			UserId_pswd up=userService.checkUserUpwd(userId, upwd);
			if(up!=null) {
				return "ok";
			}else {return "密码错误!";}
		}else {
			return "未登录!";
		}
	}
	

	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public MenuService getMenuService() {
		return menuService;
	}
	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}
	
}
