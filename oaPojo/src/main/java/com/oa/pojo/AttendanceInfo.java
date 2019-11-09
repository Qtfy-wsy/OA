package com.oa.pojo;

import java.util.List;

public class AttendanceInfo {
	
	private AttendCount attendCount;
	private List<UserAttendList> userAttendList;
	
	public AttendCount getAttendCount() {
		return attendCount;
	}
	public void setAttendCount(AttendCount attendCount) {
		this.attendCount = attendCount;
	}
	public List<UserAttendList> getUserAttendList() {
		return userAttendList;
	}
	public void setUserAttendList(List<UserAttendList> userAttendList) {
		this.userAttendList = userAttendList;
	}
}
