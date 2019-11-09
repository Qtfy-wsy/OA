package com.oa.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oa.mapper.UserMapper;
import com.oa.pojo.Param;
import com.oa.pojo.User;
import com.oa.pojo.UserLogin;
import com.oa.pojo.vo.UserId_pswd;
import com.oa.pojo.vo.UserVo;
import com.oa.pojo.vo.User_role;
@Component
public class UserDao {
	
	@Autowired
	private SqlSessionFactory sessionFactory;
	
	//获取用户详细信息
	public User getUser(UserLogin ul) {
		SqlSession session=sessionFactory.openSession(true);
		return session.getMapper(UserMapper.class).selectUser(ul);
	}
	//获取所有用户信息
	public List<User> getUsers(){
		SqlSession session=sessionFactory.openSession(true);
		return session.getMapper(UserMapper.class).selectUsers();
	}
	//添加用户
	public int addUser(User user) {
		SqlSession session=sessionFactory.openSession(true);
		return session.getMapper(UserMapper.class).insertUser(user);
	}
	//删除用户
	public int deleteUser(Param p) {
		SqlSession session=sessionFactory.openSession(true);
		return session.getMapper(UserMapper.class).deleteUser(p);
	}
	//查询用户是否有角色。删除角色用
	public User_role getUser_role(Param p) {
		SqlSession session=sessionFactory.openSession(true);
		return session.getMapper(UserMapper.class).selectUserRole(p);
	}
	//查询部门下辖用户
	public List<UserVo> getDepartUser(Integer userId){
		SqlSession session=sessionFactory.openSession();
		return session.getMapper(UserMapper.class).selectDepartmentUser(userId);
	} 
	//验证考勤登录密码
	public UserId_pswd checkUserUpwd(UserId_pswd up) {
		SqlSession session=sessionFactory.openSession();
		return session.getMapper(UserMapper.class).selectPswd(up);
	}
	public User selectUser(User user)
	{
		SqlSession session=sessionFactory.openSession();
		 return  session.getMapper(UserMapper.class).selectUser1(user);
	}


	public User selectUserByuserId(Integer userId) {
		SqlSession session=sessionFactory.openSession();
		 return  session.getMapper(UserMapper.class).selectUserByuserId(userId);
	}


	public List<User> selectUsers(Integer leaderId) {
		SqlSession session=sessionFactory.openSession();
		 return  session.getMapper(UserMapper.class).selectUsers1(leaderId);
	}
	
	
	public SqlSessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SqlSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
