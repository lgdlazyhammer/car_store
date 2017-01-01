package com.econny.webapp.CarStoreService.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.econny.webapp.CarStoreDao.mybatis.dao.UserRoleMapper;
import com.econny.webapp.CarStoreEntity.UserRoleEntity;
import com.econny.webapp.CarStoreService.inter.UserRoleService;
/*
 * author: peter.li
 * date: 20160-12-22
 * purpose: service implement layer*/
@Service
@Transactional(readOnly=true)
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	UserRoleMapper userRoleMapper;
	
	@Transactional(readOnly=false)
	public void save(UserRoleEntity userRoleEntity) {
		// TODO Auto-generated method stub
		userRoleMapper.save(userRoleEntity);
	}
	@Transactional(readOnly=false)
	public void saveBatch(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		userRoleMapper.saveBatch(map);
	}
	@Transactional(readOnly=false)
	public void delete(UserRoleEntity userRoleEntity) {
		// TODO Auto-generated method stub
		userRoleMapper.delete(userRoleEntity);
	}
	@Transactional(readOnly=false)
	public void update(UserRoleEntity userRoleEntity) {
		// TODO Auto-generated method stub
		userRoleMapper.update(userRoleEntity);
	}

	public List<UserRoleEntity> findList(UserRoleEntity userRoleEntity) {
		// TODO Auto-generated method stub
		return userRoleMapper.findList(userRoleEntity);
	}

}
