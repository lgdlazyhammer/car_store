package com.econny.webapp.CarStoreService.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.econny.webapp.CarStoreDao.mybatis.dao.SystemMapper;
import com.econny.webapp.CarStoreEntity.UserEntity;
import com.econny.webapp.CarStoreEnum.UserRoleEnum;
import com.econny.webapp.CarStoreService.inter.SystemService;

/*
 * author: peter.li
 * date: 20160-12-22
 * purpose: service implement layer*/
@Service
@Transactional(readOnly = true)
public class SystemServiceImpl implements SystemService {

	@Autowired
	SystemMapper systemMapper;
	
	@Autowired
	UserServiceImpl userServiceImpl;

	@Transactional(readOnly = false)
	public void truncTables() {
		// TODO Auto-generated method stub
		systemMapper.truncTables();
	}

	@Transactional(readOnly = false)
	public void initUser() {
		// TODO Auto-generated method stub
		UserEntity manager = new UserEntity();
		manager.setId(UUID.randomUUID().toString());
		manager.setName("john@163.com");
		manager.setPassword("john");
		manager.setRoleId(UserRoleEnum.MANAGER.getRoleId());

		UserEntity superManager = new UserEntity();
		superManager.setId(UUID.randomUUID().toString());
		superManager.setName("mary@163.com");
		superManager.setPassword("mary");
		superManager.setRoleId(UserRoleEnum.SUPERMANAGER.getRoleId());

		userServiceImpl.save(manager);
		userServiceImpl.save(superManager);
	}

}
