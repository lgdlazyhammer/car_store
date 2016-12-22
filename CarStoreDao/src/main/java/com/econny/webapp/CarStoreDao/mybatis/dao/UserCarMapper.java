package com.econny.webapp.CarStoreDao.mybatis.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.econny.webapp.CarStoreEntity.UserCarEntity;
/*
 * author: peter.li
 * date: 20160-12-22
 * purpose: ibatis persistence for user*/
@Repository
public interface UserCarMapper {

	public void save(UserCarEntity userCarEntity);
	
	public void saveBatch(HashMap<String,Object> map);
	
	public void delete(UserCarEntity userCarEntity);
	
	public void update(UserCarEntity userCarEntity);
	
	public List<UserCarEntity> findList(UserCarEntity userCarEntity);
}
