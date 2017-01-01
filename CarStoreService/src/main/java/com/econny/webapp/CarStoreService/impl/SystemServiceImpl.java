package com.econny.webapp.CarStoreService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.econny.webapp.CarStoreDao.mybatis.dao.SystemMapper;
import com.econny.webapp.CarStoreService.inter.SystemService;
/*
 * author: peter.li
 * date: 20160-12-22
 * purpose: service implement layer*/
@Service
@Transactional(readOnly=true)
public class SystemServiceImpl implements SystemService {

	@Autowired
	SystemMapper systemMapper;
	
	@Transactional(readOnly=false)
	public void truncTables() {
		// TODO Auto-generated method stub
		systemMapper.truncTables();
	}

}
