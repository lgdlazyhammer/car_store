package com.econny.webapp.CarStoreDao.mybatis.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.econny.webapp.CarStoreEntity.UserEntity;
import com.econny.webapp.CarStoreEntity.UserRoleEntity;
import com.econny.webapp.CarStoreEntity.UserRoleServiceEntity;

/*
 * author: peter.li
 * date: 20160-12-22
 * purpose: ibatis persistence for user role service*/
@Repository
public interface UserRoleServiceMapper {

	public void save(UserRoleServiceEntity userRoleServiceEntity);

	public void saveBatch(HashMap<String, Object> map);

	public void delete(UserRoleServiceEntity userRoleServiceEntity);

	public void update(UserRoleServiceEntity userRoleServiceEntity);

	public List<UserRoleServiceEntity> findList(UserRoleServiceEntity userRoleServiceEntity);

	/* find user role service permission list */
	public List<UserRoleServiceEntity> findUserPermission(UserEntity userEntity);
}
