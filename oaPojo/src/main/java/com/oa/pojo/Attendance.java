package com.oa.pojo;

import java.sql.Timestamp;

public class Attendance {
	
	private Integer userId;
	private String registerType;
	private Timestamp registerTime;
	private Integer registerId;
	private String remark;
	private Integer dutyType;
	private boolean isHoliday;
	private boolean enable;
	private Timestamp stime;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getRegisterType() {
		return registerType;
	}
	public void setRegisterType(String registerType) {
		this.registerType = registerType;
	}
	public Timestamp getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}
	public Integer getRegisterId() {
		return registerId;
	}
	public void setRegisterId(Integer registerId) {
		this.registerId = registerId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getDutyType() {
		return dutyType;
	}
	public void setDutyType(Integer dutyType) {
		this.dutyType = dutyType;
	}
	
	public boolean getIsHoliday() {
		return isHoliday;
	}
	public void setIsHoliday(boolean isHoliday) {
		this.isHoliday = isHoliday;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	public Timestamp getStime() {
		return stime;
	}
	public void setStime(Timestamp stime) {
		this.stime = stime;
	}
	public void setHoliday(boolean isHoliday) {
		this.isHoliday = isHoliday;
	}
}
