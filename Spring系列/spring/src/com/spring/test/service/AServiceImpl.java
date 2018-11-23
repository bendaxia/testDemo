package com.spring.test.service;

import com.spring.test.dao.ADao;
import com.spring.test.dao.BDao;

public class AServiceImpl implements AService{
	ADao aDao;
	BDao bDao;
	
	public ADao getADao() {
		return aDao;
	}

	public void setADao(ADao aDao) {
		this.aDao = aDao;
	}

	public BDao getBDao() {
		return bDao;
	}

	public void setBDao(BDao bDao) {
		this.bDao = bDao;
	}

	@Override
	public void init() {
		this.aDao.init();
		this.bDao.init();
	}

}
