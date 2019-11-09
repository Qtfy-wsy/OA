package com.oa.mapper;

import java.util.List;

import com.oa.pojo.Attendance;
import com.oa.pojo.DateParam;
import com.oa.pojo.Duty;
import com.oa.pojo.DutyName;
import com.oa.pojo.Param;
import com.oa.pojo.UserDutyInfo;
import com.oa.pojo.vo.UserDuty;
import com.oa.pojo.vo.UserUpdateAttend;

public interface DutyMapper {
	//查询所有班次信息
	List<Duty> selectDuty();
	//添加班次信息
	int insertDuty(Duty duty);
	//删除班次信息
	int deleteDuty(Param param);
	//更新版次信息
	int updateDuty(Duty duty);
	//按id查找班次信息
	Duty selectDutyById(Param param);
	//查看用户的排班信息
	UserDuty selectUserDuty(Param param);
	//添加考勤信息
	int insertAttend(Attendance attendance);
	//按id查找用户考勤信息
	List<Attendance> selectUserAttend(DateParam dateParam);
	//查询用户所有考勤信息
	List<Attendance> selectUserAttends(Param param);
	//用户打卡
	int updateAttend(UserUpdateAttend uua);
	//查询所有用户排班
	List<UserDutyInfo> selectUserDutyInfo();
	//给用户排班
	int insertUserDuty(UserDutyInfo udi);
	//删除用户排班
	int deleteUserDuty(Integer userId);
	//更新用户排班
	int updateUserDuty(UserDutyInfo udi);
	//班次名称查重
	DutyName selectDutyName(DutyName dutyName);
	//按班次id查找用户排班id
	UserDutyInfo selectUserDutyById(Integer dutyType);
	
}
