package com.spring.test.service;

import com.spring.test.dao.BDao;

public class BServiceImpl implements BService{
	BDao bDao;

	public BDao getBDao() {
		return bDao;
	}

	public void setBDao(BDao bDao) {
		this.bDao = bDao;
	}

	@Override
	public void init() {
		bDao.init();
	}
	
	
}
