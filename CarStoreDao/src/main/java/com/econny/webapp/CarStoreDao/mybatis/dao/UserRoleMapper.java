package com.econny.webapp.CarStoreDao.mybatis.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.econny.webapp.CarStoreEntity.UserRoleEntity;
/*
 * author: peter.li
 * date: 20160-12-22
 * purpose: ibatis persistence for user*/
@Repository
public interface UserRoleMapper {

	public void save(UserRoleEntity userRoleEntity);
	
	public void saveBatch(HashMap<String,Object> map);
	
	public void delete(UserRoleEntity userRoleEntity);
	
	public void update(UserRoleEntity userRoleEntity);
	
	public List<UserRoleEntity> findList(UserRoleEntity userRoleEntity);
}
