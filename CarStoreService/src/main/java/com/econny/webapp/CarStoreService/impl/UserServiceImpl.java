package com.econny.webapp.CarStoreService.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.econny.webapp.CarStoreDao.mybatis.dao.UserMapper;
import com.econny.webapp.CarStoreEntity.UserEntity;
import com.econny.webapp.CarStoreParam.UserParam;
import com.econny.webapp.CarStoreService.inter.UserService;
/*
 * author: peter.li
 * date: 20160-12-22
 * purpose: service implement layer*/
@Service
@Transactional(readOnly=true)
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	
	@Transactional(readOnly=false)
	public void save(UserEntity userEntity) {
		// TODO Auto-generated method stub
		userMapper.save(userEntity);
	}
	@Transactional(readOnly=false)
	public void saveBatch(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		userMapper.saveBatch(map);
	}
	@Transactional(readOnly=false)
	public void delete(UserEntity userEntity) {
		// TODO Auto-generated method stub
		userMapper.delete(userEntity);
	}
	@Transactional(readOnly=false)
	public void update(UserEntity userEntity) {
		// TODO Auto-generated method stub
		userMapper.update(userEntity);
	}

	public List<UserEntity> findList(UserEntity userEntity) {
		// TODO Auto-generated method stub
		return userMapper.findList(userEntity);
	}
	public List<UserParam> findUesrDetailInfo(UserEntity userEntity) {
		// TODO Auto-generated method stub
		return userMapper.findUesrDetailInfo(userEntity);
	}

}
