package com.oa.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oa.dao.MenuDao;
import com.oa.pojo.Param;
import com.oa.pojo.vo.Menu_operate;
@Service
public class MenuService {
	@Autowired
	private MenuDao menuDao;
	@Transactional
	public Menu_operate getOpreate(Param p){
		return menuDao.getOpreate(p);
	}
	
	public MenuDao getMenuDao() {
		return menuDao;
	}
	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}
}
