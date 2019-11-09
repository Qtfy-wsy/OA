package com.oa.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.oa.service.TimerTaskService;

@Controller
public class TimerTaskController {
	@Autowired
	private TimerTaskService timerTaskService;
	//自动添加考勤记录
	@Scheduled(cron="0 53 12 * * ?")
	public void autoAddAttend() {
		timerTaskService.autoAddAttend();
	}

	
	public TimerTaskService getTimerTaskService() {
		return timerTaskService;
	}

	public void setTimerTaskService(TimerTaskService timerTaskService) {
		this.timerTaskService = timerTaskService;
	}
}
