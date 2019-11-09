package com.oa.mapper;

import java.util.List;

import com.oa.pojo.Param;
import com.oa.pojo.User;
import com.oa.pojo.UserLogin;
import com.oa.pojo.vo.UserId;
import com.oa.pojo.vo.UserId_pswd;
import com.oa.pojo.vo.UserVo;
import com.oa.pojo.vo.User_role;

public interface UserMapper {
	//根据用户id查找用户信息
	User selectUser(UserLogin ul);
	//查看所有用户的基本信息
	List<User> selectUsers();
	//添加用户
	int insertUser(User user);
	//删除用户
	int deleteUser(Param p);
	//查询用户是否拥有角色
	User_role selectUserRole(Param p);
	//查询所有用户id
	List<UserId> selectUserId();
	//查询部门下所有用户粗略信息
	List<UserVo> selectDepartmentUser(Integer userId);
	//验证考勤登记密码
	UserId_pswd selectPswd(UserId_pswd up);
	
	User selectUser1(User user);

	User selectUserByuserId(Integer userId);

	List<User> selectUsers1(Integer leaderId);
	
}
