package com.econny.webapp.CarStoreService.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.econny.webapp.CarStoreDao.mybatis.dao.UserRoleMapper;
import com.econny.webapp.CarStoreDao.mybatis.dao.UserRoleServiceMapper;
import com.econny.webapp.CarStoreEntity.UserRoleServiceEntity;
import com.econny.webapp.CarStoreService.inter.UserRoleServiceService;
/*
 * author: peter.li
 * date: 20160-12-22
 * purpose: service implement layer*/
@Service
@Transactional(readOnly=true)
public class UserRoleServiceServiceImpl implements UserRoleServiceService {

	@Autowired
	UserRoleServiceMapper userRoleServiceMapper;
	
	@Transactional(readOnly=false)
	public void save(UserRoleServiceEntity userRoleServiceEntity) {
		// TODO Auto-generated method stub
		userRoleServiceMapper.save(userRoleServiceEntity);
	}
	@Transactional(readOnly=false)
	public void saveBatch(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		userRoleServiceMapper.saveBatch(map);
	}
	@Transactional(readOnly=false)
	public void delete(UserRoleServiceEntity userRoleServiceEntity) {
		// TODO Auto-generated method stub
		userRoleServiceMapper.delete(userRoleServiceEntity);
	}
	@Transactional(readOnly=false)
	public void update(UserRoleServiceEntity userRoleServiceEntity) {
		// TODO Auto-generated method stub
		userRoleServiceMapper.update(userRoleServiceEntity);
	}

	public List<UserRoleServiceEntity> findList(UserRoleServiceEntity userRoleServiceEntity) {
		// TODO Auto-generated method stub
		return userRoleServiceMapper.findList(userRoleServiceEntity);
	}

}
