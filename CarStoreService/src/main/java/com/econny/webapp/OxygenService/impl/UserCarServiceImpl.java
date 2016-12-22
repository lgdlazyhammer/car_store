package com.econny.webapp.OxygenService.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.econny.webapp.CarStoreDao.mybatis.dao.UserCarMapper;
import com.econny.webapp.CarStoreEntity.UserCarEntity;
import com.econny.webapp.OxygenService.inter.UserCarService;
/*
 * author: peter.li
 * date: 20160-12-22
 * purpose: service implement layer*/
@Service
@Transactional(readOnly=true)
public class UserCarServiceImpl implements UserCarService {

	@Autowired
	UserCarMapper userCarMapper;
	
	@Transactional(readOnly=false)
	public void save(UserCarEntity userCarEntity) {
		// TODO Auto-generated method stub
		userCarMapper.save(userCarEntity);
	}
	@Transactional(readOnly=false)
	public void saveBatch(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		userCarMapper.saveBatch(map);
	}
	@Transactional(readOnly=false)
	public void delete(UserCarEntity userCarEntity) {
		// TODO Auto-generated method stub
		userCarMapper.delete(userCarEntity);
	}
	@Transactional(readOnly=false)
	public void update(UserCarEntity userCarEntity) {
		// TODO Auto-generated method stub
		userCarMapper.update(userCarEntity);
	}

	public List<UserCarEntity> findList(UserCarEntity userCarEntity) {
		// TODO Auto-generated method stub
		return userCarMapper.findList(userCarEntity);
	}

}
