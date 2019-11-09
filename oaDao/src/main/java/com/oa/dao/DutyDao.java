package com.oa.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oa.mapper.DutyMapper;
import com.oa.pojo.Attendance;
import com.oa.pojo.DateParam;
import com.oa.pojo.Duty;
import com.oa.pojo.DutyName;
import com.oa.pojo.Param;
import com.oa.pojo.User;
import com.oa.pojo.UserDutyInfo;
import com.oa.pojo.vo.UserDuty;
import com.oa.pojo.vo.UserUpdateAttend;

@Component
public class DutyDao {
	@Autowired
	private SqlSessionFactory sessionFactory;
	//获取所有班次信息
	public List<Duty> getDuty(){
		SqlSession sqlSession=sessionFactory.openSession();
		return sqlSession.getMapper(DutyMapper.class).selectDuty();
	}
	//按Id查询班次信息
	public Duty getDutyById(Param param) {
		SqlSession sqlSession=sessionFactory.openSession();
		return sqlSession.getMapper(DutyMapper.class).selectDutyById(param);
	}
	//添加班次信息
	public int addDuty(Duty duty) {
		SqlSession sqlSession=sessionFactory.openSession(true);
		return sqlSession.getMapper(DutyMapper.class).insertDuty(duty);
	}
	//删除班次信息
	public int deleteDuty(Param param) {
		SqlSession sqlSession=sessionFactory.openSession(true);
		return sqlSession.getMapper(DutyMapper.class).deleteDuty(param);
	}
	//更新班次信息
	public int updateDuty(Duty duty) {
		SqlSession sqlSession=sessionFactory.openSession(true);
		return sqlSession.getMapper(DutyMapper.class).updateDuty(duty);
	}
	//查询用户班次信息
	public UserDuty getUserDuty(Param param) {
		SqlSession sqlSession=sessionFactory.openSession();
		return sqlSession.getMapper(DutyMapper.class).selectUserDuty(param);
	}
	//添加考勤记录
	public int addAttend(Attendance attendance) {
		SqlSession sqlSession=sessionFactory.openSession(true);
		return sqlSession.getMapper(DutyMapper.class).insertAttend(attendance);
	}
	//查询某一时间段用户考勤记录
	public List<Attendance> getUserAttend(DateParam dateParam){
		SqlSession sqlSession=sessionFactory.openSession();
		return sqlSession.getMapper(DutyMapper.class).selectUserAttend(dateParam);
	}
	//查询用户所有考勤记录
	public List<Attendance> getUserAttends(Param param){
		SqlSession sqlSession=sessionFactory.openSession();
		return sqlSession.getMapper(DutyMapper.class).selectUserAttends(param);
	}
	//更新考勤记录
	public int updateUserAttend(UserUpdateAttend uua) {
		SqlSession sqlSession=sessionFactory.openSession(true);
		return sqlSession.getMapper(DutyMapper.class).updateAttend(uua);
	}
	//查询所有排班信息
	public List<UserDutyInfo> getUserDutyInfo(){
		SqlSession sqlSession=sessionFactory.openSession();
		return sqlSession.getMapper(DutyMapper.class).selectUserDutyInfo();
	}
	//给用户排班
	public int addUserDuty(UserDutyInfo udi) {
		SqlSession sqlSession=sessionFactory.openSession(true);
		return sqlSession.getMapper(DutyMapper.class).insertUserDuty(udi);
	}
	//删除用户排班信息
	public int deleteUserDuty(Integer userId) {
		SqlSession sqlSession=sessionFactory.openSession(true);
		return sqlSession.getMapper(DutyMapper.class).deleteUserDuty(userId);
	}
	//更新用户排班
	public int updateUserDuty(UserDutyInfo udi) {
		SqlSession sqlSession=sessionFactory.openSession(true);
		return sqlSession.getMapper(DutyMapper.class).updateUserDuty(udi);
	}
	//班次名称查重
	public DutyName isDutyNameExit(DutyName dutyName) {
		SqlSession sqlSession=sessionFactory.openSession();
		return sqlSession.getMapper(DutyMapper.class).selectDutyName(dutyName);
	} 
	//按班次id查找用户排班信息
	public UserDutyInfo getUserDutyByType(Integer dutyType) {
		SqlSession sqlSession=sessionFactory.openSession();
		return sqlSession.getMapper(DutyMapper.class).selectUserDutyById(dutyType);
	}
	
	public SqlSessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SqlSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
