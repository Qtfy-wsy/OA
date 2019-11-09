package com.oa.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oa.dao.DutyDao;
import com.oa.pojo.AttendCount;
import com.oa.pojo.Attendance;
import com.oa.pojo.AttendanceInfo;
import com.oa.pojo.DateParam;
import com.oa.pojo.Duty;
import com.oa.pojo.DutyName;
import com.oa.pojo.Param;
import com.oa.pojo.UserAttendList;
import com.oa.pojo.UserDutyInfo;
import com.oa.pojo.vo.UserDuty;
import com.oa.pojo.vo.UserUpdateAttend;
@Service
public class DutyService {
	@Autowired
	private DutyDao dutyDao;
	//封装的用户考勤记录类
	private UserAttendList ual;
	//查看班次
	@Transactional
	public List<Duty> getDuty(){
		return dutyDao.getDuty();
	}
	//按Id查找班次信息
	@Transactional
	public Duty getDutyById(Param param) {
		Duty duty=dutyDao.getDutyById(param);
		//将公休日信息拆分成星期数组
		String string=duty.getGeneral();
		if(string!=null) {
		String[] str_arr=string.split(",");
		List<String> week = new ArrayList<String>();
		for (String str : str_arr) {
			week.add(str);
		}
		duty.setWeek(week);
		}
		return duty;
	}
	//添加班次
	@Transactional
	public int addDuty(Duty duty) {
		//将星期集合组合成字符串,赋值给公休日
		String string="";
		List<String> str_arr=duty.getWeek();
		if(str_arr!=null&&!str_arr.isEmpty()) {
			for(String s:duty.getWeek()) {
				string=string+","+s;
			}
			duty.setGeneral(string.substring(1));
		}
		return dutyDao.addDuty(duty);
	}
	//删除班次
	@Transactional
	public int deleteDuty(Param param) {
		//先检查是否有该班次的排班信息
		UserDutyInfo udi=dutyDao.getUserDutyByType(param.getId());
		if(udi!=null) {
			return -1;
		}else {
			return dutyDao.deleteDuty(param);
		}
	}
	//更新班次信息
	@Transactional
	public int updateDuty(Duty duty) {
		// 将星期集合组合成字符串,赋值给公休日
		String string = "";
		if (duty.getWeek() != null) {
			for (String s : duty.getWeek()) {
				string = string + "," + s;
			}
			duty.setGeneral(string.substring(1));
		}
		return dutyDao.updateDuty(duty);
	}
	//查询用户班次信息
	@Transactional
	public UserDuty getUserDuty(Param param) {
		return dutyDao.getUserDuty(param);
	}
	//更新考勤记录
	@Transactional
	public int UpdateAttend(Attendance attendance) {
		//获取当前时间戳 
		Timestamp timestamp=new Timestamp(System.currentTimeMillis());
		UserUpdateAttend uua=new UserUpdateAttend();
		uua.setRegisterTime(timestamp);
		//传入今天和明天的日期
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();//取时间
		uua.setDate1(formatter.format(date));
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
		date=calendar.getTime(); //这个时间就是日期往后推一天的结果 
		uua.setDate2(formatter.format(date));
		uua.setRegisterId(attendance.getRegisterId());
		uua.setRemark(attendance.getRemark());
		uua.setUserId(attendance.getUserId());
		return dutyDao.updateUserAttend(uua);
	}
	//查询用户当天考勤
	@Transactional
	public List<Attendance> getUserAttend(Param param){
		DateParam dateParam=new DateParam();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();//取时间
		dateParam.setDate1(formatter.format(date));
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
		date=calendar.getTime(); //这个时间就是日期往后推一天的结果 
		dateParam.setDate2(formatter.format(date));
		dateParam.setUserId(param.getId());
		return dutyDao.getUserAttend(dateParam);
	}
	//查询用户所有考勤信息,并进行封装,每天的考勤信息封装进一个对象（用户）
	@Transactional
	public List<UserAttendList> getUserAttends(Param param){
		List<Attendance> userAttends=dutyDao.getUserAttends(param);
		return  packAttendance(userAttends);
	}
	//查询指定用户的考勤指定时间段的信息(管理员)
	@Transactional
	public AttendanceInfo getAttendanceList(DateParam dateParam){
		List<Attendance> attendances=dutyDao.getUserAttend(dateParam);
		if(attendances!=null&&!attendances.isEmpty()) {
			AttendanceInfo aInfo=new AttendanceInfo();
			aInfo.setAttendCount(statistics(attendances));
			aInfo.setUserAttendList(packAttendance(attendances));
			return aInfo;
		}
		return null;
	}
	//查询所有排班信息
	@Transactional
	public List<UserDutyInfo> getUserDutyInfo(){
		return dutyDao.getUserDutyInfo();
	}
	//给用户排班
	@Transactional
	public int addUserDuty(UserDutyInfo udi) {
		//检查是否已为用户排过班
		Param p=new Param();
		p.setId(udi.getUserId());
		UserDuty userDuty=dutyDao.getUserDuty(p);
		if(userDuty==null) {
			return dutyDao.addUserDuty(udi);
		}else {
			return -1;
		}	
	}
	//删除排班
	@Transactional
	public int deleteUserDuty(Integer userId) {
		return dutyDao.deleteUserDuty(userId);
	}
	//更新用户排班
	@Transactional
	public int updateUserDuty(UserDutyInfo udi) {
		return dutyDao.updateUserDuty(udi);
	}
	//班次名称查重
	@Transactional
	public DutyName isDutyNameExit(DutyName dutyName) {
		return dutyDao.isDutyNameExit(dutyName);
	}
	//组装考勤记录对象
	public List<UserAttendList> packAttendance(List<Attendance> userAttends) {
		List<UserAttendList> userAttendList=new ArrayList<UserAttendList>();
		SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd"); 
		SimpleDateFormat format2=new SimpleDateFormat("hh:mm:ss"); 
		String date_str=null;
		if(userAttends!=null&&!userAttends.isEmpty()) {
			for(Attendance attendance:userAttends) {
					Timestamp timestamp=attendance.getRegisterTime();
					Timestamp timestamp1=attendance.getStime();
					String str1=format1.format(timestamp1.getTime());
					if(timestamp!=null) {
						Long time=timestamp.getTime();
						String str2=format2.format(time);
						if(!str1.equals(date_str)) {
							date_str=str1;
							userAttendList.add(ual);
							ual=new UserAttendList();
							ual.setDate(str1);
							setTime(attendance.getRegisterId(),str2);
						}else {
							setTime(attendance.getRegisterId(),str2);
						}
					}else {
						if(!str1.equals(date_str)) {
							date_str=str1;
							userAttendList.add(ual);
							ual=new UserAttendList();
							ual.setDate(str1);
						}
						setTime(attendance.getRegisterId(),"未打卡");
					}
			}
		}
		userAttendList.add(ual);
		//去除第一个为空的
		userAttendList.remove(0);
		return  userAttendList;
	}
	//统计考勤信息
	public AttendCount statistics(List<Attendance> userAttends) {
		AttendCount aCount=new AttendCount();
		for(Attendance a:userAttends) {
			if(!a.getIsHoliday()) {
				if(a.isEnable()) {
					int temp=aCount.getUnsign();
					temp+=1;
					aCount.setUnsign(temp);
				}else if(a.getRegisterType().equals("1")) {
					long ss=a.getStime().getTime()-a.getRegisterTime().getTime();
					if(ss<-60000) {
						long temp=aCount.getLate();
						temp+=-ss/60000;
						aCount.setLate(temp);
					}
				}else {
					long ss=a.getRegisterTime().getTime()-a.getStime().getTime();
					if(ss<-60000) {
						long temp=aCount.getEarlyLeave();
						temp+=-ss/60000;
						aCount.setEarlyLeave(temp);
					}
				}
			}
		}
		return aCount;
	}
	//装填考勤记录的属性
	private void setTime(Integer t,String string) {
		switch(t) {
			case 1:ual.setTime1(string);break;
			case 2:ual.setTime2(string);break;
			case 3:ual.setTime3(string);break;
			case 4:ual.setTime4(string);break;
			case 5:ual.setTime5(string);break;
			case 6:ual.setTime6(string);break;
		}
	}
	
	public DutyDao getDutyDao() {
		return dutyDao;
	}
	public void setDutyDao(DutyDao dutyDao) {
		this.dutyDao = dutyDao;
	}
}
