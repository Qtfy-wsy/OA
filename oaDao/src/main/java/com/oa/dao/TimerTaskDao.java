package com.oa.dao;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.oa.mapper.DutyMapper;
import com.oa.mapper.TaskMapper;
import com.oa.mapper.UserMapper;
import com.oa.pojo.Attendance;
import com.oa.pojo.DateParam;
import com.oa.pojo.Duty;
import com.oa.pojo.Holiday;
import com.oa.pojo.Param;
import com.oa.pojo.vo.UserDuty;
import com.oa.pojo.vo.UserId;
@Component
public class TimerTaskDao {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	@Autowired
	private DutyDao dutyDao;
	//定时初始化考勤记录
	public void autoAddAttend() {
		//获取当前日期，并去数据库的假期表中查找是否有假期记录
		String dateString=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		System.out.println("初始化今天的考勤记录....");
		DateParam dp=new DateParam();
		dp.setDate1(dateString);
		SqlSession sqlSession=sqlSessionFactory.openSession();
		Holiday holiday= sqlSession.getMapper(TaskMapper.class).selectHoliday(dp);
		//取出所有员工的id
		List<UserId> userIdList=sqlSession.getMapper(UserMapper.class).selectUserId();
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		String week=""+w;
		if(holiday==null) {
			//查询当前日期是否是公休日
			for(UserId uId:userIdList) {
				Param param=new Param();
				param.setId(uId.getUserId());
				UserDuty uDuty=dutyDao.getUserDuty(param);
				if(uDuty!=null) {
					Duty duty=uDuty.getUserDuty();
					String userGenral=duty.getGeneral();
					// 是公休日
					if (userGenral.contains(week)) {
						Attendance attendance = new Attendance();
						//格式化日期
						Date d=new Date();
						SimpleDateFormat dateToString=new SimpleDateFormat("yyyy-MM-dd");
						String ds=dateToString.format(d);
						ds=ds+" 00:00:00";
						Timestamp stime=Timestamp.valueOf(ds);
						attendance.setStime(stime);
						attendance.setUserId(uId.getUserId());
						attendance.setIsHoliday(true);
						attendance.setRemark("休息");
						attendance.setRegisterId(1);
						attendance.setEnable(false);
						sqlSession.getMapper(DutyMapper.class).insertAttend(attendance);
						System.out.println(uId.getUserId()+"号用户今天休息");
					} else {
						// 不是公休日,给用户添加记录(未打卡)
						if (duty.getDutyTime1() != null && duty.getDutyTime1() != "") {
							Attendance attendance =this.initAttend(duty,uId.getUserId(),1,duty.getDutyTime1(),duty.getDutyType1());
							sqlSession.getMapper(DutyMapper.class).insertAttend(attendance);
						}
						if (duty.getDutyTime2() != null && duty.getDutyTime2() != "") {
							Attendance attendance =this.initAttend(duty,uId.getUserId(),2,duty.getDutyTime2(),duty.getDutyType2());
							sqlSession.getMapper(DutyMapper.class).insertAttend(attendance);
						}
						if (duty.getDutyTime3() != null && duty.getDutyTime3() != "") {
							Attendance attendance =this.initAttend(duty,uId.getUserId(),3,duty.getDutyTime3(),duty.getDutyType3());
							sqlSession.getMapper(DutyMapper.class).insertAttend(attendance);
						}
						if (duty.getDutyTime4() != null && duty.getDutyTime4() != "") {
							Attendance attendance =this.initAttend(duty,uId.getUserId(),4,duty.getDutyTime4(),duty.getDutyType4());
							sqlSession.getMapper(DutyMapper.class).insertAttend(attendance);
						}
						if (duty.getDutyTime5() != null && duty.getDutyTime5() != "") {
							Attendance attendance =this.initAttend(duty,uId.getUserId(),5,duty.getDutyTime5(),duty.getDutyType5());
							sqlSession.getMapper(DutyMapper.class).insertAttend(attendance);
						}
						if (duty.getDutyTime6() != null && duty.getDutyTime6() != "") {
							Attendance attendance =this.initAttend(duty,uId.getUserId(),6,duty.getDutyTime6(),duty.getDutyType6());
							sqlSession.getMapper(DutyMapper.class).insertAttend(attendance);
						}
					}
				}else {System.out.println(uId.getUserId()+"号用户未排班");}
			}
		}else {
			//循环给所有员工添加假期记录
			for(UserId uId:userIdList) {
				Attendance attendance=new Attendance();
				//格式化日期
				Date d=new Date();
				SimpleDateFormat dateToString=new SimpleDateFormat("yyyy-MM-dd");
				String ds=dateToString.format(d);
				ds=ds+" 00:00:00";
				Timestamp stime=Timestamp.valueOf(ds);
				attendance.setStime(stime);
				attendance.setUserId(uId.getUserId());
				attendance.setIsHoliday(true);
				attendance.setRegisterId(1);
				attendance.setRemark(holiday.getHolidayName());
				attendance.setEnable(false);
				sqlSession.getMapper(DutyMapper.class).insertAttend(attendance);
			}
		}
	}
	//初始化打卡记录
	public Attendance initAttend(Duty duty,Integer userId,Integer registerId,String time,String dutyType) {
		Attendance attendance = new Attendance();
		//格式化日期
		Date d=new Date();
		SimpleDateFormat dateToString=new SimpleDateFormat("yyyy-MM-dd");
		String dateString=dateToString.format(d);
		dateString=dateString+" "+time;
		Timestamp stime=Timestamp.valueOf(dateString);
		attendance.setStime(stime);
		attendance.setRegisterType(dutyType);
		attendance.setDutyType(duty.getDutyType());
		attendance.setIsHoliday(false);
		attendance.setRemark("未打卡");
		attendance.setRegisterId(registerId);
		attendance.setUserId(userId);
		attendance.setEnable(true);
		return attendance;
	}
	
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	public DutyDao getDutyDao() {
		return dutyDao;
	}
	public void setDutyDao(DutyDao dutyDao) {
		this.dutyDao = dutyDao;
	}
}
