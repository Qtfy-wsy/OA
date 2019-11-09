package com.oa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oa.dao.TimerTaskDao;
@Service
public class TimerTaskService {
	@Autowired
	private TimerTaskDao timerTaskDao;
	@Transactional
	public void autoAddAttend() {
		timerTaskDao.autoAddAttend();
	}

	
	public TimerTaskDao getTimerTaskDao() {
		return timerTaskDao;
	}

	public void setTimerTaskDao(TimerTaskDao timerTaskDao) {
		this.timerTaskDao = timerTaskDao;
	}
}
