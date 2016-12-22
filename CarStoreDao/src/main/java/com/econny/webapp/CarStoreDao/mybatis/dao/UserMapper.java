package com.econny.webapp.CarStoreDao.mybatis.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.econny.webapp.CarStoreEntity.UserEntity;
/*
 * author: peter.li
 * date: 20160-12-22
 * purpose: ibatis persistence for user*/
@Repository
public interface UserMapper {

	public void save(UserEntity userEntity);
	
	public void saveBatch(HashMap<String,Object> map);
	
	public void delete(UserEntity userEntity);
	
	public void update(UserEntity userEntity);
	
	public List<UserEntity> findList(UserEntity userEntity);
}
