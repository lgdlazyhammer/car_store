package com.econny.webapp.CarStoreDao.mybatis.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.econny.webapp.CarStoreEntity.ServiceEntity;
import com.econny.webapp.CarStoreEntity.UserEntity;
/*
 * author: peter.li
 * date: 20160-12-22
 * purpose: ibatis persistence for service*/
@Repository
public interface ServiceMapper {

	public void save(ServiceEntity serviceEntity);
	
	public void saveBatch(HashMap<String,Object> map);
	
	public void delete(ServiceEntity serviceEntity);
	
	public void update(ServiceEntity serviceEntity);
	
	public List<ServiceEntity> findList(ServiceEntity serviceEntity);
	
	/* find user role service list */
	public List<ServiceEntity> findListForUser(UserEntity userEntity);
}
