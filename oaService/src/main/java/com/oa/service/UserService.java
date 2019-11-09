package com.oa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oa.dao.DepartmentDao;
import com.oa.dao.RoleDao;
import com.oa.dao.UserDao;
import com.oa.pojo.Department;
import com.oa.pojo.Param;
import com.oa.pojo.Role;
import com.oa.pojo.User;
import com.oa.pojo.UserLogin;
import com.oa.pojo.vo.UserId_pswd;
import com.oa.pojo.vo.UserVo;
import com.oa.pojo.vo.UserVo1;
import com.oa.pojo.vo.User_role;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private DepartmentDao departmentDao;
	
	public RoleDao getRoleDao() {
		return roleDao;
	}
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	//获取用户信息
	@Transactional
	public User getUser(UserLogin ul) {
		return userDao.getUser(ul);
	}
	//获取所有用户信息
	@Transactional
	public List<User> getUsers(){
		return userDao.getUsers();
	}
	//删除用户
	@Transactional
	public int deleteUser(Param p) {
		User_role ur=userDao.getUser_role(p);
		if(ur==null) {
			//无其他信息，删除用户
			int result=userDao.deleteUser(p);
			if(result==0) {
				//删除失败
				return 0;
				//删除成功
			}else {return 1;}
			//有信息，不能删除用户
		}else {return -1;}
	}
	//查询部门下辖用户
	@Transactional
	public List<UserVo> getDepartUser(Integer userId){
		return userDao.getDepartUser(userId);
	}
	//验证考勤登记密码
	@Transactional
	public UserId_pswd checkUserUpwd(Integer userId,String upwd) {
		UserId_pswd up=new UserId_pswd();
		up.setUserId(userId);
		up.setUpwd(upwd);
		return userDao.checkUserUpwd(up);
	}
	
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public UserVo1 selectUserVo(User user) {
		UserVo1 userVo=new UserVo1();
		//封装user对象
		userVo.setUser(user);
		//部门对象
		List<Department> departmentList=departmentDao.selectDepartments(user);
		userVo.setDepartmentList(departmentList);
		
		//角色对象
		List<Role> roleList = roleDao.selectRoles(user);
		userVo.setRoleList(roleList);
		return userVo;
	}
	
}
