package com.econny.webapp.OxygenService.inter;

import java.util.HashMap;
import java.util.List;
/*
 * author: peter.li
 * date: 20160-12-22
 * purpose: service layer interface*/
import com.econny.webapp.CarStoreEntity.UserEntity;
import com.econny.webapp.CarStoreEntity.UserRoleEntity;
/*
 * author: peter.li
 * date: 20160-12-22
 * purpose: service layer*/
public interface UserRoleService {

	public void save(UserRoleEntity userRoleEntity);
	
	public void saveBatch(HashMap<String,Object> map);
	
	public void delete(UserRoleEntity userRoleEntity);
	
	public void update(UserRoleEntity userRoleEntity);
	
	public List<UserRoleEntity> findList(UserRoleEntity userRoleEntity);
}
